package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.RemedioEntity;
import com.example.demo.interfaces.IRemedioService;

@Controller
@RequestMapping("/crud/remedio")
public class RemedioController {

    @Autowired
    private IRemedioService remedioService;

    // 1. LISTAR (El que ya te funciona)
    @GetMapping("")
    public String listar(Model model) {
        model.addAttribute("remedios", remedioService.findAll());
        return "indexremedio";
    }

    // 2. MOSTRAR FORMULARIO PARA AGREGAR
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("remedio", new RemedioEntity());
        return "remedio-form"; // Debes tener este archivo .html
    }

    // 3. GUARDAR (Para crear y para editar)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("remedio") RemedioEntity remedio) {
        remedioService.save(remedio);
        return "redirect:/crud/remedio"; // Redirige a la tabla para ver el cambio
    }

    // 4. EDITAR (Carga los datos en el formulario)
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("remedio", remedioService.findById(id));
        return "remedio-form";
    }

    // 5. ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        remedioService.deleteById(id);
        return "redirect:/crud/remedio";
    }
}