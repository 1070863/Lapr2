/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratarficheiros;

import eventoscientificos.Artigo;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Submissao;
import eventoscientificos.Utilizador;
import excecoes.EventoNaoEncontradoException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import states.SubmissaoCriadaState;

/**
 *
 * @author Pedro
 */
public class ImportarFicheiroArtigoCSV {

    /**
     * Le ficheiro que carrega artigo
     *
     * @param fichArtigo objecto do tipo String
     * @throws java.lang.Exception caso não encontre ficheiro
     */
    public void LerFicheiro(String fichArtigo, Empresa empresa) throws ParserConfigurationException, SAXException, IOException, EventoNaoEncontradoException {

        List<String[]> temp = new ArrayList<>();
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
                            a.setTipo(temp.get(linha)[coluna]);
                            break;
                        case "Title":
                            a.setTitulo(temp.get(linha)[coluna]);
                            break;
                        case "Author":
                            if (coluna < temp.get(linha).length) {
                                autor(temp, linha, coluna, a, empresa);
                            }
                            break;
                    }
                    coluna++;
                }
                
                boolean regista;
                if (existeEvento(a.getEventoID(), empresa)) {
                    Submissao submissao = new Submissao();
                    submissao.novoArtigo();
                    submissao.setArtigo(a);
                    empresa.getM_registoEventos().getEvento(a.getEventoID()).novaSubmissao();
                    empresa.getM_registoEventos().getEvento(a.getEventoID()).addSubmissao(submissao);
                    empresa.getM_registoEventos().getEvento(a.getEventoID()).getSubmissao(a).
                            setState(new SubmissaoCriadaState(submissao));
                } else {
                    //throw new EventoNaoEncontradoException();
                }
                 //if(regista)
                 //{
                 i++;
                 linha++;
                 coluna = 0;  
                 
            }
            
        }
    }

    /**
     * Verifica se o autor pertence à lista de utilizadores. Se existir na lista adiciona ao artigo senão cria o utilizador
     * e adiciona-o ao artigo.
     * @param temp
     * @param linha
     * @param coluna
     * @param artigo
     * @param empresa 
     */
    public void autor(List<String[]> temp, int linha, int coluna, Artigo artigo, Empresa empresa) {
        Utilizador u;
        if (empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna]) != null) {
            u = empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna + 2]);
        } else {
            u = new Utilizador(temp.get(linha)[coluna], temp.get(linha)[coluna], null, temp.get(linha)[coluna + 1]);
            empresa.getM_registaUtilizador().addUtilizador(u);
        }
        artigo.novoAutor(temp.get(linha)[coluna], temp.get(linha)[coluna + 1],
                    temp.get(linha)[coluna + 2], u);
    }

    /**
     * Verifica se o evento já existe
     *
     * @param e
     * @param empresa
     * @return boolean
     */
    public boolean existeEvento(String eventoId, Empresa empresa) {
        for (Evento evento : empresa.getM_registoEventos().getM_listaEventos()) {
            if(evento.getID()!=null)
                if (evento.getID().trim().equalsIgnoreCase(eventoId.trim()))
                    return true;
        }
        return false;
    }
}
