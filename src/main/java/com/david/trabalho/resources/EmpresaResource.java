/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.trabalho.resources;

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
import com.david.trabalho.repository.EmpresaRepository;
import java.util.Optional;

/**
 *
 * @author David
 */
@RestController
@Transactional
@RequestMapping(value = "/api")
public class EmpresaResource {

    @Autowired
    EmpresaRepository repository;

    //listar 
    @GetMapping("/empresas")
    public List<Empresa> listar() {
        return repository.findAll();
    }

    //listar 
    @GetMapping("/empresas/{id}")
    public Optional<Empresa> listarPorId(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    //cadastrar 
    @PostMapping("/empresas")
    public Empresa cadastrar(@RequestBody Empresa empresa) {
        return repository.save(empresa);
    }

    //alterar 
    @PutMapping("/empresas/{id}")
    public Empresa atualizar(@RequestBody Empresa empresa,@PathVariable("id") long id) {
        Empresa e = new Empresa();
        e = empresa;
        e.setId(id);
        return repository.save(empresa);
    }

    //excluir 
    @DeleteMapping("/empresas/{id}")
    public void deletar(@PathVariable("id") long id) {
        repository.deleteById(id);
    }

    @GetMapping("/empresas/nome/{nome}")
    public List<Empresa> listarEmpresaPorNome(@PathVariable("nome") String nome) {
        return repository.listarEmpresaPorNome(nome);
    }

    @GetMapping("/empresas/cidade/{cidade}")
    public List<Empresa> listarEmpresaPorCidade(@PathVariable("cidade") String cidade) {
        return repository.listarEmpresaPorCidade(cidade);
    }

    @GetMapping("/empresas/uf/{uf}")
    public List<Empresa> listarEmpresaPorEstado(@PathVariable("uf") String uf) {
        return repository.listarEmpresaPorEstado(uf);
    }

}
