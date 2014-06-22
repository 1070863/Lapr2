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
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 */
public class ImportacaoDadosController {
    
    public ImportacaoDadosController() {
    }
    
    
    /**Método que retorna uma lista de eventos lida de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     * @return lista de eventos
     */
    public List<Evento> lerEvento(String nomeFicheiro, Empresa empresa){
        LerFicheiroEvento lerFicheiro = new LerFicheiroEventoCSV();
        
        return lerFicheiro.getListaEventosProvisoria();
    }    
    
    /**Método que retorna uma lista de artigos lida de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     * @return lista de artigos
     */
    public List<Artigo> lerArtigos(String nomeFicheiro, Empresa empresa){
        
        return null;
    }
    
    /**Método que retorna uma lista de revisões de artigos lida de um ficheiro .csv
     * @param nomeFicheiro
     * @param empresa
     * @return lista de revisão de artigos
     */
    public List<RevisaoArtigo> lerRevisoes(String nomeFicheiro, Empresa empresa){
        
        return null;
    }
}
