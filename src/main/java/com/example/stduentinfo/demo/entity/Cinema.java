package com.example.stduentinfo.demo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-15 15:42
 */

@Getter
@Setter
public class Cinema {
    private String cinemaName;
    private String privence;
    private String city;
    private String responsible;

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getPrivence() {
        return privence;
    }

    public void setPrivence(String privence) {
        this.privence = privence;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "cinemaName='" + cinemaName + '\'' +
                ", privence='" + privence + '\'' +
                ", city='" + city + '\'' +
                ", responsible='" + responsible + '\'' +
                '}';
    }
}
