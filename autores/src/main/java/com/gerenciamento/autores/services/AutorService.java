package com.gerenciamento.autores.services;


import com.gerenciamento.autores.models.AutorModel;
import com.gerenciamento.autores.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorModel> buscarTodosAutores() { return autorRepository.findAll(); }

    public AutorModel criarAutores(AutorModel autorModel){
        return autorRepository.save(autorModel);
    }

    public Optional<AutorModel> buscarAutorId(Long id) { return autorRepository.findById(id); }

    public AutorModel atualizarAutores(Long id, AutorModel autorModel){
        AutorModel model = autorRepository.findById(id).get();
        model.setNome(autorModel.getNome());
        model.setDataNascimento(autorModel.getDataNascimento());
        model.setNacionalidade(autorModel.getNacionalidade());
        return autorRepository.save(model);
    }

    public void deletarAutores(Long id){ autorRepository.deleteById(id); }


}
