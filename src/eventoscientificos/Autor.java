/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.io.Serializable;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Autor implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private Utilizador m_Utilizador;
    private String m_strNome;
    private String m_strAfiliacao;
    private String m_strEMail;
    
    public Autor()
    {
        this.m_Utilizador = null;
    }
    
    public void setNome(String strNome)
    {
        this.m_strNome = strNome;
    }

    public void setM_Utilizador(Utilizador m_Utilizador) {
        this.m_Utilizador = m_Utilizador;
    }
    
    public void setAfiliacao(String strAfiliacao)
    {
        this.m_strAfiliacao = strAfiliacao;
    }
    
    public void setEMail(String strEMail)
    {
        this.m_strEMail = strEMail;
    }
    
    public void setUtilizador(Utilizador utilizador)
    {
        this.m_Utilizador = utilizador;
    }
    
    public boolean valida()
    {
        return true;
    }

    boolean podeSerCorrespondente() 
    {
        return (m_Utilizador != null);
    }

    public String getM_strNome() {
        return m_strNome;
    }
    public String getM_strEMail() {
        return m_strEMail;
    }
    
    @Override
    public String toString()
    {
        return this.m_strNome + " - " + this.m_strAfiliacao +  " - " + this.m_strEMail; 
    }
    
    /**
     * 
     * @param obj
     * @return 
     * 
     * Um Autor é identificado pelo seu endereço de e-mail que deve ser único no artigo, 
     * mas não tem que corresponder a um Utilizador.
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        else
            if(obj instanceof Autor) {
                Autor aux = (Autor) obj;
                return this.m_strEMail.equals(aux.m_strEMail);
            } else
                return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.m_Utilizador != null ? this.m_Utilizador.hashCode() : 0);
        hash = 41 * hash + (this.m_strEMail != null ? this.m_strEMail.hashCode() : 0);
        return hash;
    }
}
