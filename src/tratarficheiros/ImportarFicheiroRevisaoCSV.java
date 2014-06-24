/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tratarficheiros;

import eventoscientificos.Empresa;
import eventoscientificos.RevisaoArtigo;
import eventoscientificos.Revisor;
import eventoscientificos.Utilizador;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Pedro
 */
public class ImportarFicheiroRevisaoCSV {
    /**
     * Lista de revisões provisória
     */
    private List<RevisaoArtigo> listaRevisoesProvisoria= new ArrayList<>();

    /**
     * Retorna a lista de revisões provisória
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
            while (linha < temp.size())
            {
                listaRevisoesProvisoria.add(new RevisaoArtigo());
                while (coluna < temp.get(0).length) {
                    opcao = temp.get(0)[coluna];
                    switch (opcao) {
                        case "Reviewer":        
                            listaRevisoesProvisoria.get(i).setRevisor(revisor(temp, linha, coluna,
                                    empresa));
                            break;
                        case "Reviewer confidence":
                            listaRevisoesProvisoria.get(i).setConfianca(temp.get(linha)[coluna]);
                            break;
                        case "Suitability for the event":
                            listaRevisoesProvisoria.get(i).setConfianca(temp.get(linha)[coluna]);
                            break;
                        case "Originality":
                            listaRevisoesProvisoria.get(i).setOriginalidade(temp.get(linha)[coluna]);
                            break;
                        case "Quality":
                            listaRevisoesProvisoria.get(i).setQualidade(temp.get(linha)[coluna]);
                            break;
                        case "Overall Recommendation":
                            listaRevisoesProvisoria.get(i).setRecomendacao(temp.get(linha)[coluna].equalsIgnoreCase("Accept") ?
                                    true : false);
                            break;
                    }
                    coluna++;
                }
                /*boolean regista = empresa.getM_registoEventos().registaEvento(listaArtigosProvisoria.get(i));
                if(regista)
                {
                    i++;
                    linha++;
                    coluna = 0;  
                }*/
            }
        }
    }
    /**
     * Retorna o autor se existir na lista de utilizadores
     * @param temp
     * @param linha
     * @param coluna
     * @param empresa
     * @return Autor
     */    
    public Revisor revisor(List<String[]> temp, int linha, int coluna, Empresa empresa) {
        Utilizador u;
        Revisor revisor = new Revisor();
        if (empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna]) != null) {
            u = empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna]);
            revisor.setM_utilizador(u);
            revisor.setM_strNome(u.getM_strNome());
        }
        return revisor;
    }
}
