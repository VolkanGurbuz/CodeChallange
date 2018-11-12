package com.volkangurbuz.codechallenge.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {

    @SerializedName("username")
    @Expose
    private String repoName;
    @SerializedName("stargazers_count")
    @Expose
    private int star;
    @SerializedName("subscribers_count")
    @Expose
    private int watcher;


    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getWatcher() {
        return watcher;
    }

    public void setWatcher(int watcher) {
        this.watcher = watcher;
    }
}
