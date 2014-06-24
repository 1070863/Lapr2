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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import states.EventoDecididoState;
/**
 *
 * @author Pereira
 * Serve para fazer a ligação entre a NotificarAutores 
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
 
          public List<Evento> getListaEventosProntosNotificar(String strId){
         List<Evento> listaEventos= new ArrayList<>();
                listaEventos= m_empresa.getM_registoEventos().getListaEventosProntosNotificar(strId);
        return listaEventos;
    }
         
          public boolean NotificarAutores(Evento env) throws TransformerException, ParserConfigurationException, IOException
          {
            NotificarAutores(env);
          return true;
          }
          
          
          public boolean termina()
          {
              for (Submissao submissao : m_evento.getListaSubmissoes())
         {
             submissao.getState().setNotificadoAceite();
              submissao.getState().setRejeitada();
         }
              
          return m_evento.getState().setDecidido();
          
          
          }
}

