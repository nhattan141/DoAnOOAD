/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author 01042001
 */
import DAO.MaSachDAO;
import DTO.MaSachDTO;
import java.util.ArrayList;
public class MaSachBUS {
    private ArrayList<MaSachDTO> listMaSach;
    
    public MaSachBUS(){
    
    }
    
    public void listMaSach() throws Exception{
        MaSachDAO masachdao=new MaSachDAO();
        listMaSach=new ArrayList<MaSachDTO>();
        listMaSach=masachdao.list();
    }
    
    public ArrayList<MaSachDTO> Search(String MaSach, String TenSach){
        ArrayList<MaSachDTO> res=new ArrayList<MaSachDTO>();
        boolean masach=false, tensach=false;
        if(MaSach.equals(""))
            masach=true;
        if(TenSach.equals(""))
            tensach=true;
        for(MaSachDTO ms: listMaSach){
            if(!MaSach.equals(""))
                masach=(ms.getMaSach().contains(MaSach)) ? true : false;
            if(!TenSach.equals(""))
                tensach=(ms.getTenSach().contains(TenSach)) ? true : false;
            if(masach && tensach)
                res.add(ms);
        }
        return res;
    }
    
    public ArrayList<MaSachDTO> getList(){
        return listMaSach;
    }
}
