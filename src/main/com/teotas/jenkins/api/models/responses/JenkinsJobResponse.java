package com.teotas.jenkins.api.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teotas.jenkins.api.models.objects.JenkinsBuild;
import com.teotas.jenkins.api.models.objects.JenkinsHealthReport;
import com.teotas.jenkins.api.models.objects.JenkinsJob;
import com.teotas.jenkins.api.models.objects.JenkinsProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JenkinsJobResponse {
    private String description;
    private String displayName;
    private String name;
    private String url;
    private boolean buildable;
    private ArrayList<JenkinsBuild> builds;
    private String color;
    private JenkinsBuild firstBuild;
    @JsonProperty("healthReport")
    private ArrayList<JenkinsHealthReport> healthReports;
    private boolean inQueue;
    private boolean keepDependencies;
    private JenkinsBuild lastBuild;
    private JenkinsBuild lastCompletedBuild;
    private JenkinsBuild lastFailedBuild;
    private JenkinsBuild lastStableBuild;
    private JenkinsBuild lastSuccessfulBuild;
    private JenkinsBuild lastUnstableBuild;
    private JenkinsBuild lastUnsuccessfulBuild;
    private long nextBuildNumber;
    @JsonProperty("property")
    private ArrayList<JenkinsProperty> properties;
    private ArrayList<JenkinsJob> downstreamProjects;
    private ArrayList<JenkinsJob> upstreamProjects;
}
