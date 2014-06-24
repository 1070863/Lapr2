package tratarficheiros;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Utilizador;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import states.EventoCriadoFicheiroState;
import utils.*;
import static utils.Data.*;

/**
 * Esta classe serve como controladora do fluxo entre a interface gráfica e a as
 * classes intervenientes para o carregamento de eventos via ficheiro.
 *
 * @author Grupo 66 LPR2
 */
public class LerFicheiroEventoCSV implements LerFicheiroEvento {

    /**
     * Le ficheiro que carrega evento conforme definições de ficheiro
     *
     * @param fichEvento objecto do tipo String
     * @throws java.lang.Exception caso não encontre ficheiro
     */
    @Override
    public void LerFicheiro(String fichEvento, Empresa empresa) throws ParserConfigurationException, SAXException, IOException {
        
        List<String[]> temp = new ArrayList<>();
        Scanner fIn = new Scanner(new File(fichEvento), "ISO-8859-1");

        while (fIn.hasNext()) {
            String[] aux = (fIn.nextLine()).split(";");
            temp.add(aux);
        }
        
        int coluna = 0;
        int linha = 1;

        String opcao = "";
        for (String[] strings : temp) {
            while (linha < temp.size())
            {
                Evento e = new Evento();
                //listaEventosProvisoria.add(new Evento());
                while (coluna < temp.get(0).length) {
                    opcao = temp.get(0)[coluna];
                    switch (opcao) {
                        case "Name":
                            e.setTitulo(temp.get(linha)[coluna]);
                            break;
                        case "Host":
                            e.setLocal(temp.get(linha)[coluna]);
                            break;
                        case "City":
                            e.setCidade(temp.get(linha)[coluna]);
                            break;
                        case "Country":
                            e.setPais(temp.get(linha)[coluna]);
                            break;
                        case "Submission deadline":
                            e.setDataLimiteSubmissao(temp.get(linha)[coluna]);
                            break;
                        case "Revision deadline":
                            e.setDataLimiteRevisao(temp.get(linha)[coluna]);
                            break;
                        case "Final paper deadline":
                            e.setDataLimiteSubmissaoFinal(temp.get(linha)[coluna]);
                            break;
                        case "Author registration deadline":
                            e.setDataLimiteRegisto(temp.get(linha)[coluna]);
                            break;
                        case "Date":
                            e.setDataInicio(temp.get(linha)[coluna]);
                            break;
                        case "Duration (days)":
                            String dataFinal = calculoDataFim(temp, linha, coluna);
                            e.setDataFim(dataFinal);
                            break;
                        case "Organizer":
                            if(coluna < temp.get(linha).length && organizador(temp, linha, coluna, empresa) != null)
                                 e.addOrganizador(temp.get(linha)[coluna + 1], organizador(temp, linha, coluna, empresa));
                            break;
                    }
                    coluna++;
                }

                e.setState(new EventoCriadoFicheiroState(e));
           
                boolean regista = empresa.getM_registoEventos().registaEvento(e);

                    linha++;
                    coluna = 0;  
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

        Calendar c = StringToData(temp.get(linha)[date]);
        c.add(Calendar.DAY_OF_MONTH, duration);

        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String texto = (String) sd.format(c.getTime());
        String[] aux3 = (texto.split("/"));
        int dia = Integer.parseInt(aux3[0].trim());
        int mes = Integer.parseInt(aux3[1].trim());
        int ano = Integer.parseInt(aux3[2].trim());
        Data dataFim = new Data(ano, mes, dia);
        String dataFinal = dataFim.toString();

        return dataFinal;
    }
   
    /**
     * Introducao e validacao de organizadores na lista dos mesmo do evento em
     * questao
     *
     * @param temp Array em que retiramos nome e email do organizador
     * @param posicao posicao que estamos a tratar no array
     * @param evento evento que vai conter a lista de organizadores
     */
    public Utilizador organizador(List<String[]> temp, int linha, int coluna, Empresa empresa) {
        Utilizador u;
        if (empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna + 1]) != null) {
            u = empresa.getM_registaUtilizador().getUtilizadorEmail(temp.get(linha)[coluna + 1]);
            return u;
            //listaEventosProvisoria.get(i).addOrganizador(temp.get(linha)[coluna + 1], u);
           // System.out.println("size: " + listaEventosProvisoria.get(i).getListaOrganizadores().size());
  
        }
        return null;
    }

}
