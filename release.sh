#!/usr/bin/env bash

set -o errexit
RELEASE_BRANCH="release"
DEVELOP_BRANCH="master"
TAG_PREFIX="retrofit-jenkins-api"
WORK_PREFIX="rel"

#Make sure two arguments are provided
if [ "$#" != "2" ]; then
    echo "2 arguments must be provided:"
    echo " release: the name of release version to build"
    echo " snapshot: the name of the next snapshot version"
    exit 1
fi

#Make sure both branches are up to date
git checkout $DEVELOP_BRANCH
git fetch origin
git fetch origin $RELEASE_BRANCH:$RELEASE_BRANCH
developDiff=$(git log HEAD..origin/$DEVELOP_BRANCH --oneline)
if [[ "$developDiff" != "" ]]; then
    echo "Branch '$DEVELOP_BRANCH' is not up to date."
    exit 1
fi
releaseDiff=$(git log $RELEASE_BRANCH..origin/$RELEASE_BRANCH --oneline)
if [[ "$developDiff" != "" ]]; then
    echo "Branch '$RELEASE_BRANCH' is not up to date."
    exit 1
fi

#Create env variables for release version/snapshot
export RELEASE="$1"
export SNAPSHOT="$2"

#Create a release candidate branch
git checkout -b "$WORK_PREFIX/$RELEASE" $DEVELOP_BRANCH

#Update the poms for release version
mvn -DnewVersion=$RELEASE -f pom.xml versions:set

#Commit the pom version changes
git commit -am "Updating version for $RELEASE"

#Finish the release
git checkout $RELEASE_BRANCH
git merge --no-edit --no-ff "$WORK_PREFIX/$RELEASE"
SIGN_TAG=""
[ $(git config --get user.signingkey) != "" ] && SIGN_TAG="-s"
git tag $SIGN_TAG -m "Release $RELEASE" "$TAG_PREFIX-$RELEASE"
git checkout $DEVELOP_BRANCH
git merge --no-edit --no-ff $WORK_PREFIX/$RELEASE
git branch -d "$WORK_PREFIX/$RELEASE"

#Update the master branch with new snapshot version
mvn -DnewVersion=$SNAPSHOT -f pom.xml versions:set

#Commit the pom version changes
git commit -am "Updating version for $SNAPSHOT"

#Push master, release, and tags
git push origin master
git push origin release
git push --tags
echo "Release process complete!"