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
import DAO.PhieuMuonDAO;
import DTO.PhieuMuonDTO;
import DTO.PhieuPhatDTO;
import DTO.ChiTietPhieuMuonDTO;
import DTO.ChiTietPhieuPhatDTO;
import java.util.ArrayList;
public class PhieuMuonBUS {
    private ArrayList<PhieuMuonDTO> listPhieuMuon;
    
    public void listPhieuMuon () throws Exception{
        PhieuMuonDAO phieumuon=new PhieuMuonDAO();
        listPhieuMuon=new ArrayList<PhieuMuonDTO>();
        listPhieuMuon=phieumuon.list();
    }
    public ArrayList<PhieuMuonDTO> getList(){
        return listPhieuMuon;
    }
    public void Add(PhieuMuonDTO phieumuon) throws Exception{
        listPhieuMuon.add(phieumuon);
        PhieuMuonDAO phieumuondao=new PhieuMuonDAO();
        phieumuondao.Insert(phieumuon);
    }
    public void Edit(PhieuMuonDTO phieumuon) throws Exception {
        for(int i=0;i<listPhieuMuon.size();i++) {
            if(listPhieuMuon.get(i).getMaPhieuMuon().equals(phieumuon.getMaPhieuMuon())) {
                listPhieuMuon.set(i, phieumuon);
                PhieuMuonDAO phieumuondao = new PhieuMuonDAO();
                phieumuondao.Update(phieumuon);
                return;
            }
        }
    }
    public ArrayList<PhieuMuonDTO> Search(String MaPhieuMuon, String MaDocGia, String MaNhanVien, String NgayMuon, String NgayHenTra, int TinhTrang) {
        ArrayList<PhieuMuonDTO> res=new ArrayList<PhieuMuonDTO>();
        boolean mapm=false, madg=false, manv=false, ngaymuon=false, ngayhentra=false, tt=false;
        if(MaPhieuMuon.equals(""))
            mapm=true;
        if(MaDocGia.equals(""))
            madg=true;
        if(MaNhanVien.equals(""))
            manv=true;
        if(NgayMuon.equals(""))
             ngaymuon=true;
        if(NgayHenTra.equals(""))
            ngayhentra=true;
        if(TinhTrang==-1)
            tt=true;
        
        for(PhieuMuonDTO phieumuon: listPhieuMuon){
            if(!MaPhieuMuon.equals(""))
                mapm=(phieumuon.getMaPhieuMuon().contains(MaPhieuMuon)) ? true : false;
            if(!MaDocGia.equals(""))
                madg=(phieumuon.getMaDocGia().contains(MaDocGia)) ? true : false;
            if(!MaNhanVien.equals(""))
                manv=(phieumuon.getMaNhanVien().contains(MaNhanVien)) ? true : false;
            if(!NgayMuon.equals(""))
                ngaymuon=(phieumuon.getNgayMuon().contains(NgayMuon)) ? true : false;
            if(!NgayHenTra.equals(""))
                ngayhentra=(phieumuon.getNgayHenTra().contains(NgayHenTra)) ? true : false;
            if(TinhTrang!=-1)
                tt=(phieumuon.getTinhTrang() ==TinhTrang) ? true : false;
            
            if(mapm && madg && manv && ngaymuon && ngayhentra && tt)
                res.add(phieumuon);
        }
        return res;
    }
    public void Remove(String MaPhieuMuon) throws Exception {
        for(PhieuMuonDTO phieumuon: listPhieuMuon) {
            if(phieumuon.getMaPhieuMuon().equals(MaPhieuMuon)) {
                listPhieuMuon.remove(phieumuon);
                PhieuMuonDAO phieumuondao = new PhieuMuonDAO();
                phieumuondao.Delete(MaPhieuMuon);
                return;
            }
        }
    }
}
