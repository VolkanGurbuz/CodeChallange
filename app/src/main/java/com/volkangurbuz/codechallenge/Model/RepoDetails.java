package com.volkangurbuz.codechallenge.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepoDetails {

    private String name;
    private String description;
    private String url;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
