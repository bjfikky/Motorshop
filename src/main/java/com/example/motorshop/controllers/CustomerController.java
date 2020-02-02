package com.example.motorshop.controllers;

import com.example.motorshop.dao.CustomerRepository;
import com.example.motorshop.dao.MotorcycleRepository;
import com.example.motorshop.models.Customer;
import com.example.motorshop.models.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final MotorcycleRepository motorcycleRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, MotorcycleRepository motorcycleRepository) {
        this.customerRepository = customerRepository;
        this.motorcycleRepository = motorcycleRepository;
    }

    @GetMapping("")
    public String getAllCustomers(Model model) {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customers/index";
    }

    @GetMapping("/new")
    public String displayCustomerForm(Model model) {
        Customer customer = new Customer();

        Motorcycle motorcycle1 = new Motorcycle();
        Motorcycle motorcycle2 = new Motorcycle();

        customer.getMotorcycles().add(motorcycle1);
        customer.getMotorcycles().add(motorcycle2);

        model.addAttribute("customer", customer);

        return "customers/new-customer";
    }

    @PostMapping("/save")
    public String createCustomer(Customer customer, Model model) {
        customerRepository.save(customer);

        for ( Motorcycle motorcycle :customer.getMotorcycles() ) {
            motorcycle.setCustomer(customer);
        }
        motorcycleRepository.saveAll(customer.getMotorcycles());

        return "redirect:/customers/new";
    }
}
