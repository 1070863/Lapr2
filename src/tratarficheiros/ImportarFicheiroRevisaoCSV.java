/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratarficheiros;

import controller.ImportacaoDadosController;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.RevisaoArtigo;
import eventoscientificos.Revisor;
import eventoscientificos.Submissao;
import eventoscientificos.Utilizador;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import states.EventoRevistoState;
import states.SubmissaoRevistaState;

/**
 *
 * @author Pedro
 */
public class ImportarFicheiroRevisaoCSV {

    
    FileHandler fh;
Logger log = Logger.getLogger("Log");

    public ImportarFicheiroRevisaoCSV() {
        try {
            //Configuração do ficheiro de Logs
				fh = new FileHandler("EventosCientificos.log");
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Inicia a importação de dados!");
        } catch (IOException ex) {
            log.getLogger(ImportarFicheiroRevisaoCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            log.getLogger(ImportarFicheiroRevisaoCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Le ficheiro que carrega as revisões
     *
     * @param fichRevisoes objecto do tipo String
     * @throws java.lang.Exception caso não encontre ficheiro
     */
    public void lerFicheiro(String fichArtigo, Empresa empresa) {

        List<String[]> temp = new ArrayList<>();
        try{
        Scanner fIn = new Scanner(new File(fichArtigo), "ISO-8859-1");

        while (fIn.hasNext()) {
            String[] aux = (fIn.nextLine()).split(";");
            temp.add(aux);
        }
        
        fIn.close();

        int coluna = 0;
        int linha = 1;
        int i = 0;

        String opcao = "";
        for (String[] strings : temp) {
            while (linha < temp.size()) {
                RevisaoArtigo revisao = new RevisaoArtigo();
                
                while (coluna < temp.get(0).length) {
                    opcao = temp.get(0)[coluna];
                    switch (opcao) {
                        case "ConferenceID":
                            revisao.setIdEvento(temp.get(linha)[coluna]);
                        case "ID":
                            revisao.setIdArtigo(temp.get(linha)[coluna]);
                        case "Reviewer":
                            revisao.setRevisor(revisor(temp, linha, coluna,
                                    empresa));
                            break;
                        case "Reviewer confidence":
                            revisao.setConfianca(temp.get(linha)[coluna]);
                            break;
                        case "Suitability for the event":
                            revisao.setAdequacao(temp.get(linha)[coluna]);
                            break;
                        case "Originality":
                            revisao.setOriginalidade(temp.get(linha)[coluna]);
                            break;
                        case "Quality":
                            revisao.setQualidade(temp.get(linha)[coluna]);
                            break;
                        case "Overall Recommendation":
                            revisao.setRecomendacao(temp.get(linha)[coluna].equalsIgnoreCase("Accept")
                                    ? true : false);
                            break;
                    }
                    coluna++;
                }

                boolean regista;
                if (existeEvento(revisao.getIdEvento(), empresa)) {
                    Submissao submissao = empresa.getM_registoEventos().getEvento(revisao.getIdEvento()).
                            getSubmissao(revisao.getM_artigo());
                    if (submissao != null) {
                        empresa.getM_registoEventos().getEvento(revisao.getIdEvento()).
                                getSubmissao(revisao.getM_artigo()).
                                setRevisaoArtigo(revisao);

                        empresa.getM_registoEventos().getEvento(revisao.getIdEvento()).
                                setState(new EventoRevistoState(empresa.getM_registoEventos().
                                                getEvento(revisao.getIdEvento())));

                        empresa.getM_registoEventos().getEvento(revisao.getIdEvento()).
                                getSubmissao(revisao.getM_artigo()).
                                setState(new SubmissaoRevistaState(empresa.getM_registoEventos().
                                                getEvento(revisao.getIdEvento()).
                                                getSubmissao(revisao.getM_artigo())));
                    }
                }
                    i++;
                 linha++;
                 coluna = 0;
                }
            }
       } catch (IOException excecao) {
            log.severe("Erro: Erro na leitura do ficheiro!" + excecao.getMessage());
        } 
    }

    /**
     * Retorna o revisor se existir na lista de utilizadores Se não existir cria
     * um utilizador
     *
     * @param temp
     * @param linha
     * @param coluna
     * @param empresa
     * @return Revisor
     */
    public Revisor revisor(List<String[]> temp, int linha, int coluna, Empresa empresa) {
        Utilizador u;
        Revisor revisor = new Revisor();
        if (empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna]) != null) {
            u = empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna]);
        } else {
            u = new Utilizador(temp.get(linha)[coluna], temp.get(linha)[coluna], null, temp.get(linha)[coluna + 1]);
            empresa.getM_registaUtilizador().addUtilizador(u);
        }
        revisor.setM_utilizador(u);
        revisor.setM_strNome(u.getM_strNome());
        return revisor;
    }

    /**
     * Verifica se o evento já existe
     *
     * @param e
     * @param empresa
     * @return boolean
     */
    private boolean existeEvento(String eventoId, Empresa empresa) {
        for (Evento evento : empresa.getM_registoEventos().getM_listaEventos()) {
            if (evento.getID() != null) {
                if (evento.getID().trim().equalsIgnoreCase(eventoId.trim())) {
                    return true;
                }
            }
        }
        return false;
    }
}
