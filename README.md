# Retrofit Jenkins API Library

### Summary

This is a light-weight Java wrapper for Jenkins api calls. Using a combination of Retrofit 2.0, Lombok,
and the not-so-secret api call paths of Jenkins to retrieve View, Job, and Build information (among other things)
for use in whatever way you see fit.

### Setup

To get started with this library, simply download the repository (or pull in from the public maven repo //linkgoeshere )
and declare/instantiate your JenkinsAPI object like so:

```java
JenkinsAPIConnection connection = JenkinsAPIConnection.builder().jenkinsBaseURL("http://myjenkinsurl.com")
                                                                .userName("Add.Me")
                                                                .userAuthToken("addme")
                                                                .build();
JenkinsAPI jenkins = new JenkinsAPI(connection);
```

and you're good to go!

### JenkinsAPI.java versus other API.java classes in this package

When you're sifting through the contents of this project, or referencing any of its classes via dot syntax in a smart
IDE (like IntelliJ), you might notice that there are several *API.java classes you can instantiate, such as JobAPI.
##### YOU DO NOT NEED TO DIRECTLY INSTANTIATE EACH OF THESE CLASSES WITH A CONNECTION TO USE THEM
The JenkinsAPI class will lazy-load these other APIs as needed. All you have to do is call the right one when you want
it. Here's an example of what you might want to do and how you might accomplish it with JenkinsAPI:

```java
JenkinsAPI jenkins = new JenkinsAPI(connection);
JenkinsJobResponse job = jenkins.jobAPI().getJob("my-job");
ArrayList<JenkinsView> views = jenkins.viewAPI().getViews(); 
```

This implementation pattern will yield less code clutter, while maintaining some of the efficiency of using individual
api classes via the lazy-load. It certainly beats having to do this:

```java
JobAPI jobAPI = new JobAPI(connection);
jobAPI.getJob("my-job");
ViewAPI viewAPI = new ViewAPI(connection);
viewAPI.getViews();
```

But if you want/need to use the individual API classes there's nothing stopping you, just make sure you keep track
of what the connection creds are (if you need to change them up here or there) and which url you're using (if you have
multiple Jenkins instances for some reason).
