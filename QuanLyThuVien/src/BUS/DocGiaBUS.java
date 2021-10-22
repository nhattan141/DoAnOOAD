
package BUS;
import DAO.DocGiaDAO;
import DTO.DocGiaDTO;
import java.util.ArrayList;

public class DocGiaBUS {
    private ArrayList<DocGiaDTO> ListDocGia;
    
    public DocGiaBUS(){
        
    }
    public void listDocGia() throws Exception{
        DocGiaDAO dgdao=new DocGiaDAO();
        ListDocGia = new ArrayList<DocGiaDTO>();
        ListDocGia=dgdao.list();
    }
    
    public void Add(DocGiaDTO docgia) throws Exception {
        ListDocGia.add(docgia);
        DocGiaDAO docgiadao=new DocGiaDAO();
        docgiadao.Insert(docgia);
    }
    
    public void Edit(DocGiaDTO docgia) throws Exception {
        for(int i=0;i<ListDocGia.size();i++) {
            if(ListDocGia.get(i).getMaDocGia().equals(docgia.getMaDocGia())) {
                ListDocGia.set(i, docgia);
                DocGiaDAO docgiadao = new DocGiaDAO();
                docgiadao.Update(docgia);
                return;
            }
        }
    }
    
    public void Remove(String MaDocGia) throws Exception {
        for(DocGiaDTO docgia: ListDocGia) {
            if(docgia.getMaDocGia().equals(MaDocGia)) {
                ListDocGia.remove(docgia);
                DocGiaDAO docgiadao = new DocGiaDAO();
                docgiadao.Delete(MaDocGia);
                return;
            }
        }
    }
    
   public ArrayList<DocGiaDTO> Search(String MaDG, String HoLot, String Ten, String NgaySinh, String NgaySinh2, int GioiTinh, String DienThoai, String DiaChi, String NgheNghiep, String TrinhDo){
        ArrayList<DocGiaDTO> res=new ArrayList<DocGiaDTO>();
        boolean madg=false, holot=false, ten=false, fromDate=false, toDate=false, ngaysinh=false, dienthoai=false, gioitinh=false, dc=false, nghenghiep=false, trinhdo=false;
        int fromD=0, fromM=0, fromY=0, toD=0, toM=0, toY=0, day=0, month=0, year=0;
        String[] dateInput1, dateInput2, date;
        if(MaDG.equals(""))
            madg=true;
        if(HoLot.equals(""))
            holot=true;
        if(Ten.equals(""))
            ten=true;
        if(NgaySinh.equals(""))
            fromDate=true;
        else{
            dateInput1=NgaySinh.split("-");
            fromD=Integer.parseInt(dateInput1[0]);
            fromM=Integer.parseInt(dateInput1[1]);
            fromY=Integer.parseInt(dateInput1[2]); 
        }
        if(NgaySinh2.equals(""))
            toDate=true;
        else{
            dateInput2=NgaySinh2.split("-");
            toD=Integer.parseInt(dateInput2[0]);
            toM=Integer.parseInt(dateInput2[1]);
            toY=Integer.parseInt(dateInput2[2]);
        }
        if(DienThoai.equals(""))
            dienthoai=true;
        if(GioiTinh==-1)
            gioitinh=true;
        if(DiaChi.equals(""))
            dc=true;
        if(NgheNghiep.equals(""))
            nghenghiep=true;
        if(TrinhDo.equals("Chọn trình độ"))
            trinhdo=true;
        for(DocGiaDTO ms: ListDocGia){
            if(!MaDG.equals(""))
                madg=(ms.getMaDocGia().contains(MaDG)) ? true : false;
            if(!HoLot.equals(""))
                holot=(ms.getHoLot().contains(HoLot)) ? true : false;
            if(!Ten.equals(""))
                ten=(ms.getTen().contains(Ten)) ? true : false;
            if(!DienThoai.equals(""))
                dienthoai=(ms.getDienThoai().contains(DienThoai)) ? true : false;
            if(!DiaChi.equals(""))
                dc=(ms.getDiaChi().contains(DiaChi)) ? true : false;
            if(!NgheNghiep.equals(""))
                nghenghiep=(ms.getNgheNghiep().contains(NgheNghiep)) ? true : false;
            if(!TrinhDo.equals("Chọn trình độ"))
                trinhdo=(ms.getTrinhDo().equals(TrinhDo)) ? true : false;
            if(GioiTinh!=-1)
                gioitinh=(ms.getGioiTinh()==GioiTinh) ? true : false;
            date=(ms.getNgaySinh()).split("-");
            day=Integer.parseInt(date[0]);
            month=Integer.parseInt(date[1]);
            year=Integer.parseInt(date[2]);
            if(!NgaySinh.equals("")){
                if(year<fromY)
                    fromDate=false;
                else{
                    if(year>fromY)
                        fromDate=true;
                    else{
                        if(month<fromM)
                            fromDate=false;
                        else{
                            if(month>fromM)
                                fromDate=true;
                            else{
                                if(day<fromD)
                                    fromDate=false;
                                else
                                    fromDate=true;
                            }
                        }
                    }
                }
            }     
            if(!NgaySinh2.equals("")){
                if(year>toY)
                    toDate=false;
                else{
                    if(year<toY)
                        toDate=true;
                    else{
                        if(month>toM)
                            toDate=false;
                        else{
                            if(month<toM)
                                toDate=true;
                            else{
                                if(day>toD)
                                    toDate=false;
                                else
                                    toDate=true;
                            }
                        }
                    }
                }
            }
            ngaysinh=(fromDate && toDate);
            if(madg&& holot && ten && ngaysinh && gioitinh && dienthoai  && dc && nghenghiep && trinhdo)
                res.add(ms);
        }
        return res;
    }
    
    public ArrayList<DocGiaDTO> getList(){
        return ListDocGia;
    }
}
