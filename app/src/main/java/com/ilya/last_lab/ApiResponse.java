package com.ilya.last_lab;

import com.google.gson.annotations.SerializedName;

public class ApiResponse<T> {
    @SerializedName("results")
    private T results;

    public T getResults() {
        return results;
    }
}