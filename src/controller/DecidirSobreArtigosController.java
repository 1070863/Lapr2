/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import eventoscientificos.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import states.EventoRevistoState;
import states.SubmissaoRevistaState;

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
    private Decisao m_decisao;
    private List<RevisaoArtigo> listaRevisaoArtigos;
    private Submissao submissao;
    
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
        List<Evento> listaEventosOrganizador = new ArrayList<Evento>();
                for(Evento e : m_empresa.getM_registoEventos().getEventosOrganizador(orgID)){
                    for (Submissao submissao : e.getListaSubmissoes()) {
                    if(e.getState() instanceof EventoRevistoState &&
                            submissao.getState() instanceof SubmissaoRevistaState)
                   listaEventosOrganizador.add(e);}
                }
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
        m_decisao= m_evento.getProcessoDecisao().getMecanismoDecisao().decide(processoDecisao);
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
    
    public Submissao getArtigo()
    {
        int i=0;
     for (Submissao submissao : m_evento.getListaSubmissoes())
         i++;
         if(submissao.getArtigo().equals(processoDecisao.getM_listaDistribuicao().get(i).getM_artigo()))
             return submissao;
         else 
             return null;
    }
   /**
     * Quando terminado o caso de uso este método irá iniciar a validação do
     * evento.
     *
     * @return verdadeiro ou falso em função da validação do evento e dos seus
     * estados.
     */
    public boolean termina() {
         getArtigo().getState().setRevista();
        return this.m_evento.getState().setRevisto();
        
    }
}
