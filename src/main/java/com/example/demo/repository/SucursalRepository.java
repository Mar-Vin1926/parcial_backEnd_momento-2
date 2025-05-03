package com.example.demo.repository;

import com.example.demo.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    // JpaRepository proporciona los métodos CRUD básicos.
}