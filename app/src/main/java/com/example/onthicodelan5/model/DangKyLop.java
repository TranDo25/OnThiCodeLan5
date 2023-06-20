package com.example.onthicodelan5.model;

public class DangKyLop {
    private int id;
    private int masv;
    private int malop;
    private int kyhoc;
    private int sotc;

    public DangKyLop(int id, int masv, int malop, int kyhoc, int sotc) {
        this.id = id;
        this.masv = masv;
        this.malop = malop;
        this.kyhoc = kyhoc;
        this.sotc = sotc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public int getMalop() {
        return malop;
    }

    public void setMalop(int malop) {
        this.malop = malop;
    }

    public int getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(int kyhoc) {
        this.kyhoc = kyhoc;
    }

    public int getSotc() {
        return sotc;
    }

    public void setSotc(int sotc) {
        this.sotc = sotc;
    }
}
