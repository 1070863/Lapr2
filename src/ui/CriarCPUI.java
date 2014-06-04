package ui;

import controller.CriarCPController;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Revisor;
import eventoscientificos.Topico;
import java.util.ArrayList;
import java.util.List;
import utils.*;

/**
 * Classe responsável pela interface gráfica aquando da criação de uma CP
 * (Comissão de Programa).
 *
 * @author Grupo 66 LPR2
 */
public class CriarCPUI {

    /**
     * Atributos de intância.
     */
    private Empresa m_empresa;
    private CriarCPController m_controllerCCP;

    /**
     * Construtor de rersponsável por intânciar os atributos.
     *
     * @param empresa objeto do tipo empresa
     */
    public CriarCPUI(Empresa empresa) {
        this.m_empresa = empresa;
        this.m_controllerCCP = new CriarCPController(m_empresa);
    }

    /**
     * Inicia o processo de criação de CP.
     */
    public void run() {
        String strIdOrganizador = introduzIdOrganizador();

        List<Evento> le = this.m_controllerCCP.getEventosOrganizador(strIdOrganizador);

        apresentaEventosOrganizador(strIdOrganizador, le);

        Evento e = selecionaEvento(le);

        if (e != null) {
            this.m_controllerCCP.selectEvento(e);

            adicionaMembrosCP();

            this.m_controllerCCP.setCP();

            System.out.println("Terminado.");
        } else {
            System.out.println("Criação da Comissão de Programa cancelada.");
        }
    }

    /**
     * Lê o id do organizador.
     *
     * @return id do organizador
     */
    private String introduzIdOrganizador() {
        return Utils.readLineFromConsole("Introduza Id Organizador: ");
    }

    /**
     * Apresenta ao organizador os eventos para os quais ele é organizador.
     *
     * @param strIdOrganizador username ou email do organizador
     * @param le lista de eventos do organizador
     */
    private void apresentaEventosOrganizador(String strIdOrganizador, List<Evento> le) {
        System.out.println("Eventos do organizador " + strIdOrganizador + ":");

        int index = 0;
        for (Evento e : le) {
            index++;

            System.out.println(index + ". " + e.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancelar");
    }

    /**
     * Seleciona na lista de eventos o evento para qual quer criar uma CP.
     *
     * @param le lista de eventos do organizador
     * @return evento selecionado
     */
    private Evento selecionaEvento(List<Evento> le) {
        String opcao;
        int nOpcao;
        do {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > le.size());

        if (nOpcao == 0) {
            return null;
        } else {
            return le.get(nOpcao - 1);
        }
    }

    /**
     * Adiciona revisores à CP (Comissão de Programa) através da indicação do
     * seu id.
     */
    private void adicionaMembrosCP() {
        String strResposta;
        do {
            String strId = Utils.readLineFromConsole("Introduza Id do Membro: ");

            Revisor r = m_controllerCCP.addMembroCP(strId);

            if (r == null) {
                System.out.println("Membro não criado.");
            } else {
                System.out.println("Membro CP: " + r.toString());

                if (confirmaNovoMembroCP()) {
                    if (m_controllerCCP.registaMembroCP(r)) {
                        System.out.println("Membro da CP adicionado.");

                        List<Topico> listaTopicosRevisor = selecionaTopicosRevisor();

                        m_controllerCCP.setListaTopicosRevisor(r, listaTopicosRevisor);
                    } else {
                        System.out.println("Membro da CP não adicionado.");
                    }
                }
            }

            strResposta = Utils.readLineFromConsole("Introduzir outro membro CP (S/N)? ");
        } while (strResposta.equalsIgnoreCase("S"));
    }

    /**
     * Apresenta a informação do membro da CP introduzido e solicita
     * confirmação.
     *
     * @return verdadeiro/falso em função da decisão do organizador
     */
    private boolean confirmaNovoMembroCP() {
        String strConfirma;
        do {
            strConfirma = Utils.readLineFromConsole("Confirma novo membro da CP (S/N): ");
        } while (!strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));

        if (strConfirma.equalsIgnoreCase("s")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Lista os tópicos do Evento para que sejam indicados quais os tópicos de
     * perícia do revisor.
     *
     * @return lista de tópicos de pericia
     */
    private List<Topico> selecionaTopicosRevisor() {
        List<Topico> listaTopicosEvento = this.m_controllerCCP.getTopicosEvento();

        List<Topico> listaTopicosRevisor = new ArrayList<Topico>();

        String strResposta;
        do {
            apresentaTopicosEvento(listaTopicosEvento);

            Topico t = selecionaTopico(listaTopicosEvento);

            listaTopicosRevisor.add(t);

            strResposta = Utils.readLineFromConsole("Introduzir outro tópico (S/N)? ");
        } while (strResposta.equalsIgnoreCase("S"));

        return listaTopicosRevisor;
    }

    /**
     * Apresenta ao organizador os tópicos do evento.
     *
     * @param listaTopicos lista de tópicos do evento
     */
    private void apresentaTopicosEvento(List<Topico> listaTopicos) {
        int i = 0;
        System.out.println("Topicos de Evento:");

        for (Topico t : listaTopicos) {
            i++;
            System.out.println(i + "." + t.toString());
        }
    }

    /**
     * Seleciona e retorna um tópico de uma lista de tópicos.
     *
     * @param le lista de tópicos
     * @return objeto do tipo Tópico
     */
    private Topico selecionaTopico(List<Topico> le) {
        String opcao;
        int nOpcao;
        do {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > le.size());

        if (nOpcao == 0) {
            return null;
        } else {
            return le.get(nOpcao - 1);
        }
    }
}
