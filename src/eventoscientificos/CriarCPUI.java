package eventoscientificos;


import java.util.ArrayList;
import java.util.List;
import utils.*;

/**
 *
 * @author Nuno Silva
 */
public class CriarCPUI
{

    private Empresa m_empresa;
    private CriarCPController m_controllerCCP;

    public CriarCPUI(Empresa empresa)
    {
        m_empresa = empresa;
        m_controllerCCP = new CriarCPController(m_empresa);
    }

    public void run()
    {
        String strIdOrganizador = introduzIdOrganizador();

        List<Evento> le = m_controllerCCP.getEventosOrganizador(strIdOrganizador);

        apresentaEventosOrganizador(strIdOrganizador, le);

        Evento e = selecionaEvento(le);

        if (e != null)
        {
            m_controllerCCP.selectEvento(e);

            adicionaMembrosCP();

            m_controllerCCP.setCP();

            System.out.println("Terminado.");
        } else
        {
            System.out.println("Criação da Comissão de Programa cancelada.");
        }
    }

    private String introduzIdOrganizador()
    {
        return Utils.readLineFromConsole("Introduza Id Organizador: ");
    }

    private void apresentaEventosOrganizador(String strIdOrganizador, List<Evento> le)
    {
        System.out.println("Eventos do organizador " + strIdOrganizador + ":");

        int index = 0;
        for (Evento e : le)
        {
            index++;

            System.out.println(index + ". " + e.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancelar");
    }

    private Evento selecionaEvento(List<Evento> le)
    {
        String opcao;
        int nOpcao;
        do
        {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > le.size());

        if (nOpcao == 0)
        {
            return null;
        } else
        {
            return le.get(nOpcao - 1);
        }
    }

    // alterado na iteração 2
    private void adicionaMembrosCP()
    {
        String strResposta;
        do
        {
            String strId = Utils.readLineFromConsole("Introduza Id do Membro: ");

            Revisor r = m_controllerCCP.addMembroCP(strId);

            if (r == null)
            {
                System.out.println("Membro não criado.");
            } else
            {
                System.out.println("Membro CP: " + r.toString());

                if (confirmaNovoMembroCP())
                {
                    if (m_controllerCCP.registaMembroCP(r))
                    {
                        System.out.println("Membro da CP adicionado.");
                        
                        List<Topico> listaTopicosRevisor = selecionaTopicosRevisor();

                        m_controllerCCP.setListaTopicosRevisor(r, listaTopicosRevisor);
                    } else
                    {
                        System.out.println("Membro da CP não adicionado.");
                    }
                }
            }

            strResposta = Utils.readLineFromConsole("Introduzir outro membro CP (S/N)? ");
        } while (strResposta.equalsIgnoreCase("S"));
    }

    private boolean confirmaNovoMembroCP()
    {
        String strConfirma;
        do
        {
            strConfirma = Utils.readLineFromConsole("Confirma novo membro da CP (S/N): ");
        } while (!strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));

        if (strConfirma.equalsIgnoreCase("s"))
        {
            return true;
        } else
        {
            return false;
        }
    }

    // adicionada na iteração 2
    private List<Topico> selecionaTopicosRevisor()
    {
        List<Topico> listaTopicosEvento = this.m_controllerCCP.getTopicosEvento();
        
        List<Topico> listaTopicosRevisor = new ArrayList<Topico>();

        String strResposta;
        do
        {
            apresentaTopicosEvento( listaTopicosEvento );

            Topico t = selecionaTopico( listaTopicosEvento );

            listaTopicosRevisor.add(t);

            strResposta = Utils.readLineFromConsole("Introduzir outro tópico (S/N)? ");
        }
        while (strResposta.equalsIgnoreCase("S"));
        
        return listaTopicosRevisor;
    }

    // adicionada na iteração 2
    private void apresentaTopicosEvento( List<Topico> listaTopicos )
    {
        int i = 0;
        System.out.println("Topicos de Evento:");

        for (Topico t : listaTopicos)
        {
            i++;
            System.out.println(i + "." + t.toString());
        }
    }

    // adicionada na iteração 2
    private Topico selecionaTopico(List<Topico> le)
    {
        String opcao;
        int nOpcao;
        do
        {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > le.size());

        if (nOpcao == 0)
        {
            return null;
        } else
        {
            return le.get(nOpcao - 1);
        }
    }
}