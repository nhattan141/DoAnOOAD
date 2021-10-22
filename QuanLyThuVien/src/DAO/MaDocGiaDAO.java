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
import DTO.MaDocGiaDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
public class MaDocGiaDAO {
    MyConnectUnit connect;
    public MaDocGiaDAO(){
        connect=DAO.getDAO();
    }
    public ArrayList<MaDocGiaDTO>list(String condition, String OderBy) throws Exception{
        ResultSet result =this.connect.Select("docgia", condition, OderBy);
        ArrayList<MaDocGiaDTO>listMaDocGia=new ArrayList<MaDocGiaDTO>();
        while(result.next()){
            MaDocGiaDTO madg=new MaDocGiaDTO();
            madg.setMaDG(result.getString("MaDG"));
            madg.setHoLot(result.getString("HoLot"));
            madg.setTen(result.getString("Ten"));
            listMaDocGia.add(madg);
        }
        return listMaDocGia;
    }
    public ArrayList<MaDocGiaDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<MaDocGiaDTO> list() throws Exception{
        return list(null);
    }
    
}
