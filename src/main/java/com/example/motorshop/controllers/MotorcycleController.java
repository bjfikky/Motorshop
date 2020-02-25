package com.example.motorshop.controllers;

import com.example.motorshop.dao.MotorcycleRepository;
import com.example.motorshop.models.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/motorcycles")
public class MotorcycleController {
    private final MotorcycleRepository motorcycleRepository;

    @Autowired
    public MotorcycleController(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    @GetMapping("")
    public String getAllMotorcycles(Model model) {
        List<Motorcycle> motorcycles = (List<Motorcycle>) motorcycleRepository.findAll();
        model.addAttribute("motorcycles", motorcycles);
        return "motorcycles/index";
    }
}
