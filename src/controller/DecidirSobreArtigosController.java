/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import eventoscientificos.Decisao;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.MecanismoDecisao;
import eventoscientificos.ProcessoDecisao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pereira
 */
public class DecidirSobreArtigosController implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Empresa m_empresa;
    private Evento m_evento;
    private ProcessoDecisao processoDecisao;
    private List<Decisao> listaDecisoes = new ArrayList<>();
    private List<MecanismoDecisao> listaMecanismosDecisao;
    
/**
 * construtor recebe a empresa e instancia this.empresa
 * @param m_empresa 
 */
    public DecidirSobreArtigosController(Empresa m_empresa) {
        this.m_empresa = m_empresa;
    }
/**
 * 
 * @return evento
 */
    public Evento getM_evento() {
        return m_evento;
    }
/**
 * 
 * @param m_evento 
 */
    public void setM_evento(Evento m_evento) {
        this.m_evento = m_evento;
        processoDecisao= this.m_evento.novoProcessoDecisao();
    }
    /**
     * devolve a lista de eventos para um dado organizador
     * @param orgID
     * @return 
     */
    public List<Evento> ListarEventosOrganizador(String orgID) {
        List<Evento> listaEventosOrganizador = m_empresa.getM_registoEventos().getEventosOrganizador(orgID);
        return listaEventosOrganizador;
    }
/**
 * 
 * @return processoDecisao
 */
    public ProcessoDecisao getProcessoDecisao() {
        return processoDecisao;
    }
/**
 * reescreve no valor
 * @param processoDecisao 
 */
    public void setProcessoDecisao(ProcessoDecisao processoDecisao) {
        this.processoDecisao = processoDecisao;
    }
    
/**
 * cria Mecanismo de decisao
 * @return lista de decisao
 */
    public List<MecanismoDecisao> getListaMecanismosDecisao() {
        listaMecanismosDecisao = m_empresa.getM_registoEventos().criarListaMecanismoDecisao();
        return listaMecanismosDecisao;
    }
/**
 * reescreve listaMecanismoDecisao
 * @param listaMecanismosDecisao 
 */
    public void setListaMecanismosDecisao(List<MecanismoDecisao> listaMecanismosDecisao) {
        this.listaMecanismosDecisao = listaMecanismosDecisao;
    }
    
/**
 * decide sobre um artigo e acrescenta a decisao a listaDecisoes
 * @param m 
 */
     public void setMecanismoDecisao(int m) {
        m_evento.getProcessoDecisao().setMecanismoDecisao(m);
         m_evento.getProcessoDecisao().decide();
         listaDecisoes = m_evento.getProcessoDecisao().getM_listaDecisao();
    }
    
   
/**
 * 
 * @return listaDecisao
 */
    public List<Decisao> getListaDecisoes() {
        return listaDecisoes;
    }
/**
 * reescreve toda a lista
 * @param listaDecisoes 
 */
    public void setListaDecisoes(List<Decisao> listaDecisoes) {
        this.listaDecisoes = listaDecisoes;
    }
    
   
}
