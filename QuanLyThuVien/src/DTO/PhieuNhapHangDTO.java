/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Vy
 */
public class PhieuNhapHangDTO {
    private String maPNH;
    private String nv;
    private String ncc;
    private String ngayPH;
    private int tongtien;
    
    public PhieuNhapHangDTO(){
        maPNH=null;
        nv=null;
        ncc=null;
        ngayPH=null;
        tongtien=0;
    }

    public PhieuNhapHangDTO(String maPNH, String nv, String ncc, String ngayPH, int tongtien) {
        this.maPNH = maPNH;
        this.nv = nv;
        this.ncc = ncc;
        this.ngayPH = ngayPH;
        this.tongtien=tongtien;
    }

    public String getMaPNH() {
        return maPNH;
    }

    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public String getNv() {
        return nv;
    }

    public void setNv(String nv) {
        this.nv = nv;
    }

    public String getNcc() {
        return ncc;
    }

    public void setNcc(String ncc) {
        this.ncc = ncc;
    }

    public String getNgayPH() {
        return ngayPH;
    }

    public void setNgayPH(String ngayPH) {
        this.ngayPH = ngayPH;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
}
