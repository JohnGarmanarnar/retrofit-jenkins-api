package com.teotas.jenkins.api;

import com.teotas.jenkins.APICall;
import com.teotas.jenkins.JenkinsAPIConnection;
import com.teotas.jenkins.JenkinsRetrofitFactory;
import com.teotas.jenkins.RetrofitClient;
import com.teotas.jenkins.api.endpoints.JobEndpoints;
import com.teotas.jenkins.api.models.objects.Job;
import com.teotas.jenkins.api.models.responses.JenkinsJob;
import retrofit2.Retrofit;

import java.util.List;

public class JobAPI {
    private JobEndpoints endpoints;

    public JobAPI(JenkinsAPIConnection connection) {
        Retrofit retrofit = JenkinsRetrofitFactory.createJsonBuilder(connection)
                                                  .client(RetrofitClient.basicAuthClient(connection))
                                                  .build();
        endpoints = retrofit.create(JobEndpoints.class);
    }

    public JenkinsJob getJob(String jobName) {
        return new APICall<>(
                endpoints.getJob(jobName)
        ).makeRequest();
    }

    public List<Job> getJobs() {
        return new APICall<>(
                endpoints.getJenkinsMain()
        ).makeRequest()
         .getJobs();
    }
}
