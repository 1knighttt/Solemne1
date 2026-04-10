package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.PersonaEntity;
import com.example.demo.interfaces.IPersonaService;
import com.example.demo.repository.PersonaRepository; 

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private PersonaRepository repo; 

    @Override
    public List<PersonaEntity> findAll() {
        
        return (List<PersonaEntity>) repo.findAll();
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public PersonaEntity save(PersonaEntity persona) {
        return repo.save(persona);
    }

    @Override
    public PersonaEntity findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}