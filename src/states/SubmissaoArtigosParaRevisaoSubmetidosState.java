/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import eventoscientificos.Submissao;
import java.io.Serializable;

/**
 *
 * @author Pereira
 */
public class SubmissaoArtigosParaRevisaoSubmetidosState implements SubmissaoState, Serializable {

    Submissao m_submissao;

	public SubmissaoArtigosParaRevisaoSubmetidosState(Submissao m_submissao)
	{
		this.m_submissao=m_submissao;
	}

	public boolean SetCriada()
	{
	return false;

	}

    public  boolean SetArtigosParaRevisaoSubmetidos()
	{
	return false;
	}
    public  boolean setDestribuida()
	{

	if (valida())
	 {
            m_submissao.setState(new SubmissaoDistribuidaState(m_submissao));
            return true;
         } 
		else 
		{
           	 return false;
        	} 
	}

	public boolean valida() 
	{
       if(m_submissao.getState() instanceof SubmissaoArtigosParaRevisaoSubmetidosState &&											
           m_submissao.getArtigo().getM_listaTopicos().size()>0)
               return true;
       else
               return false;

    	}


    public boolean setRevista() {
        return false;
    }

   
    public boolean setRejeitada() {
       return false;
    }

    public boolean setAceite() {
        return false;
    }

 
    public boolean setNotificadoAceite() {
       return false;
    }

    @Override
    public boolean setNotificadoRejeitada() {
        return false;
    }

    @Override
    public boolean setRegistada() {
        return false;
    }
	
}
    
