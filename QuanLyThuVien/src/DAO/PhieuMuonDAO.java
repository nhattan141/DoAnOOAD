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
import DTO.PhieuMuonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
public class PhieuMuonDAO {
    MyConnectUnit connect;
    
    public PhieuMuonDAO(){
        connect=DAO.getDAO();
    }
    public ArrayList<PhieuMuonDTO> list(String condition, String OrderBy) throws Exception{
        ResultSet result=this.connect.Select("phieumuon", condition, OrderBy);
        ArrayList<PhieuMuonDTO> listPhieuMuon=new ArrayList<PhieuMuonDTO>();
        while(result.next()){
            PhieuMuonDTO phieumuon=new PhieuMuonDTO();
            phieumuon.setMaPhieuMuon(result.getString("MaPhieuMuon"));
            phieumuon.setMaDocGia(result.getString("MaDocGia"));
            phieumuon.setMaNhanVien(result.getString("MaNhanVien"));
            phieumuon.setNgayMuon(result.getString("NgayMuon"));
            phieumuon.setNgayHenTra(result.getString("NgayHenTra"));
            phieumuon.setTinhTrang(result.getInt("TinhTrang"));
            listPhieuMuon.add(phieumuon);
        }
        return listPhieuMuon;
    }
    public ArrayList<PhieuMuonDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    public ArrayList<PhieuMuonDTO>list() throws Exception{
        return list(null);
    }
    public PhieuMuonDTO getByID (String id) throws Exception{
        ArrayList<PhieuMuonDTO> listPhieuMuon=this.list("MaPhieuMuon"+" "+id+" ");
        if(listPhieuMuon.size()>0)
            return listPhieuMuon.toArray(new PhieuMuonDTO[listPhieuMuon.size()])[0];
        return null;
    }
    public void Insert(PhieuMuonDTO phieumuon) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaPhieuMuon", phieumuon.getMaPhieuMuon());
        map.put("MaDocGia", phieumuon.getMaDocGia());
        map.put("MaNhanVien", phieumuon.getMaNhanVien());
        map.put("NgayMuon", phieumuon.getNgayMuon());
        map.put("NgayHenTra", phieumuon.getNgayHenTra());
        map.put("TinhTrang", phieumuon.getTinhTrang());
 
        this.connect.Insert("phieumuon"+ "", map);
    }
    
    public void Update(PhieuMuonDTO phieumuon) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaPhieuMuon", phieumuon.getMaPhieuMuon());
        map.put("MaDocGia", phieumuon.getMaDocGia());
        //theloai=theloaidao.getByName(phieumuon.getTheLoai());
        map.put("MaNhanVien", phieumuon.getMaNhanVien());
        //tacgia=tacgiadao.getByName(phieumuon.getTacGia());
        map.put("NgayMuon", phieumuon.getNgayMuon());
        //nhaxuatban=nxbdao.getByName(phieumuon.getNhaXuatBan());
        map.put("NgayHenTra", phieumuon.getNgayHenTra());
        map.put("TinhTrang", phieumuon.getTinhTrang());
 
        this.connect.Update("phieumuon", map, "MaPhieuMuon = '" + phieumuon.getMaPhieuMuon() + "'");
    }
    
    public void Delete(String MaPhieuMuon) throws Exception{
        this.connect.Delete("phieumuon", "MaPhieuMuon = '" + MaPhieuMuon+ "'" );    
    }
}
