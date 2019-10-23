package com.example.stduentinfo.demo.entity;

import java.util.Date;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-08 16:03
 */
public class Task {
    private Integer id;
    private String title;
    private String equipment;
    private String publish;
    private Date start;
    private Date end;
    private Integer status;
    private String responsible;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", equipment='" + equipment + '\'' +
                ", publish='" + publish + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", status=" + status +
                ", reponsible='" + responsible + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReponsible() {
        return responsible;
    }

    public void setReponsible(String reponsible) {
        this.responsible = reponsible;
    }
}
