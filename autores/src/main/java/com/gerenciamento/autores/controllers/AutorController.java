package com.gerenciamento.autores.controllers;


import com.gerenciamento.autores.models.AutorModel;
import com.gerenciamento.autores.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoas")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorModel>> buscarTodosOsAutores(){
        List<AutorModel> requisicao = autorService.buscarTodosAutores();
        return ResponseEntity.ok().body(requisicao);
    }

    @PostMapping
    public ResponseEntity <AutorModel> criarAutor(@RequestBody AutorModel autorModel){
        AutorModel requisicao = autorService.criarAutores(autorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(autorModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requisicao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAutor(@PathVariable Long id){
        autorService.deletarAutores(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<AutorModel> buscarAutorPeloId(@PathVariable Long id){
        return  autorService.buscarAutorId(id);
    }

    @PutMapping("/{id}")
    public AutorModel atualizarAutor(@PathVariable Long id, @RequestBody AutorModel autorModel){
        return autorService.atualizarAutores(id,autorModel);
    }


}
