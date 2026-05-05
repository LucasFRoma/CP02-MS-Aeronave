package com.github.lucasfroma.montadora.controller;


import com.github.lucasfroma.montadora.model.Fabricante;
import com.github.lucasfroma.montadora.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fabricante")
public class FabricanteController {

    @Autowired
    private FabricanteRepository repository;

    @PostMapping
    public ResponseEntity<Fabricante> create (@RequestBody Fabricante fabricante){

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(fabricante));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> findById(@PathVariable Long id){

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Fabricante>> findAll(){

        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> update(@PathVariable Long id, @RequestBody Fabricante fabricante){

        Optional<Fabricante> optFabricante = repository.findById(id);

        if (optFabricante.isPresent()){
            fabricante.setId(id);
            Fabricante faricanteAlterada = repository.save(fabricante);
            return ResponseEntity.ok(faricanteAlterada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
