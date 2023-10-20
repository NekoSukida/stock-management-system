import StockManagement.Stock;
import util.RenderTable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String op;
        ArrayList<Stock> stockList = new ArrayList<>(){{
            add(new Stock(1, "Coca Cola", 2000, 10, LocalDate.now()));
            add(new Stock(2, "Sprite", 2000, 15, LocalDate.now()));
            add(new Stock(3, "Ramune", 6000, 20, LocalDate.now()));
            add(new Stock(4, "Rio", 8000, 10, LocalDate.now()));
            add(new Stock(5, "Pepsi", 1500, 50, LocalDate.now()));
            add(new Stock(6, "Dasani", 1000, 100, LocalDate.now()));
        }};
        do {
            RenderTable obj = new RenderTable();
            obj.renderMenu();
            System.out.println("===================<< Stock Management System >>========================");
            obj.displayMenu("*)Display   |   W)rite  |   R)ead   |   U)pdate |   D)elete |   F)irst  |   P)revious   |   L)ast   |  S)earch |   G)oto   |   Se)t row    |   H)elp   |   E)xit");
            System.out.print("Command -> ");
            op = input.nextLine();
            switch (op){
                case "*":
                    System.out.println("===================<< Display Product Information >>===================");
                    obj.displayRecord(stockList);
                    break;
                case "W", "w":
                    writeData(stockList);
                    break;
                case "R", "r":
                    readData(stockList);
                    break;
                case "U", "u":
                    break;
                case "D", "d":
                    deleteElement(stockList);
                    break;
                case "F", "f":
                    dataFirstElement(stockList);
                    break;
                case "L", "l":
                    dataLastElement(stockList);
                    break;
                case "P", "p":
                    break;
                case "S", "s":
                    searchElement(stockList);
                    break;
                case "G", "g":
                    break;
                case "T", "t":
                    break;
                case "H", "h":
                    break;
                case "E", "e":
                    System.out.println("<<<<<<< Thank You !!! >>>>>>");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice !!! Please Choose Again From the Guide Line!!");
                    break;
            }

        }while (true);
    }

    // Write data
    public static void writeData(ArrayList<Stock> arrayList){
        System.out.print("ID: "); int id = new Scanner(System.in).nextInt();
        System.out.print("Named Product: "); String name = new Scanner(System.in).nextLine();
        System.out.print("Price: "); double price = new Scanner(System.in).nextInt();
        System.out.print("Quantity: "); int qty = new Scanner(System.in).nextInt();
        LocalDate importedDate = LocalDate.now();
        System.out.println(" ");
        arrayList.add(new Stock(id,name,price,qty,importedDate));
    }

    // Read data
    public static void readData(ArrayList<Stock> arrayList){
        System.out.print("Read by ID: "); int id = new Scanner(System.in).nextInt();
        RenderTable display = new RenderTable();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getId()==id) index=i;
        }
        display.displayAnElement(arrayList,index);
    }

    // Update data
    public static void updateData(ArrayList<Stock> arrayList){
        RenderTable obj = new RenderTable();
        obj.displayMenu("1/Update ID","    2/Update Name","    3/Update Price","    4/Update Qty");
        char ch = obj.displaySelection();
        switch(ch){
            case '1':  idUpdating(arrayList);      break;
            case '2':  nameUpdating(arrayList);     break;
            case '3':  priceUpdating(arrayList);     break;
            case '4':  qtyUpdating(arrayList);     break;
            default:        break;
        }
    }
    public static void idUpdating(ArrayList<Stock> arrayList){
        new RenderTable().displayRecord(arrayList);
        Scanner input = new Scanner(System.in);
        System.out.print("Select Product's ID to update the element: ");
        int id = input.nextInt();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getId()==id) index=i;
        }
        System.out.println("Enter new ID: ");
        int newId = input.nextInt();
        arrayList.set(index,new Stock(newId,
                arrayList.get(index).getName(),
                arrayList.get(index).getUnitPrice(),
                arrayList.get(index).getQty(),
                arrayList.get(index).getImportedDate()));
        System.out.println("===========After Update==========");
        new RenderTable().displayRecord(arrayList);
    }
    public static void nameUpdating(ArrayList<Stock> arrayList){
        new RenderTable().displayRecord(arrayList);
        Scanner input = new Scanner(System.in);
        System.out.print("Select Product's ID to update the element: ");
        int id = input.nextInt();
        input.nextLine();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getId()==id) index=i;
        }
        System.out.println("Enter new Pro's Name: ");
        String newName = input.nextLine();
        Stock s =  arrayList.get(index);
        s.setName(newName);
        System.out.println("===========After Update==========");
        new RenderTable().displayRecord(arrayList);
    }
    public static void priceUpdating(ArrayList<Stock> arrayList){
        new RenderTable().displayRecord(arrayList);
        Scanner input = new Scanner(System.in);
        System.out.print("Select Product's ID to update the element: ");
        int id = input.nextInt();
        input.nextLine();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getId()==id) index=i;
        }
        System.out.println("Enter new Price: ");
        double newPrice = input.nextDouble();
        Stock s =  arrayList.get(index);
        s.setUnitPrice(newPrice);
        System.out.println("===========After Update==========");
        new RenderTable().displayRecord(arrayList);
    }
    public static void qtyUpdating(ArrayList<Stock> arrayList){
        new RenderTable().displayRecord(arrayList);
        Scanner input = new Scanner(System.in);
        System.out.print("Select Product's ID to update the element: ");
        int id = input.nextInt();
        input.nextLine();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getId()==id) index=i;
        }
        System.out.println("Enter new Quantity: ");
        int newQty = input.nextInt();
        Stock s=  arrayList.get(index);
        s.setQty(newQty);
        System.out.println("===========After Update==========");
        new RenderTable().displayRecord(arrayList);
    }

    //
    public static void dataFirstElement(ArrayList<Stock> arrayList){
        new RenderTable().displayAnElement(arrayList,0);
    }
    public static void dataLastElement(ArrayList<Stock> arrayList){
        new RenderTable().displayAnElement(arrayList, arrayList.size()-1);
    }

    //delete Element
    public static void deleteElement(ArrayList<Stock> arrayList){
        new RenderTable().displayRecord(arrayList);
        Scanner input = new Scanner(System.in);
        System.out.print("Select Product's ID to Delete the element: ");
        int id =input.nextInt();
        input.nextLine();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getId()==id) index=i;
        }
        arrayList.remove(index);
        System.out.println("========After Remove=======");
    }

    public static void searchElement(ArrayList<Stock> arrayList){
        RenderTable obj = new RenderTable();
        obj.displayMenu("1/Search by ID","    2/Search by Name","    3/Search by Price","    4/Search by Qty");
        char ch = obj.displaySelection();
        switch (ch){
            case '1':  searchElementByID(arrayList); break;
            case '2':searchElementByName(arrayList); break;
            case '3':searchElementByPrice(arrayList); break;
            case '4':searchElementByQty(arrayList); break;
        }
    }
    public static void searchElementByID(ArrayList<Stock> arrayList){
        System.out.print("Enter ID: "); int id = new Scanner(System.in).nextInt();
        RenderTable display = new RenderTable();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getId()==id) index=i;
        }
        display.displayAnElement(arrayList,index);
    }
    public static void searchElementByName(ArrayList<Stock> arrayList){
        b:while (true){ System.out.print("Enter Name: "); String name = new Scanner(System.in).nextLine();
            RenderTable display = new RenderTable();
            boolean ch = true;
            int index =0;
            for (int i =0 ; i< arrayList.size();i++){
                if(arrayList.get(i).getName().equals(name)) {
                    display.displayAnElement(arrayList,i);
                    ch = false; break b;
                }
            }
            if(ch){
                display.displayMenu("=====NOT FOUND=======");
            }
        }

    }

    public static void searchElementByPrice(ArrayList<Stock> arrayList){
        System.out.print("Enter Price: "); double price = new Scanner(System.in).nextDouble();
        RenderTable display = new RenderTable();
        boolean ch = true;
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getUnitPrice()==price) {
                display.displayAnElement(arrayList,i);
                ch = false;
            }
        }
        if(ch){
            display.displayMenu("=====NOT FOUND=======");
        }
    }

    public static void searchElementByQty(ArrayList<Stock> arrayList){
        System.out.print("Enter Qty: "); int qty = new Scanner(System.in).nextInt();
        RenderTable display = new RenderTable();
        boolean ch = true;
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getQty()==qty) {
                display.displayAnElement(arrayList,i);
                ch=false;
            }
        }
        if(ch){
            display.displayMenu("=====NOT FOUND=======");
        }
    }


}