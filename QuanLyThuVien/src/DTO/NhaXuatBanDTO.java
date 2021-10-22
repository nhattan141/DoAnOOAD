/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Lộc
 */
public class NhaXuatBanDTO {
    private String MaNXB;
    private String TenNXB;
    
    public NhaXuatBanDTO(){
        MaNXB=null;
        TenNXB=null;
    }

    public NhaXuatBanDTO(String MaNXB, String TenNXB) {
        this.MaNXB = MaNXB;
        this.TenNXB = TenNXB;
    }

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public String getTenNXB() {
        return TenNXB;
    }

    public void setTenNXB(String TenNXB) {
        this.TenNXB = TenNXB;
    }
    
}
