/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import eventoscientificos.Artigo;
import eventoscientificos.Distribuicao;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Submissao;
import java.util.ArrayList;
import java.util.List;
import states.EventoDistribuidoState;
import states.EventoRevistoState;
import states.SubmissaoRevistaState;

/**
 *
 * @author Pedro
 */
public class RevisaoArtigoController {
    private Empresa m_empresa;
    private Evento evento;
    private Artigo artigo;
    private List<Artigo> artigos;
    private Submissao submissao;

    /**
     * Constroi uma instância de RevisaoArtigoController
     * @param m_empresa 
     */
    public RevisaoArtigoController(Empresa m_empresa) {
        this.m_empresa = m_empresa;
        this.artigos = new ArrayList<Artigo>();
    }
    
    /**
     * Obtém a lista de eventos que podem ser revistos do organizador
     * @param organizador
     * @return List<Evento>
     */
    public List<Evento> getListaEventosPodeRever(String organizador){
        List<Evento> eventos = new ArrayList<Evento>();
        for (Evento e : this.m_empresa.getM_registoEventos().getEventosOrganizador(organizador)) {
            if(e.getState() instanceof EventoDistribuidoState){
                eventos.add(e);
            }
        }
        return eventos;
    }
    
    /**
     * Selecciona um evento
     * @param evento 
     */
    public void seleccionaEvento(String evento){
        this.evento = m_empresa.getM_registoEventos().getEvento(evento);
    }
    
    /**
     * Retorna a lista de artigos distribuidos
     * @return List<Artigo>
     */
    public List<Artigo> getListaArtigos(){
        List<Distribuicao> distribuicoes = new ArrayList<Distribuicao>();
        distribuicoes =this.m_empresa.getM_registoEventos().getEvento(this.evento.getM_strTitulo()).
                getProcessoDistribuicao().getM_listaDistribuicao();
        
        for (Distribuicao distribuicao : distribuicoes) {
            artigos.add(distribuicao.getM_artigo());
        }
        return artigos;
    }

    public Artigo getArtigo() {
        return artigo;
    }
    
    /**
     * Selecciona um artigo
     * @param artigo 
     */
    public void sleccionaArtigo(String artigo){
        for (Artigo a : artigos) {
            if(a.getTitulo().equalsIgnoreCase(artigo)){
                this.artigo = a;
            }
        }
    }
    
    /**
     * Selecciona submissão
     * @param artigo 
     */
    public void seleccionaSubmissao(Artigo artigo){
        this.submissao =  this.m_empresa.getM_registoEventos().
                getEvento(evento.getM_strTitulo()).getSubmissao(artigo); 
    }
    
    public boolean registaRevisao(String confianca, String adequacao, String originalidade,
            String qualidade, boolean recomendacao, String texto){
        if(this.m_empresa.getM_registoEventos().getEvento(this.evento.
                getM_strTitulo()).getSubmissao(artigo).valida()){
            
             for (Distribuicao distribuicao : this.m_empresa.getM_registoEventos().getEvento(evento.getM_strTitulo()).
                    getProcessoDistribuicao().getM_listaDistribuicao()) {
                 if(distribuicao.getM_artigo().equals(this.artigo)){
                     distribuicao.setConfianca(confianca);
                     distribuicao.setAdequacao(adequacao);
                     distribuicao.setOriginalidade(originalidade);
                     distribuicao.setQualidade(qualidade);
                     distribuicao.setRecomendacao(recomendacao);
                     distribuicao.setTextoJustificativo(texto);
                     this.m_empresa.getM_registoEventos().getEvento(evento.getM_strTitulo()).
                             getSubmissao(artigo).setState(new SubmissaoRevistaState(submissao));
                     this.m_empresa.getM_registoEventos().getEvento(evento.getM_strTitulo()).
                             setState(new EventoRevistoState(evento));
                     return true;
                 }
             }
                    
        }
        return false;
    }
    
    
}
