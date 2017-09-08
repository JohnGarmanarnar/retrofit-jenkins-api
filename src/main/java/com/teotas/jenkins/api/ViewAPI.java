package com.teotas.jenkins.api;

import com.teotas.jenkins.*;
import com.teotas.jenkins.api.endpoints.ViewEndpoints;
import com.teotas.jenkins.api.models.objects.JenkinsJob;
import com.teotas.jenkins.api.models.objects.JenkinsView;
import retrofit2.Retrofit;

import com.teotas.jenkins.APICall;
import com.teotas.jenkins.JenkinsAPIConnection;
import com.teotas.jenkins.JenkinsRetrofitFactory;
import com.teotas.jenkins.RetrofitClient;
import java.util.ArrayList;

public class ViewAPI {
    private ViewEndpoints endpoints;

    public ViewAPI(JenkinsAPIConnection connection){
        Retrofit retrofit = JenkinsRetrofitFactory.createJsonBuilder(connection)
                .client(RetrofitClient.basicAuthClient(connection))
                .build();
        endpoints = retrofit.create(ViewEndpoints.class);
    }

    public ArrayList<JenkinsView> getViews(){
        return new APICall<>(
                endpoints.getLandingPageView()
        ).makeRequest().getViews();
    }

    public ArrayList<JenkinsJob> getJobs(String viewName){
        return new APICall<>(
                endpoints.getView(viewName)
        ).makeRequest().getJobs();
    }
}
