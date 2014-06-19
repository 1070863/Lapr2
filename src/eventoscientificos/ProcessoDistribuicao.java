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
 * @author Lopes
 */
public class ProcessoDistribuicao {
    
    private MecanismoDistribuicao mecanismoDistribuicao;
    private List<Distribuicao> m_listaDistribuicao;
    private List<Submissao> m_listaSubmissoes;
    private CP m_cp;
    
    private Distribuicao m_distribuicao;
    
    

    public void setMecanismoDistribuicao(int m) {
        if (m == 1) {
            mecanismoDistribuicao = new Mecanismo1();
        }
    }

    public List<Distribuicao> distribui() {
        m_listaDistribuicao = mecanismoDistribuicao.distribui(this);
        return m_listaDistribuicao;
    }
    
        /**
     * Cria uma nova distribuição e a lista de revisores que vai ter
     *
     * @return
     */
    public Distribuicao novaDistribuicao() {
        m_distribuicao = new Distribuicao();

        return m_distribuicao;
    }

    public List<Distribuicao> getM_listaDistribuicao() {
        return m_listaDistribuicao;
    }

    public void setM_listaDistribuicao(List<Distribuicao> m_listaDistribuicao) {
        this.m_listaDistribuicao = m_listaDistribuicao;
    }
    
        /**
     *
     * @return
     */
    public List<Submissao> getM_listaSubmissoes() {
        return m_listaSubmissoes;
    }

    /**
     * Define Comissão do programa do Processo de Distribuição.
     *
     * @param m_listaSubmissoes lista de Submissões
     *
     */
    public void setM_listaSubmissoes(List<Submissao> m_listaSubmissoes) {
        this.m_listaSubmissoes = m_listaSubmissoes;
    }  

    public Distribuicao getM_distribuicao() {
        return m_distribuicao;
    }

    public void setM_distribuicao(Distribuicao m_distribuicao) {
        this.m_distribuicao = m_distribuicao;
    }    

    public MecanismoDistribuicao getMecanismoDistribuicao() {
        return mecanismoDistribuicao;
    }

    public void setMecanismoDistribuicao(MecanismoDistribuicao mecanismoDistribuicao) {
        this.mecanismoDistribuicao = mecanismoDistribuicao;
    }

    public CP getM_cp() {
        return m_cp;
    }

    public void setM_cp(CP m_cp) {
        this.m_cp = m_cp;
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
        final ProcessoDistribuicao other = (ProcessoDistribuicao) obj;
        if (!Objects.equals(this.mecanismoDistribuicao, other.mecanismoDistribuicao)) {
            return false;
        }
//        if (mecanismoDistribuicao.getClass().equals(obj)){
//            return true;
//        }
        return true;
    }
    
    
}
