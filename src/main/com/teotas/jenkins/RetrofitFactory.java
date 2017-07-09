package com.teotas.jenkins;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitFactory {

    public static Retrofit.Builder createJsonBuilder() {
        return initializeBuilder(JacksonConverterFactory.create());
    }

    private static Retrofit.Builder initializeBuilder(Converter.Factory converterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(converterFactory)
                .baseUrl(""); //TODO configurable baseURL for use in anyone's project
    }

}