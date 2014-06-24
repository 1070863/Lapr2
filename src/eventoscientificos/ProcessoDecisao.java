/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *Esta classe agrega mecanismos de decisao bem como as decisões e artigos
 * @author Pereira
 */
public class ProcessoDecisao implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private MecanismoDecisao mecanismoDecisao;
    private List<Decisao> m_listaDecisao;
    private List<RevisaoArtigo> m_listaRevisaoArtigo;
    private Decisao m_decisao;

    /**
     * Construtor cria listas de Decisao e RevisaoArtigo
     */
    public ProcessoDecisao() {
   m_listaDecisao= new  ArrayList<>();
   m_listaRevisaoArtigo= new ArrayList<>();
    }
    
    
    
    /**
     * recebe o numero o mecanismo e caso seja um cria o mecanismoDecisao1
     * @param m 
     */
     public void setMecanismoDecisao(int m) {
        if (m == 1) {
            mecanismoDecisao= new MecanismoDecisao1();
        }
    }
/**
 * devolve a lista de revisões de artigos existentes no processo de decisao
 * @return List<Revisao>
 */
    public List<RevisaoArtigo> getM_listaDistribuicao() {
        return m_listaRevisaoArtigo;
    }
/**
 * reescreve m_listaRevisaoArtigo
 * @param m_listaRevisaoArtigo
 */
    public void setM_listaRevisao(List<RevisaoArtigo> m_listarevisaoArtigo) {
        this.m_listaRevisaoArtigo = m_listarevisaoArtigo;
    }
/**
 * cria uma decisão e chama um metodo decide de um mecanismo
 * por fim adiciona a decisão á lista de decisão existente no processo decisão
 * @return <Decisao>
 */
    public Decisao decide() {
        m_decisao= new Decisao();
        m_decisao = mecanismoDecisao.decide(this);
        m_listaDecisao.add(m_decisao);
        return m_decisao;
    }
    
        /**
     * Cria uma nova distribuição e a lista de revisores que vai ter
     *
     * @return
     */
    public Decisao novaDecisao() {
        m_decisao = new Decisao();

        return m_decisao;
    }
/**
 * 
 * @return List<Decisao>
 */
    public List<Decisao> getM_listaDecisao() {
        return m_listaDecisao;
    }
/**
 * 
 * @param m_listaDecisao 
 */
    public void setM_listaDecisao(List<Decisao> m_listaDecisao) {
        this.m_listaDecisao = m_listaDecisao;
    }
    
/**
 * altera o conteudo
 * @param m_decisao 
 */
    public void setM_decisao(Decisao m_decisao) {
        this.m_decisao = m_decisao;
    }    
/**
 * 
 * @return mecanismoDecisao
 */
    public MecanismoDecisao getMecanismoDecisao() {
        return mecanismoDecisao;
    }
/**
 * altera o conteudo
 * @param mecanismoDecisao 
 */
    public void setMecanismoDecisao(MecanismoDecisao mecanismoDecisao) {
        this.mecanismoDecisao = mecanismoDecisao;
    }
/**
 * devolve Decisao
 * @return 
 */
    public Decisao getM_decisao() {
        return m_decisao;
    }

    public void setM_listaDistribuicao(List<RevisaoArtigo> m_listarevisaoArtigo) {
        this.m_listaRevisaoArtigo = m_listarevisaoArtigo;
    }

  /**
   * devolve posição
   * @return 
   */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
/**
 * compara O obj com mecanismoDecisão
 * @param obj
 * @return 
 */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcessoDecisao other = (ProcessoDecisao) obj;
        if (Objects.equals(this.mecanismoDecisao, other.mecanismoDecisao)) {
            return  true;
        }
       
        return true;
    }
    
    
}
    
    

