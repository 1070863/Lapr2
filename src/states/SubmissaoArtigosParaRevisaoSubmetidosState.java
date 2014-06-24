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
 * SubmissaoArtigosParaRevisaoSubmetidosState gere o estado de uma submissão, efetudando
 * validações e de acordo com o modelo de negócio .
 * Esta classe é o segundo estado de submissão, implemanta a interface
 * SbmissaoState mas apenas utiliza setDestribuida
 */
public class SubmissaoArtigosParaRevisaoSubmetidosState implements SubmissaoState, Serializable {

    Submissao m_submissao;
/**
 * construtor recebe uma submissão
 * @param m_submissao 
 */
	public SubmissaoArtigosParaRevisaoSubmetidosState(Submissao m_submissao)
	{
		this.m_submissao=m_submissao;
	}
/**
 * Define a submissão como criada quando iniciado o processo de Submissão.
 * @return false
 */
	public boolean SetCriada()
	{
	return false;

	}
/**
 * Estado definido após sucesso de submissão de Artigo
 * @return false
 */
    public  boolean SetArtigosParaRevisaoSubmetidos()
	{
	return false;
	}
/**
 * Atera o estado de sumissao para submissaoDistribuidaState se passar 
 * @return 
 */
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

    /**
     * validação das condições para alterar o estado de submissão de SubmissaoArtigosParaRevisaoSubmetidosState
     * para SubmissaoDistribuidaState
     * @return 
     */
	public boolean valida() 
	{
       if(m_submissao.getState() instanceof SubmissaoArtigosParaRevisaoSubmetidosState &&											
           m_submissao.getArtigo().getM_listaTopicos().size()>0)
               return true;
       else
               return false;

    	}
/**
 * Estado definido depois do sucesso da revisão do artigo
 * @return false
 */

    public boolean setRevista() {
        return false;
    }

   /**
 *estado criado se a decisão do organizador sobre a submissão for rejeitada
 * @return false
 */
    public boolean setRejeitada() {
       return false;
    }
/**
 * estado criado se a decisão do organizador sobre a submissão for aceite
 * @return 
 */
    public boolean setAceite() {
        return false;
    }

 /**
 * estado definido depois da notificação da submissao aceite pelo organizador
 * for efectuada com sucesso
 * 
 * @return false
 */
    public boolean setNotificadoAceite() {
       return false;
    }
/**
 * estado definido depois da notificação da submissao rejeitada pelo organizador
 * for efectuada com sucesso
 * @return false
 */
    @Override
    public boolean setNotificadoRejeitada() {
        return false;
    }
/**
 *  estado definido depois do pagamento da submissao
 * 
 * @return false
 */
    @Override
    public boolean setRegistada() {
        return false;
    }
	
}
    
