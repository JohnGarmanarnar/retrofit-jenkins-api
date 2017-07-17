package com.teotas.jenkins.api.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teotas.jenkins.api.models.objects.Build;
import com.teotas.jenkins.api.models.objects.HealthReport;
import com.teotas.jenkins.api.models.objects.Job;
import com.teotas.jenkins.api.models.objects.Property;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JenkinsJob {
    private String description;
    private String displayName;
    private String name;
    private String url;
    private boolean buildable;
    private ArrayList<Build> builds;
    private String color;
    private Build firstBuild;
    @JsonProperty("healthReport")
    private ArrayList<HealthReport> healthReports;
    private boolean inQueue;
    private boolean keepDependencies;
    private Build lastBuild;
    private Build lastCompletedBuild;
    private Build lastFailedBuild;
    private Build lastStableBuild;
    private Build lastSuccessfulBuild;
    private Build lastUnstableBuild;
    private Build lastUnsuccessfulBuild;
    private long nextBuildNumber;
    @JsonProperty("property")
    private ArrayList<Property> properties;
    private ArrayList<Job> downstreamProjects;
    private ArrayList<Job> upstreamProjects;
}
