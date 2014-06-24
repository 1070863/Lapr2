/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import eventoscientificos.Submissao;

/**
 * SubmissaoNotificadaRejeitadaState gere o estado de uma submissão, efetudando
 * validações e de acordo com o modelo de negócio .
 *Esta classe implementa a interface SubmissaoState mas é o último estado pelo que 
 * apenas utiliza o construtor de forma a permitir a criação do estado
 * @author Pereira
 */
public class SubmissaoNotificadaRejeitadaState implements SubmissaoState {

     private Submissao m_submissao;
/**
 * Este construtor recebe uma submissão
 * @param m_submissao 
 */
    public SubmissaoNotificadaRejeitadaState(Submissao m_submissao) {
        this.m_submissao = m_submissao;
    }
        /**
 * É o estado definido aquando a criação de submissão
 * @return false
 */
     
    @Override
    public boolean SetCriada() {
        return false;
    }
    /**
 * é o estado definido após a submissão do artigo com sucesso
 * @return false
 */
    @Override
    public boolean SetArtigosParaRevisaoSubmetidos() {
       return false;
    }
    /**
 * é o estado definido depois de ter distribuido os artigos pelos revisores com sucesso
 * @return false
 */
    @Override
    public boolean setDestribuida() {
       return false;
    }
    /**
 * nEstado definido aós a revisao dos artigos, por parte dos revisores, ter sido
 * realizada com secesso
 * @return false
 */
    @Override
    public boolean setRevista() {
      return false;
    }
    /**
 *é o estado definido após o organizador ter decidido rejeitar a submissão com sucesso
 * @return false
 */
    @Override
    public boolean setRejeitada() {
       return false;
    }
    /**
 * é o estado definido após o organizador ter decidido aceitar  a submissão com sucesso
 * @return false
 */
    @Override
    public boolean setAceite() {
       return false;
    }
   /**
 * é o estado definido após o organizador ter decidido aceitar  a submissão com sucesso
 * e os autores serme notificados com sucesso
 * @return false
 */
    @Override
    public boolean setNotificadoAceite() {
        return false;
    }
    /**
 * não é usada nesta classe
 * @return false
 */
    @Override
    public boolean valida() {
       return false;
    }
        /**
 * não é usada nesta classe
 * @return false
 */
    public boolean setNotificadoRejeitada() {
       return false;
    }
    /**
 *  é o estado definido após o pagamento por parte do autor
 * @return false
 */
    @Override
    public boolean setRegistada() {
        return false;
    }
    
}
