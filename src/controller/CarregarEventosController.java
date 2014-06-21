package controller;

import eventoscientificos.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Lopes
 */
public class CarregarEventosController {

    private Empresa m_empresa;
    private LerFicheiroEvento lerFicheiroEvento;
    private List<Evento> listaProvisoria;

    public CarregarEventosController(Empresa m_empresa) {
        this.m_empresa = m_empresa;

    }

    public int setFicheiro(String fileName) throws ParserConfigurationException, SAXException, IOException {
        int index = fileName.lastIndexOf(".");
        String ext = fileName.substring(index);
        
        if (ext.equalsIgnoreCase(".csv")) 
            lerFicheiroEvento = new LerFicheiroEventoCSV();
        else if (ext.equalsIgnoreCase(".xml")) 
            lerFicheiroEvento = new LerFicheiroEventoXML();
        else 
            return 1;
        
        lerFicheiroEvento.LerFicheiro(fileName, m_empresa);

        if(lerFicheiroEvento.getListaEventosProvisoria().size() < 1)
            return 2; 
        
        return 0;
    }

    public List<Evento> mostrarListaProvisoria() {
        this.listaProvisoria = new ArrayList<>();
        this.listaProvisoria = lerFicheiroEvento.getListaEventosProvisoria();
        return this.listaProvisoria;
    }

    public void setEvento(Evento e) {
        m_empresa.getM_registoEventos().getListaEventosCorrigir().add(e);
    }
}
