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
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Artigo implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String m_strTitulo;
    private String m_strResumo;
    private List<Autor> m_listaAutores;
    private Autor m_autorCorrespondente;
    private String m_strFicheiro;
    private List<Topico> m_listaTopicos;
    private String tipo;
    
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Artigo() {
        m_listaAutores = new ArrayList<Autor>();
        m_listaTopicos = new ArrayList<Topico>();
    }

    /**
     *
     * @param strTitulo
     */
    public void setTitulo(String strTitulo) {
        this.m_strTitulo = strTitulo;
    }
    
   /**
    * 
    * @return 
    */
    public String getTitulo() {
        return this.m_strTitulo;
    }

    /**
     *
     * @param strResumo
     */
    public void setResumo(String strResumo) {
        this.m_strResumo = strResumo;
    }

    /**
    * 
    * @return 
    */
    public String getResumo() {
        return this.m_strResumo;
    }
    
    public Autor getAutor(String id)
        {
            
            for (Autor autor : m_listaAutores) {
                String str=autor.getM_strNome();
                if (str.equalsIgnoreCase(id))
                    return autor;
            }
            return null;
        }
    
    /**
     *
     * @param strNome
     * @param strAfiliacao
     * @return
     */
    public Autor novoAutor(String strNome, String strAfiliacao) {
        Autor autor = new Autor();

        autor.setNome(strNome);
        autor.setAfiliacao(strAfiliacao);

        return autor;
    }

    /**
     *
     * @param strNome
     * @param strAfiliacao
     * @param strEmail
     * @param utilizador
     * @return
     */
    public Autor novoAutor(String strNome, String strAfiliacao, String strEmail, Utilizador utilizador) {
        Autor autor = new Autor();

        autor.setNome(strNome);
        autor.setAfiliacao(strAfiliacao);
        autor.setEMail(strEmail);
        autor.setUtilizador(utilizador);

        return autor;
    }

    /**
     *
     * @param autor
     * @return
     */
    public boolean addAutor(Autor autor) {
        if (validaAutor(autor)) {
            return m_listaAutores.add(autor);
        } else {
            return false;
        }

    }

    /**
     *
     * @param autor
     * @return
     */
    private boolean validaAutor(Autor autor) {
        return autor.valida();
    }

    /**
     *
     * @return
     */
    public List<Autor> getPossiveisAutoresCorrespondentes() {
        List<Autor> la = new ArrayList<Autor>();

        for (Autor autor : this.m_listaAutores) {
            if (autor.podeSerCorrespondente()) {
                la.add(autor);
            }
        }
        return la;
    }

    /**
     *
     * @param autor
     */
    public void setAutorCorrespondente(Autor autor) {
        this.m_autorCorrespondente = autor;
    }

    /**
     *
     * @param strFicheiro
     */
    public void setFicheiro(String strFicheiro) {
        this.m_strFicheiro = strFicheiro;
    }

    /**
     *
     * @param listaTopicos
     *
     * adicionado na iteração 2
     */
    public void setListaTopicos(List<Topico> listaTopicos) {
        this.m_listaTopicos.addAll(listaTopicos);
    }

    /**
     *
     * @return
     */
    public String getInfo() {
        return this.toString();
    }

    /**
     *
     * @return
     */
    public boolean valida() {
        return true;
    }

    public String getM_strFicheiro() {
        return m_strFicheiro;
    }

    @Override
    public String toString() {
        String aux= "Artigo: "+this.m_strTitulo + "\nResumo: "+this.m_strResumo+"\nAutores:\n";
        for (Autor autor : m_listaAutores) {
            aux+=autor.toString()+"\n";
        }
        aux+="Autor correspondente: "+this.m_autorCorrespondente+"\nTópicos do artigo:\n";
        for (Topico topico : m_listaTopicos) {
            aux+=topico.toString()+"\n";
        }
        return aux+="Ficheiro: "+this.m_strFicheiro;
    }

    /**
     * 
     * @param obj
     * @return 
     * 
     * Quando é que dois artigos são iguais? Quando têm o mesmo título e mesmo autor correspondente?
     * Ou quando todos os autores forem também os mesmos?
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            if (obj instanceof Artigo) {
                Artigo aux = (Artigo) obj;
                 return this.m_autorCorrespondente.equals(aux.m_autorCorrespondente)
                        && this.m_strTitulo.equals(aux.m_strTitulo);
            } else {
                return false;
            }
        }
    }

    public List<Topico> getM_listaTopicos() {
        return m_listaTopicos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.m_strTitulo != null ? this.m_strTitulo.hashCode() : 0);
        hash = 19 * hash + (this.m_strResumo != null ? this.m_strResumo.hashCode() : 0);
        return hash;
    }
    
    /**
     * Retorna a confiança do revisor nos tópicos do artigo
     * @return confianca
     */
    public String getConfianca() {
        return confianca;
    }

    /**
     * Altera a confiança do revisor nos tópicos do artigo
     * @param confianca 
     */
    public void setConfianca(String confianca) {
        this.confianca = confianca;
    }

    /**
     * Retorna a adequação ao evento
     * @return adequacao
     */
    public String getAdequacao() {
        return adequacao;
    }

    /**
     * Atribui a adequação ao evento
     * @param adequacao 
     */
    public void setAdequacao(String adequacao) {
        this.adequacao = adequacao;
    }

    /**
     * Retorna a originalidade
     * @return originalidade
     */
    public String getOriginalidade() {
        return originalidade;
    }

    /**
     * Atribui a originalidade
     * @param originalidade 
     */
    public void setOriginalidade(String originalidade) {
        this.originalidade = originalidade;
    }

    /**
     * Retorna a qualidade
     * @return qualidade
     */
    public String getQualidade() {
        return qualidade;
    }

    /**
     * Atribui a qualidade 
     * @param qualidade 
     */
    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    /**
     * Retorna a recomendação
     * @return recomendacao
     */
    public boolean getRecomendacao() {
        return recomendacao;
    }

    /**
     * Atribui a recomendação
     * @param recomendacao 
     */
    public void setRecomendacao(boolean recomendacao) {
        this.recomendacao = recomendacao;
    }

    /**
     * Retorna o texto justificativo
     * @return textoJustificativo
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
