/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import eventoscientificos.Submissao;
import java.io.Serializable;

/**
 * SubmissaoAceiteRejeitada gere o estado de uma submissão, efetudando
 * validações e de acordo com o modelo de negócio .
 * é um dos estados de Submissão e esta classe é utilizada para
 * validar e alterar o estado de submissão para SubmissaoNotificadaAceiteState
 * implementa Submissão state mas apenas utiliza um método setNotificadoRejeitada()
 * @author Pereira
 */
public class SubmissaoRejeitadaState implements SubmissaoState, Serializable{

    Submissao m_submissao;
/**
 * Construtor recebe uma submissao
 * @param m_submissao 
 */
    public SubmissaoRejeitadaState(Submissao m_submissao) {
        this.m_submissao = m_submissao;
    }
    
    /**
 * é criada quando a criação de submissão
 * @return false
 */
    @Override
    public boolean SetCriada() {
        return false;
    }
/**
 * é criada após sucesso de Sucesso de Submissão de artigo
 * @return false
 */
    @Override
    public boolean SetArtigosParaRevisaoSubmetidos() {
       return false;
    }
/**
 * é criada após o sucesso de Distribuir artigos
 * @return false
 */
    @Override
    public boolean setDestribuida() {
        return false;
    }
/**
 * é criada depois de dos artigos revistos com sucesso
 * @return false
 */
    @Override
    public boolean setRevista() {
        return false;
    }
/**
 * este método valisa as condições para passar o estado de submissão rejeitada para
 * submissao notificadarejeitada
 * @return boolean
 */
    @Override
    public boolean setRejeitada() {
        return false;
    }
/**
 * é criada se a decisãpo do organizador sobre a submissão for aceite
 * @return false
 */
    @Override
    public boolean setAceite() {
        return false;
    }
/**
 * é criada se a notificação ocurrer com sucesso e a decisao tever sido Aceite
 * @return false
 */
    @Override
    public boolean setNotificadoAceite() {
        return false;
    }
/**
 * testa de o estado de submissão 
 * @return 
 */
    @Override
    public boolean valida() {
      if(m_submissao.getState() instanceof SubmissaoRejeitadaState)
               return true;
       else
               return false;											

    }
/**
 * é criada se a decisãpo do organizador sobre a submissão for rejeitada e se a validação devolver verdadeira
 * @return false
 */
    @Override
    public boolean setNotificadoRejeitada() {
      
        if(valida())
        {m_submissao.setState(new SubmissaoNotificadaRejeitadaState(m_submissao));
        return true;
        }
        else
        return false;
    }
 /**
 * é criada apos pagamento do artigo
 * @return false
 */
    @Override
    public boolean setRegistada() {
        return false;
    }
    
}
