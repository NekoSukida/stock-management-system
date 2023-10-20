package util;

import StockManagement.Stock;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.Scanner;

public class RenderTable {
    public void  renderMenu() {
        System.out.println("\n" +
                " ██████╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗     \n" +
                "██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗    \n" +
                "██║     ███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║    \n" +
                "██║     ╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║    \n" +
                "╚██████╗███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║    \n" +
                " ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝    \n" +
                "                                                                                  \n");

    }
    public void displayMenu(String ... a){
        String total="";
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table t = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        t.setColumnWidth(0, 20, 200);
        for (String b:a){
            total+=b;
        }
        t.addCell(total);
        System.out.println(t.render());
    }
    public char displaySelection(){
        char ch;
        System.out.print("Command-->");
        return new Scanner(System.in).nextLine().charAt(0);
    }
    public void displayRecord(ArrayList<Stock> arrayList){
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table t = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        t.setColumnWidth(0, 10, 50);
        t.setColumnWidth(1, 20, 50);
        t.setColumnWidth(2, 20, 50);
        t.setColumnWidth(3, 20, 50);
        t.setColumnWidth(4, 20, 50);
        t.addCell("ID",numberStyle);
        t.addCell("Name",numberStyle);
        t.addCell("Unit Price",numberStyle);
        t.addCell("Qty",numberStyle);
        t.addCell("Imported Date",numberStyle);


        for (Stock s : arrayList){
            t.addCell(String.valueOf(s.getId()),numberStyle);
            t.addCell(String.valueOf(s.getName()),numberStyle);
            t.addCell(String.valueOf(s.getUnitPrice()),numberStyle);
            t.addCell(String.valueOf(s.getQty()),numberStyle);
            t.addCell(String.valueOf(s.getImportedDate()),numberStyle);
        }
        t.addCell("Total Record:"+arrayList.size(),5);
        System.out.println(t.render());
    }

    public void displayAnElement(ArrayList<Stock> arrayList , int index){

        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table t = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        t.setColumnWidth(0, 10, 50);
        t.setColumnWidth(1, 30, 50);
        t.addCell("ID",numberStyle);
        t.addCell(String.valueOf(String.valueOf(arrayList.get(index).getId())),numberStyle);
        t.addCell("Product's Name",numberStyle);
        t.addCell(String.valueOf(String.valueOf(arrayList.get(index).getName())),numberStyle);
        t.addCell("Unit Price",numberStyle);
        t.addCell(String.valueOf(String.valueOf(arrayList.get(index).getUnitPrice())),numberStyle);
        t.addCell("Qty",numberStyle);
        t.addCell(String.valueOf(String.valueOf(arrayList.get(index).getQty())),numberStyle);
        t.addCell("Imported Date",numberStyle);
        t.addCell(String.valueOf(String.valueOf(arrayList.get(index).getImportedDate())),numberStyle);
        System.out.println(t.render());
    }


}

