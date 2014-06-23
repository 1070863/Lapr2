/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import eventoscientificos.Artigo;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.LerFicheiroEvento;
import eventoscientificos.LerFicheiroEventoCSV;
import eventoscientificos.RevisaoArtigo;
import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import tratarficheiros.LerFicheiroArtigoCSV;
import tratarficheiros.LerFicheiroRevisaoCSV;

/**
 *
 * @author Pedro
 */
public class ImportacaoDadosController {
    private int opcao;
    
    Logger log = Logger.getLogger("Log");
    FileHandler fh;
    
    public ImportacaoDadosController() {
        try {
            //Configuração do ficheiro de Logs
            fh = new FileHandler("EventosLog.log");
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);
            log.info("Importação de dados iniciada com sucesso!");
        } catch (IOException ex) {
            Logger.getLogger(ImportacaoDadosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ImportacaoDadosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**Método que retorna uma lista de eventos lida de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     * @return lista de eventos
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public List<Evento> lerEvento(String nomeFicheiro, Empresa empresa) throws ParserConfigurationException, 
            SAXException, IOException{
        LerFicheiroEvento lerFicheiro = new LerFicheiroEventoCSV();
        lerFicheiro.LerFicheiro(nomeFicheiro, empresa);
        
        return lerFicheiro.getListaEventosProvisoria();
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
            SAXException, IOException{
        LerFicheiroArtigoCSV lerFicheiro = new LerFicheiroArtigoCSV();
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
        LerFicheiroRevisaoCSV lerFicheiro = new LerFicheiroRevisaoCSV();
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
    
}
