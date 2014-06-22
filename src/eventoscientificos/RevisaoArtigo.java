/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class RevisaoArtigo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /**
     * Revisor que efectuou a revisão
     */
    private Revisor revisor;

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }
    
    /**
     * Artigo que foi revisto
     */
    private Artigo m_artigo;

    public Artigo getM_artigo() {
        return m_artigo;
    }

    public void setM_artigo(Artigo m_artigo) {
        this.m_artigo = m_artigo;
    }

   
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
     * Controi uma instância de revisão de artigos
     */
    public RevisaoArtigo() {
    }

    /**
     * Constroi uma instância de Revisão de artigo
     * @param confianca
     * @param adequacao
     * @param originalidade
     * @param qualidade
     * @param recomendacao
     * @param textoJustificativo 
     */
    public RevisaoArtigo(String confianca, String adequacao, String originalidade, String qualidade, 
            boolean recomendacao, String textoJustificativo, Revisor revisor) {
        this.confianca = confianca;
        this.adequacao = adequacao;
        this.originalidade = originalidade;
        this.qualidade = qualidade;
        this.recomendacao = recomendacao;
        this.textoJustificativo = textoJustificativo;
        this.revisor = revisor;
    }
    
    /**
     * Obtém a confiança
     * @return confianca
     */
    public String getConfianca() {
        return confianca;
    }

    /**
     * Atribui valor a confiança
     * @param confianca 
     */
    public void setConfianca(String confianca) {
        this.confianca = confianca;
    }

    /**
     * Obtém a adequação 
     * @return adequacao
     */
    public String getAdequacao() {
        return adequacao;
    }

    /**
     * Atribui valor a adequação
     * @param adequacao 
     */
    public void setAdequacao(String adequacao) {
        this.adequacao = adequacao;
    }

    /**
     * Obtém valor originalidade
     */
    public String getOriginalidade() {
        return originalidade;
    }

    /**
     * Atribui valor da originalidade
     * @param originalidade 
     */
    public void setOriginalidade(String originalidade) {
        this.originalidade = originalidade;
    }

    /**
     * Obtém valor da qualidade
     * @return qualidade
     */
    public String getQualidade() {
        return qualidade;
    }

    /**
     * Altera o valor da qualidade
     * @param qualidade 
     */
    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    /**
     * Obtém o valor da recomendação
     * @return recomendacao
     */
    public boolean getRecomendacao() {
        return recomendacao;
    }

    /**
     * Atribui o valor a recomendação
     * @param recomendacao 
     */
    public void setRecomendacao(boolean recomendacao) {
        this.recomendacao = recomendacao;
    }

    /**
     * Obtém o texto justificativo
     * @return txtoJustificativo
     */
    public String getTextoJustificativo() {
        return textoJustificativo;
    }

    /**
     * Atribui o texto justificativo
     * @param textoJustificativo 
     */
    public void setTextoJustificativo(String textoJustificativo) {
        this.textoJustificativo = textoJustificativo;
    }

    
}
