/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tratarficheiros;

import eventoscientificos.Artigo;
import eventoscientificos.Empresa;
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
public class ImportarFicheiroArtigoCSV {
    
    /**
     * Lista de artigos provisória
     */
    private List<Artigo> listaArtigosProvisoria= new ArrayList<>();

    /**
     * Retorna a lista de artigos provisória
     * @return List<Artigo> listaArtigosProvisoria
     */
    public List<Artigo> getListaArtigosProvisoria() {
        return listaArtigosProvisoria;
    }

    /**
     * Le ficheiro que carrega artigo
     *
     * @param fichArtigo objecto do tipo String
     * @throws java.lang.Exception caso não encontre ficheiro
     */

    public void LerFicheiro(String fichArtigo, Empresa empresa) throws ParserConfigurationException, SAXException, IOException {
        
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
                Artigo a = new Artigo();
                
                while (coluna < temp.get(0).length) {
                    opcao = temp.get(0)[coluna];
                    switch (opcao) {
                        case "ConferenceID":
                            a.setEventoID(temp.get(linha)[coluna]);
                            break;
                        case "ID":
                            a.setId(temp.get(linha)[coluna]);
                            break;
                        case "Type":
                            listaArtigosProvisoria.get(i).setTipo(temp.get(linha)[coluna]);
                            break;
                        case "Title":
                            listaArtigosProvisoria.get(i).setTitulo(temp.get(linha)[coluna]);
                            break;
                        case "Author":
                            if(coluna < temp.get(linha).length )
                                 autor(temp, linha, coluna, listaArtigosProvisoria.get(i), empresa);
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
        public void autor(List<String[]> temp, int linha, int coluna, Artigo artigo, Empresa empresa) {
        Utilizador u;
        if (empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna]) != null) {
            u = empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna+2]);
            artigo.novoAutor(temp.get(linha)[coluna], temp.get(linha)[coluna+1], 
                    temp.get(linha)[coluna+2], u);
        }
    }

}
