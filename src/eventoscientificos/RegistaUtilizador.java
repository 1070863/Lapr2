/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

import java.util.ArrayList;
import java.util.List;

/**
 *Esta classe tem como principal objetivo gerir Utilizadores. 
 * Tem uma lista de Utilizadores e alguns métodos que lhe permite validar os dados e adicionar 
 *utilizadores a sua lista 
 * @author Pereira
 */
public class RegistaUtilizador {

    private List<Utilizador> m_listaUtilizadores;

    /**
     * Cria uma lista de Utilizadores
     */
    public RegistaUtilizador() {
        this.m_listaUtilizadores = new ArrayList<Utilizador>();
    }
/**
 * Cria um novo utilizador invocando o construtor da classe Utilizador
 * @return 
 */
    public Utilizador novoUtilizador() {
        return new Utilizador();
    }
/**
 * Este método verifica se o utilizador passado por parametro existe na lista
 * caso exista retorna true
 * @param u
 * @return 
 */
    private boolean validaUtilizador(Utilizador u) {

        for (Utilizador uExistente : m_listaUtilizadores) {
            if (uExistente.mesmoQueUtilizador(u)) {
                return false;
            }
        }
        return true;
    }
/**
 * Cria um novo utilizador e valida os atributos do utilizador e verifica se existe na lista
 * Se os atributos estiverem corretos e não existir o utilizador na lista 
 * adiciona utilizador á lista
 * @param u
 * @return 
 */
    public boolean registaUtilizador(Utilizador u) {
        u = new Utilizador();
        if (u.valida() && validaUtilizador(u)) {
            return addUtilizador(u);
        } else {
            return false;
        }
    }
/**
 * Percorre a lista de utilizadores e caso encontro o utilizador devolve-o
 * senão devolve null
 * @param strId
 * @return 
 */
    public Utilizador getUtilizador(String strId) {
        for (Utilizador u : this.m_listaUtilizadores) {
            String s1 = u.getUsername();
            if (s1.equalsIgnoreCase(strId)) {
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
 * @return 
 */
    public Utilizador getUtilizadorEmail(String strEmail) {
        for (Utilizador u : this.m_listaUtilizadores) {
            String s1 = u.getEmail();
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

}
