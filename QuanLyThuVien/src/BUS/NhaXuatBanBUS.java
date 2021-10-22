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
import DAO.NhaXuatBanDAO;
import DTO.NhaXuatBanDTO;
import java.util.ArrayList;

public class NhaXuatBanBUS {
    private ArrayList<NhaXuatBanDTO> listNXB;
    
    public NhaXuatBanBUS(){
    
    }
    
    public void listNXB() throws Exception{
        NhaXuatBanDAO nxbdao=new NhaXuatBanDAO();
        listNXB=new ArrayList<NhaXuatBanDTO>();
        listNXB=nxbdao.list();
    }
    
    public void Add(NhaXuatBanDTO nxb) throws Exception {
        listNXB.add(nxb);
        NhaXuatBanDAO nxbdao=new NhaXuatBanDAO();
        nxbdao.Insert(nxb);
    }
    
    public void Edit(NhaXuatBanDTO nxb) throws Exception {
        for(int i=0;i<listNXB.size();i++) {
            if(listNXB.get(i).getMaNXB().equals(nxb.getMaNXB())) {
                listNXB.set(i, nxb);
                NhaXuatBanDAO nxbdao = new NhaXuatBanDAO();
                nxbdao.Update(nxb);
                return;
            }
        }
    }
    
    public void Remove(String MaNXB) throws Exception {
        for(NhaXuatBanDTO nxb: listNXB) {
            if(nxb.getMaNXB().equals(MaNXB)) {
                listNXB.remove(nxb);
                NhaXuatBanDAO nxbdao = new NhaXuatBanDAO();
                nxbdao.Delete(MaNXB);
                return;
            }
        }
    }
    
    public ArrayList<NhaXuatBanDTO> Search(String MaNXB, String TenNXB){
        ArrayList<NhaXuatBanDTO> res=new ArrayList<NhaXuatBanDTO>();
        boolean manxb=false, tennxb=false;
        if(MaNXB.equals(""))
            manxb=true;
        if(TenNXB.equals(""))
            tennxb=true;
        for(NhaXuatBanDTO nxb: listNXB){
            if(!MaNXB.equals(""))
                manxb=(nxb.getMaNXB().contains(MaNXB)) ? true : false;
            if(!TenNXB.equals(""))
                tennxb=(nxb.getTenNXB().contains(TenNXB)) ? true : false;
            if(manxb && tennxb)
                res.add(nxb);
        }
        return res;
    }
    
    public ArrayList<NhaXuatBanDTO> getList(){
        return listNXB;
    }
}
