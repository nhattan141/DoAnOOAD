/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author 01042001
 */
import DTO.ChiTietPhieuMuonDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class ChiTietPhieuMuonDAO {

    MyConnectUnit connect;

    public ChiTietPhieuMuonDAO() {
        connect = DAO.getDAO();
    }

    public ArrayList<ChiTietPhieuMuonDTO> list(String condition, String OderBy) throws Exception {
        ResultSet result = this.connect.Select("chitietphieumuon", condition, OderBy);
        ArrayList<ChiTietPhieuMuonDTO> listchitietctphieumuon = new ArrayList<ChiTietPhieuMuonDTO>();
        while (result.next()) {
               ChiTietPhieuMuonDTO chitiet=new ChiTietPhieuMuonDTO();
               chitiet.setMaPhieuMuon(result.getString("MaPhieuMuon"));
               chitiet.setMaSach(result.getString("MaSach"));
               chitiet.setSoLuong(result.getInt("SoLuong"));
               listchitietctphieumuon.add(chitiet);
        }
        return listchitietctphieumuon;
                
    }
    public ArrayList<ChiTietPhieuMuonDTO> listctpm(String MaPM) throws Exception {
        ResultSet result = this.connect.SelectCt(MaPM);
        ArrayList<ChiTietPhieuMuonDTO> listchitietctphieumuon = new ArrayList<ChiTietPhieuMuonDTO>();
        while (result.next()) {
               ChiTietPhieuMuonDTO chitiet=new ChiTietPhieuMuonDTO();
               chitiet.setMaPhieuMuon(result.getString("MaPhieuMuon"));
               chitiet.setMaSach(result.getString("MaSach"));
               chitiet.setSoLuong(result.getInt("SoLuong"));
               listchitietctphieumuon.add(chitiet);
        }
        return listchitietctphieumuon;
                
    }
    public ArrayList<ChiTietPhieuMuonDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    public ArrayList<ChiTietPhieuMuonDTO>list() throws Exception{
        return list(null);
    }
    public ChiTietPhieuMuonDTO getByID (String id) throws Exception{
        ArrayList<ChiTietPhieuMuonDTO> listPhieuMuon=this.list("MaPhieuMuon"+" "+id+" ");
        if(listPhieuMuon.size()>0)
            return listPhieuMuon.toArray(new ChiTietPhieuMuonDTO[listPhieuMuon.size()])[0];
        return null;
    }
    public void Insert(ChiTietPhieuMuonDTO chitietphieumuon) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaPhieuMuon", chitietphieumuon.getMaPhieuMuon());
        map.put("MaSach", chitietphieumuon.getMaSach());
        map.put("SoLuong", chitietphieumuon.getSoLuong());
 
        this.connect.Insert("chitietphieumuon"+ "", map);
    }
     public void Update(ChiTietPhieuMuonDTO ctphieumuon) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaPhieuMuon", ctphieumuon.getMaPhieuMuon());
        map.put("MaSach", ctphieumuon.getMaSach());
        //theloai=theloaidao.getByName(ctphieumuon.getTheLoai());
        map.put("SoLuong", ctphieumuon.getSoLuong());
        //tacgia=tacgiadao.getByName(ctphieumuon.getTacGia());
 
        this.connect.Update("chitietphieumuon", map, "MaPhieuMuon = '" + ctphieumuon.getMaPhieuMuon() + "'");
    }
    
    public void Delete(String MaPhieuMuon,String MaSach, int SoLuong) throws Exception{
        this.connect.Delete("chitietphieumuon", "MaPhieuMuon = '" + MaPhieuMuon+
                                                                                        "'AND MaSach = '" + MaSach+ 
                                                                                        "' AND SoLuong = '" + SoLuong+ "'" );    
    }
}
