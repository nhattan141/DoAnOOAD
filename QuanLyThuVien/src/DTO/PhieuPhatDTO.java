/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author 01042001
 */
public class PhieuPhatDTO {
     private String MaPhieuMuon;
    private String MaPhieuPhat;
    private int TongTien;
    
    public PhieuPhatDTO(){
        
    }

    public String getMaPhieuMuon() {
        return MaPhieuMuon;
    }

    public void setMaPhieuMuon(String MaPhieuMuon) {
        this.MaPhieuMuon = MaPhieuMuon;
    }

    public String getMaPhieuPhat() {
        return MaPhieuPhat;
    }

    public void setMaPhieuPhat(String MaPieuPhat) {
        this.MaPhieuPhat = MaPieuPhat;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
}
