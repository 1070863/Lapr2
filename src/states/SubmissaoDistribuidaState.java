/**
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
 * SubmissaoDistribuidaState gere o estado de uma submissão, efetudando
 * validações e de acordo com o modelo de negócio .
 * Esta classe é um dos estados da submissão e é utilizada para alterar o estado de submissao 
 * para SubmissaoRevistaState. A classe implementa SubmissaoState mas apenas utiliza
 * o métodoSubmissaoDistribuidaState SubmissaoRevistaState.
 */
public class SubmissaoDistribuidaState implements SubmissaoState, Serializable {

    Submissao m_submissao;
/**
 * construtor recebe uma submissão
 * @param m_submissao 
 */
	public SubmissaoDistribuidaState(Submissao m_submissao)
	{
		this.m_submissao=m_submissao;
	}
/**
 * É o estado definido aquando a criação de submissão
 * @return false
 */
	public boolean SetCriada()
	{
	return false;

	}
/**
 * é o estado definido após a submissão do artigo com sucesso
 * @return false
 */
    public boolean SetArtigosParaRevisaoSubmetidos()
	{
	return false;
	}
    
    /**
 * é o estado definido depois de ter distribuido os artigos pelos revisores com sucesso
 * @return false
 */
    public boolean setDestribuida()
	{
		return false;
	
	}
/**
 * Chama o valida desta classe e caso retorne verdadeiro
 * Altera o estado de submissão para SubmissaoRevistaState
 * @return boolean
 */
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
	/**
         * valida as condições para alterar o estado de submissão de 
         * SubmissaoDistribuidaState  para SubmissaoRevistaState
         * @return 
         */
	public boolean valida() 
	{
          if(m_submissao.getState() instanceof SubmissaoDistribuidaState &&											
               m_submissao.getArtigo().getM_listaTopicos().size()>0)
              return true;
          else
        return false;
    }
    

    /**
 * é o estado definido após o organizador ter decidido rejeitar a submissão com sucesso
 * @return false
 */

    public  boolean setRejeitada()
	{
	return false;
	}
/**
 * é o estado definido após o organizador ter decidido aceitar  a submissão com sucesso
 * @return false
 */
    public boolean setAceite()
	{
	return false;

	}
    /**
 * é o estado definido após o organizador ter decidido aceitar  a submissão com sucesso
 * e os autores serme notificados com sucesso
 * @return false
 */
    public boolean setNotificadoAceite()
	{
	return false;

	}
/**
 *  é o estado definido após o organizador ter decidido rejeitar a submissão com sucesso e os 
 * autores serem notificados com sucesso
 * @return false
 */
    @Override
    public boolean setNotificadoRejeitada() {
       return false;
    }
/**
 é o estado definido após o pagamento por parte do autor
 * @return false
 */
    @Override
    public boolean setRegistada() {
        return false;
    }
}    