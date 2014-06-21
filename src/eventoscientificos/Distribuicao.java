/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lopes
 */
public class Distribuicao implements Serializable {
    private static final long serialVersionUID = 1L;
    
  /**
     * Variáveis de instância
     */
    private List<Revisor> m_listaRevisores;
    private Artigo m_artigo;
    
    /**
     * confianca: confiança do revisor no tópico do artigo
     * adequacao: Adequação ao evento
     * originalidade: originalidade do artigo
     * qualidade: qualidade de apresentação
     * recomendacao: recomendação global aceite/rejeitado
     */
    private String confianca;
    private String adequacao;
    private String originalidade;
    private String qualidade;
    private boolean recomendacao;
    /**
     * textoJustificativo: texto justificativo da revisão
     */
    private String textoJustificativo;

    /**
     * Cria objeto do tipo Distribuicao que não recebe parametros (construtor
     * vazio)
     */
    public Distribuicao() {
        m_listaRevisores = new ArrayList<>();
        m_artigo = new Artigo();
    }

    /**
     * Cria objeto do tipo Distribuicao que recebe como parametros uma lista de
     * revisores e um artigo.
     *
     * @param m_artigo Objecto do tipo Artigo
     * @param m_listaRevisores lista de objecto Revisor
     */
    public Distribuicao(List<Revisor> m_listaRevisores, Artigo m_artigo) {
        this.m_listaRevisores = m_listaRevisores;
        this.m_artigo = m_artigo;
    }

    /**
     * Procura a lista de revisores
     *
     * @return lista de revisores
     */
    public List<Revisor> getM_listaRevisores() {
        return m_listaRevisores;
    }

    /**
     * Define uma lista de revisores
     *
     * @param m_listaRevisores lista de objecto Revisor
     */
    public void setM_listaRevisores(List<Revisor> m_listaRevisores) {
        this.m_listaRevisores = m_listaRevisores;
    }

    /**
     * Procura o artigo
     *
     * @return Artigo
     */
    public Artigo getM_artigo() {
        return m_artigo;
    }

    /**
     * Define um artigo
     *
     * @param m_artigo Objecto do tipo Artigo
     */
    public void setM_artigo(Artigo m_artigo) {
        this.m_artigo = m_artigo;
    }
    
    /**
     * Recebe o username e procura na lista de revisores. Se o revisor existir retorna o revisor senão retorna null.
     * @param revisor
     * @return Revisor 
     */
    public Revisor getRevisor(String revisor){
        for (Revisor rev : m_listaRevisores) {
            if(rev.getM_utilizador().getM_strUsername().equals(revisor))
                return rev;
        }
        return null;
    }
    
    public String getConfianca() {
        return confianca;
    }

    public void setConfianca(String confianca) {
        this.confianca = confianca;
    }

    public String getAdequacao() {
        return adequacao;
    }

    public void setAdequacao(String adequacao) {
        this.adequacao = adequacao;
    }

    public String getOriginalidade() {
        return originalidade;
    }

    public void setOriginalidade(String originalidade) {
        this.originalidade = originalidade;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    public boolean getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(boolean recomendacao) {
        this.recomendacao = recomendacao;
    }

    public String getTextoJustificativo() {
        return textoJustificativo;
    }

    public void setTextoJustificativo(String textoJustificativo) {
        this.textoJustificativo = textoJustificativo;
    }

    @Override
    public String toString() {
        return "Distribuicao{" + "m_artigo=" + m_artigo + '}';
    }
    
}
