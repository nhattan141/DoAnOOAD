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
import DTO.NhaCungCapDTO;;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class NhaCungCapDAO {
    MyConnectUnit connect;
    
    public NhaCungCapDAO() {
        connect=DAO.getDAO();
    }
    
    public ArrayList<NhaCungCapDTO> list(String condition, String OrderBy) throws Exception{
        ResultSet result=this.connect.Select("nhacungcap", condition, OrderBy);
        ArrayList<NhaCungCapDTO> listncc=new ArrayList<NhaCungCapDTO>();
      
 
        while(result.next()){
            NhaCungCapDTO nhacungcap=new NhaCungCapDTO();
            nhacungcap.setMaNCC(result.getString("MaNCC"));
            nhacungcap.setTenNCC(result.getString("TenNCC"));
            listncc.add(nhacungcap);
        }
        return listncc;
    }
    
    public ArrayList<NhaCungCapDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<NhaCungCapDTO> list() throws Exception{
        return list(null);
    }
    
    public NhaCungCapDTO getByID(String id) throws Exception{
        ArrayList<NhaCungCapDTO> listncc=this.list("MaNCC = " + "'" + id + "'");
        if(listncc.size()>0)
            return listncc.toArray(new NhaCungCapDTO[listncc.size()])[0];
        return null;
    }
    
    public void Insert(NhaCungCapDTO nhacungcap) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaNCC", nhacungcap.getMaNCC());
        map.put("TenNCC", nhacungcap.getTenNCC());
 
        this.connect.Insert("nhacungcap", map);
    }
    
    public void Update(NhaCungCapDTO nhacungcap) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaNCC", nhacungcap.getMaNCC());
        map.put("TenNCC", nhacungcap.getTenNCC());
 
        this.connect.Update("nhacungcap", map, "MaNCC = '" + nhacungcap.getMaNCC() + "'");
    }
    
    public void Delete(String MaNhaCungCap) throws Exception{
        this.connect.Delete("nhacungcap", "MaNCC = '" + MaNhaCungCap + "'" );    
    }

    public NhaCungCapDTO getByName(String ncc) throws Exception {
        ArrayList<NhaCungCapDTO> listncc=this.list("TenNCC = " + "'" + ncc + "'");
        if(listncc.size()>0)
            return listncc.toArray(new NhaCungCapDTO[listncc.size()])[0];
        return null;
    }
}

