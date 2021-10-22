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
import DTO.LoiPhatDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;
public class LoiPhatDAO {
    MyConnectUnit connect;
    
    public LoiPhatDAO(){
        connect=DAO.getDAO();
    }
    public ArrayList<LoiPhatDTO>list(String condition, String OderBY) throws Exception{
        ResultSet result=this.connect.Select("loiphat", condition, OderBY);
        ArrayList<LoiPhatDTO> listloiphat=new ArrayList<LoiPhatDTO>();
        while(result.next()){
            LoiPhatDTO loiphat=new LoiPhatDTO();
            loiphat.setMaLoiPhat(result.getString("MaLoiPhat"));
            loiphat.setTenLoiPhat(result.getString("TenLoiPhat"));
            loiphat.setTienPhat(result.getInt("TienPhat"));
            listloiphat.add(loiphat);
        }
        return listloiphat;
    }
    public ArrayList<LoiPhatDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    public ArrayList<LoiPhatDTO>list() throws Exception{
        return list(null);
    }
    public LoiPhatDTO getByID (String id) throws Exception{
        ArrayList<LoiPhatDTO> listLoiPhat=this.list("MaLoiPhat"+" "+id+" ");
        if(listLoiPhat.size()>0)
            return listLoiPhat.toArray(new LoiPhatDTO[listLoiPhat.size()])[0];
        return null;
    }
    public void Insert(LoiPhatDTO loiphat) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaLoiPhat", loiphat.getMaLoiPhat());
        map.put("TenLoiPhat", loiphat.getTenLoiPhat());
        map.put("TienPhat", loiphat.getTienPhat());
 
        this.connect.Insert("loiphat", map);
    }
    
    public void Update(LoiPhatDTO loiphat) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaLoiPhat", loiphat.getMaLoiPhat());
        map.put("TenLoiPhat", loiphat.getTenLoiPhat());
        map.put("TienPhat", loiphat.getTienPhat());
 
        this.connect.Update("loiphat", map, "MaLoiPhat = '" + loiphat.getMaLoiPhat() + "'");
    }
    
    public void Delete(String MaLoiPhat) throws Exception{
        this.connect.Delete("loiphat", "MaLoiPhat = '" + MaLoiPhat + "'" );    
    }
}
