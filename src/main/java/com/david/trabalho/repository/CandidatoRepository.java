/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.trabalho.repository;

import com.david.trabalho.model.Candidato;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author David
 */


public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

 
// @Query("from Candidato c join c.experiencia e where e.cargo = ?1")
     @Query("from Candidato c where c.cargo = ?1")
    public List<Candidato> listarCandidatoPorCargo(String cargo);

    @Query("from Candidato c where c.cidade = ?1")
    public List<Candidato> listarCandidatoPorCidade(String cidade);

   @Query("from Candidato c where c.uf = ?1")
    public List<Candidato> listarCandidatoPorEstado(String uf);

}
