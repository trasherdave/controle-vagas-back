/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.trabalho.repository;

import com.david.trabalho.model.Vaga;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author David
 */

public interface VagaRepository extends JpaRepository<Vaga, Long> {

    
    @Query("from Vaga v join v.empresa e where e.nome = ?1")
    public List<Vaga> listarVagaPorNome(String nome);

     @Query("from Vaga v where v.cargo = ?1")
    public List<Vaga> listarVagaPorCargo(String cargo);

     @Query("from Vaga v join v.empresa e where e.cidade = ?1")
    public List<Vaga> listarVagaPorCidade(String cidade);

     @Query("from Vaga v where v.uf = ?1")
    public List<Vaga> listarVagaPorEstado(String uf);

}
