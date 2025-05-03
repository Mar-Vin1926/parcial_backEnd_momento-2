package com.example.demo.controller;

import com.example.demo.model.Sucursal;
import com.example.demo.service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sucursales")
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<Sucursal>> obtenerTodasSucursales() {
        List<Sucursal> sucursales = sucursalService.obtenerTodasSucursales();
        return new ResponseEntity<>(sucursales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> obtenerSucursalPorId(@PathVariable Long id) {
        Optional<Sucursal> sucursal = sucursalService.obtenerSucursalPorId(id);
        return sucursal.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Sucursal> crearSucursal(@RequestBody Sucursal sucursal) {
        Sucursal nuevaSucursal = sucursalService.guardarSucursal(sucursal);
        return new ResponseEntity<>(nuevaSucursal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> actualizarSucursal(@PathVariable Long id, @RequestBody Sucursal sucursalActualizada) {
        Optional<Sucursal> sucursal = sucursalService.actualizarSucursal(id, sucursalActualizada);
        return sucursal.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSucursal(@PathVariable Long id) {
        if (sucursalService.eliminarSucursal(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}