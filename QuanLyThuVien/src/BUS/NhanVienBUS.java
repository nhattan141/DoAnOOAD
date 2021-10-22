/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author Vy
 */
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

public class NhanVienBUS {
    private ArrayList<NhanVienDTO> listNhanVien;
    
    public NhanVienBUS(){

    }    
   
    public void listNhanVien() throws Exception {
        NhanVienDAO nhanviendao=new NhanVienDAO();
        listNhanVien=new ArrayList<NhanVienDTO>();
        listNhanVien=nhanviendao.list();   
    }
    
    public void Add(NhanVienDTO nhanvien) throws Exception {
        listNhanVien.add(nhanvien);
        NhanVienDAO nhanviendao=new NhanVienDAO();
        nhanviendao.Insert(nhanvien);
    }
    
    public void Edit(NhanVienDTO nhanvien) throws Exception {
        for(int i=0;i<listNhanVien.size();i++) {
            if(listNhanVien.get(i).getManv().equals(nhanvien.getManv())) {
                listNhanVien.set(i, nhanvien);
                NhanVienDAO nhanviendao = new NhanVienDAO();
                nhanviendao.Update(nhanvien);
                return;
            }
        }
    }
    
    public void Remove(String MaNhanVien) throws Exception {
        for(NhanVienDTO nhanvien: listNhanVien) {
            if(nhanvien.getManv().equals(MaNhanVien)) {
                listNhanVien.remove(nhanvien);
                NhanVienDAO nhanviendao = new NhanVienDAO();
                nhanviendao.Delete(MaNhanVien);
                return;
            }
        }
    }
    
    public ArrayList<NhanVienDTO> Search(String MaNV, String HoLot, String Ten, String NgaySinh, String DienThoai) {
        ArrayList<NhanVienDTO> res=new ArrayList<NhanVienDTO>();
        boolean manv=false, holot=false,ten=false,ngaysinh=false,dienthoai=false,gioitinh=false;
        if(MaNV.equals(""))
            manv=true;
        if(HoLot.equals(""))
            holot=true;
        if(Ten.equals(""))
            ten=true;
        if(NgaySinh.equals(""))
            ngaysinh=true;
        if(DienThoai.equals(""))
            dienthoai=true;
        for(NhanVienDTO ms: listNhanVien){
            if(!MaNV.equals(""))
                manv=(ms.getManv().contains(MaNV)) ? true : false;
            if(!HoLot.equals(""))
                holot=(ms.getHolot().contains(HoLot)) ? true : false;
            if(!Ten.equals(""))
                ten=(ms.getTen().contains(Ten)) ? true : false;
            if(!NgaySinh.equals(""))
                ngaysinh=(ms.getNgaysinh().contains(NgaySinh)) ? true : false;
            if(!DienThoai.equals(""))
                dienthoai=(ms.getDienthoai().contains(DienThoai)) ? true : false;
    
            if(manv && holot && ten && ngaysinh && dienthoai)
                res.add(ms);
        }
        return res;
    }
    public ArrayList<NhanVienDTO> getList(){
        return listNhanVien;
    }
}
