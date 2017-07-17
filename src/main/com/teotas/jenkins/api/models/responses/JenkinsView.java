package com.teotas.jenkins.api.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teotas.jenkins.api.models.objects.Job;
import com.teotas.jenkins.api.models.objects.View;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JenkinsView {
    private ArrayList<Job> jobs;
    private ArrayList<View> views;
}
