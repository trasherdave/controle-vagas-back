/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.trabalho.resources;

import com.david.trabalho.model.Empresa;
import com.david.trabalho.model.Vaga;
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
import com.david.trabalho.repository.VagaRepository;
import java.util.Optional;

/**
 *
 * @author David
 */
@RestController
@Transactional
@RequestMapping(value = "/api")
public class VagaResource {

    @Autowired
    VagaRepository repository;

    //listar 
    @GetMapping("/vagas")
    public List<Vaga> listarTodos() {
        return repository.findAll();
    }

    //listar 
    @GetMapping("/vagas/{id}")
    public Optional<Vaga> listarPorId(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    //cadastrar 
    @PostMapping("/vagas")
    public Vaga cadastrar(@RequestBody Vaga vaga) {

        if (vaga.getEmpresaid() > 0) {

            Empresa empresa = new Empresa();
            empresa.setId(vaga.getEmpresaid());
            vaga.setEmpresa(empresa);

            System.out.println("EMPRESA: " + vaga.getEmpresaid());
            return repository.save(vaga);
        }
        
        return repository.save(vaga);
    }

    //alterar 
    @PutMapping("/vagas/{id}")
    public Vaga atualizar(@RequestBody Vaga vaga, @PathVariable("id") long id) {
        Vaga v = new Vaga();
        v = vaga;
        v.setId(id);
        return repository.save(vaga);
    }

    //excluir 
    @DeleteMapping("/vagas/{id}")
    public void deletar(@PathVariable("id") long id) {
        repository.deleteById(id);
    }

    @GetMapping("/vagas/empresa/{nome}")
    public List<Vaga> listarVagaPorEmpresa(@PathVariable("nome") String nome) {
        return repository.listarVagaPorNome(nome);
    }

    @GetMapping("/vagas/cargo/{cargo}")
    public List<Vaga> listarVagaPorCargo(@PathVariable("cargo") String cargo) {
        return repository.listarVagaPorCargo(cargo);
    }

    @GetMapping("/vagas/cidade/{cidade}")
    public List<Vaga> listarVagaPorCidade(@PathVariable("cidade") String cidade) {
        return repository.listarVagaPorCidade(cidade);
    }

    @GetMapping("/vagas/uf/{uf}")
    public List<Vaga> listarVagaPorEstado(@PathVariable("uf") String uf) {
        return repository.listarVagaPorEstado(uf);
    }
}
