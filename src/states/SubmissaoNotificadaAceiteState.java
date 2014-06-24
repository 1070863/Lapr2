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
 * SubmissaoNotificadaAceiteState gere o estado de uma submissão, efetudando
 * validações e de acordo com o modelo de negócio .
 * esta classe implementa SubmissaoState mas apenas utiliza o método 
 * setNoticadaAceiteSatate para alterar o estado de submissao para 
 * SubmissaoPagoState.
 * 
 */
public class SubmissaoNotificadaAceiteState implements SubmissaoState, Serializable {
    
    Submissao m_submissao;
/**
 * É o estado definido aquando a criação de submissão
 * @param m_submissao 
 */
    public SubmissaoNotificadaAceiteState(Submissao m_submissao) {
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
 *  é o estado definido após a submissão do artigo com sucesso
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
 * é o estado definido após a revisão dos artigo com secesso
 * @return false
 */
    @Override
    public boolean setRevista() {
       return false;
    }
/**
 * é o estado definido após o organizador ter decidido rejeitar a submissão com sucesso
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
    public boolean setNotificadoAceite() {
        return false;
    }
/**
 * 
 * @return true
 */
    @Override
    public boolean valida() {
        return true;
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
 *  é o estado definido após o pagamento por parte do autor
 * @return false
 */
    @Override
    public boolean setRegistada() {
        return false;
    }
    
    
}
