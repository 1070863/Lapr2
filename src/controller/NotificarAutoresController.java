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
 * Serve para fazer a ligação entre a NotificarAutores e a NotificarAutoresUI
 */
public class NotificarAutoresController {
    
    //
    private Empresa m_empresa;
    private Artigo artigo;
    private NotificarAutores m_NotificarAutores;
    private Submissao m_submissao;
    private Evento m_evento;
    private NotificarAutores m_notificarAutores;
/**
 * Construtor recebe empresa para poder instanciar os objetos
 * @param empresa 
 */
    public NotificarAutoresController(Empresa empresa) {
       this.m_empresa=empresa;
    }
 /**
  * invoca o método getListaEventosProntosNotificar(strId) da classe RegistoEventos
  * que devolve a lista daquele organizador que estão prontos para notificar
  * @param strId
  * @return 
  */
          public List<Evento> getListaEventosProntosNotificar(String strId){
         List<Evento> listaEventos= new ArrayList<>();
                listaEventos= m_empresa.getM_registoEventos().getListaEventosProntosNotificar(strId);
        return listaEventos;
    }
         /**
          * Recebe um evento e cria um ficheiro de notificação para esse evento
          * @param env
          * @return
          * @throws TransformerException
          * @throws ParserConfigurationException
          * @throws IOException 
          */
          public boolean NotificarAutores(Evento env) throws TransformerException, ParserConfigurationException, IOException
          {
            m_NotificarAutores.NotificarAutores(env);
          return true;
          }
          
          /**
           * Este método serve para validar os estados de modo a verificar
           * se cumpre os requisitos de negócio para alterar o estado se cumprir 
           * altera o estado de evento e submissão
           * @return 
           */
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

