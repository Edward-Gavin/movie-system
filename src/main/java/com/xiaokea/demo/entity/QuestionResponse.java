package com.xiaokea.demo.entity;

import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-11-06 18:50
 */
public class QuestionResponse {
    private String title;
    private List<String> options;
    private List<String> details;
    private String url;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "QuestionResponse{" +
                ", title='" + title + '\'' +
                ", options=" + options +
                ", details=" + details +
                ", url='" + url + '\'' +
                '}';
    }
}
