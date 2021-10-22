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
public class MaDocGiaDTO {
    private String MaDG,HoLot,Ten;
    public MaDocGiaDTO(){
        
    }

    public MaDocGiaDTO(String MaNV, String HoLot, String Ten) {
        this.MaDG = MaNV;
        this.HoLot = HoLot;
        this.Ten = Ten;
    }
    

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaNV) {
        this.MaDG = MaNV;
    }

    public String getHoLot() {
        return HoLot;
    }

    public void setHoLot(String HoLot) {
        this.HoLot = HoLot;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    
}
