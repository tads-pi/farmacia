/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmacia.view.classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kaua.ccalixto
 */
public class ItemVenda {
    private int id;
    private Produto product;
    private double amount;
    private double unitValue;
    private double totalValue;
    private Date date;

    public ItemVenda(int id, Produto product, double amount, double unitValue, double totalValue, Date date) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.unitValue = unitValue;
        this.totalValue = totalValue;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduct() {
        return product;
    }

    public void setProduct(Produto product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
