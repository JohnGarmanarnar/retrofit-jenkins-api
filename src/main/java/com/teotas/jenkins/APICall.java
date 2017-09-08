package com.teotas.jenkins;

import lombok.experimental.Delegate;
import retrofit2.Call;

import java.io.IOException;

import static com.google.common.base.Throwables.throwIfUnchecked;

public class APICall<T> implements Call<T> {
    private T body;

    interface Excludes<T> {
        Call<T> clone();
    }

    @Delegate(excludes = Excludes.class)
    private final Call<T> call;

    // Lombok doesn't delegate to clone
    @Override
    public Call<T> clone() {
        return call.clone();
    }

    public APICall(Call<T> call) {
        this.call = call;
    }

    public T makeRequest() {
        if (isExecuted()) return body;
        try {
            body = call.execute().body();
        } catch (IOException e) {
            throwIfUnchecked(e);
            throw new RuntimeException(e);
        }
        return body;
    }

}
