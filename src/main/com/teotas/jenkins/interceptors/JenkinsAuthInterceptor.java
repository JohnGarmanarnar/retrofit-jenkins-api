package com.teotas.jenkins.interceptors;

import com.teotas.jenkins.JenkinsAPIConnection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;

public class JenkinsAuthInterceptor implements Interceptor {
    private String basicAuth;


    public JenkinsAuthInterceptor(JenkinsAPIConnection connection){
        basicAuth = connection.getUserName() + ":" + connection.getUserAuthToken() + "@"; //TODO make sure this is inserted into calls properly, ex: http://[user.name:thisistheapicode@]myjenkins.com
    }

    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .method(original.method(), original.body());

        Request updatedRequest = requestBuilder.build();

        return chain.proceed(updatedRequest);
    }
}
