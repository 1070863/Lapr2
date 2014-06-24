/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import eventoscientificos.Artigo;
import eventoscientificos.Empresa;
import tratarficheiros.LerFicheiroEventoCSV;
import eventoscientificos.RevisaoArtigo;
import excecoes.EventoExistenteException;
import excecoes.EventoNaoEncontradoException;
import excecoes.RegistoEventoException;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import tratarficheiros.ImportarFicheiroArtigoCSV;
import tratarficheiros.ImportarFicheiroRevisaoCSV;

/**
 *
 * @author Pedro
 */
public class ImportacaoDadosController {
    private int opcao;
    
    
    
    public ImportacaoDadosController() {
        
    }  
    
    /**Método que carrega eventos lidos de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public void lerEventos(String nomeFicheiro, Empresa empresa) throws ParserConfigurationException, 
            SAXException, IOException, EventoExistenteException, RegistoEventoException{
        LerFicheiroEventoCSV lerFicheiro = new LerFicheiroEventoCSV();
        lerFicheiro.LerFicheiro(nomeFicheiro, empresa);
        
    }
    
    /**Método que carrega artigos lidos de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public void lerArtigos(String nomeFicheiro, Empresa empresa) throws ParserConfigurationException, 
            SAXException, IOException, EventoNaoEncontradoException{
        ImportarFicheiroArtigoCSV lerFicheiro = new ImportarFicheiroArtigoCSV();
        lerFicheiro.LerFicheiro(nomeFicheiro, empresa);
        
    }
    
    /**Método que carrega revisões de artigos lidas de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public void lerRevisoes(String nomeFicheiro, Empresa empresa) throws 
            ParserConfigurationException, SAXException, IOException{
        ImportarFicheiroRevisaoCSV lerFicheiro = new ImportarFicheiroRevisaoCSV();
        lerFicheiro.LerFicheiro(nomeFicheiro, empresa);
        
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
