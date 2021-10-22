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
public class NhaCungCapDTO {
    private String maNCC;
    private String tenNCC;
 
    
    
    public NhaCungCapDTO(){
        maNCC=null;
        tenNCC=null;
        
    }

    public NhaCungCapDTO(String maNCC, String tenNCC) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
       
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }
   
}
