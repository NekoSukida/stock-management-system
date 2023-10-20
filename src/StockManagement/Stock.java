package StockManagement;

import java.time.LocalDate;

public class Stock {
    private int id;
    private String name;
    private double unitPrice;
    private int qty;
    private LocalDate importedDate;

    public Stock() {
    }

    public Stock(int id, String name, double unitPrice, int qty, LocalDate importedDate) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public LocalDate getImportedDate() {
        return importedDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setImportedDate(LocalDate importedDate) {
        this.importedDate = importedDate;
    }
}