/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.PhieuMuonDTO;
import DTO.ChiTietPhieuMuonDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class printBill{

    private String file = "./report/test.pdf";
    private ArrayList<ChiTietPhieuMuonDTO> ctpm = new ArrayList<ChiTietPhieuMuonDTO>();
    private PhieuMuonDTO pm;
    private BaseFont bf;

    public printBill(PhieuMuonDTO pm, ArrayList<ChiTietPhieuMuonDTO> ctpm, String file) {
        this.pm = pm;
        this.file = file;
        this.ctpm = ctpm;
        print();
    }

    public void print() {
        String uderline = "-";
        try {
            bf = BaseFont.createFont("./font/TIMES.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Document bill = new Document(PageSize.A4, 15, 15, 10, 10);
            String line = "";
            for (int i = 0; i < bill.getPageSize().getWidth() / 5; i++) {
                line += uderline;
            }
            PdfWriter.getInstance(bill, new FileOutputStream(file));
            bill.open();
            Paragraph header = new Paragraph("Phieu Muon Sach", new Font(bf, 35));
            header.setAlignment(1);
            bill.add(header);
            Paragraph info = new Paragraph("             Ma Phieu Muon : " + pm.getMaPhieuMuon() + "   Ngay muon : " + pm.getNgayMuon(), new Font(bf, 15));
            bill.add(info);
            Paragraph l = new Paragraph(line);
            l.setAlignment(1);
            bill.add(l);
            
            //table
            String[] cellHeader = {"Ma Sach", "SL"};

            PdfPTable t = new PdfPTable(cellHeader.length);
            t.setSpacingAfter(10);
            t.setSpacingBefore(10);
            int[] relativeWidths = {20,  20};
            t.setWidths(relativeWidths);

            for (String s : cellHeader) {
                t.addCell(createCell(s, new Font(bf, 13)));
            }

            for (ChiTietPhieuMuonDTO ct : ctpm) {
                t.addCell(createCell(String.valueOf(ct.getMaSach())));
                t.addCell(createCell(Integer.toString(ct.getSoLuong())));
            }
            bill.add(t);
            bill.add(l);

            Paragraph nht = new Paragraph("Ngay Hen Tra : " + pm.getNgayHenTra()+ "   ", new Font(bf, 20));
            nht.setAlignment(Element.ALIGN_RIGHT);
            bill.add(nht);

            bill.close();

        JOptionPane.showMessageDialog(null, "In hoàn tất");
            System.out.println("Done");
        } catch (DocumentException | HeadlessException | IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public PdfPCell createCell(String s) {
        PdfPCell cell = new PdfPCell(new Phrase(s, new Font(bf, 13)));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        return cell;
    }

    public PdfPCell createCell(String s, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(s, font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        return cell;
    }
}
