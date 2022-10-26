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
public class Venda {
    private int id;
    private Cliente client;
    private ArrayList<ItemVenda> cart;
    private double total;
    private Date date;
    private boolean active;

    public Venda(int id, Cliente client, ArrayList<ItemVenda> cart, double total, Date date, boolean active) {
        this.id = id;
        this.client = client;
        this.cart = cart;
        this.total = total;
        this.date = date;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public ArrayList<ItemVenda> getCart() {
        return cart;
    }

    public void setCart(ArrayList<ItemVenda> cart) {
        this.cart = cart;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
