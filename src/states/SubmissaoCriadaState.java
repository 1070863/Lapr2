/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import eventoscientificos.Submissao;

/**
 *
 * @author Pereira
 */
public class SubmissaoCriadaState implements SubmissaoState {

    Submissao m_submissao;
/**
 * 
 * @param m_submissao 
 */
	public SubmissaoCriadaState(Submissao m_submissao)
	{
		this.m_submissao=m_submissao;
	}
/**
 * Altera o estado da submissão para 
 * @return 
 */
	public boolean SetCriada()
	{
	
        return false;

	}

    public  boolean SetArtigosParaRevisaoSubmetidos()
	{

	if (valida())
	 {
            m_submissao.setState(new SubmissaoArtigosParaRevisaoSubmetidosState(m_submissao));
            return true;
         } 
		else 
		{
           	 return false;
        	} 
	}

	public boolean valida() 
	{
        return !(m_submissao.getArtigo().getTitulo().isEmpty() ||
					m_submissao.getArtigo().getResumo().isEmpty() ||
					m_submissao.getArtigo().getPossiveisAutoresCorrespondentes()== null ||
					m_submissao.getArtigo() ==null);													


    	}
	
    public boolean setDestribuida()
	{
	return false;

	}

    public  boolean setRevista()
	{
	return false;

	}

    public  boolean setRejeitada()
	{
	return false;
	}

    public  boolean setAceite()
	{
	return false;

	}
    public boolean setNotificadoAceite()
	{
	return false;

	}
}    