
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Vy
 */
import DTO.CTPhieuNhapDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class CTPhieuNhapDAO {

    MyConnectUnit connect;

    public CTPhieuNhapDAO() {
        connect = DAO.getDAO();
    }

    public ArrayList<CTPhieuNhapDTO> list(String condition, String OderBy) throws Exception {
        ResultSet result = this.connect.Select("ctphieunhap", condition, OderBy);
        ArrayList<CTPhieuNhapDTO> listctphieunhap = new ArrayList<CTPhieuNhapDTO>();
        while (result.next()) {
               CTPhieuNhapDTO chitiet=new CTPhieuNhapDTO();
               chitiet.setPhieunhap(result.getString("MaPN"));
               chitiet.setSach(result.getString("MaSach"));
               chitiet.setSoluong(result.getInt("SoLuong"));
               chitiet.setDongia(result.getInt("DonGia"));
               chitiet.setThanhtien(result.getInt("ThanhTien"));
               listctphieunhap.add(chitiet);
        }
        return listctphieunhap;
                
    }
    public ArrayList<CTPhieuNhapDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    public ArrayList<CTPhieuNhapDTO>list() throws Exception{
        return list(null);
    }
    public CTPhieuNhapDTO getByID (String id) throws Exception{
        ArrayList<CTPhieuNhapDTO> listPhieuNhap=this.list("MaPN"+" "+id+" ");
        if(listPhieuNhap.size()>0)
            return listPhieuNhap.toArray(new CTPhieuNhapDTO[listPhieuNhap.size()])[0];
        return null;
    }
    public void Insert(CTPhieuNhapDTO ctphieunhap) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        HashMap<String, Object> giaTriPN=new HashMap<String, Object>();
        HashMap<String, Object> giaTriSach=new HashMap<String, Object>();
        int tongtienold=0, tongtiennew=0, soluongold=0, soluongnew=0;
        PhieuNhapHangDAO phieunhap=new PhieuNhapHangDAO();
        SachDAO sach=new SachDAO();

        map.put("MaPN", ctphieunhap.getPhieunhap());
        map.put("MaSach", ctphieunhap.getSach());
        map.put("SoLuong", ctphieunhap.getSoluong());
        map.put("DonGia", ctphieunhap.getDongia());
        map.put("ThanhTien", ctphieunhap.getThanhtien());

        this.connect.Insert("ctphieunhap"+ "", map);
        
        ResultSet result = this.connect.SelectTK("SELECT TongTien FROM phieunhaphang WHERE MaPN='"+ctphieunhap.getPhieunhap()+"'");
        while(result.next()){
            tongtienold+=result.getInt("TongTien");
        }
        tongtiennew=tongtienold + ctphieunhap.getThanhtien();
        giaTriPN.put("TongTien", tongtiennew);
        
        result = this.connect.SelectTK("SELECT SoLuong FROM sach WHERE MaSach='"+ctphieunhap.getSach()+"'");
        while(result.next()){
            soluongold+=result.getInt("SoLuong");
        }
        soluongnew=soluongold + ctphieunhap.getSoluong();
        giaTriSach.put("SoLuong", soluongnew);
        
        this.connect.Update("phieunhaphang", giaTriPN, "MaPN='"+ctphieunhap.getPhieunhap()+"'");
        this.connect.Update("sach", giaTriSach, "MaSach='"+ctphieunhap.getSach()+"'");
        
    }
     public void Update(CTPhieuNhapDTO ctphieunhap) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaPN", ctphieunhap.getPhieunhap());
        map.put("MaSach", ctphieunhap.getSach());
        map.put("SoLuong", ctphieunhap.getSoluong());
        map.put("DonGia", ctphieunhap.getDongia());
        map.put("ThanhTien", ctphieunhap.getThanhtien());
 
        this.connect.Update("ctphieunhap", map, "MaPN = '" + ctphieunhap.getPhieunhap() + "'");
    }

    public void Delete(String MaPhieuNhapHang, String MaSach, int SoLuong, int DonGia, int ThanhTien) throws Exception {
        this.connect.Delete("ctphieunhap", "MaPN = '" + MaPhieuNhapHang+"'AND MaSach = '" + MaSach+ "' AND SoLuong = '" + SoLuong+"'AND DonGia = '" + DonGia+ "'AND ThanhTien = '" + ThanhTien+"'" );    
        HashMap<String, Object> giaTriPN=new HashMap<String, Object>();
        HashMap<String, Object> giaTriSach=new HashMap<String, Object>();
        int tongtienold=0, tongtiennew=0, soluongold=0, soluongnew=0;
        
        ResultSet result = this.connect.SelectTK("SELECT TongTien FROM phieunhaphang WHERE MaPN='"+MaPhieuNhapHang+"'");
        while(result.next()){
            tongtienold+=result.getInt("TongTien");
        }
        tongtiennew=tongtienold - ThanhTien;
        giaTriPN.put("TongTien", tongtiennew);
        
        result = this.connect.SelectTK("SELECT SoLuong FROM sach WHERE MaSach='"+MaSach+"'");
        while(result.next()){
            soluongold+=result.getInt("SoLuong");
        }
        soluongnew=soluongold - SoLuong;
        giaTriSach.put("SoLuong", soluongnew);
        
        this.connect.Update("phieunhaphang", giaTriPN, "MaPN='"+MaPhieuNhapHang+"'");
        this.connect.Update("sach", giaTriSach, "MaSach='"+MaSach+"'");
    }
    
    public static void main(String[] args) throws Exception{
        CTPhieuNhapDAO ct=new CTPhieuNhapDAO();
        CTPhieuNhapDTO ctpn=new CTPhieuNhapDTO();
        ctpn.setPhieunhap("PN15");
        ctpn.setSach("MS-15");
        ctpn.setSoluong(2);
        ctpn.setDongia(80000);
        ctpn.setThanhtien(160000);
        ct.Insert(ctpn);
    }
}
