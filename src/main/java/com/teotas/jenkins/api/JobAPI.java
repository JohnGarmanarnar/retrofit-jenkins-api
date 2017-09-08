package com.teotas.jenkins.api;

import com.teotas.jenkins.APICall;
import com.teotas.jenkins.JenkinsAPIConnection;
import com.teotas.jenkins.JenkinsRetrofitFactory;
import com.teotas.jenkins.RetrofitClient;
import com.teotas.jenkins.api.endpoints.JobEndpoints;
import com.teotas.jenkins.api.models.responses.JenkinsJobResponse;
import retrofit2.Retrofit;

public class JobAPI {
    private JobEndpoints endpoints;

    public JobAPI(JenkinsAPIConnection connection){
        Retrofit retrofit = JenkinsRetrofitFactory.createJsonBuilder(connection)
                .client(RetrofitClient.basicAuthClient(connection))
                .build();
        endpoints = retrofit.create(JobEndpoints.class);
    }

    public JenkinsJobResponse getJob(String jobName){
        return new APICall<>(
                endpoints.getJob(jobName)
        ).makeRequest();
    }
}
