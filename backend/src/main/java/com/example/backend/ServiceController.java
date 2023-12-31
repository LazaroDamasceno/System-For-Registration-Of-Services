package com.example.backend;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
@CrossOrigin("http://localhost:5173/")
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServiceModel>> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<ServiceModel> getById(@PathVariable(value = "id") Long id) {
        return service.getById(id);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<ServiceModel>> getPendingServices() {
        return service.getPendingServices();
    }

    @GetMapping("/done")
    public ResponseEntity<List<ServiceModel>> getDoneServices() {
        return service.getDoneServices();
    }

    @GetMapping("/cancelled")
    public ResponseEntity<List<ServiceModel>> getCancelledervices() {
        return service.getCancelledervices();
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody ServiceModel model) {
        return service.save(model);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody ServiceModel model) {
        return service.save(model);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<Void> cancelService(@PathVariable(value = "id") Long id) {
        return service.cancelService(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
        return service.deleteById(id);
    }

    
}
