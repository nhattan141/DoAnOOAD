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
public class CTPhieuNhapDTO {
    private String phieunhap;
    private String sach;
    private int soluong;
    private int dongia;
    private int thanhtien;
    
    public CTPhieuNhapDTO(){
        phieunhap=null;
        sach=null;
        soluong=0;
        dongia=0;
        thanhtien=0;
    }

    public CTPhieuNhapDTO(String phieunhap, String sach, int soluong, int dongia, int thanhtien) {
        this.phieunhap = phieunhap;
        this.sach = sach;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien=thanhtien;
    }

    public String getPhieunhap() {
        return phieunhap;
    }

    public void setPhieunhap(String phieunhap) {
        this.phieunhap = phieunhap;
    }

    public String getSach() {
        return sach;
    }

    public void setSach(String sach) {
        this.sach = sach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }
    
}
