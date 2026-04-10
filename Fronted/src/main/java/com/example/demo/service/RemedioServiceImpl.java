package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; // Importante
import com.example.demo.entity.RemedioEntity; // Importante
import com.example.demo.interfaces.IRemedioService;

@Service
public class RemedioServiceImpl implements IRemedioService {
    
    // URL del Backend local con el puerto de la solemne 
    private String url = "http://localhost:6789/api/v1/entities/remedio/";
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<RemedioEntity> findAll() {
        // Obtiene el array de remedios desde el backend
        RemedioEntity[] res = restTemplate.getForObject(url, RemedioEntity[].class);
        return Arrays.asList(res);
    }

    @Override
    public RemedioEntity save(RemedioEntity remedio) {
        // Envía el objeto al backend [cite: 145]
        return restTemplate.postForObject(url, remedio, RemedioEntity.class);
    }

    @Override
    public void deleteById(Long id) {
        // Elimina el remedio usando el ID
        restTemplate.delete(url + id);
    }

    @Override
    public RemedioEntity findById(Long id) {
        // Busca un remedio específico
        return restTemplate.getForObject(url + id, RemedioEntity.class);
    }
}