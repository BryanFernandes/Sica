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
import com.sica.dao.AbrigadaDAO;
import com.sica.entity.Abrigada;
import java.util.List;

/**
 *
 * @author Leonn Ferreira
 */
@Resource
public class AbrigadaController {
    private AbrigadaDAO dao;
    private Result result;
    private Validator validator;
    
    public AbrigadaController(AbrigadaDAO dao, Result result, Validator validator){
        this.dao = dao;
        this.result = result;
        this.validator = validator;
        System.out.println("Criando abrigadaController");
    }
    
    public void form(){
        System.out.println("Chamando o form");
    }
    
    //@Get("/abrigada")
    public List<Abrigada> lista(){
        return dao.listaTodos();
    }
    
    //@Post("/abrigada")
    public void adiciona(final Abrigada abrigada){
        // Valida
        validator.checking(new Validations(){{
            that(abrigada.getNome() != null, "abrigada.nome", "nome.vazio");
            that(abrigada.getEndereco() != null, "abrigada.endereco", "endereco.vazio");
            
        }});
        
        // Em caso de erro
        validator.onErrorUsePageOf(this.getClass()).form(); 
        
        // Adiciona
        dao.adiciona(abrigada); 

        // Redireciona para a listagem
        result.redirectTo(this.getClass()).lista();
    }

    @Path("/abrigada/edita/{abrigada.id}")
    public void edita(Abrigada abrigada){        
        // Redireciona para o form de cadastro
        result.include("action", 1);
        result.include("abrigada", dao.findById(abrigada));
        result.redirectTo(this.getClass()).form();
    }
    
    @Path("/abrigada/atualizar")
    public void atualizar(final Abrigada abrigada){
         // Valida
        validator.checking(new Validations(){{
            that(abrigada.getNome() != null, "abrigada.nome", "nome.vazio");
            that(abrigada.getEndereco() != null, "abrigada.endereco", "endereco.invalido");
        }});

        // Em caso de erro
        result.include("action");
        result.include("abrigada", abrigada);
        validator.onErrorUsePageOf(this.getClass()).form(); 
        
        // Adiciona
        dao.edita(abrigada); 
        
        // Redireciona para a listagem
        result.redirectTo(this.getClass()).lista();
    }
    
    @Path("/abrigada/deleta/{abrigada.id}")
    public void deleta(Abrigada abrigada){
        dao.deleta(abrigada);
        // Redireciona para a listagem
        result.redirectTo(this.getClass()).lista();
    }
    @Path("/abrigada/info/{abrigada.id}")
    public Abrigada info(Abrigada abrigada){
       return dao.findById(abrigada);
    }
}
