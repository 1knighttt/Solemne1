package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.PersonaEntity;
import com.example.demo.interfaces.IPersonaService;

@RestController
@RequestMapping("/api/v1/entities/persona") 
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(personaService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody PersonaEntity persona) {
        return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersona(@PathVariable Long id, @RequestBody PersonaEntity PersonaActualizada) {
        try {
            if (personaService.findById(id) == null) {
                return ResponseEntity.status(404).body("No se encontró persona para actualizar. ID: " + id + " \n");
            } else {
                personaService.save(PersonaEntity.builder()
                        .id(id)
                        .nombre(PersonaActualizada.getNombre())
                        .build());
                
                return ResponseEntity.ok().body("Persona actualizada con éxito. ID: " + id + " \n");
            }
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al actualizar: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        PersonaEntity p = personaService.findById(id);
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
           
            personaService.deleteById(id);
            return ResponseEntity.ok().body("Persona eliminada con éxito. ID: " + id + " \n");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar la persona ID = " + id + " \n" + e.getMessage());
        }
    }
}