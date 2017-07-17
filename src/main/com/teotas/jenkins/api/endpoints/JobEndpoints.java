package com.teotas.jenkins.api.endpoints;

import com.teotas.jenkins.api.models.responses.JenkinsJob;
import com.teotas.jenkins.api.models.responses.JenkinsMain;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JobEndpoints {

    @GET("job/{jobName}/api/json")
    Call<JenkinsJob> getJob(
                @Path("jobName") String jobName
                           );

    @GET("api/json")
    Call<JenkinsMain> getJenkinsMain();


}
