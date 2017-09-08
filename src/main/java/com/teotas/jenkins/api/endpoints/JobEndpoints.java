package com.teotas.jenkins.api.endpoints;

import com.teotas.jenkins.api.models.responses.JenkinsJobResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JobEndpoints {

    @GET("job/{jobName}/api/json")
    Call<JenkinsJobResponse> getJob(
                @Path("jobName") String jobName
    );

}
