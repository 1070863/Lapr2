/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package states;

import eventoscientificos.Submissao;
import java.io.Serializable;

/**
 *
 * @author Pereira
 * SubmissaoAceiteState gere o estado de uma submissão, efetudando
 * validações e de acordo com o modelo de negócio .
 * é um dos estados de Submissão e esta classe é utilizada para
 * validar e alterar o estado de submissão para SubmissaoNotificadaAceiteState
 * implementa Submissão state mas apenas utiliza um método setNotificadoAceite()
 */
public class SubmissaoAceiteState implements SubmissaoState, Serializable {

    Submissao m_submissao;
/**
 * Construtor recebe uma submissao
 * @param m_submissao 
 */
    public SubmissaoAceiteState(Submissao m_submissao) {
        this.m_submissao = m_submissao;
    }
/**
 * é criada quando a criação de submissão
 * @return false
 */
    public boolean SetCriada() {
        return false;

    }
/**
 * é criada após sucesso de Sucesso de Submissão de artigo
 * @return false
 */
    public boolean SetArtigosParaRevisaoSubmetidos() {
        return false;
    }
/**
 * é criada após o sucesso de Distribuir artigos
 * @return false
 */
    public boolean setDestribuida() {
        return false;

    }
/**
 * é criada depois de dos artigos revistos com sucesso
 * @return false
 */
    public boolean setRevista() {
        return false;

    }
/**
 * este método valisa as condições para passar o estado de submissão revista para
 * submissao aceite
 * @return boolean
 */
    public boolean valida() {
        if (m_submissao.getState() instanceof SubmissaoRevistaState
                && m_submissao.getArtigo().getM_listaTopicos().size() > 0) {
            return true;
        } else {
            return false;
        }

    }
/**
 * é criada se a decisãpo do organizador sobre a submissão for rejeitada
 * @return false
 */
    public boolean setRejeitada() {
        return false;
    }
/**
 * é criada se a decisãpo do organizador sobre a submissão for aceite
 * @return false
 */
    public boolean setAceite() {
        return false;

    }
/**
 * chama o valida desta classe e se returnar verdadeiro altera o estado
 * de submissão para SubmissaoNotificadaAceiteState
 * @return 
 */
    public boolean setNotificadoAceite() {
        if (valida()) {
            m_submissao.setState(new SubmissaoNotificadaAceiteState(m_submissao));

        }
        return true;
    }
/**
 * é criada se a notificação ocurrer com sucesso e a decisao tever sido rejeitada
 * @return false
 */
    @Override
    public boolean setNotificadoRejeitada() {
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
