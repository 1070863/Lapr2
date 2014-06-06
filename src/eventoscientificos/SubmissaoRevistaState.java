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
public class SubmissaoRevistaState implements SubmissaoState {

    Submissao m_submissao;

	public SubmissaoRevistaState(Submissao m_submissao)
	{
		this.m_submissao=m_submissao;
	}

	public  boolean SetCriada()
	{
	return false;

	}

    public  boolean SetArtigosParaRevisaoSubmetidos()
	{
	return false;
	}
    public  boolean setDestribuida()
	{
		return false;
	
	}


    public boolean setRevista()
	{
	return false;

	}
	
	public boolean valida() 
	{
       return true;												


    }

    public boolean setRejeitada()
	{
	return false;
	}

    public boolean setAceite()
	{
	if (valida())
	 {
            m_submissao.setState(new SubmissaoAceiteState(m_submissao));
            return true;
         } 
		else 
		{
           	 m_submissao.setState(new SubmissaoRejeitadaState(m_submissao));
            return true;
        	} 

	}
    

    
    public boolean setNotificadoAceite() {
       return false;
       
    }
}    