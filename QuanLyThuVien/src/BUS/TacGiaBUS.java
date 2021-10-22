/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author Lộc
 */
import DAO.TacGiaDAO;
import DTO.TacGiaDTO;
import java.util.ArrayList;

public class TacGiaBUS {
    private ArrayList<TacGiaDTO> listTacGia;
    
    public TacGiaBUS(){
    
    }
    
    public void listTacGia() throws Exception{
        TacGiaDAO tacgiadao=new TacGiaDAO();
        listTacGia=new ArrayList<TacGiaDTO>();
        listTacGia=tacgiadao.list();
    }
    
    public void Add(TacGiaDTO tacgia) throws Exception {
        listTacGia.add(tacgia);
        TacGiaDAO tacgiadao=new TacGiaDAO();
        tacgiadao.Insert(tacgia);
    }
    
    public void Edit(TacGiaDTO tacgia) throws Exception {
        for(int i=0;i<listTacGia.size();i++) {
            if(listTacGia.get(i).getMaTacGia().equals(tacgia.getMaTacGia())) {
                listTacGia.set(i, tacgia);
                TacGiaDAO tacgiadao = new TacGiaDAO();
                tacgiadao.Update(tacgia);
                return;
            }
        }
    }
    
    public void Remove(String MaTG) throws Exception {
        for(TacGiaDTO tacgia: listTacGia) {
            if(tacgia.getMaTacGia().equals(MaTG)) {
                listTacGia.remove(tacgia);
                TacGiaDAO tacgiadao = new TacGiaDAO();
                tacgiadao.Delete(MaTG);
                return;
            }
        }
    }
    
    public ArrayList<TacGiaDTO> Search(String MaTG, String TenTG){
        ArrayList<TacGiaDTO> res=new ArrayList<TacGiaDTO>();
        boolean matg=false, tentg=false;
        if(MaTG.equals(""))
            matg=true;
        if(TenTG.equals(""))
            tentg=true;
        for(TacGiaDTO tg: listTacGia){
            if(!MaTG.equals(""))
                matg=(tg.getMaTacGia().contains(MaTG)) ? true : false;
            if(!TenTG.equals(""))
                tentg=(tg.getTenTacGia().contains(TenTG)) ? true : false;
            if(matg && tentg)
                res.add(tg);
        }
        return res;
    }
    
    public ArrayList<TacGiaDTO> getList(){
        return listTacGia;
    }
  
}
