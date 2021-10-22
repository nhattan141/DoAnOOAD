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
import DAO.ChiTietPhieuMuonDAO;
import DAO.SachDAO;
import DTO.ChiTietPhieuMuonDTO;
import DTO.SachDTO;
import DTO.PhieuMuonDTO;
import DTO.SachDTO;
import BUS.SachBUS;

import java.util.ArrayList;
public class ChiTietPhieuMuonBUS {
    private ArrayList<ChiTietPhieuMuonDTO> listChiTiet;
    private SachBUS sachbus=new SachBUS();
    public ChiTietPhieuMuonBUS(){
        
    }
    public void listChiTietPhieuMuon()throws Exception{
        ChiTietPhieuMuonDAO chitiet=new ChiTietPhieuMuonDAO();
        listChiTiet=new ArrayList<ChiTietPhieuMuonDTO>();
        listChiTiet=chitiet.list();   
    }
    public void listChiTietPhieuMuon(String MaPhieuMuon)throws Exception{
        ChiTietPhieuMuonDAO chitiet=new ChiTietPhieuMuonDAO();
        listChiTiet=new ArrayList<ChiTietPhieuMuonDTO>();
        listChiTiet=chitiet.listctpm(MaPhieuMuon);   
    }
    public ArrayList<ChiTietPhieuMuonDTO> getList(){
        return listChiTiet;
    }
    public void Add(ChiTietPhieuMuonDTO chitietphieumuon, String MaSach) throws Exception{
        listChiTiet.add(chitietphieumuon);
        ChiTietPhieuMuonDAO ctphieumuondao=new ChiTietPhieuMuonDAO();
        ctphieumuondao.Insert(chitietphieumuon);
        ArrayList<SachDTO> listSach;
         if(sachbus.getList()==null)
             sachbus.listSach();
         listSach=sachbus.getList();
        int slsach=0;
            for(int j=0;j<listSach.size();j++)
                if(MaSach.equals(listSach.get(j).getMaSach())){
                    slsach=listSach.get(j).getSoLuong()-chitietphieumuon.getSoLuong();
                }
        SachDTO sach=new SachDTO();
        sach.setMaSach(MaSach);
        sach.setSoLuong(slsach);
        SachDAO sachdao=new SachDAO();
        sachdao.UpdateSL(sach);
    }
    public void Edit(ChiTietPhieuMuonDTO ctpm) throws Exception {
        for(int i=0;i<listChiTiet.size();i++) {
            if(listChiTiet.get(i).getMaPhieuMuon().equals(ctpm.getMaPhieuMuon())) {
                listChiTiet.set(i, ctpm);
                ChiTietPhieuMuonDAO ctdao = new ChiTietPhieuMuonDAO();
                ctdao.Update(ctpm);
                return;
            }
        }
    }
    public ArrayList<ChiTietPhieuMuonDTO> Search(String MaPhieuMuon, String MaSach, int SoLuong) {
        ArrayList<ChiTietPhieuMuonDTO> res=new ArrayList<ChiTietPhieuMuonDTO>();
        boolean mapm=false, masach=false, soluong=false;
        if(MaSach.equals(""))
            masach=true;
        if(MaPhieuMuon.equals(""))
            mapm=true;
        if(SoLuong==-1)
            soluong=true;
        for(ChiTietPhieuMuonDTO ctpm: listChiTiet){
            if(!MaSach.equals(""))
                masach=(ctpm.getMaSach().contains(MaSach)) ? true : false;
            if(!MaPhieuMuon.equals(""))
                mapm=(ctpm.getMaPhieuMuon().contains(MaPhieuMuon)) ? true : false;
            if(SoLuong!=-1)
                soluong=(ctpm.getSoLuong()>=SoLuong) ? true : false;
            if(masach && mapm && soluong )
                res.add(ctpm);
        }
        return res;
    }
    
    public void Remove(String MaPhieuMuon, String MaSach, int SoLuong) throws Exception {
        for(ChiTietPhieuMuonDTO ctpm: listChiTiet) {
            if(ctpm.getMaPhieuMuon().equals(MaPhieuMuon) &&
                    ctpm.getMaSach().equals(MaSach) &&
                    ctpm.getSoLuong()==SoLuong) {
                listChiTiet.remove(ctpm);
                ChiTietPhieuMuonDAO ctpmdao = new ChiTietPhieuMuonDAO();
                ctpmdao.Delete(MaPhieuMuon, MaSach, SoLuong);
                return;
            }
        }
    }
}
