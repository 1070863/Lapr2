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
import java.util.ArrayList;
import java.util.List;
import states.EventoDistribuidoState;

/**
 *
 * @author Pedro
 */
public class RevisaoArtigoController {
    private Empresa m_empresa;
    private Evento evento;
    private Artigo artigo;
    private List<Artigo> artigos;

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
    
    public boolean registaRevisao(String confianca, String adequacao, String originalidade,
            String qualidade, String recomendacao, String texto){
        if(this.m_empresa.getM_registoEventos().getEvento(this.evento.
                getM_strTitulo()).valida()){
            
                    
        }
    }
    
}
