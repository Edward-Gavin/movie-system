package com.xiaokea.demo.entity;

/**
 * @Author: Edward Gavin
 * @Create: 2019-12-31 11:08
 */
public class Standard {

    private int id;
    private String name;
    private String type;
    private String num;
    private String content;
    private String use_range;
    private String image;
    private String file;
    private String video;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUse_range() {
        return use_range;
    }

    public void setUse_range(String use_range) {
        this.use_range = use_range;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", num='" + num + '\'' +
                ", content='" + content + '\'' +
                ", use_range='" + use_range + '\'' +
                ", image='" + image + '\'' +
                ", file='" + file + '\'' +
                ", video='" + video + '\'' +
                '}';
    }
}
