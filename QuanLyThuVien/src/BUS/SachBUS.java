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
import DAO.SachDAO;
import DTO.SachDTO;
import DTO.TheLoaiDTO;
import DTO.TacGiaDTO;
import DTO.NhaXuatBanDTO;
import java.util.ArrayList;

public class SachBUS {
    private ArrayList<SachDTO> listSach;
    
    public SachBUS(){

    }    
   
    public void listSach() throws Exception {
        SachDAO sachdao=new SachDAO();
        listSach=new ArrayList<SachDTO>();
        listSach=sachdao.list();   
    }
    
    public void Add(SachDTO sach) throws Exception {
        listSach.add(sach);
        SachDAO sachdao=new SachDAO();
        sachdao.Insert(sach);
    }
    
    public void Edit(SachDTO sach) throws Exception {
        for(int i=0;i<listSach.size();i++) {
            if(listSach.get(i).getMaSach().equals(sach.getMaSach())) {
                listSach.set(i, sach);
                SachDAO sachdao = new SachDAO();
                sachdao.Update(sach);
                return;
            }
        }
    }
    
    public void Remove(String MaSach) throws Exception {
        for(SachDTO sach: listSach) {
            if(sach.getMaSach().equals(MaSach)) {
                listSach.remove(sach);
                SachDAO sachdao = new SachDAO();
                sachdao.Delete(MaSach);
                return;
            }
        }
    }
    
    public ArrayList<SachDTO> Search(String MaSach, String TenSach, String TheLoai, String TacGia, String NhaXuatBan, int NamXuatBan, int NamXuatBanMax, int SoLuong, int SoLuongMax, int DonGia, int DonGiaMax) {
        ArrayList<SachDTO> res=new ArrayList<SachDTO>();
        boolean masach=false, tensach=false, theloai=false, tacgia=false, nhaxuatban=false, namxuatban=false, namxuatbanmax=false, soluong=false, soluongmax=false, dongia=false, dongiamax=false;
        if(MaSach.equals(""))
            masach=true;
        if(TenSach.equals(""))
            tensach=true;
        if(TheLoai.equals(""))
            theloai=true;
        if(TacGia.equals(""))
            tacgia=true;
        if(NhaXuatBan.equals(""))
            nhaxuatban=true;
        if(NamXuatBan==-1)
            namxuatban=true;
        if(NamXuatBanMax==-1)
            namxuatbanmax=true;
        if(SoLuong==-1)
            soluong=true;
        if(SoLuongMax==-1)
            soluongmax=true;
        if(DonGia==-1)
            dongia=true;
        if(DonGiaMax==-1)
            dongiamax=true;
        for(SachDTO sach: listSach){
            if(!MaSach.equals(""))
                masach=(sach.getMaSach().contains(MaSach)) ? true : false;
            if(!TenSach.equals(""))
                tensach=(sach.getTenSach().contains(TenSach)) ? true : false;
            if(!TheLoai.equals(""))
                theloai=(sach.getTheLoai().contains(TheLoai)) ? true : false;
            if(!TacGia.equals(""))
                tacgia=(sach.getTacGia().contains(TacGia)) ? true : false;
            if(!NhaXuatBan.equals(""))
                nhaxuatban=(sach.getNhaXuatBan().contains(NhaXuatBan)) ? true : false;
            if(NamXuatBan!=-1)
                namxuatban=(sach.getNamXuatBan()>=NamXuatBan) ? true : false;
            if(NamXuatBanMax!=-1)
                namxuatbanmax=(sach.getNamXuatBan()<=NamXuatBanMax) ? true : false;
            if(SoLuong!=-1)
                soluong=(sach.getSoLuong()>=SoLuong) ? true : false;
            if(SoLuongMax!=-1)
                soluongmax=(sach.getSoLuong()<=SoLuongMax) ? true : false;
            if(DonGia!=-1)
                dongia=(sach.getDonGia()>=DonGia) ? true : false;
            if(DonGiaMax!=-1)
                dongiamax=(sach.getDonGia()<=DonGiaMax) ? true : false;
            if(masach && tensach && theloai && tacgia && nhaxuatban && namxuatban && namxuatbanmax && soluong && soluongmax && dongia && dongiamax)
                res.add(sach);
        }
        return res;
    }
    
    public ArrayList<SachDTO> getList(){
        return listSach;
    }
}
