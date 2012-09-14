/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sica.entity;

import br.com.caelum.vraptor.ioc.Component;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Bryan
 */
@Entity
@Component
public class RelatorioPsicoSocial implements Serializable {
    
    @Id
    private long id;
    private long idAbrigada;

    
    public RelatorioPsicoSocial() {
    }

    public RelatorioPsicoSocial(long id, long idAbrigada) {
        this.id = id;
        this.idAbrigada = idAbrigada;
    
    }
     
    public long getId() {
        return id;
    }
    
    public long getIdAbrigada() {
        return idAbrigada;
    }
    
}

