package com.example.demo.service;

import com.example.demo.model.Sucursal;
import com.example.demo.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    public List<Sucursal> obtenerTodasSucursales() {
        return sucursalRepository.findAll();
    }

    public Optional<Sucursal> obtenerSucursalPorId(Long id) {
        return sucursalRepository.findById(id);
    }

    public Sucursal guardarSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Optional<Sucursal> actualizarSucursal(Long id, Sucursal sucursalActualizada) {
        return sucursalRepository.findById(id)
                .map(s -> {
                    s.setNombre(sucursalActualizada.getNombre());
                    s.setDireccion(sucursalActualizada.getDireccion());
                    s.setNumeroTelefono(sucursalActualizada.getNumeroTelefono());
                    return sucursalRepository.save(s);
                });
    }

    public boolean eliminarSucursal(Long id) {
        if (sucursalRepository.existsById(id)) {
            sucursalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}