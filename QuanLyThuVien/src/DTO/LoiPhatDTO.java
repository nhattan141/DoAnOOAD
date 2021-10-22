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
public class LoiPhatDTO {
    private String MaLoiPhat;
    private String TenLoiPhat;
    private int TienPhat;
    
    public LoiPhatDTO(){
        
    }

    public LoiPhatDTO(String MaLoiPhat, String TenLoiPhat, int TienPhat) {
        this.MaLoiPhat = MaLoiPhat;
        this.TenLoiPhat = TenLoiPhat;
        this.TienPhat = TienPhat;
    }

    public String getMaLoiPhat() {
        return MaLoiPhat;
    }

    public void setMaLoiPhat(String MaLoiPhat) {
        this.MaLoiPhat = MaLoiPhat;
    }

    public String getTenLoiPhat() {
        return TenLoiPhat;
    }

    public void setTenLoiPhat(String TenLoiPhat) {
        this.TenLoiPhat = TenLoiPhat;
    }

    public int getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(int TienPhat) {
        this.TienPhat = TienPhat;
    }
    
    
}
