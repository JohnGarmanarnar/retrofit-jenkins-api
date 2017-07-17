package com.teotas.jenkins.api.endpoints;

import com.teotas.jenkins.api.models.responses.JenkinsView;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ViewEndpoints {

    @GET("api/json")
    Call<JenkinsView> getLandingPageView();

    @GET("view/{viewName}/api/json")
    Call<JenkinsView> getView(
            @Path("viewName") String viewName
                             );
}
