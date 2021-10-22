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
public class TacGiaDTO {
    private String MaTacGia;
    private String TenTacGia;
    
    public TacGiaDTO(){
        MaTacGia=null;
        TenTacGia=null;
    }

    public TacGiaDTO(String MaTacGia, String TenTacGia) {
        this.MaTacGia = MaTacGia;
        this.TenTacGia = TenTacGia;
    }

    public String getMaTacGia() {
        return MaTacGia;
    }

    public void setMaTacGia(String MaTacGia) {
        this.MaTacGia = MaTacGia;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String TenTacGia) {
        this.TenTacGia = TenTacGia;
    }
    
}
