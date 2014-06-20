/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Pereira
 */
public class ProcessoDecisao {
    
    private MecanismoDecisao mecanismoDecisao;
    private List<Decisao> m_listaDecisao;
    private List<Distribuicao> m_listaDistribuicao;
    
    private Decisao m_decisao;
    /**
     * 
     * @param m 
     */
     public void setMecanismoDecisao(int m) {
        if (m == 1) {
            mecanismoDecisao= new MecanismoDecisao1();
        }
    }
/**
 * 
 * @return List<Revisao>
 */
    public List<Distribuicao> getM_listaDistribuicao() {
        return m_listaDistribuicao;
    }
/**
 * 
 * @param m_listaDistribuicao
 */
    public void setM_listaRevisao(List<Distribuicao> m_listaDistribuicao) {
        this.m_listaDistribuicao = m_listaDistribuicao;
    }
/**
 * 
 * @return List<Decisao>
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

    public Decisao getM_decisao() {
        return m_decisao;
    }

    public void setM_listaDistribuicao(List<Distribuicao> m_listaDistribuicao) {
        this.m_listaDistribuicao = m_listaDistribuicao;
    }

  
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

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
    
    

