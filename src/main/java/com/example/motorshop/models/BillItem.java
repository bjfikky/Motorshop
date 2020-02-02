package com.example.motorshop.models;

import javax.persistence.*;

@Entity
public class BillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int units;
    private double cost;
    @ManyToOne
    private Bill bill;

    public BillItem() {
    }

    public BillItem(String name, int units, double cost, Bill bill) {
        this.name = name;
        this.units = units;
        this.cost = cost;
        this.bill = bill;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
