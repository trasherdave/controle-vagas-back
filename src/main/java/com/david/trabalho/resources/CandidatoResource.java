/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.trabalho.resources;

import com.david.trabalho.model.Candidato;
import com.david.trabalho.model.Empresa;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.david.trabalho.repository.CandidatoRepository;
import java.util.Optional;

/**
 *
 * @author David
 */
@RestController
@Transactional
@RequestMapping(value = "/api")
public class CandidatoResource {

    @Autowired
    CandidatoRepository repository;

    //listar 
    @GetMapping("/candidatos")
    public List<Candidato> listarTodos() {
        return repository.findAll();
    }

    //listar 
    @GetMapping("/candidatos/{id}")
    public Optional<Candidato> listarPorId(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    //cadastrar 
    @PostMapping("/candidatos")
    public Candidato cadastrar(@RequestBody Candidato candidato) {
        return repository.save(candidato);
    }

    //alterar 
    @PutMapping("/candidatos/{id}")
    public Candidato atualizar(@RequestBody Candidato candidato, @PathVariable("id") long id) {
        Candidato c = new Candidato();
        c = candidato;
        c.setId(id);
        return repository.save(candidato);
    }

    //excluir 
    @DeleteMapping("/candidatos/{id}")
    public void deletar(@PathVariable("id") long id) {
        repository.deleteById(id);

    }

    @GetMapping("/candidatos/cargo/{cargo}")
    public List<Candidato> listarCandidatoPorCargo(@PathVariable("cargo") String cargo) {
        return repository.listarCandidatoPorCargo(cargo);
    }

    @GetMapping("/candidatos/cidade/{cidade}")
    public List<Candidato> listarCandidatoPorCidade(@PathVariable("cidade") String cidade) {
        return repository.listarCandidatoPorCidade(cidade);
    }

    @GetMapping("/candidatos/uf/{uf}")
    public List<Candidato> listarCandidatoPorEstado(@PathVariable("uf") String uf) {
        return repository.listarCandidatoPorEstado(uf);
    }
}
