/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Pereira
 */
public class Decisao implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /**
     * variaveis de instancia
    */
    private String decisao;
  
    
    
    public Decisao() {
       
    }

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

 
    
    
    

