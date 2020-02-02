package com.example.motorshop.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private LocalDate dateTimeIn;
    private LocalDate dateTimeOut;
    private String createdBy;
    private final LocalDate createdAt = LocalDate.now();
    @ManyToOne()
    private Customer customer;
    @ManyToOne()
    private Motorcycle motorcycle;
    @ManyToOne()
    private Status status;
    @OneToOne
    private Bill bill;
    @ManyToMany
    @JoinTable(name = "visit_employee", joinColumns = @JoinColumn(name = "visit_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;

    public Visit() {
    }

    public Visit(String description, LocalDate dateTimeIn, LocalDate dateTimeOut, String createdBy, Customer customer, Motorcycle motorcycle, Status status) {
        this.description = description;
        this.dateTimeIn = dateTimeIn;
        this.dateTimeOut = dateTimeOut;
        this.createdBy = createdBy;
        this.customer = customer;
        this.motorcycle = motorcycle;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateTimeIn() {
        return dateTimeIn;
    }

    public void setDateTimeIn(LocalDate dateTimeIn) {
        this.dateTimeIn = dateTimeIn;
    }

    public LocalDate getDateTimeOut() {
        return dateTimeOut;
    }

    public void setDateTimeOut(LocalDate dateTimeOut) {
        this.dateTimeOut = dateTimeOut;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
