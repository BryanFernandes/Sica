/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sica.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import com.sica.dao.DependenteDAO;
import com.sica.entity.Dependente;
import java.util.List;

/**
 *
 * @author Leonn Ferreira
 */
@Resource
public class DependenteController {
    private DependenteDAO dao;
    private Result result;
    private Validator validator;
    
    public DependenteController(DependenteDAO d, Result r, Validator v){
        this.dao = d;
        this.result = r;
        this.validator = v;
        System.out.println("Criando dependenteController");
    }
    @Path("/dependente/form/{idAbrigada}")
    public void form(long idAbrigada){
        result.include("idAbrigada",idAbrigada);
    }
    
    //@Get("/dependente")
    @Path("/dependente/lista/{dependente.idAbrigada}")
    public List<Dependente> lista(Dependente dependente){
        return dao.listaTodos(dependente);
    }

    //@Get("/dependente/{dependente.id}")
    public Dependente visualiza(Dependente dependente){
        return dependente;
    }
    
    //@Post("/dependente")
    public void adiciona(final Dependente dependente){
        // Valida
        validator.checking(new Validations(){{
            that(dependente.getNome() != null, "dependente.nome", "nome.vazio");            
        }});
        
        // Em caso de erro
        validator.onErrorUsePageOf(this.getClass()).form(dependente.getIdAbrigada()); 
        
        // Adiciona
        dao.adiciona(dependente); 

        // Redireciona para a listagem
        result.redirectTo("/dependente/lista/"+dependente.getIdAbrigada());
    }

    @Path("/dependente/edita/{dependente.id}")
    public void edita(Dependente dependente){        
        // Redireciona para o form de cadastro
        result.include("action", 1);
        result.include("dependente", dao.findById(dependente));
        result.include("idAbrigada",dao.findById(dependente).getIdAbrigada());
        result.redirectTo("/dependente/form/"+dependente.getIdAbrigada());
    }
    
    @Path("/dependente/atualizar")
    public void atualizar(final Dependente dependente){
         // Valida
        validator.checking(new Validations(){{
            that(dependente.getNome() != null, "dependente.nome", "nome.vazio");
        }});

        // Em caso de erro
        result.include("action");
        result.include("dependente", dependente);
        validator.onErrorUsePageOf(this.getClass()).form(dependente.getIdAbrigada()); 
        
        // Adiciona
        dao.edita(dependente); 
        
        // Redireciona para a listagem
        result.redirectTo("/dependente/lista/"+dependente.getIdAbrigada());
    }
    
    @Path("/dependente/deleta/{dependente.idAbrigada}/{dependente.id}")
    public void deleta(Dependente dependente){
        dao.deleta(dependente);
        // Redireciona para a listagem
        result.redirectTo("/dependente/lista/"+dependente.getIdAbrigada());
    }
    @Path("/dependente/info/{dependente.id}")
    public Dependente info(Dependente dependente){
       return dao.findById(dependente);
    }
}
