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
    public ResponseEntity<List<AutorModel>> findAll(){
        List<AutorModel> requisicao = autorService.findAll();
        return ResponseEntity.ok().body(requisicao);
    }

    @PostMapping
    public ResponseEntity <AutorModel> criarPessoa(@RequestBody AutorModel autorModel){
        AutorModel requisicao = autorService.criarPessoa(autorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(autorModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requisicao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<AutorModel> buscarId(@PathVariable Long id){
        return  autorService.buscarId(id);
    }

    @PutMapping("/{id}")
    public AutorModel atualizar(@PathVariable Long id, @RequestBody AutorModel autorModel){
        return autorService.atualizar(id,autorModel);
    }


}
