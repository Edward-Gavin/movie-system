package com.xiaokea.demo.entity;

/**
 * @Author: Edward Gavin
 * @Create: 2019-12-31 11:09
 */
public class Malfunction {
    private int id;
    private String type;
    private String equ_type;
    private String brand;
    private String model;
    private String code;
    private String return_mg;
    private String details;
    private String status_1;
    private String solution_1;
    private String status_2;
    private String solution_2;
    private String status_3;
    private String solution_3;
    private String status_4;
    private String solution_4;
    private String image;
    private String video;

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

    public String getEqu_type() {
        return equ_type;
    }

    public void setEqu_type(String equ_type) {
        this.equ_type = equ_type;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReturn_mg() {
        return return_mg;
    }

    public void setReturn_mg(String return_mg) {
        this.return_mg = return_mg;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus_1() {
        return status_1;
    }

    public void setStatus_1(String status_1) {
        this.status_1 = status_1;
    }

    public String getSolution_1() {
        return solution_1;
    }

    public void setSolution_1(String solution_1) {
        this.solution_1 = solution_1;
    }

    public String getStatus_2() {
        return status_2;
    }

    public void setStatus_2(String status_2) {
        this.status_2 = status_2;
    }

    public String getSolution_2() {
        return solution_2;
    }

    public void setSolution_2(String solution_2) {
        this.solution_2 = solution_2;
    }

    public String getStatus_3() {
        return status_3;
    }

    public void setStatus_3(String status_3) {
        this.status_3 = status_3;
    }

    public String getSolution_3() {
        return solution_3;
    }

    public void setSolution_3(String solution_3) {
        this.solution_3 = solution_3;
    }

    public String getStatus_4() {
        return status_4;
    }

    public void setStatus_4(String status_4) {
        this.status_4 = status_4;
    }

    public String getSolution_4() {
        return solution_4;
    }

    public void setSolution_4(String solution_4) {
        this.solution_4 = solution_4;
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
        return "Malfunction{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", equ_type='" + equ_type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", code='" + code + '\'' +
                ", return_mg='" + return_mg + '\'' +
                ", details='" + details + '\'' +
                ", status_1='" + status_1 + '\'' +
                ", solution_1='" + solution_1 + '\'' +
                ", status_2='" + status_2 + '\'' +
                ", solution_2='" + solution_2 + '\'' +
                ", status_3='" + status_3 + '\'' +
                ", solution_3='" + solution_3 + '\'' +
                ", status_4='" + status_4 + '\'' +
                ", solution_4='" + solution_4 + '\'' +
                ", image='" + image + '\'' +
                ", video='" + video + '\'' +
                '}';
    }
}
