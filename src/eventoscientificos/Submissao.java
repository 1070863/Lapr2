/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

import java.io.Serializable;
import states.SubmissaoCriadaState;
import states.SubmissaoState;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Submissao implements Serializable {
    private static final long serialVersionUID = 1L;

    private Artigo m_artigo;
    
    private SubmissaoState state;
    
    private RevisaoArtigo revisaoArtigo;
    
    private Decisao m_decisao;

    public Submissao() {
        this.setState(new SubmissaoCriadaState(this));
    }
    
    public Artigo novoArtigo() {
        return new Artigo();
    }

    public String getInfo() {
        return this.toString();
    }

    public void setArtigo(Artigo artigo) {
        this.m_artigo = artigo;
    }

    public Artigo getArtigo() {
        return this.m_artigo;
    }

    public boolean valida() {
        return this.state.valida();
    }

    @Override
    public String toString() {
        return "Submissão:\n"+m_artigo.toString();
    }
     public void setState(SubmissaoState state) {
        this.state = state;
    }

    public SubmissaoState getState() {
        return state;
    }

    /**
     * Retorna a RevisaoArtigo
     * @return RevisaoArtigo
     */
    public RevisaoArtigo getRevisaoArtigo() {
        return revisaoArtigo;
    }

    /**
     * Atltera a revisao de artigo
     * @param revisaoArtigo 
     */
    public void setRevisaoArtigo(RevisaoArtigo revisaoArtigo) {
        this.revisaoArtigo = revisaoArtigo;
    }

    /**
     * Retorna a decisão
     * @return m_decisao
     */
    public Decisao getM_decisao() {
        return m_decisao;
    }

    /**
     * Atribui a decisão
     */
    public void setM_decisao(Decisao m_decisao) {
        this.m_decisao = m_decisao;
    }    
}
