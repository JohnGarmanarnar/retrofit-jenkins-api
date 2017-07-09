package com.teotas.jenkins;

import com.teotas.jenkins.api.JobAPI;
import com.teotas.jenkins.api.ViewAPI;

public class JenkinsAPI {
    JenkinsAPIConnection connection;
    JobAPI jobAPI;
    ViewAPI viewAPI;

    public JenkinsAPI(JenkinsAPIConnection connection){
        this.connection = connection;
    }

    public JobAPI jobAPI(){
        if(jobAPI == null){
            jobAPI = new JobAPI(connection);
        }
        return jobAPI;
    }

    public ViewAPI viewAPI(){
        if(viewAPI == null){
            viewAPI = new ViewAPI(connection);
        }
        return viewAPI;
    }

}
