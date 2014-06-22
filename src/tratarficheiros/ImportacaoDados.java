/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tratarficheiros;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Utilizador;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import utils.Data;

/**
 *
 * @author Pedro
 */
public class ImportacaoDados {
    private List<Evento> listaEventosProvisoria;
            
    
    private List<Evento> lerEvento(String nomeFicheiro){
        listaEventosProvisoria= new ArrayList<>();
        
        return listaEventosProvisoria;
    }    
     /**
     * Lista de eventos provisória
     */
    
    public List<Evento> getListaEventosProvisoria() {
        return listaEventosProvisoria;
    }

    public void setListaEventosProvisoria(List<Evento> listaEventosProvisoria) {
        this.listaEventosProvisoria = listaEventosProvisoria;
    }

    /**
     * Le ficheiro que carrega evento
     *
     * @param fichEvento objecto do tipo String
     * @throws java.lang.Exception caso não encontre ficheiro
     */
    public void LerFicheiro(String fichEvento, Empresa empresa) throws ParserConfigurationException, SAXException, IOException {
        
        List<String[]> temp = new ArrayList<>();
        Scanner fIn = new Scanner(new File(fichEvento), "ISO-8859-1");

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
                listaEventosProvisoria.add(new Evento());
                while (coluna < temp.get(0).length) {
                    opcao = temp.get(0)[coluna];
                    switch (opcao) {
                        case "Name":
                            listaEventosProvisoria.get(i).setTitulo(temp.get(linha)[coluna]);
                            break;
                        case "Host":
                            listaEventosProvisoria.get(i).setLocal(temp.get(linha)[coluna]);
                            break;
                        case "City":
                            listaEventosProvisoria.get(i).setCidade(temp.get(linha)[coluna]);
                            break;
                        case "Country":
                            listaEventosProvisoria.get(i).setPais(temp.get(linha)[coluna]);
                            break;
                        case "Submission deadline":
                            listaEventosProvisoria.get(i).setDataLimiteSubmissao(temp.get(linha)[coluna]);
                            break;
                        case "Revision deadline":
                            listaEventosProvisoria.get(i).setDataLimiteRevisao(temp.get(linha)[coluna]);
                            break;
                        case "Final paper deadline":
                            listaEventosProvisoria.get(i).setDataLimiteSubmissaoFinal(temp.get(linha)[coluna]);
                            break;
                        case "Author registration deadline":
                            listaEventosProvisoria.get(i).setDataLimiteRegisto(temp.get(linha)[coluna]);
                            break;
                        case "Date":
                            listaEventosProvisoria.get(i).setDataInicio(temp.get(linha)[coluna]);
                            break;
                        case "Duration (days)":
                            String dataFinal = calculoDataFim(temp, linha, coluna);
                            listaEventosProvisoria.get(i).setDataFim(dataFinal);
                            break;
                        case "Organizer":
                            if(coluna < temp.get(linha).length )
                                 organizador(temp, linha, coluna, listaEventosProvisoria.get(i), empresa);
                            break;
                    }
                    coluna++;
                }
                boolean regista = empresa.getM_registoEventos().registaEvento(listaEventosProvisoria.get(i));
                if(regista)
                {
                    i++;
                    linha++;
                    coluna = 0;  
                }
            }
        }
    }

    /**
     * calculo da data final do evento a partir da data inicial e a duração de
     * dias
     *
     * @param temp Array do qual retiramos data de inicio e duração
     * @param linha linha que estamos a tratar no array
     * @return String de data final de evento
     * @throws ParseException
     */
    public String calculoDataFim(List<String[]> temp, int linha, int coluna) throws ParserConfigurationException, SAXException, IOException {

        int duration = Integer.parseInt(temp.get(linha)[coluna]);
        int date = -1;
        for (int i = 0; i < temp.get(0).length; i++) {
            if (temp.get(0)[i].equals("Date")) {
                date = i;
                break;
            }
        }
        String[] aux = (temp.get(linha)[date].split(","));
        String[] aux2 = aux[1].trim().split(" ");

        int mes = findMes(aux2[0].trim());
        int dia = Integer.parseInt(aux2[1].trim());
        int ano = Integer.parseInt(aux[2].trim());

        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = new GregorianCalendar(ano, mes - 1, dia);
        c.add(Calendar.DAY_OF_MONTH, duration);

        String texto = (String) sd.format(c.getTime());
        String[] aux3 = (texto.split("/"));
        dia = Integer.parseInt(aux3[0].trim());
        mes = Integer.parseInt(aux3[1].trim());
        ano = Integer.parseInt(aux3[2].trim());
        Data dataFim = new Data(ano, mes, dia);
        String dataFinal = dataFim.toString();

        return dataFinal;
    }

    private int findMes(String aux) {
        for (int i = 1; i < 14; i++) {
            if (aux.equalsIgnoreCase(Data.nomeMes[i])) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Introducao e validacao de organizadores na lista dos mesmo do evento em
     * questao
     *
     * @param temp Array em que retiramos nome e email do organizador
     * @param posicao posicao que estamos a tratar no array
     * @param evento evento que vai conter a lista de organizadores
     */
    public void organizador(List<String[]> temp, int linha, int coluna, Evento evento, Empresa empresa) {
        Utilizador u;
        if (empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna + 1]) != null) {
            u = empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna + 1]);
            evento.addOrganizador(temp.get(linha)[coluna + 1], u);
        }
    }
    
    
}
