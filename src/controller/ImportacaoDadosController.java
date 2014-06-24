/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import eventoscientificos.Artigo;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import tratarficheiros.LerFicheiroEvento;
import tratarficheiros.LerFicheiroEventoCSV;
import eventoscientificos.RevisaoArtigo;
import excecoes.EventoExistenteException;
import excecoes.EventoNaoEncontradoException;
import excecoes.RegistoEventoException;
import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import tratarficheiros.ImportarFicheiroArtigoCSV;
import tratarficheiros.LerFicheiroEventoXML;
import tratarficheiros.ImportarFicheiroRevisaoCSV;

/**
 *
 * @author Pedro
 */
public class ImportacaoDadosController {
    private int opcao;
    
    
    
    public ImportacaoDadosController() {
        
    }  
    
    /**Método que retorna uma lista de eventos lida de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     * @return lista de eventos
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public void lerEventos(String nomeFicheiro, Empresa empresa) throws ParserConfigurationException, 
            SAXException, IOException, EventoExistenteException, RegistoEventoException{
        LerFicheiroEventoCSV lerFicheiro = new LerFicheiroEventoCSV();
        lerFicheiro.LerFicheiro(nomeFicheiro, empresa);
        
    }
    
    /**Método que retorna uma lista de artigos lida de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     * @return lista de artigos
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public List<Artigo> lerArtigos(String nomeFicheiro, Empresa empresa) throws ParserConfigurationException, 
            SAXException, IOException, EventoNaoEncontradoException{
        ImportarFicheiroArtigoCSV lerFicheiro = new ImportarFicheiroArtigoCSV();
        lerFicheiro.LerFicheiro(nomeFicheiro, empresa);
        
        return lerFicheiro.getListaArtigosProvisoria();
    }
    
    /**Método que retorna uma lista de revisões de artigos lida de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     * @return lista de revisão de artigos
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public List<RevisaoArtigo> lerRevisoes(String nomeFicheiro, Empresa empresa) throws 
            ParserConfigurationException, SAXException, IOException{
        ImportarFicheiroRevisaoCSV lerFicheiro = new ImportarFicheiroRevisaoCSV();
        lerFicheiro.LerFicheiro(nomeFicheiro, empresa);
        
        return lerFicheiro.getListaRevisoesProvisoria();
    }

    /**
     * Atribui a opção selleccionada
     * @param opcao 
     */
    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
    
    /**
     * Valida se o ficheiro seleccionado é valido
     * @param nomeFicheiro
     * @return int
     */
    public int validaFicheiro(String nomeFicheiro){
        int index = nomeFicheiro.lastIndexOf(".");
        String ext = nomeFicheiro.substring(index);
        
        if (ext.equalsIgnoreCase(".csv")) 
            return 0;
        else 
            return 1; 
        
    }
    
}
