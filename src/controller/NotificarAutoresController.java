/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import eventoscientificos.Artigo;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.NotificarAutores;
import eventoscientificos.Submissao;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Pereira
 */
public class NotificarAutoresController {
    
    
    private Empresa m_empresa;
    private Artigo artigo;
    private NotificarAutores m_NotificarAutores;
    private Submissao m_submissao;
    private Evento m_evento;

    public NotificarAutoresController(Empresa empresa) {
       this.m_empresa=empresa;
    }
 

       
       
        public List<Evento> iniciarSubmissao()
    {
        return this.m_empresa.getM_registoEventos().getListaEventosPodeSubmeter();
    }
        
       public void  NovoArtigo()
       {
           m_empresa.getM_registoEventos().novoEvento().novaSubmissao();   
            m_empresa.getM_registoEventos().novoEvento().novaSubmissao().novoArtigo();
       }
       
          public String[] getListaEventosProntosNotificar(){
        String[] listaEventos= new String[m_empresa.getM_registoEventos().getListaEventosProntosNotificar().size()];
        for (Evento evento : m_empresa.getM_registoEventos().getListaEventosProntosNotificar()) {
            listaEventos[m_empresa.getM_registoEventos().getListaEventosProntosNotificar().indexOf(evento)]=
                    evento.getM_strTitulo();
        }
        return listaEventos;
    }
         
}

