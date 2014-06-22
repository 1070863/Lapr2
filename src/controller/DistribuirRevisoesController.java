/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import eventoscientificos.ProcessoDistribuicao;
import eventoscientificos.Distribuicao;
import eventoscientificos.*;
import java.util.ArrayList;
import java.util.List;
import states.EventoCPDefinidaState;
import states.SubmissaoArtigosParaRevisaoSubmetidosState;

/**
 *
 * @author Lopes
 */
public class DistribuirRevisoesController {

    private Empresa m_empresa;
    private Evento m_evento;
    private ProcessoDistribuicao processoDistribuicao;
    private List<Distribuicao> listaDistribuicoes = new ArrayList<>();
    private List<MecanismoDistribuicao> listaMecanismos;

    public DistribuirRevisoesController(Empresa empresa) {
        m_empresa = empresa;
    }  
        
    public Evento getM_evento() {
        return m_evento;
    }
    
    public void setEvento(Evento e) {
        m_evento = e;
        processoDistribuicao = m_evento.novoProcessoDistribuicao();
        processoDistribuicao.setM_listaSubmissoes(m_evento.getListaSubmissoes());
    }


    public List<Evento> novaDistribuicaoOrganizador(String orgID) {
       List<Evento> listaEventosOrganizador = new ArrayList<Evento>();
                for(Evento e : m_empresa.getM_registoEventos().getEventosOrganizador(orgID)){
                    for (Submissao submissao : e.getListaSubmissoes()) {
                    if(e.getState() instanceof EventoCPDefinidaState &&
                            submissao.getState() instanceof SubmissaoArtigosParaRevisaoSubmetidosState)
                   listaEventosOrganizador.add(e);}
                }
                return listaEventosOrganizador;
    }

    public ProcessoDistribuicao getProcessoDistribuicao() {
        return processoDistribuicao;
    }

    public List<MecanismoDistribuicao> getMecanismoDistribuicao() {
        listaMecanismos = m_empresa.getM_registoEventos().criarListaMecanismoDistribuicaos();
        return listaMecanismos;
    }

    public void setMecanismoDistribuicao(int m) {
        m_evento.getProcessoDistribuicao().setMecanismoDistribuicao(m);
        listaDistribuicoes = m_evento.getProcessoDistribuicao().getMecanismoDistribuicao().distribui(processoDistribuicao);
    }
    
    public void RegistaDistribuicao() {
        m_evento.setProcessoDistribuicao(processoDistribuicao);
    }

    public List<Distribuicao> getListaDistribuicoes() {
        return listaDistribuicoes;
    }

    public void setListaDistribuicoes(List<Distribuicao> listaDistribuicoes) {
        this.listaDistribuicoes = listaDistribuicoes;
    }
    
    public boolean termina()
    {
         for (Submissao submissao : m_evento.getListaSubmissoes())
         {
             submissao.getState().SetArtigosParaRevisaoSubmetidos();
         }
    return m_evento.getState().setCPDefinida();
    
    }
}
