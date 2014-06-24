/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.io.Serializable;
import java.util.List;

/**
 *classe que contem decisao
 * @author Pereira
 */
public class Decisao implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /**
     * variaveis de instancia
    */
    private String decisao;
  
    
    /**
     * construtor por omissão de Decisão
     */
    public Decisao() {
       
    }
/**
 * Construtor que recebe decisao 
 * @param decisao 
 */
    public Decisao(String decisao) {
        this.decisao = decisao;
    }


    
/**
 * devolve
 * @return decisao
 */
    public String getDecisao() {
        return decisao;
    }
/**
 * define decisão
 * @param decisao 
 */
    public void setDecisao(String decisao) {
        this.decisao = decisao;
    }

  
    }

 
    
    
    

