/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import eventoscientificos.Artigo;
import eventoscientificos.Autor;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Organizador;
import eventoscientificos.Submissao;
import eventoscientificos.Topico;
import eventoscientificos.Utilizador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class SubmeterArtigoController
{

    private Empresa m_empresa;
    private Evento m_evento;
    private Submissao m_submissao;
    private Artigo m_artigo;
    private List<Evento> eventosPodeSub;
    private List<Topico> topicosArtigo;

    public SubmeterArtigoController(Empresa empresa)
    {
        m_empresa = empresa;
        eventosPodeSub= new ArrayList<>();
        topicosArtigo = new ArrayList<>();
    }

    public List<Evento> iniciarSubmissao()
    {
        return this.m_empresa.getM_registoEventos().getListaEventosPodeSubmeter();
    }

    public void selectEvento(Evento e)
    {
        m_evento = e;
        this.m_submissao = this.m_evento.novaSubmissao();
        this.m_artigo = this.m_submissao.novoArtigo();
    }

    public List<Topico> getTopicosEvento()
    {
        if (m_evento != null)
        {
            return m_evento.getTopicos();
        } else
        {
            return null;
            
        }
    }

    public void setDados(String strTitulo, String strResumo)
    {
        this.m_artigo.setTitulo(strTitulo);
        this.m_artigo.setResumo(strResumo);
    }

    public Autor novoAutor(String strNome, String strAfiliacao)
    {
        return this.m_artigo.novoAutor(strNome, strAfiliacao);
    }
    
    public Autor novoAutor(String strNome, String strAfiliacao, String strEmail)
    {
        return this.m_artigo.novoAutor(strNome, strAfiliacao,strEmail,
                this.m_empresa.getM_registaUtilizador().getUtilizadorEmail(strEmail));
    }

    public boolean addAutor(Autor autor)
    {
        return this.m_artigo.addAutor(autor);
    }

    public List<Topico> getTopicosArtigo() {
        return topicosArtigo;
    }

    public List<Autor> getPossiveisAutoresCorrespondentes()
    {
        return this.m_artigo.getPossiveisAutoresCorrespondentes();
    }

    public void setCorrespondente(Autor autor)
    {
        this.m_artigo.setAutorCorrespondente(autor);
    }

    public void setFicheiro(String strFicheiro)
    {
        this.m_artigo.setFicheiro(strFicheiro);
    }

    public String getInfoResumo()
    {
        return this.m_submissao.getInfo() + this.m_artigo.getInfo();
    }

    public Submissao getM_submissao() {
        return m_submissao;
    }

    public boolean registarSubmissao()
    {
        this.m_submissao.setArtigo(m_artigo);
        return this.m_evento.addSubmissao(m_submissao);
    }

    // adicionado na iteração 2
    public void setListaTopicosArtigo(List<Topico> listaTopicosArtigo)
    {
        m_artigo.setListaTopicos(listaTopicosArtigo);
    }

    /**
     * Obtém a lista de eventos que podem submeter artigos
     * @return String[]
     */
    public String[] getListaEventosPodeSub(){
        String[] listaEventos= new String[m_empresa.getM_registoEventos().
                getListaEventosPodeSubmeter().size()];
        for (Evento evento : m_empresa.getM_registoEventos().getListaEventosPodeSubmeter()) {
                listaEventos[m_empresa.getM_registoEventos().getListaEventosPodeSubmeter().indexOf(evento)]=
                    evento.getM_strTitulo();
            
        }
        return listaEventos;
    }
    
    /**
     * Retorna a lista de autores
     * @param empresa
     * @return String[]
     */
    public String[] listaAutores(Empresa empresa){
        String[] autores = new String[this.m_empresa.getM_registaUtilizador().getM_listaUtilizadores().size()];
        for (Utilizador utilizador : this.m_empresa.getM_registaUtilizador().getM_listaUtilizadores()) {
            autores[this.m_empresa.getM_registaUtilizador().
                    getM_listaUtilizadores().indexOf(utilizador)]=utilizador.getM_strUsername();
        }
        return autores;
    }
    
    /**
     * Recebe uma string com o nome do autor e obtém o Utilizador se existir
     * @param autor
     * @return Utilizador
     */
    public Utilizador obterAutor(String autor){
        return m_empresa.getM_registaUtilizador().getUtilizador(autor);
    }

    public Artigo getM_artigo() {
        return m_artigo;
    }
    
    public void setTipoArtigo(String tipo){
        this.m_artigo.setTipo(tipo);
    }
    
    /**
     * Procura um tópico inserido e retorna o objeto tópico correspondente. Se não existir retorna null
     * @param t
     * @return Topico 
     */
    public Topico topicoExisteEvento(String t){
        if(t!=null){
            List<Topico> topico = new ArrayList<>();
            topico = getTopicosEvento();
            if (topico != null) {
                for (Topico t_evento : topico) {
                    if (t.equalsIgnoreCase(t_evento.getM_strCodigoACM())) {
                        return t_evento;
                    }
                }
        }
        }
        return null;
    }
    
    public void addTopico(Topico topico){
        this.topicosArtigo.add(topico);
    }

    }

