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
 * SubmissaoCriadaState gere o estado de uma submissão, efetudando
 * validações e de acordo com o modelo de negócio .
 * Esta classe é o primeiro estado de submissão, implemanta a interface
 * SbmissaoState mas apenas utiliza SubmissaoArtigosParaRevisaoSubmetidosState
 */
public class SubmissaoCriadaState implements SubmissaoState, Serializable {

    Submissao m_submissao;
/**
 * construtor de submissao recebe o estado da submissao
 * @param m_submissao 
 */
	public SubmissaoCriadaState(Submissao m_submissao)
	{
		this.m_submissao=m_submissao;
	}
/**
 *é definida quando é criada a Submissão
 * @return false
 */
	public boolean SetCriada()
	{
	
        return false;

	}
/**
 * chama o valida desta classe e se retornar verdadeiro 
 * Altera o estado da submissão para SubmissaoArtigosParaRevisaoSubmetidosState
 * @return 
 */
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

    /**
     * valida as condições para passar o estadpo da submissão para
     * SubmissaoArtigosParaRevisaoSubmetidosState
     * @return 
     */
	public boolean valida() 
	{
        return !(m_submissao.getArtigo().getTitulo().isEmpty() ||
					m_submissao.getArtigo().getResumo().isEmpty() ||
					m_submissao.getArtigo().getPossiveisAutoresCorrespondentes()== null ||
					m_submissao.getArtigo() ==null);													


    	}
/**
 * é o estado definidio depois dos artigos serem distribuidos pelos organizadores com sucesso
 * @return false
 */	
    public boolean setDestribuida()
	{
	return false;

	}
/**
 * é o estado definidio depois dos artigos serem revistos pelos revisores com sucesso
 * @return false
 */
    public  boolean setRevista()
	{
	return false;

	}
/**
 * é o estado definido depois de o organizador ter decidido sobre a submissão 
 * e ter rejeitado, com sucesso
 * @return false
 */
    public  boolean setRejeitada()
	{
	return false;
	}
/**
 * Estado definido epois de o organizador ter decidido sobre a submissão 
 * e ter aceite, com sucesso
 * @return false
 */
    public  boolean setAceite()
	{
	return false;

	}
    /**
 * Estado definido epois de o organizador ter decidido sobre a submissão 
 * e ter aceite, e feita a notificação com sucesso
 * @return false
 */
    public boolean setNotificadoAceite()
	{
	return false;

	}
/**
 * é o estado definido depois de o organizador ter decidido sobre a submissão 
 * e ter rejeitado, e notificado com sucesso
 * @return false
 */
    @Override
    public boolean setNotificadoRejeitada() {
        return false;
    }
/**
 * é o estado definido após o pagamento da submissão
 * @return false
 */
    @Override
    public boolean setRegistada() {
        return false;
    }
}    