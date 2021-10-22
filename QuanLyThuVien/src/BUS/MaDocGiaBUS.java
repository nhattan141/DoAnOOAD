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
import DAO.MaDocGiaDAO;
import DTO.MaDocGiaDTO;
import java.util.ArrayList;
public class MaDocGiaBUS {
    private ArrayList<MaDocGiaDTO>ListMaDocGia;
    
    public MaDocGiaBUS(){
        
    }
    public void listMaDG() throws Exception{
        MaDocGiaDAO mdgdao=new MaDocGiaDAO();
        ListMaDocGia = new ArrayList<MaDocGiaDTO>();
        ListMaDocGia=mdgdao.list();
    }
   public ArrayList<MaDocGiaDTO> Search(String MaDG, String HoLot, String Ten){
        ArrayList<MaDocGiaDTO> res=new ArrayList<MaDocGiaDTO>();
        boolean madg=false, holot=false,ten=false;
        if(MaDG.equals(""))
            madg=true;
        if(HoLot.equals(""))
            holot=true;
        if(Ten.equals(""))
            ten=true;
        for(MaDocGiaDTO ms: ListMaDocGia){
            if(!MaDG.equals(""))
                madg=(ms.getMaDG().contains(MaDG)) ? true : false;
            if(!HoLot.equals(""))
                holot=(ms.getHoLot().contains(HoLot)) ? true : false;
            if(!Ten.equals(""))
                ten=(ms.getTen().contains(Ten)) ? true : false;
            if(madg && holot && ten)
                res.add(ms);
        }
        return res;
    }
    
    public ArrayList<MaDocGiaDTO> getList(){
        return ListMaDocGia;
    }
}
