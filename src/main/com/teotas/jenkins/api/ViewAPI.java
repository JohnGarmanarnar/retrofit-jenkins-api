package com.teotas.jenkins.api;

import com.teotas.jenkins.*;
import com.teotas.jenkins.api.endpoints.ViewEndpoints;
import com.teotas.jenkins.api.models.objects.Job;
import com.teotas.jenkins.api.models.objects.View;
import retrofit2.Retrofit;

import java.util.ArrayList;

public class ViewAPI {
    private ViewEndpoints endpoints;

    public ViewAPI(JenkinsAPIConnection connection){
        Retrofit retrofit = JenkinsRetrofitFactory.createJsonBuilder(connection)
                .client(RetrofitClient.basicAuthClient(connection))
                .build();
        endpoints = retrofit.create(ViewEndpoints.class);
    }

    public ArrayList<View> getViews(){
        return new APICall<>(
                endpoints.getLandingPageView()
        ).makeRequest().getViews();
    }

    public ArrayList<Job> getJobs(String viewName){
        return new APICall<>(
                endpoints.getView(viewName)
        ).makeRequest().getJobs();
    }
}
