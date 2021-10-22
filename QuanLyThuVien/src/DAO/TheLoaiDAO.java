/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Lộc
 */
import DTO.TheLoaiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class TheLoaiDAO {
    MyConnectUnit connect;
    
    public TheLoaiDAO() {
        connect=DAO.getDAO();
    }
    
    public ArrayList<TheLoaiDTO> list(String condition, String OrderBy) throws Exception {
        ResultSet result=this.connect.Select("theloai", condition, OrderBy);
        ArrayList<TheLoaiDTO> listTheLoai=new ArrayList<TheLoaiDTO>();
        while(result.next()){
            TheLoaiDTO theloai=new TheLoaiDTO();
            theloai.setMaTheLoai(result.getString("MaTL"));
            theloai.setTenTheLoai(result.getString("TenTL"));
            listTheLoai.add(theloai);
        }
        return listTheLoai;
    }
    
    public ArrayList<TheLoaiDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<TheLoaiDTO> list() throws Exception{
        return list(null);
    }
    
    public void Insert(TheLoaiDTO theloai) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("MaTL", theloai.getMaTheLoai());
        map.put("TenTL", theloai.getTenTheLoai());
        this.connect.Insert("theloai", map);
    }
    
    public void Update(TheLoaiDTO theloai) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("MaTL", theloai.getMaTheLoai());
        map.put("TenTL", theloai.getTenTheLoai());
        this.connect.Update("theloai", map, "MaTL = '" + theloai.getMaTheLoai() + "'");
    }
    
    public void Delete(String MaTL) throws Exception{
        this.connect.Delete("theloai", "MaTL = '" + MaTL + "'" );    
    }
    
    public TheLoaiDTO getByID(String id) throws Exception{
        ArrayList<TheLoaiDTO> listTheLoai=this.list("MaTL = " + "'" + id + "'");
        if(listTheLoai.size()>0)
            return listTheLoai.toArray(new TheLoaiDTO[listTheLoai.size()])[0];
        return null;
    }
    
    public TheLoaiDTO getByName(String name) throws Exception{
        ArrayList<TheLoaiDTO> listTheLoai=this.list("TenTL = " + "'" + name + "'");
        if(listTheLoai.size()>0)
            return listTheLoai.toArray(new TheLoaiDTO[listTheLoai.size()])[0];
        return null;
    }
}
