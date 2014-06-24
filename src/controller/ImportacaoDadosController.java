/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import eventoscientificos.Empresa;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import tratarficheiros.ImportarFicheiroEventoCSV;
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
     */
    public void lerEventos(String nomeFicheiro, Empresa empresa) {
        ImportarFicheiroEventoCSV lerFicheiro = new ImportarFicheiroEventoCSV();
        lerFicheiro.lerFicheiro(nomeFicheiro, empresa);
    }
    
    /**Método que carrega artigos lidos de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public void lerArtigos(String nomeFicheiro, Empresa empresa) {
        ImportarFicheiroArtigoCSV lerFicheiro = new ImportarFicheiroArtigoCSV();
        lerFicheiro.lerFicheiro(nomeFicheiro, empresa);
        
    } 
        
    
    /**Método que carrega revisões de artigos lidas de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     */
    public void lerRevisoes(String nomeFicheiro, Empresa empresa) {
        ImportarFicheiroRevisaoCSV lerFicheiro = new ImportarFicheiroRevisaoCSV();
        lerFicheiro.lerFicheiro(nomeFicheiro, empresa);

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
