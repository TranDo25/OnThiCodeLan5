package com.example.onthicodelan5.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int msv;
    private String hoten;
    private int namsinh;
    private String quequan;
    private int namhoc;

    public SinhVien(int msv, String hoten, int namsinh, String quequan, int namhoc) {
        this.msv = msv;
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.quequan = quequan;
        this.namhoc = namhoc;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public int getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(int namhoc) {
        this.namhoc = namhoc;
    }

    public int getMsv() {
        return msv;
    }

    public void setMsv(int msv) {
        this.msv = msv;
    }
}
