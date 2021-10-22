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
import DAO.PhieuNhapHangDAO;
import DTO.PhieuNhapHangDTO;
import DTO.CTPhieuNhapDTO;
import java.util.ArrayList;
public class PhieuNhapHangBUS {
    private ArrayList<PhieuNhapHangDTO> listPhieuNhapHang;
    
    public void listPhieuNhapHang () throws Exception{
        PhieuNhapHangDAO phieunhaphang=new PhieuNhapHangDAO();
        listPhieuNhapHang=new ArrayList<PhieuNhapHangDTO>();
        listPhieuNhapHang=phieunhaphang.list();
    }
    public ArrayList<PhieuNhapHangDTO> getList(){
        return listPhieuNhapHang;
    }
    public void Add(PhieuNhapHangDTO phieunhaphang) throws Exception{
        listPhieuNhapHang.add(phieunhaphang);
        PhieuNhapHangDAO phieunhaphangdao=new PhieuNhapHangDAO();
        phieunhaphangdao.Insert(phieunhaphang);
    }
    public void Edit(PhieuNhapHangDTO phieunhaphang) throws Exception {
        for(int i=0;i<listPhieuNhapHang.size();i++) {
            if(listPhieuNhapHang.get(i).getMaPNH().equals(phieunhaphang.getMaPNH())) {
                listPhieuNhapHang.set(i, phieunhaphang);
                PhieuNhapHangDAO phieunhaphangdao = new PhieuNhapHangDAO();
                phieunhaphangdao.Update(phieunhaphang);
                return;
            }
        }
    }
    public ArrayList<PhieuNhapHangDTO> Search(String MaPhieuNhapHang, String MaNCC, String MaNhanVien, String NgayPhieuNhap, int TongTien) {
        ArrayList<PhieuNhapHangDTO> res=new ArrayList<PhieuNhapHangDTO>();
        boolean mapm=false, manv=false, mancc=false, ngayphieunhap=false, tongtien=false;
        if(MaPhieuNhapHang.equals(""))
            mapm=true;
        if(MaNhanVien.equals(""))
            manv=true;
        if(MaNCC.equals(""))
            mancc=true;
        if(NgayPhieuNhap.equals(""))
             ngayphieunhap=true;
        if(TongTien==-1)
            tongtien=true;
        
        for(PhieuNhapHangDTO phieunhaphang: listPhieuNhapHang){
            if(!MaPhieuNhapHang.equals(""))
                mapm=(phieunhaphang.getMaPNH().contains(MaPhieuNhapHang)) ? true : false;
            if(!MaNhanVien.equals(""))
                manv=(phieunhaphang.getNv().contains(MaNhanVien)) ? true : false;
            if(!MaNCC.equals(""))
                mancc=(phieunhaphang.getNcc().contains(MaNCC)) ? true : false;
            if(!NgayPhieuNhap.equals(""))
                ngayphieunhap=(phieunhaphang.getNgayPH().contains(NgayPhieuNhap)) ? true : false;
            if(TongTien!=-1)
                tongtien=(phieunhaphang.getTongtien()<=TongTien) ? true : false;
            
            if(mapm && mancc && manv && ngayphieunhap && tongtien)
                res.add(phieunhaphang);
        }
        return res;
    }
    public void Remove(String MaPhieuNhapHang) throws Exception {
        for(PhieuNhapHangDTO phieunhaphang: listPhieuNhapHang) {
            if(phieunhaphang.getMaPNH().equals(MaPhieuNhapHang)) {
                listPhieuNhapHang.remove(phieunhaphang);
                PhieuNhapHangDAO phieunhaphangdao = new PhieuNhapHangDAO();
                phieunhaphangdao.Delete(MaPhieuNhapHang);
                return;
            }
        }
    }
}
