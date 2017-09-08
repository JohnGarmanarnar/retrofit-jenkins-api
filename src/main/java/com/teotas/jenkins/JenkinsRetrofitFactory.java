package com.teotas.jenkins;

import retrofit2.Retrofit;

public class JenkinsRetrofitFactory {
    public static Retrofit.Builder createJsonBuilder(JenkinsAPIConnection connection) {
        return initializeJenkinsConnection(RetrofitFactory.createJsonBuilder(), connection);
    }

    private static Retrofit.Builder initializeJenkinsConnection(Retrofit.Builder builder, JenkinsAPIConnection connection) {
        return builder.baseUrl(connection.getJenkinsBaseURL());
    }
}
