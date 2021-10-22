package DTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 01042001
 */
public class PhieuMuonDTO {
    private String MaPhieuMuon;
    private String MaDocGia;
    private String MaNhanVien;
    private String NgayMuon;
    private String NgayHenTra;
    private int TinhTrang;

    public PhieuMuonDTO(String MaPhieuMuon, String MaDocGia, String MaNhanVien, String NgayMuon, String NgayHenTra, int TinhTrang) {
        this.MaPhieuMuon = MaPhieuMuon;
        this.MaDocGia = MaDocGia;
        this.MaNhanVien = MaNhanVien;
        this.NgayMuon = NgayMuon;
        this.NgayHenTra = NgayHenTra;
        this.TinhTrang = TinhTrang;
    }
    public PhieuMuonDTO() {
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getMaPhieuMuon() {
        return MaPhieuMuon;
    }

    public String getMaDocGia() {
        return MaDocGia;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public String getNgayHenTra() {
        return NgayHenTra;
    }

    public void setMaPhieuMuon(String MaPhieuMuon) {
        this.MaPhieuMuon = MaPhieuMuon;
    }

    public void setMaDocGia(String MaDocGia) {
        this.MaDocGia = MaDocGia;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public void setNgayHenTra(String NgayHenTra) {
        this.NgayHenTra = NgayHenTra;
    }
    
    
    
}
