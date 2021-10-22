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
import DAO.PhieuPhatDAO;
import DTO.PhieuPhatDTO;
import java.util.ArrayList;
public class PhieuPhatBUS {
    private ArrayList<PhieuPhatDTO> listPhieuPhat;
    
    public void listPhieuPhat () throws Exception{
        PhieuPhatDAO phieumuon=new PhieuPhatDAO();
        listPhieuPhat=new ArrayList<PhieuPhatDTO>();
        listPhieuPhat=phieumuon.list();
    }
    public ArrayList<PhieuPhatDTO> getList(){
        return listPhieuPhat;
    }
    public void Add(PhieuPhatDTO phieuphat) throws Exception{
        listPhieuPhat.add(phieuphat);
        PhieuPhatDAO phieumuondao=new PhieuPhatDAO();
        phieumuondao.Insert(phieuphat);
    }
    public void Edit(PhieuPhatDTO phieuphat) throws Exception {
        
        for(int i=0;i<listPhieuPhat.size();i++) {
            if(listPhieuPhat.get(i).getMaPhieuPhat().equals(phieuphat.getMaPhieuPhat())) {
                listPhieuPhat.set(i, phieuphat);
                PhieuPhatDAO phieuphatdao = new PhieuPhatDAO();
                phieuphatdao.Update(phieuphat);
                return;
            }
        }
    }
    public void EditTongTien(PhieuPhatDTO phieuphat) throws Exception {
        for(int i=0;i<listPhieuPhat.size();i++) {
            if(listPhieuPhat.get(i).getMaPhieuPhat().equals(phieuphat.getMaPhieuPhat())) {
                listPhieuPhat.set(i, phieuphat);
                PhieuPhatDAO phieuphatdao = new PhieuPhatDAO();
                phieuphatdao.Update(phieuphat);
                return;
            }
        }
    }
    public ArrayList<PhieuPhatDTO> Search(String MaPhieuPhat, String MaPhieuMuon,int TongTien) {
        ArrayList<PhieuPhatDTO> res=new ArrayList<PhieuPhatDTO>();
        boolean mapp=false, mapm=false, tongtien=false;
        if(MaPhieuMuon.equals(""))
            mapm=true;
        if(MaPhieuPhat.equals(""))
            mapp=true;
        if(TongTien == -1)
            tongtien=true;
        
        for(PhieuPhatDTO phieuphat: listPhieuPhat){
            if(!MaPhieuMuon.equals(""))
                mapm=(phieuphat.getMaPhieuMuon().contains(MaPhieuMuon)) ? true : false;
            if(!MaPhieuPhat.equals(""))
                mapp=(phieuphat.getMaPhieuPhat().contains(MaPhieuPhat)) ? true : false;
            if(TongTien !=-1)
                tongtien=(phieuphat.getTongTien() ==TongTien) ? true : false;
            
            if(mapm && mapp && tongtien )
                res.add(phieuphat);
        }
        return res;
    }
    public void Remove(String MaPhieuPhat) throws Exception {
        for(PhieuPhatDTO phieuphat: listPhieuPhat) {
            if(phieuphat.getMaPhieuPhat().equals(MaPhieuPhat)) {
                listPhieuPhat.remove(phieuphat);
                PhieuPhatDAO ppdao = new PhieuPhatDAO();
                ppdao.Delete(MaPhieuPhat);
                return;
            }
        }
    }
}
