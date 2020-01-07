package com.xiaokea.demo.entity;

import java.util.Date;

/**
 * @Author: Edward Gavin
 * @Create: 2020-01-07 20:25
 */
public class Course {
    private int id;
    private String type;
    private String name;
    private String video;
    private String image;
    private Date datetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", video='" + video + '\'' +
                ", image='" + image + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
