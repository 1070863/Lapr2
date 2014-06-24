package controller;

import eventoscientificos.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import states.EventoLidoFicheiroState;

/**
 * Esta classe serve como controladora do fluxo entre a interface gráfica e a as
 * classes intervenientes para a correcção de eventos importados via ficheiro.
 *
 * @author Grupo 66 LPR2
 */
public class CorrigirEventosImportadosController {

    /**
     * Atributos de intância.
     */
    
    private Empresa m_empresa;
    private String strTitulo_old;
    private DefaultListModel modelOrganizadores;
    private List<Utilizador> novosOrganizadores;
      
    /**
     * Construtor responsável por criar instância de empresa.
     *
     * @param m_empresa Empresa a ser instânciada
     */
    public CorrigirEventosImportadosController(Empresa m_empresa) {
        this.m_empresa = m_empresa;
    }
    /**
     * Procura eventos registados que foram lidos do ficheiro e confirmados para correcao
     *
     * @return lista de eventos registados com estado "LidoFicheiro"
     */
    public List<Evento> getListaEventosCarregados() {
        List<Evento> eventosCarregados = new ArrayList<>();
        for (Evento e : m_empresa.getM_registoEventos().getM_listaEventos()) {
            //System.out.println(e.getM_strTitulo() + ", " +e.getState() );
            if (e.getState() instanceof EventoLidoFicheiroState) {
                eventosCarregados.add(e);
            }
        }
        return eventosCarregados;
    }

