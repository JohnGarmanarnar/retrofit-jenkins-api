package com.teotas.jenkins;

import com.google.common.base.Preconditions;
import com.teotas.jenkins.interceptors.JenkinsAuthInterceptor;
import com.teotas.jenkins.interceptors.ResponseInterceptor;
import lombok.Getter;
import okhttp3.OkHttpClient;

public class RetrofitClient {
    @Getter
    private static String defaultLogLevel = "NONE";

    public static OkHttpClient basicAuthClient(JenkinsAPIConnection connection){
        return getBasicAuthClientBuilder(connection).build();
    }

    private static OkHttpClient.Builder getBasicAuthClientBuilder(JenkinsAPIConnection connection){
        JenkinsAuthInterceptor jenkinsAuthInterceptor = new JenkinsAuthInterceptor(connection);
        ResponseInterceptor responseInterceptor = new ResponseInterceptor(connection);
        return new OkHttpClient.Builder()
                .addInterceptor(jenkinsAuthInterceptor)
                .addInterceptor(responseInterceptor);
    }

}
