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
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class NhanVienDAO {
    MyConnectUnit connect;
    
    public NhanVienDAO() {
        connect=DAO.getDAO();
    }
    
    public ArrayList<NhanVienDTO> list(String condition, String OrderBy) throws Exception{
        ResultSet result=this.connect.Select("nhanvien", condition, OrderBy);
        ArrayList<NhanVienDTO> listNhanVien=new ArrayList<NhanVienDTO>();

        while(result.next()){
            NhanVienDTO nhanvien=new NhanVienDTO();
            nhanvien.setManv(result.getString("MaNV"));
            nhanvien.setHolot(result.getString("HoLot"));
            nhanvien.setTen(result.getString("Ten"));
            nhanvien.setNgaysinh(result.getString("NgaySinh"));
            nhanvien.setDienthoai(result.getString("DienThoai"));
            listNhanVien.add(nhanvien);
        }
        return listNhanVien;
    }
    
    public ArrayList<NhanVienDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<NhanVienDTO> list() throws Exception{
        return list(null);
    }
    
    public NhanVienDTO getByID(String id) throws Exception{
        ArrayList<NhanVienDTO> listNhanVien=this.list("MaNV = " + "'" + id + "'");
        if(listNhanVien.size()>0)
            return listNhanVien.toArray(new NhanVienDTO[listNhanVien.size()])[0];
        return null;
    }
    
    public void Insert(NhanVienDTO nhanvien) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaNV", nhanvien.getManv());
        map.put("HoLot", nhanvien.getHolot());
        map.put("Ten", nhanvien.getTen());
        map.put("NgaySinh", nhanvien.getNgaysinh());
        map.put("DienThoai", nhanvien.getDienthoai());
 
        this.connect.Insert("nhanvien", map);
    }
    
    public void Update(NhanVienDTO nhanvien) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaNV", nhanvien.getManv());
        map.put("HoLot", nhanvien.getHolot());
        map.put("Ten", nhanvien.getTen());
        map.put("NgaySinh", nhanvien.getNgaysinh());
        map.put("DienThoai", nhanvien.getDienthoai());
 
        this.connect.Update("nhanvien", map, "MaNV = '" + nhanvien.getManv() + "'");
    }
    
    public void Delete(String MaNV) throws Exception{
        this.connect.Delete("nhanvien", "MaNV = '" + MaNV + "'" );    
    }

    public NhanVienDTO getByName(String nhanvien) throws Exception {
        ArrayList<NhanVienDTO> listNhanVien=this.list("Ten = " + "'" + nhanvien + "'");
        if(listNhanVien.size()>0)
            return listNhanVien.toArray(new NhanVienDTO[listNhanVien.size()])[0];
        return null;
    }
    
}
