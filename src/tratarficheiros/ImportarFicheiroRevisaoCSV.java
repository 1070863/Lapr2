/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratarficheiros;

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
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import states.EventoRevistoState;
import states.SubmissaoCriadaState;
import states.SubmissaoRevistaState;

/**
 *
 * @author Pedro
 */
public class ImportarFicheiroRevisaoCSV {

    /**
     * Lista de revisões provisória
     */
    private List<RevisaoArtigo> listaRevisoesProvisoria = new ArrayList<>();

    /**
     * Retorna a lista de revisões provisória
     *
     * @return List<RevisaoArtigo> listaRevisoesProvisoria
     */
    public List<RevisaoArtigo> getListaRevisoesProvisoria() {
        return listaRevisoesProvisoria;
    }

    /**
     * Le ficheiro que carrega as revisões
     *
     * @param fichRevisoes objecto do tipo String
     * @throws java.lang.Exception caso não encontre ficheiro
     */
    public void LerFicheiro(String fichArtigo, Empresa empresa) throws ParserConfigurationException,
            SAXException, IOException {

        List<String[]> temp = new ArrayList<>();
        Scanner fIn = new Scanner(new File(fichArtigo), "ISO-8859-1");

        while (fIn.hasNext()) {
            String[] aux = (fIn.nextLine()).split(";");
            temp.add(aux);
        }

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
            }
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
