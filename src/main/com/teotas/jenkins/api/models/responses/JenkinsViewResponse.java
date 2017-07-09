package com.teotas.jenkins.api.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teotas.jenkins.api.models.objects.JenkinsJob;
import com.teotas.jenkins.api.models.objects.JenkinsView;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JenkinsViewResponse {
    private ArrayList<JenkinsJob> jobs;
    private ArrayList<JenkinsView> views;
}
