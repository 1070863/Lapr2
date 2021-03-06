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
 *Esta classe tem como principal objetivo gerir Utilizadores. 
 * Tem uma lista de Utilizadores e alguns métodos que lhe permite validaEmailr os dados e adicionar 
utilizadores a sua lista 
 * @author Pereira
 */
public class RegistoUtilizador implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Utilizador> m_listaUtilizadores;

    /**
     * Cria uma lista de Utilizadores
     */
    public RegistoUtilizador() {
        this.m_listaUtilizadores = new ArrayList<Utilizador>();
    }
/**
 * Cria um novo utilizador invocando o construtor da classe Utilizador
 * @return Utilizador por omissão
 */
    public Utilizador novoUtilizador() {
        return new Utilizador();
    }
/**
 * Este método verifica se o utilizador passado por parametro existe na lista
 * caso exista retorna true
 * @param u
 * @return boolean
 */
    private boolean validaUtilizador(Utilizador u) {

        for (Utilizador uExistente : m_listaUtilizadores) {
            if (uExistente.equals(u)) {
                return false;
            }
        }
        return true;
    }
/**
 * Cria um novo utilizador e validaEmail os atributos do utilizador e verifica se existe na lista
 Se os atributos estiverem corretos e não existir o utilizador na lista 
 adiciona utilizador á lista
 * @param u
 * @return boolean
 */
    public boolean registaUtilizador(Utilizador u) {
    if (u.validaEmail() && validaUtilizador(u)){
            return addUtilizador(u);
        } else {
            return false;
        }
    }
/**
 * Percorre a lista de utilizadores e caso encontro o utilizador devolve-o
 * senão devolve null
 * @param strId
 * @return Utilizador
 */
    public Utilizador getUtilizador(String strId) {
        for (Utilizador u : this.m_listaUtilizadores) {
            String s1 = u.getM_strUsername();
            String s2= u.getM_strEmail();
            if (s1.equalsIgnoreCase(strId) || s2.equalsIgnoreCase(strId)) {
                return u;
            }
        }
        return null;
    }
    /**
     * 
     * @param strId
     * @return Utilizador
     */
    public Utilizador setUtilizador(String strId) {
        for (Utilizador u : this.m_listaUtilizadores) {
            String s1 = strId;
            String s2= strId;
            if (s1.equalsIgnoreCase(strId) || s2.equalsIgnoreCase(strId)) {
                return u;
            }
        }
        return null;
    }
/**
 * 
 * Percorre a lista de utilizadores e caso encontre o e-mail de um utilizador devolve-o
 * senão devolve null
 * @param strEmail
 * @return Utilizador
 */
    public Utilizador getUtilizadorEmail(String strEmail) {
        for (Utilizador u : this.m_listaUtilizadores) {
            String s1 = u.getM_strEmail();
            if (s1.equalsIgnoreCase(strEmail)) {
                return u;
            }
        }

        return null;
    }
    /**
     * 
     * @param strEmail
     * @return 
     */
     public Utilizador setUtilizadorEmail(String strEmail) {
        for (Utilizador u : this.m_listaUtilizadores) {
            String s1 = strEmail;
            if (s1.equalsIgnoreCase(strEmail)) {
                return u;
            }
        }

        return null;
    }
    
/**
 * adiciona um utilizador á lista
 * @param u
 * @return 
 */
    public boolean addUtilizador(Utilizador u) {

        return m_listaUtilizadores.add(u);
    }

    public List<Utilizador> getM_listaUtilizadores() {
        return m_listaUtilizadores;
    }

}
