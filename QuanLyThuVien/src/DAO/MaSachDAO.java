/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author 01042001
 */
import DTO.MaSachDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
public class MaSachDAO {
    MyConnectUnit connect;
    public MaSachDAO() {
        connect=DAO.getDAO();
    }
    public ArrayList<MaSachDTO> list(String condition, String OrderBy) throws Exception {
        ResultSet result=this.connect.Select("sach", condition, OrderBy);
        ArrayList<MaSachDTO> listMaSach=new ArrayList<MaSachDTO>();
        while(result.next()){
            MaSachDTO theloai=new MaSachDTO();
            theloai.setMaSach(result.getString("MaSach"));
            theloai.setTenSach(result.getString("TenSach"));
            listMaSach.add(theloai);
        }
        return listMaSach;
    }
    
    public ArrayList<MaSachDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<MaSachDTO> list() throws Exception{
        return list(null);
    }
    
    public MaSachDTO getByID(String id) throws Exception{
        ArrayList<MaSachDTO> listMaSach=this.list("MaTL = " + "'" + id + "'");
        if(listMaSach.size()>0)
            return listMaSach.toArray(new MaSachDTO[listMaSach.size()])[0];
        return null;
    }
    
    public MaSachDTO getByName(String name) throws Exception{
        ArrayList<MaSachDTO> listMaSach=this.list("TenTL = " + "'" + name + "'");
        if(listMaSach.size()>0)
            return listMaSach.toArray(new MaSachDTO[listMaSach.size()])[0];
        return null;
    }
}
