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
public class ChiTietPhieuPhatDTO {
     private String MaPhieuPhat;
    private String MaSach;
    private String MaLoiPhat;
    
    public ChiTietPhieuPhatDTO(){
        
    }

    public String getMaPhieuPhat() {
        return MaPhieuPhat;
    }

    public void setMaPhieuPhat(String MaPhieuPhat) {
        this.MaPhieuPhat = MaPhieuPhat;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getMaLoiPhat() {
        return MaLoiPhat;
    }

    public void setMaLoiPhat(String MaLoiPhat) {
        this.MaLoiPhat = MaLoiPhat;
    }
    
}
