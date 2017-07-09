package com.teotas.jenkins;

import retrofit2.Retrofit;

public class JenkinsRetrofitFactory {
    public static Retrofit.Builder createJsonBuilder() {
        return initializeJenkinsConnection(RetrofitFactory.createJsonBuilder());
    }

    private static Retrofit.Builder initializeJenkinsConnection(Retrofit.Builder builder) {
        return builder.baseUrl(""); //TODO Configure baseURL
    }
}
