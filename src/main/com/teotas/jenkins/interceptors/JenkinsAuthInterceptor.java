package com.teotas.jenkins.interceptors;

import com.teotas.jenkins.JenkinsAPIConnection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class JenkinsAuthInterceptor implements Interceptor {
    private String tokenAuth;


    public JenkinsAuthInterceptor(JenkinsAPIConnection connection){
        tokenAuth = connection.getUserName() + ":" + connection.getUserAuthToken() + "@";
    }

    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        String requestURL = original.url().toString();
        if(requestURL.contains("://")) {
            requestURL.replace("://", "://" + tokenAuth);
        } else {
            requestURL = tokenAuth + requestURL;
        }

        Request.Builder requestBuilder = original.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .url(requestURL)
                .method(original.method(), original.body());

        Request updatedRequest = requestBuilder.build();

        return chain.proceed(updatedRequest);
    }
}
