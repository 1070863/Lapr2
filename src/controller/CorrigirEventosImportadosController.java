/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import eventoscientificos.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.SpringLayout;
import states.EventoLidoFicheiroState;

/**
 *
 * @author Lopes
 */
public class CorrigirEventosImportadosController {

    private Empresa m_empresa;
    private String strTitulo_old;

    public CorrigirEventosImportadosController(Empresa m_empresa) {
        this.m_empresa = m_empresa;
    }

    public List<Evento> getListaEventosCarregados() {
        List<Evento> eventosCarregados = new ArrayList<>();
        for (Evento e : m_empresa.getM_registoEventos().getM_listaEventos()) {
            System.out.println(e.getM_strTitulo() + ", " +e.getState() );
            if (e.getState() instanceof EventoLidoFicheiroState) {
                eventosCarregados.add(e);
            }
        }
        return eventosCarregados;
    }

    public void setTitulo(String strTitulo) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setTitulo(strTitulo);
        strTitulo_old = strTitulo;
    }

    public void setDescricao(String strDescricao) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDescricao(strDescricao);
    }

    public void setLocal(String strLocal) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setLocal(strLocal);
    }

    public void setCidade(String strCidade) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setCidade(strCidade);
    }

    public void setPais(String strPais) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setPais(strPais);
    }

    public void setDataInicio(String strDataInicio) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataInicio(strDataInicio);
    }

    public void setDataFim(String strDataFim) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataFim(strDataFim);
    }

    public void setDataLimiteSubmissão(String strDataLimiteSubmissão) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataLimiteSubmissao(strDataLimiteSubmissão);
    }

    public void setDataLimiteRevisao(String strDataLimiteRevisao) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataLimiteRevisao(strDataLimiteRevisao);
    }

    public void setDataLimiteRegisto(String strDataLimiteRegisto) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataLimiteRegisto(strDataLimiteRegisto);
    }

    public void setDataLimiteSubmissaoFinal(String strDataLimiteSubmissaoFinal) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setDataLimiteSubmissaoFinal(strDataLimiteSubmissaoFinal);
    }

    public void setNumeroMaximoTopicos(int nMaxTopicos) {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).setnMaxTopicos(nMaxTopicos);
    }

    public void registaEvento() {
        m_empresa.getM_registoEventos().getEvento(strTitulo_old).getState().setCriado();
    }

    public void setStrTitulo_old(String strTitulo_old) {
        this.strTitulo_old = strTitulo_old;
    }

    /**
     * Valida o nome do evento
     *
     * @param ID nome do evento que tem de ser unico
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
    
    public DefaultListModel listaDeOrganizadores(Evento e) {
        DefaultListModel modelOrganizadores = new DefaultListModel();
        
        for (Organizador o : e.getListaOrganizadores()) {
            modelOrganizadores.addElement(o.toStringSimplificada());
        }
        return modelOrganizadores;
    }

}
