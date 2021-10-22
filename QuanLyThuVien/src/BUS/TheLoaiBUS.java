/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author Lộc
 */
import DAO.TheLoaiDAO;
import DTO.TheLoaiDTO;
import java.util.ArrayList;

public class TheLoaiBUS {
    private ArrayList<TheLoaiDTO> listTheLoai;
    
    public TheLoaiBUS(){
    
    }
    
    public void listTheLoai() throws Exception{
        TheLoaiDAO theloaidao=new TheLoaiDAO();
        listTheLoai=new ArrayList<TheLoaiDTO>();
        listTheLoai=theloaidao.list();
    }
    
    public void Add(TheLoaiDTO theloai) throws Exception {
        listTheLoai.add(theloai);
        TheLoaiDAO theloaidao=new TheLoaiDAO();
        theloaidao.Insert(theloai);
    }
    
    public void Edit(TheLoaiDTO theloai) throws Exception {
        for(int i=0;i<listTheLoai.size();i++) {
            if(listTheLoai.get(i).getMaTheLoai().equals(theloai.getMaTheLoai())) {
                listTheLoai.set(i, theloai);
                TheLoaiDAO theloaidao = new TheLoaiDAO();
                theloaidao.Update(theloai);
                return;
            }
        }
    }
    
    public void Remove(String MaTL) throws Exception {
        for(TheLoaiDTO theloai: listTheLoai) {
            if(theloai.getMaTheLoai().equals(MaTL)) {
                listTheLoai.remove(theloai);
                TheLoaiDAO theloaidao = new TheLoaiDAO();
                theloaidao.Delete(MaTL);
                return;
            }
        }
    }
    
    public ArrayList<TheLoaiDTO> Search(String MaTL, String TenTL){
        ArrayList<TheLoaiDTO> res=new ArrayList<TheLoaiDTO>();
        boolean matl=false, tentl=false;
        if(MaTL.equals(""))
            matl=true;
        if(TenTL.equals(""))
            tentl=true;
        for(TheLoaiDTO tl: listTheLoai){
            if(!MaTL.equals(""))
                matl=(tl.getMaTheLoai().contains(MaTL)) ? true : false;
            if(!TenTL.equals(""))
                tentl=(tl.getTenTheLoai().contains(TenTL)) ? true : false;
            if(matl && tentl)
                res.add(tl);
        }
        return res;
    }
    
    public ArrayList<TheLoaiDTO> getList(){
        return listTheLoai;
    }
}
