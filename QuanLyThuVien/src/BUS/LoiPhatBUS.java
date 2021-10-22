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
import DAO.LoiPhatDAO;
import DTO.LoiPhatDTO;
import java.util.ArrayList;
public class LoiPhatBUS {
    private ArrayList<LoiPhatDTO> listLoiPhat;
    public LoiPhatBUS(){

    }    
    
    public void listLoiPhat () throws Exception{
        LoiPhatDAO loiphat=new LoiPhatDAO();
        listLoiPhat=new ArrayList<LoiPhatDTO>();
        listLoiPhat=loiphat.list();
    }
    public ArrayList<LoiPhatDTO> getList(){
        return listLoiPhat;
    }
    public void Add(LoiPhatDTO loiphat) throws Exception{
        listLoiPhat.add(loiphat);
        LoiPhatDAO loiphatdao=new LoiPhatDAO();
        loiphatdao.Insert(loiphat);
    }
    public void Edit(LoiPhatDTO loiphat) throws Exception {
        for(int i=0;i<listLoiPhat.size();i++) {
            if(listLoiPhat.get(i).getMaLoiPhat().equals(loiphat.getMaLoiPhat())) {
                listLoiPhat.set(i, loiphat);
                LoiPhatDAO loiphatdao = new LoiPhatDAO();
                loiphatdao.Update(loiphat);
                return;
            }
        }
    }
    public ArrayList<LoiPhatDTO> Search(String MaLoiPhat, String TenLoiPhat, int TienPhat) {
        ArrayList<LoiPhatDTO> res=new ArrayList<LoiPhatDTO>();
        boolean malp=false, tenlp=false, tienphat=false;
        if(MaLoiPhat.equals(""))
           malp=true;
        if(TenLoiPhat.equals(""))
             tenlp=true;
        if(TienPhat==-1)
            tienphat=true;
        
        for(LoiPhatDTO loiphat: listLoiPhat){
            if(!MaLoiPhat.equals(""))
                malp=(loiphat.getMaLoiPhat().contains(MaLoiPhat)) ? true : false;
            if(!TenLoiPhat.equals(""))
                tenlp=(loiphat.getTenLoiPhat().contains(TenLoiPhat)) ? true : false;
            if(TienPhat!=-1)
                tienphat=(loiphat.getTienPhat()==TienPhat) ? true : false;
            
            if(malp && tenlp && tienphat )
                res.add(loiphat);
        }
        return res;
    }
 
    public void Remove(String MaLoiPhat) throws Exception {
        for(LoiPhatDTO loiphat: listLoiPhat) {
            if(loiphat.getMaLoiPhat().equals(MaLoiPhat)) {
                listLoiPhat.remove(loiphat);
                LoiPhatDAO loiphatdao = new LoiPhatDAO();
                loiphatdao.Delete(MaLoiPhat);
                return;
            }
        }
    }
}
