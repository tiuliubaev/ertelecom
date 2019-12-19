package com.ertelecom.gwt.common;

import java.io.Serializable;

public class EmployeeDto implements Serializable {
    Long id;
    String last_name;
    String fst_name;
    String mid_name;
    String job_title;
    String work_ph_num;

    public EmployeeDto(Long id, String last_name, String fst_name, String mid_name, String job_title, String work_ph_num) {
        this.id = id;
        this.last_name = last_name;
        this.fst_name = fst_name;
        this.mid_name = mid_name;
        this.job_title = job_title;
        this.work_ph_num = work_ph_num;
    }

    public EmployeeDto() {
    }

    public EmployeeDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFst_name() {
        return fst_name;
    }

    public String getMid_name() {
        return mid_name;
    }

    public String getJob_title() {
        return job_title;
    }

    public String getWork_ph_num() {
        return work_ph_num;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFst_name(String fst_name) {
        this.fst_name = fst_name;
    }

    public void setMid_name(String mid_name) {
        this.mid_name = mid_name;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setWork_ph_num(String work_ph_num) {
        this.work_ph_num = work_ph_num;
    }

}
