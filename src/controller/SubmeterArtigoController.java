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
import eventoscientificos.Submissao;
import eventoscientificos.Topico;
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

    public SubmeterArtigoController(Empresa empresa)
    {
        m_empresa = empresa;
    }

    public List<Evento> iniciarSubmissao()
    {
        return this.m_empresa.getListaEventosPodeSubmeter();
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
        return this.m_artigo.novoAutor(strNome, strAfiliacao,strEmail,this.m_empresa.getUtilizadorEmail(strEmail));
    }

    public boolean addAutor(Autor autor)
    {
        return this.m_artigo.addAutor(autor);
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

}
