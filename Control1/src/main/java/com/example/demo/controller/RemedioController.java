package com.example.demo.controller;

import com.example.demo.entity.RemedioEntity;
import com.example.demo.interfaces.IRemedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Solo para enviar JSON
@RequestMapping("/api/v1/entities/remedio")
public class RemedioController {

    @Autowired
    private IRemedioService remedioService;
    
    @GetMapping("/{id}")
    public ResponseEntity<RemedioEntity> getById(@PathVariable Long id) {
        RemedioEntity r = remedioService.findById(id);
        return r != null ? ResponseEntity.ok(r) : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/")
    public List<RemedioEntity> getAll() {
        return remedioService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<RemedioEntity> create(@RequestBody RemedioEntity remedio) {
        return new ResponseEntity<>(remedioService.save(remedio), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RemedioEntity nuevo) {
        RemedioEntity actual = remedioService.findById(id);
        if (actual == null) return ResponseEntity.notFound().build();
        
        actual.setNombreCientifico(nuevo.getNombreCientifico());
        actual.setMarca(nuevo.getMarca());
        actual.setGramos(nuevo.getGramos());
        actual.setAnio(nuevo.getAnio());
        actual.setTipo(nuevo.getTipo());
        actual.setControlado(nuevo.isControlado());
        
        return ResponseEntity.ok(remedioService.save(actual));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        remedioService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}