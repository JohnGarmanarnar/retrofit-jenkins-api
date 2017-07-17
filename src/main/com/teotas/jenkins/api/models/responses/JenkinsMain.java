package com.teotas.jenkins.api.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teotas.jenkins.api.models.objects.Job;
import com.teotas.jenkins.api.models.objects.View;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JenkinsMain {
    private String nodeDescription;
    private String nodeName;
    private long numExecutors;
    private List<Job> jobs;
    private View primaryView;
    private boolean quietingDown;
    private long slaveAgentPort;
    private boolean useCrumbs;
    private boolean useSecurity;
    private List<View> views;
}
