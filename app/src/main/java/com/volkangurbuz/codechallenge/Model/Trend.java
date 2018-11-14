package com.volkangurbuz.codechallenge.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Trend implements Serializable {

        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("language")
        @Expose
        private String language;

        @SerializedName("stars")
        @Expose
        private int stars;
        @SerializedName("forks")
        @Expose

        private int forks;
        @SerializedName("currentPeriodStars")
        @Expose
        private Integer currentPeriodStars;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public int getStars() {
            return stars;
        }

        public void setStars(int stars) {
            this.stars = stars;
        }

        public int getForks() {
            return forks;
        }

        public void setForks(int forks) {
            this.forks = forks;
        }

        public Integer getCurrentPeriodStars() {
            return currentPeriodStars;
        }

        public void setCurrentPeriodStars(Integer currentPeriodStars) {
            this.currentPeriodStars = currentPeriodStars;
        }

    }


