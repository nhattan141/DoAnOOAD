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
import DAO.CTPhieuNhapDAO;
import DTO.CTPhieuNhapDTO;
import DTO.SachDTO;
import DTO.PhieuNhapHangDTO;
import java.util.ArrayList;
import DAO.SachDAO;
import BUS.SachBUS;

public class CTPhieuNhapBUS {
     private ArrayList<CTPhieuNhapDTO> listChiTiet;
     private SachBUS sachbus=new SachBUS();
    public CTPhieuNhapBUS(){
        
    }
    public void listCTPhieuNhap()throws Exception{
        CTPhieuNhapDAO chitiet=new CTPhieuNhapDAO();
        listChiTiet=new ArrayList<CTPhieuNhapDTO>();
        listChiTiet=chitiet.list();   
    }
    public ArrayList<CTPhieuNhapDTO> getList(){
        return listChiTiet;
    }
    public void Add(CTPhieuNhapDTO chitietphieunhap) throws Exception{
        listChiTiet.add(chitietphieunhap);
        CTPhieuNhapDAO ctphieunhapdao=new CTPhieuNhapDAO();
        ctphieunhapdao.Insert(chitietphieunhap);
    }
    public void Edit(CTPhieuNhapDTO ctpn) throws Exception {
        for(int i=0;i<listChiTiet.size();i++) {
            if(listChiTiet.get(i).getPhieunhap().equals(ctpn.getPhieunhap())) {
                listChiTiet.set(i, ctpn);
                CTPhieuNhapDAO ctdao = new CTPhieuNhapDAO();
                ctdao.Update(ctpn);
                return;
            }
        }
    }
    
    public ArrayList<CTPhieuNhapDTO> Search(String MaPhieuNhapHang, String MaSach, int SoLuong, int SoLuongMAX, int DonGia, int DonGiaMAX, int ThanhTien, int ThanhTienMAX) {
        ArrayList<CTPhieuNhapDTO> res=new ArrayList<CTPhieuNhapDTO>();
        boolean mapm=false, masach=false, mancc=false, soluong=false, dongia=false, thanhtien=false, soluongmax=false, dongiamax=false, thanhtienmax=false;
        if(MaSach.equals(""))
            masach=true;
        if(MaPhieuNhapHang.equals(""))
            mapm=true;
        if(SoLuong==-1)
            soluong=true;
        if(SoLuongMAX==-1)
            soluongmax=true;
        if(DonGia==-1)
            dongia=true;
        if(DonGiaMAX==-1)
            dongiamax=true;
        if(ThanhTien==-1)
            thanhtienmax=true;
        if(ThanhTienMAX==-1)
            thanhtienmax=true;
        for(CTPhieuNhapDTO ctpn: listChiTiet){
            if(!MaSach.equals(""))
                masach=(ctpn.getSach().contains(MaSach)) ? true : false;
            if(!MaPhieuNhapHang.equals(""))
                mapm=(ctpn.getPhieunhap().contains(MaPhieuNhapHang)) ? true : false;
            if(SoLuong!=-1)
                soluong=(ctpn.getSoluong()>=SoLuong) ? true : false;
            if(SoLuongMAX!=-1)
                soluongmax=(ctpn.getSoluong()<=SoLuongMAX) ? true : false;
            if(DonGia!=-1)
                dongia=(ctpn.getDongia()>=DonGia) ? true : false;
            if(DonGiaMAX!=-1)
                dongiamax=(ctpn.getDongia()<=DonGiaMAX) ? true : false;
            if(ThanhTien!=-1)
                thanhtien=(ctpn.getThanhtien()>=ThanhTien) ? true : false;
            if(ThanhTienMAX!=-1)
                thanhtienmax=(ctpn.getThanhtien()<=ThanhTienMAX) ? true : false;
            if(masach && mapm && soluong && soluongmax && dongia && dongiamax && thanhtien && thanhtienmax)
                res.add(ctpn);
        }
        return res;
    }
    
    public void Remove(String MaPhieuNhapHang, String MaSach, int SoLuong, int DonGia, int ThanhTien) throws Exception {
        for(CTPhieuNhapDTO ctpn: listChiTiet) {
            if(ctpn.getPhieunhap().equals(MaPhieuNhapHang) && ctpn.getSach().equals(MaSach) && ctpn.getSoluong()==SoLuong && ctpn.getDongia()==DonGia &&ctpn.getThanhtien()==ThanhTien) {
                listChiTiet.remove(ctpn);
                CTPhieuNhapDAO ctpndao = new CTPhieuNhapDAO();
                ctpndao.Delete(MaPhieuNhapHang, MaSach, SoLuong, DonGia, ThanhTien);
                return;
            }
        }
    }
}
