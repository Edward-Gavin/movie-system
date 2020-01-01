package com.xiaokea.demo.entity;

/**
 * @Author: Edward Gavin
 * @Create: 2019-12-31 11:09
 */
public class Maintain {
    private int id;
    private String name;
    private String type;
    private String brand;
    private String model;
    private String step_1;
    private String step_2;
    private String step_3;
    private String step_4;
    private String step_5;
    private String image;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStep_1() {
        return step_1;
    }

    public void setStep_1(String step_1) {
        this.step_1 = step_1;
    }

    public String getStep_2() {
        return step_2;
    }

    public void setStep_2(String step_2) {
        this.step_2 = step_2;
    }

    public String getStep_3() {
        return step_3;
    }

    public void setStep_3(String step_3) {
        this.step_3 = step_3;
    }

    public String getStep_4() {
        return step_4;
    }

    public void setStep_4(String step_4) {
        this.step_4 = step_4;
    }

    public String getStep_5() {
        return step_5;
    }

    public void setStep_5(String step_5) {
        this.step_5 = step_5;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Maintain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", step_1='" + step_1 + '\'' +
                ", step_2='" + step_2 + '\'' +
                ", step_3='" + step_3 + '\'' +
                ", step_4='" + step_4 + '\'' +
                ", step_5='" + step_5 + '\'' +
                ", image='" + image + '\'' +
                ", video='" + video + '\'' +
                '}';
    }
}
