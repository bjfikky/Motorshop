package com.example.motorshop.dao;

import com.example.motorshop.models.Motorcycle;
import org.springframework.data.repository.CrudRepository;

public interface MotorcycleRepository extends CrudRepository<Motorcycle, Long> {
}
