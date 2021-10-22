
package DTO;

/**
 *
 * @author ASUS
 */
public class DocGiaDTO {
    private String MaDocGia;
    private String HoLot;
    private String Ten;
    private String NgaySinh;
    private int GioiTinh;
    private String DienThoai;
    private String DiaChi;
    private String NgheNghiep;
    private String TrinhDo;
    
    public DocGiaDTO(){
        
    }

    public DocGiaDTO(String MaDocGia, String HoLot, String Ten, String NgaySinh, int GioiTinh, String DienThoai, String DiaChi, String NgheNghiep, String TrinhDo) {
        this.MaDocGia = MaDocGia;
        this.HoLot = HoLot;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DienThoai = DienThoai;
        this.DiaChi = DiaChi;
        this.NgheNghiep = NgheNghiep;
        this.TrinhDo = TrinhDo;
    }

    public String getMaDocGia() {
        return MaDocGia;
    }

    public void setMaDocGia(String MaDocGia) {
        this.MaDocGia = MaDocGia;
    }

    public String getHoLot() {
        return HoLot;
    }

    public void setHoLot(String HoLot) {
        this.HoLot = HoLot;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getNgheNghiep() {
        return NgheNghiep;
    }

    public void setNgheNghiep(String NgheNghiep) {
        this.NgheNghiep = NgheNghiep;
    }

    public String getTrinhDo() {
        return TrinhDo;
    }

    public void setTrinhDo(String TrinhDo) {
        this.TrinhDo = TrinhDo;
    }
    
    
}
