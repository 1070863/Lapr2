/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratarficheiros;

import controller.ImportacaoDadosController;
import eventoscientificos.Artigo;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Submissao;
import eventoscientificos.Utilizador;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.log;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import states.SubmissaoCriadaState;

/**
 *
 * @author Pedro
 */
public class ImportarFicheiroArtigoCSV {
    FileHandler fh;
    Logger log = Logger.getLogger("Log");

    public ImportarFicheiroArtigoCSV() {
        try {
            //Configuração do ficheiro de Logs
            fh = new FileHandler("EventosCientificos.log");
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Importação de artigos iniciada com sucesso!");
        } catch (IOException ex) {
            log.getLogger(ImportacaoDadosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            log.getLogger(ImportacaoDadosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Le ficheiro que carrega artigo
     *
     * @param fichArtigo objecto do tipo String
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
                    empresa.getM_registoEventos().getEventoPorId(a.getEventoID()).addSubmissaoLegacy(submissao);
                    
                } else {
                    log.severe("Erro: Não foi possivel adicionar o artigo: "+a.getTitulo()+
                            " Causa: O evento "+ a.getEventoID()+" não existe no sistema!");
                }

                 i++;
                 linha++;
                 coluna = 0;  
                 
            }            
        }
        }catch (IOException excecao) {
            log.severe("Erro: Erro na leitura do ficheiro!" + excecao.getMessage());
       
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
