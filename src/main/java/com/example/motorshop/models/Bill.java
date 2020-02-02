package com.example.motorshop.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final LocalDate date = LocalDate.now();
    private double cost;
    @OneToOne
    private Visit visit;
    @OneToMany(mappedBy = "bill")
    private List<BillItem> billItems;

    public Bill() {
    }

    public Bill(long id, double cost, Visit visit) {
        this.id = id;
        this.cost = cost;
        this.visit = visit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }
}
