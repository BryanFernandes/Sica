/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sica.entity;

import br.com.caelum.vraptor.ioc.Component;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Carlos
 */
@Entity
@Component
public class Dependente {
    
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private int idade;
    private String sexo;
    private long idAbrigada;

    public Dependente() {
    }

    public Dependente(long id, String nome, int idade, String sexo, long idAbrigada) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.idAbrigada = idAbrigada;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAbrigada() {
        return idAbrigada;
    }

    public void setIdAbrigada(long idAbrigada) {
        this.idAbrigada = idAbrigada;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Dependente{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", idAbrigada=" + idAbrigada + '}';
    }

}