    /**
     * Redefine titulo do evento que está a ser alterado. Guarda titulo actual em strTitulo_old (utilizado para pesquisa)
     *
     * @param strTitulo novo titulo do evento
     */
    public void setTitulo(String strTitulo) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setTitulo(strTitulo);
        strTitulo_old = strTitulo;
    }
    /**
     * Redefine descricao do evento que está a ser alterado. 
     *
     * @param strDescricao nova descricao para evento
     */
    public void setDescricao(String strDescricao) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDescricao(strDescricao);
    }
    /**
     * Redefine local do evento que está a ser alterado. 
     *
     * @param strLocal novo local para evento
     */
    public void setLocal(String strLocal) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setLocal(strLocal);
    }
    /**
     * Redefine cidade do evento que está a ser alterado. 
     *
     * @param strCidade nova cidade para evento
     */
    public void setCidade(String strCidade) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setCidade(strCidade);
    }
    /**
     * Redefine país do evento que está a ser alterado. 
     *
     * @param strPais novo país para evento
     */
    public void setPais(String strPais) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setPais(strPais);
    }
    /**
     * Redefine data de inicio do evento que está a ser alterado. 
     *
     * @param strDataInicio nova data de início para evento
     */
    public void setDataInicio(String strDataInicio) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataInicio(strDataInicio);
    }
    /**
     * Redefine data de fim do evento que está a ser alterado. 
     *
     * @param strDataFim nova data de fim para evento
     */
    public void setDataFim(String strDataFim) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataFim(strDataFim);
    }
    /**
     * Redefine data limite de submissão do evento que está a ser alterado. 
     *
     * @param strDataLimiteSubmissao nova data limite de submissao para evento
     */
    public void setDataLimiteSubmissão(String strDataLimiteSubmissao) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataLimiteSubmissao(strDataLimiteSubmissao);
    }
    /**
     * Redefine data limite de revisao do evento que está a ser alterado. 
     *
     * @param strDataLimiteRevisao nova data limite de revisao para evento
     */
    public void setDataLimiteRevisao(String strDataLimiteRevisao) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataLimiteRevisao(strDataLimiteRevisao);
    }
    /**
     * Redefine data limite de registo do evento que está a ser alterado. 
     *
     * @param strDataLimiteRegisto nova data limite de registo para evento
     */
    public void setDataLimiteRegisto(String strDataLimiteRegisto) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataLimiteRegisto(strDataLimiteRegisto);
    }
    /**
     * Redefine data limite para submissao final do evento que está a ser alterado. 
     *
     * @param strDataLimiteSubmissaoFinal nova data limite para submissao final do evento
     */
    public void setDataLimiteSubmissaoFinal(String strDataLimiteSubmissaoFinal) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataLimiteSubmissaoFinal(strDataLimiteSubmissaoFinal);
    }
    /**
     * Redefine número máximo de tópicos aceites pelo evento que está a ser alterado. 
     *
     * @param nMaxTopicos novo número máximo de tópicos para evento
     */
    public void setNumeroMaximoTopicos(int nMaxTopicos) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setnMaxTopicos(nMaxTopicos);
    }
     /**
     * Redefine strTitulo_old (utilizado para pesquisas de "evento actual")
     *
     * @param strTitulo_old novo título do evento que está a ser corrigido
     */
    public void setStrTitulo_old(String strTitulo_old) {
        this.strTitulo_old = strTitulo_old;
    }
    /**
     * Altera estado do evento actual para "Criado" (estado anterior: "LidoFicheiro")
     */
    public void registaEvento() {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).getState().setCriado();
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).getState().setRegistado();
    }
    /**
     * Adiciona novo organizador ao evento que está a ser lido actualmente.
     *
     * @param u novo utilizador a ser adicionado
     * @return verdadeiro se conseguiu adicionar utilizador, falso caso tenha ocorrido algum problema.
     */
    public boolean addOrganizador(Utilizador u)
    {
        if( u!=null)
           return m_empresa.getM_registoEventos().getEvento(strTitulo_old).addOrganizador(u.getM_strUsername(), u);
        else
            return false;
    }
    /**
     * Valida o nome do evento
     *
     * @param ID nome do evento: tem de ser unico ou igual ao strTitulo_old (evento actual)
     * @return true se não existir ou se estivermos a modificar um evento sem mexer no nome, false se já existir outro evento com este nome
     */
    public boolean validaNomeEvento(String ID) {
        if (m_empresa.getM_registoEventos().getEvento(ID) == null) {
            return true;
        }
        else if(ID.equals(strTitulo_old)){
            return true;
        } else {
            return false;
        }
    }
    /**
     * Cria uma lista com os organizadores iniciais do tipo DefaultListModel para
     * ser listada na UI.
     *
     * @return lista de organizadores em forma simplificada para apresentacao
     */
    public DefaultListModel listaDeOrganizadores(Evento e) {
        modelOrganizadores = new DefaultListModel();
        
        for (Organizador o : e.getListaOrganizadores()) {
            modelOrganizadores.addElement(o.toStringSimplificada());
        }
        return modelOrganizadores;
    }
    /**
     * Apresenta lista de organizadores do tipo DefaultListModel .
     *
     * @return lista de organizadores
     */
    public DefaultListModel getModelOrganizadores() {
        return modelOrganizadores;
    }
    /**
     * Apresenta lista de novos organizadores a serem adicionados do evento (adicionados via UI).
     *
     * @return lista de novos organizadores
     */
    public List<Utilizador> getNovosOrganizadores() {
        return novosOrganizadores;
    }
     /**
     * Declara lista de novos organizadores. Apaga organizadores caso existam. 
     */
    public void resetNovosOrganizadores(){
        this.novosOrganizadores = new ArrayList<>();
    }
    /**
     * Valida se id introduzida corresponde a organizador
     *
     * @param orgID id do organizador (email ou username)
     * @return true se encontra pelo menos um evento com aquele id de organizador. 
     */
    public boolean isOrganizador(String orgID) {
        for (Evento e : m_empresa.getM_registoEventos().getM_listaEventos()) {
            for (Organizador o : e.getListaOrganizadores()) { 
                if (o.getM_utilizador().getM_strEmail().equals(orgID)
                        || o.getM_utilizador().getM_strUsername().equals(orgID)) {
                    return true;
                }
            }
        }
        return false;
    }
}
