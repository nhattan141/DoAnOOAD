/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Lộc
 */
import DTO.SachDTO;
import DTO.TheLoaiDTO;
import DTO.TacGiaDTO;
import DTO.NhaXuatBanDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class SachDAO {
    MyConnectUnit connect;
    
    public SachDAO() {
        connect=DAO.getDAO();
    }
    
    public ArrayList<SachDTO> list(String condition, String OrderBy) throws Exception{
        ResultSet result=this.connect.Select("sach", condition, OrderBy);
        ArrayList<SachDTO> listSach=new ArrayList<SachDTO>();
        TheLoaiDAO theloaidao=new TheLoaiDAO();
        TacGiaDAO tacgiadao=new TacGiaDAO();
        NhaXuatBanDAO nxbdao=new NhaXuatBanDAO();
        while(result.next()){
            SachDTO sach=new SachDTO();
            sach.setMaSach(result.getString("MaSach"));
            sach.setTenSach(result.getString("TenSach"));
            sach.setTheLoai(theloaidao.getByID(result.getString("MaTL")).getTenTheLoai());
            sach.setTacGia(tacgiadao.getByID(result.getString("MaTG")).getTenTacGia());
            sach.setNhaXuatBan(nxbdao.getByID(result.getString("MaNXB")).getTenNXB());
            sach.setNamXuatBan(result.getInt("NamXuatBan"));
            sach.setSoLuong(result.getInt("SoLuong"));
            sach.setDonGia(result.getInt("DonGia"));
            listSach.add(sach);
        }
        return listSach;
    }
    
    public ArrayList<SachDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<SachDTO> list() throws Exception{
        return list(null);
    }
    
    public SachDTO getByID(String id) throws Exception{
        ArrayList<SachDTO> listSach=this.list("MaSach = " + "'" + id + "'");
        if(listSach.size()>0)
            return listSach.toArray(new SachDTO[listSach.size()])[0];
        return null;
    }
    
    public void Insert(SachDTO sach) throws Exception{
        TheLoaiDAO theloaidao=new TheLoaiDAO();
        TacGiaDAO tacgiadao=new TacGiaDAO();
        NhaXuatBanDAO nxbdao=new NhaXuatBanDAO();
        TheLoaiDTO theloai=new TheLoaiDTO();
        TacGiaDTO tacgia=new TacGiaDTO();
        NhaXuatBanDTO nhaxuatban=new NhaXuatBanDTO();
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaSach", sach.getMaSach());
        map.put("TenSach", sach.getTenSach());
        theloai=theloaidao.getByName(sach.getTheLoai());
        map.put("MaTL", theloai.getMaTheLoai());
        tacgia=tacgiadao.getByName(sach.getTacGia());
        map.put("MaTG", tacgia.getMaTacGia());
        nhaxuatban=nxbdao.getByName(sach.getNhaXuatBan());
        map.put("MaNXB", nhaxuatban.getMaNXB());
        map.put("NamXuatBan", sach.getNamXuatBan());
        map.put("SoLuong", sach.getSoLuong());
        map.put("DonGia", sach.getDonGia());
 
        this.connect.Insert("sach", map);
    }
    
    public void Update(SachDTO sach) throws Exception{
        TheLoaiDAO theloaidao=new TheLoaiDAO();
        TacGiaDAO tacgiadao=new TacGiaDAO();
        NhaXuatBanDAO nxbdao=new NhaXuatBanDAO();
        TheLoaiDTO theloai=new TheLoaiDTO();
        TacGiaDTO tacgia=new TacGiaDTO();
        NhaXuatBanDTO nhaxuatban=new NhaXuatBanDTO();
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaSach", sach.getMaSach());
        map.put("TenSach", sach.getTenSach());
        theloai=theloaidao.getByName(sach.getTheLoai());
        map.put("MaTL", theloai.getMaTheLoai());
        tacgia=tacgiadao.getByName(sach.getTacGia());
        map.put("MaTG", tacgia.getMaTacGia());
        nhaxuatban=nxbdao.getByName(sach.getNhaXuatBan());
        map.put("MaNXB", nhaxuatban.getMaNXB());
        map.put("NamXuatBan", sach.getNamXuatBan());
        map.put("SoLuong", sach.getSoLuong());
        map.put("DonGia", sach.getDonGia());
 
        this.connect.Update("sach", map, "MaSach = '" + sach.getMaSach() + "'");
    }
    public void UpdateSL(SachDTO sach) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaSach", sach.getMaSach());
        map.put("SoLuong", sach.getSoLuong());
 
        this.connect.Update("sach", map, "MaSach = '" + sach.getMaSach() + "'");
    }
    
    public void Delete(String MaSach) throws Exception{
        this.connect.Delete("sach", "MaSach = '" + MaSach + "'" );    
    }
}

