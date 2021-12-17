/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.trabalho.repository;

import com.david.trabalho.model.Empresa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author David
 */

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

   @Query("from Empresa e where e.uf = ?1")
    public List<Empresa> listarEmpresaPorEstado(String uf);

     @Query("from Empresa e where e.cidade = ?1")
    public List<Empresa> listarEmpresaPorCidade(String cidade);

    @Query("from Empresa e where e.nome = ?1")
    public List<Empresa> listarEmpresaPorNome(String nome);

}
