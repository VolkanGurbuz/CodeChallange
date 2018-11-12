package com.volkangurbuz.codechallenge.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Trend implements Serializable {

    @SerializedName("username")
    @Expose
    private String name;

    @SerializedName("name")
    @Expose
    private String nameDetail;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("repo")
    @Expose
    private RepoDetails reponame;


    public RepoDetails getReponame() {
        return reponame;
    }

    public void setReponame(RepoDetails reponame) {
        this.reponame = reponame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameDetail() {
        return nameDetail;
    }

    public void setNameDetail(String nameDetail) {
        this.nameDetail = nameDetail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
