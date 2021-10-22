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
public class NhanVienDTO {
    private String manv;
    private String holot;
    private String ten;
    private String ngaysinh;
    private String dienthoai;
    
    public NhanVienDTO(){
        manv=null;
        holot=null;
        ten=null;
        ngaysinh=null;
        dienthoai=null;

    }

    public NhanVienDTO(String manv, String holot, String ten, String ngaysinh, String dienthoai) {
        this.manv = manv;
        this.holot = holot;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.dienthoai = dienthoai;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHolot() {
        return holot;
    }

    public void setHolot(String holot) {
        this.holot = holot;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }   
}
