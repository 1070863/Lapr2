/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import eventoscientificos.Decisao;
import eventoscientificos.Submissao;
import java.io.Serializable;

/**
 *SubmissãoRevistaState gere o estado de uma submissão, efetudando
 * validações e de acordo com o modelo de negócio .
 * é utilizada para alterar o estado de submissão para SubmissãoRevistaState
 * @author Pereira
 */
public class SubmissaoRevistaState implements SubmissaoState, Serializable {

    private Submissao m_submissao;
/**
 * Construtor da classe Submissão quando Submissão é passado por parâmetro.
     *
 * @param m_submissao 
 */
	public SubmissaoRevistaState(Submissao m_submissao)
	{
		this.m_submissao=m_submissao;
	}        
/**
 * Define a submissão como criada quando iniciado o processo de Submissão.
 * @return false
 */
	public  boolean SetCriada()
	{
	return false;

	}
        /**
         * Define a submissão submetida após o sucesso do processo de Submissão.
         * @return false
         */

    public  boolean SetArtigosParaRevisaoSubmetidos()
	{
	return false; 
	}
    
    /**
     * Define a submissão como distribuida após ter sido distribuida para
     * revisão.
     *
     * @return false
     */
    public  boolean setDestribuida()
	{
		return false;
	
	}

  /**
     * Define a submissão como aceite após o parecer positivo do Organizador.
     *
     * @return false
     */
    
    public boolean setRevista()
	{
	return false;

	}
    
     /**
     * Define a submissão como aceite após o parecer positivo do Organizador.
     *
     * @return false
     */
	
	public boolean valida() 
	{
       if(m_submissao.getState() instanceof SubmissaoRevistaState && 
           m_submissao.getM_decisao().getDecisao().equalsIgnoreCase("aceite"))
           return true;
       else
           return false;
         }
        
         /**
     * Define a submissão como rejeitada após o parecer negativo do Organizador.
     *
     * @return false
     */

    public boolean setRejeitada()
	{
	return false;
	}
   

  /**
     * Define a submissão como aceite após o parecer positivo do Organizador.
     *
     * @return false
     */
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
    

     
    /**
     * Define a submissão como NotificadaAceite após a aceitação do artigo no
     * Evento e a geração da notificação.
     *
     * @return verdadeiro ou falso em função da validação
     */
    public boolean setNotificadoAceite() {
       return false;
       
    }
 /**
     * Define a submissão como NotificadaRejeitada após a rejeição do artigo no
     * Evento e a geração da notificação.
     *
     * @return verdadeiro ou falso em função da validação
     */
    @Override
    public boolean setNotificadoRejeitada() {
        return false;
    }
 /**
     * Define a submissão como registada após o pagamento do Registo no Evento.
     *
     * @return false
     */
    @Override
    public boolean setRegistada() {
        return false;
    }
}    