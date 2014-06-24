package controller;

import tratarficheiros.LerFicheiroEvento;
import tratarficheiros.LerFicheiroEventoCSV;
import tratarficheiros.LerFicheiroEventoXML;
import eventoscientificos.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import states.EventoCriadoFicheiroState;
import states.EventoLidoFicheiroState;

/**
 * Esta classe serve como controladora do fluxo entre a interface gráfica e a as
 * classes intervenientes para o carregamento de eventos via ficheiro.
 *
 * @author Grupo 66 LPR2
 */
public class CarregarEventosController {

    /**
     * Atributos de intância.
     */
    private Empresa m_empresa;
    private LerFicheiroEvento lerFicheiroEvento;
    private List<Evento> listaProvisoria;

    /**
     * Construtor responsável por criar instância de empresa.
     *
     * @param empresa Empresa a ser instânciada
     */
    public CarregarEventosController(Empresa m_empresa) {
        this.m_empresa = m_empresa;

    }
    /**
     * Carrega ficheiro com eventos para a empresa
     *
     * @param fileName nome do ficheiro a ser lido
     * @return 0 se a leitura e carregamento for correcta, 1 caso a extensao seja desconhecida
     * e 2 em casa do ficheiro inválido (sem eventos válidos criados)
     */
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

        if(m_empresa.getM_registoEventos().getListaEventosCriadoFicheiroSize() < 1)
            return 2; 
        
        return 0;
    }
    /**
     * Apresenta lista de eventos carregados via ficheiro que ainda não estão tratados
     * (estado = CriadoFicheiro)
     *
     * @return lista de eventos em estado CriadoFicheiro
     */
    public List<Evento> mostrarListaProvisoria() {
        this.listaProvisoria = new ArrayList<>();
        for (Evento e : m_empresa.getM_registoEventos().getM_listaEventos()) {
            System.out.println(e.getM_strTitulo() + ", " +e.getState() );
            if (e.getState() instanceof EventoCriadoFicheiroState) {
                listaProvisoria.add(e);
            }
        }
        return this.listaProvisoria;
    }

     /**
     * Atribuí estado "LidoFicheiro" a evento (confirmado para carregamento via UI)
     * 
     * @param e evento a transitar para estado "LidoFicheiro"
     */
    public void setEvento(Evento e) {     
        e.getState().setLidoFicheiro();
    }
     /**
     * Apaga eventos carregado mas não tratados (impede que fiquem em espera em futuros carregamentos)
     */
     public void apagaEventosDesnecessarios() {     
        m_empresa.getM_registoEventos().apagaEventosCriadoFicheiro();
    }
}
