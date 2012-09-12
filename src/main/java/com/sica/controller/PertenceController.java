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
import com.sica.dao.PertenceDAO;
import com.sica.entity.Pertence;
import java.util.List;

/**
 *
 * @author Leonn Ferreira
 */
@Resource
public class PertenceController {
    private PertenceDAO dao;
    private Result result;
    private Validator validator;
    
    public PertenceController(PertenceDAO dao, Result result, Validator validator){
        this.dao = dao;
        this.result = result;
        this.validator = validator;
        System.out.println("Criando pertenceController");
    }
    @Path("/pertence/form/{idAbrigada}")
    public void form(long idAbrigada){
        result.include("idAbrigada",idAbrigada);
    }
    
    //@Get("/pertence")
    @Path("/pertence/lista/{pertence.idAbrigada}")
    public List<Pertence> lista(Pertence pertence){
        return dao.listaTodos(pertence);
    }

    //@Get("/pertence/{pertence.id}")
    public Pertence visualiza(Pertence pertence){
        return pertence;
    }
    
    //@Post("/pertence")
    public void adiciona(final Pertence pertence){
        // Valida
        validator.checking(new Validations(){{
            that(pertence.getDescricao() != null, "pertence.descricao", "descricao.vazio");
        }});
        
        // Em caso de erro
        validator.onErrorUsePageOf(this.getClass()).form(pertence.getIdAbrigada()); 
        
        // Adiciona
        dao.adiciona(pertence); 

        // Redireciona para a listagem
        result.redirectTo("/pertence/lista/"+pertence.getIdAbrigada());
    }

    @Path("/pertence/edita/{pertence.id}")
    public void edita(Pertence pertence){        
        // Redireciona para o form de cadastro
        result.include("action", 1);
        result.include("pertence", dao.findById(pertence));
        result.include("idAbrigada",dao.findById(pertence).getIdAbrigada());
        result.redirectTo("/pertence/form/"+pertence.getIdAbrigada());
    }
    
    @Path("/pertence/atualizar")
    public void atualizar(final Pertence pertence){
         // Valida
        validator.checking(new Validations(){{
            that(pertence.getDescricao() != null, "pertence.descricao", "descricao.vazio");
        }});

        // Em caso de erro
        result.include("action");
        result.include("pertence", pertence);
        validator.onErrorUsePageOf(this.getClass()).form(pertence.getIdAbrigada()); 
        
        // Adiciona
        dao.edita(pertence); 
        
        // Redireciona para a listagem
        result.redirectTo("/pertence/lista/"+pertence.getIdAbrigada());
    }
    
    @Path("/pertence/deleta/{pertence.idAbrigada}/{pertence.id}")
    public void deleta(Pertence pertence){
        dao.deleta(pertence);
        // Redireciona para a listagem
        result.redirectTo("/pertence/lista/"+pertence.getIdAbrigada());
    }
    @Path("/pertence/info/{pertence.id}")
    public Pertence info(Pertence pertence){
       return dao.findById(pertence);
    }
}
