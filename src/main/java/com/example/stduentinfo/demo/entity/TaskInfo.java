package com.example.stduentinfo.demo.entity;

import java.util.Date;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-08 16:03
 */
public class TaskInfo {
    private String taskName;
    private String publicUser;
    private Integer status;
    private Date startDate;
    private Date endDate;
    private String reponsible;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getPublicUser() {
        return publicUser;
    }

    public void setPublicUser(String publicUser) {
        this.publicUser = publicUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReponsible() {
        return reponsible;
    }

    public void setReponsible(String reponsible) {
        this.reponsible = reponsible;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", publicUser='" + publicUser + '\'' +
                ", status=" + status +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reponsible='" + reponsible + '\'' +
                '}';
    }
}
