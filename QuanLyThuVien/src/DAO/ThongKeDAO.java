package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lộc
 */
import DTO.CTPhieuNhapDTO;
import DTO.ChiTietPhieuMuonDTO;
import DTO.PhieuMuonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class ThongKeDAO {
    MyConnectUnit connect;
    
    public ThongKeDAO() {
        connect=DAO.getDAO();
    }
    
    public ArrayList<CTPhieuNhapDTO> listNH(ArrayList<String> MaPN) throws Exception{
        
        ResultSet result;
        ArrayList<CTPhieuNhapDTO> listRes = new ArrayList<CTPhieuNhapDTO>();
        String query;
        StringBuilder mapn;
        mapn = new StringBuilder();
        
        if(MaPN.size()>0){
            for(String ma: MaPN){
                mapn.append("'"+ma);
                mapn.append("',");
            }

            mapn=mapn.delete(mapn.length()-1, mapn.length());

            query="SELECT MaSach, SUM(SoLuong) AS 'SoLuong', DonGia, SUM(ThanhTien) AS 'ThanhTien'  FROM `ctphieunhap` WHERE MaPN IN ("+mapn+") GROUP BY MaSach";

            result=connect.SelectTK(query);
            while(result.next()){
                CTPhieuNhapDTO ct=new CTPhieuNhapDTO();
                ct.setSach(result.getString("MaSach"));
                ct.setSoluong(result.getInt("SoLuong"));
                ct.setDongia(result.getInt("DonGia"));
                ct.setThanhtien(result.getInt("ThanhTien"));
                listRes.add(ct);
            }
        }
        return listRes;
    }
    
    public ArrayList<Object> listPM(ArrayList<PhieuMuonDTO> MaPM) throws Exception{
        ResultSet result;
        ArrayList<Object> listRes = new ArrayList<>();
        String query;
        StringBuilder mapm;
        mapm = new StringBuilder();
        int SachDaTra=0;
        
        if(MaPM.size()>0){
            for(PhieuMuonDTO ma: MaPM){
                mapm.append("'"+ma.getMaPhieuMuon());
                mapm.append("',");
            }
            mapm=mapm.delete(mapm.length()-1, mapm.length());

            query="SELECT MaPhieuMuon, SUM(SoLuong) AS 'SoLuong'  FROM `chitietphieumuon` WHERE MaPhieuMuon IN ("+mapm+") GROUP BY MaPhieuMuon";

            result=connect.SelectTK(query);
            while(result.next()){
                ChiTietPhieuMuonDTO ct=new ChiTietPhieuMuonDTO();
                ct.setMaPhieuMuon(result.getString("MaPhieuMuon"));
                ct.setSoLuong(result.getInt("SoLuong"));
                for(PhieuMuonDTO ma: MaPM){
                    if(ma.getMaPhieuMuon().equals(result.getString("MaPhieuMuon")))
                        if(ma.getTinhTrang()==1)
                            SachDaTra+=ct.getSoLuong();
                }
                listRes.add(ct);
            }
        }
        listRes.add(SachDaTra);
        return listRes;
    }
    
    public ArrayList<Vector> listPP(ArrayList<String> MaPP) throws Exception{
        ResultSet result;
        ArrayList<Vector> listRes = new ArrayList<Vector>();
        String query;
        StringBuilder mapp;
        mapp = new StringBuilder();
        
        if(MaPP.size()>0){
            for(String ma: MaPP){
                mapp.append("'"+ma);
                mapp.append("',");
            }

            mapp=mapp.delete(mapp.length()-1, mapp.length());

            query="SELECT c.MaLoiPhat, COUNT(c.MaLoiPhat) AS 'SoLuong', l.TienPhat, (l.TienPhat*COUNT(c.MaLoiPhat)) AS 'ThanhTien' FROM chitietphieuphat as c,loiphat as l WHERE MaPhieuPhat IN (SELECT MaPhieuPhat FROM phieuphat WHERE MaPhieuMuon IN ("+mapp+") ) AND l.MaLoiPhat=c.MaLoiPhat GROUP BY c.MaLoiPhat";

            result=connect.SelectTK(query);
            while(result.next()){
                Vector row=new Vector();
                row.add(result.getString("MaLoiPhat"));
                row.add(result.getInt("SoLuong"));
                row.add(result.getString("TienPhat"));
                row.add(result.getInt("ThanhTien"));
                listRes.add(row);
            }
        }
        return listRes;
    }
    
    public static void main(String args[]) throws Exception {
        ThongKeDAO tk=new ThongKeDAO();
        ArrayList<String> MaPN=new ArrayList<String>();
        MaPN.add("1");
        MaPN.add("2");
        tk.listNH(MaPN);

    }
    
}
