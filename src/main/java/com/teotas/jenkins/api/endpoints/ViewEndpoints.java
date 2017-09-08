package com.teotas.jenkins.api.endpoints;

import com.teotas.jenkins.api.models.responses.JenkinsViewResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ViewEndpoints {

    @GET("api/json")
    Call<JenkinsViewResponse> getLandingPageView();

    @GET("view/{viewName}/api/json")
    Call<JenkinsViewResponse> getView(
            @Path("viewName") String viewName
    );
}
