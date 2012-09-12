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
public class Pertence {
    
    @Id
    @GeneratedValue
    private long id;
    private String descricao;
    private int quantidade;
    private String categoria;
    private long idAbrigada;

    public Pertence() {
    }

    public Pertence(long id, String descricao, int quantidade, String categoria, long idAbrigada) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.categoria = categoria;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Pertence{" + "id=" + id + ", descricao=" + descricao + ", quantidade=" + quantidade + ", categoria=" + categoria + ", idAbrigada=" + idAbrigada + '}';
    }

}