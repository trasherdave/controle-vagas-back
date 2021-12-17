/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.trabalho.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author David
 */
@Entity
public class Experiencia implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_experiencia", allocationSize = 1, sequenceName = "seq_experiencia", schema = "public")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_experiencia")
    private long id;
    private String empresa;
    private String cargo;
    private String tarefasExecutadas;
    private String formaContratacao;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTarefasExecutadas() {
        return tarefasExecutadas;
    }

    public void setTarefasExecutadas(String tarefasExecutadas) {
        this.tarefasExecutadas = tarefasExecutadas;
    }

    public String getFormaContratacao() {
        return formaContratacao;
    }

    public void setFormaContratacao(String formaContratacao) {
        this.formaContratacao = formaContratacao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

}
