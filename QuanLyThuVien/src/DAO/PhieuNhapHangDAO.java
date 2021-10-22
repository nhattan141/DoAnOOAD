/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Vy
 */
import DTO.PhieuNhapHangDTO;
import DTO.NhanVienDTO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class PhieuNhapHangDAO {
    MyConnectUnit connect;
    
    public PhieuNhapHangDAO() {
        connect=DAO.getDAO();
    }
    
    public ArrayList<PhieuNhapHangDTO> list(String condition, String OrderBy) throws Exception{
        ResultSet result=this.connect.Select("phieunhaphang", condition, OrderBy);
        ArrayList<PhieuNhapHangDTO> listPNH=new ArrayList<PhieuNhapHangDTO>();
        while(result.next()){
            PhieuNhapHangDTO phieunhaphang=new PhieuNhapHangDTO();
            phieunhaphang.setMaPNH(result.getString("MaPN"));
            phieunhaphang.setNv(result.getString("MaNV"));
            phieunhaphang.setNcc(result.getString("MaNCC"));
            phieunhaphang.setNgayPH(result.getString("NgayNhapHang"));
            phieunhaphang.setTongtien(result.getInt("TongTien"));
            listPNH.add(phieunhaphang);
        }
        return listPNH;
    }
    
    public ArrayList<PhieuNhapHangDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<PhieuNhapHangDTO> list() throws Exception{
        return list(null);
    }
    
    public PhieuNhapHangDTO getByID(String id) throws Exception{
        ArrayList<PhieuNhapHangDTO> listPNH=this.list("MaPN = " + "'" + id + "'");
        if(listPNH.size()>0)
            return listPNH.toArray(new PhieuNhapHangDTO[listPNH.size()])[0];
        return null;
    }
    
    public void Insert(PhieuNhapHangDTO phieunhaphang) throws Exception{
      
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaPN", phieunhaphang.getMaPNH());
        map.put("MaNV", phieunhaphang.getNv());
        map.put("MaNCC", phieunhaphang.getNcc());
        map.put("NgayNhapHang", phieunhaphang.getNgayPH());
        map.put("TongTien", phieunhaphang.getTongtien());
 
        this.connect.Insert("phieunhaphang", map);
    }
    
    public void Update(PhieuNhapHangDTO phieunhaphang) throws Exception{
       
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaPN", phieunhaphang.getMaPNH());
        map.put("MaNV", phieunhaphang.getNv());
        map.put("MaNCC", phieunhaphang.getNcc());
        map.put("NgayNhapHang", phieunhaphang.getNgayPH());
        map.put("TongTien", phieunhaphang.getTongtien());
 
        this.connect.Update("phieunhaphang", map, "MaPN = '" + phieunhaphang.getMaPNH() + "'");
    }
    
    public void Delete(String MaPN) throws Exception{
        this.connect.Delete("phieunhaphang", "MaPN = '" + MaPN + "'" );    
    }
}

