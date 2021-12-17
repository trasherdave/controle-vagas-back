/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.trabalho.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author David
 */
@Entity
public class Vaga implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_vaga", allocationSize = 1, sequenceName = "seq_vaga", schema = "public")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_vaga")
    private long id;
    private String cargo;
    private String especificCargo;
    private String remuneracao;
    private String valeTransporte;
    private String valeRefeicao;
    private String turno;
    private String formaContratacao;
    private String uf;
    private long empresaid;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(long empresaid) {
        this.empresaid = empresaid;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecificCargo() {
        return especificCargo;
    }

    public void setEspecificCargo(String especificCargo) {
        this.especificCargo = especificCargo;
    }

    public String getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(String remuneracao) {
        this.remuneracao = remuneracao;
    }

    public String getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(String valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public String getValeRefeicao() {
        return valeRefeicao;
    }

    public void setValeRefeicao(String valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getFormaContratacao() {
        return formaContratacao;
    }

    public void setFormaContratacao(String formaContratacao) {
        this.formaContratacao = formaContratacao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
