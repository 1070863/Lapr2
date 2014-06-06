/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

/**
 *
 * @author Pereira
 */
public class SubmissaoDistribuidaState implements SubmissaoState {

    Submissao m_submissao;

	public SubmissaoDistribuidaState(Submissao m_submissao)
	{
		this.m_submissao=m_submissao;
	}

	public boolean SetCriada()
	{
	return false;

	}

    public boolean SetArtigosParaRevisaoSubmetidos()
	{
	return false;
	}
    public boolean setDestribuida()
	{
		return false;
	
	}


    public boolean setRevista()
	{
	if (valida())
	 {
            m_submissao.setState(new SubmissaoRevistaState(m_submissao));
            return true;
         } 
		else 
		{
           	 return false;
        	} 

	}
	
	public boolean valida() 
	{
       return true;												


    }

    public  boolean setRejeitada()
	{
	return false;
	}

    public boolean setAceite()
	{
	return false;

	}
    public boolean setNotificadoAceite()
	{
	return false;

	}
}    