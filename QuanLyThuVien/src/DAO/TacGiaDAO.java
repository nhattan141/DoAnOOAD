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
import DTO.TacGiaDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class TacGiaDAO {
    MyConnectUnit connect;
    
    public TacGiaDAO() {
        connect=DAO.getDAO();
    }
    
    public ArrayList<TacGiaDTO> list(String condition, String OrderBy) throws Exception{
        ResultSet result=this.connect.Select("tacgia", condition, OrderBy);
        ArrayList<TacGiaDTO> listTacGia=new ArrayList<TacGiaDTO>();
        while(result.next()){
            TacGiaDTO tacgia=new TacGiaDTO();
            tacgia.setMaTacGia(result.getString("MaTG"));
            tacgia.setTenTacGia(result.getString("TenTG"));
            listTacGia.add(tacgia);
        }
        return listTacGia;
    }
    
    public ArrayList<TacGiaDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<TacGiaDTO> list() throws Exception{
        return list(null);
    }
    
    public void Insert(TacGiaDTO tacgia) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("MaTG", tacgia.getMaTacGia());
        map.put("TenTG", tacgia.getTenTacGia());
        this.connect.Insert("tacgia", map);
    }
    
    public void Update(TacGiaDTO tacgia) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("MaTG", tacgia.getMaTacGia());
        map.put("TenTG", tacgia.getTenTacGia());
        this.connect.Update("tacgia", map, "MaTG = '" + tacgia.getMaTacGia() + "'");
    }
    
    public void Delete(String MaTG) throws Exception{
        this.connect.Delete("tacgia", "MaTG = '" + MaTG + "'" );    
    }
    
    public TacGiaDTO getByID(String id) throws Exception{
        ArrayList<TacGiaDTO> listTacGia=this.list("MaTG = " + "'" + id + "'");
        if(listTacGia.size()>0)
            return listTacGia.toArray(new TacGiaDTO[listTacGia.size()])[0];
        return null;
    }
    
    public TacGiaDTO getByName(String name) throws Exception{
        ArrayList<TacGiaDTO> listTacGia=this.list("TenTG = " + "'" + name + "'");
        if(listTacGia.size()>0)
            return listTacGia.toArray(new TacGiaDTO[listTacGia.size()])[0];
        return null;
    }
}
