/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import controller.SubmeterArtigoController;
import eventoscientificos.Autor;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Topico;
import java.util.ArrayList;
import java.util.List;
import utils.Utils;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class SubmeterArtigoUI
{

    private Empresa m_empresa;
    private SubmeterArtigoController m_controllerSA;

    public SubmeterArtigoUI(Empresa empresa)
    {
        m_empresa = empresa;
        m_controllerSA = new SubmeterArtigoController(m_empresa);
    }

    // alterado na iteração 2
    public void run()
    {
        List<Evento> le = m_controllerSA.iniciarSubmissao();

        apresentaEventos(le);

        Evento e = selecionaEvento(le);

        if (e != null)
        {
            m_controllerSA.selectEvento(e);

            String strTitulo = Utils.readLineFromConsole("Introduza o Título do Artigo: ");
            String strResumo = Utils.readLineFromConsole("Introduza o Resumo do Artigo: ");

            m_controllerSA.setDados(strTitulo, strResumo);

            adicionarAutores();

            List<Autor> la = m_controllerSA.getPossiveisAutoresCorrespondentes();

            apresentaAutores(la);

            Autor autor = selecionaAutor(la);

            m_controllerSA.setCorrespondente(autor);

            String strFicheiro = Utils.readLineFromConsole("Introduza o Ficheiro do Artigo: ");
            m_controllerSA.setFicheiro(strFicheiro);

            List<Topico> listaTopicosArtigo = selecionaTopicosArtigo();

            m_controllerSA.setListaTopicosArtigo(listaTopicosArtigo);

            String strQuestao = "Confirma a submissão do artigo com a seguinte informação: \n" + m_controllerSA.getInfoResumo() + "\n Opção (S/N):";
            boolean bConfirma = confirma(strQuestao);

            if (bConfirma)
            {
                if (m_controllerSA.registarSubmissao())
                {
                    System.out.println("Submissão concluida com sucesso.");
                } else
                {
                    System.out.println("Submissão cancelada devido a erros.");
                }

            } else
            {
                System.out.println("Submissão de artigo cancelada.");
            }

            System.out.println("Terminado.");
        } else
        {
            System.out.println("Submissão de artigo cancelada.");
        }

    }

    private void apresentaEventos(List<Evento> le)
    {
        System.out.println("Eventos: ");

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

    private void adicionarAutores()
    {
        String strResposta;
        do
        {
            String strNome = Utils.readLineFromConsole("Introduza Nome do Autor: ");
            String strAfiliacao = Utils.readLineFromConsole("Introduza Afiliação do Autor: ");
            String strEmail = Utils.readLineFromConsole("Introduza E-Mail do Autor: ");

            //Autor autor = m_controllerSA.novoAutor(strNome, strAfiliacao);
            Autor autor = m_controllerSA.novoAutor(strNome, strAfiliacao,strEmail);

            String strQuestao = "Confirma os dados do Autor: \n" + autor.toString() + "\n Opção (S/N):";
            boolean bConfirma = confirma(strQuestao);

            if (bConfirma)
            {
                if (m_controllerSA.addAutor(autor))
                {
                    System.out.println("Autor adicionado.");
                } else
                {
                    System.out.println("Autor não adicionado.");
                }
            } else
            {
                System.out.println("Autor não adicionado.");
            }

            strResposta = Utils.readLineFromConsole("Introduzir outro autor (S/N)? ");
        } while (strResposta.equalsIgnoreCase("S"));
    }

    private Autor selecionaAutor(List<Autor> la)
    {
        String opcao;
        int nOpcao;
        do
        {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > la.size());

        if (nOpcao == 0)
        {
            return null;
        } else
        {
            return la.get(nOpcao - 1);
        }
    }

    private void apresentaAutores(List<Autor> la)
    {
        System.out.println("Selecione Autor Correspondente: ");

        int index = 0;
        for (Autor a : la)
        {
            index++;

            System.out.println(index + ". " + a.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancelar");
    }

    // adicionada na iteração 2
    private List<Topico> selecionaTopicosArtigo()
    {
        List<Topico> listaTopicosEvento = this.m_controllerSA.getTopicosEvento();
        
        List<Topico> listaTopicosArtigo = new ArrayList<Topico>();

        String strResposta;
        do
        {
            apresentaTopicosEvento( listaTopicosEvento );

            Topico t = selecionaTopico( listaTopicosEvento );

            listaTopicosArtigo.add(t);

            strResposta = Utils.readLineFromConsole("Introduzir outro tópico (S/N)? ");
        }
        while (strResposta.equalsIgnoreCase("S"));
        
        return listaTopicosArtigo;
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
    
    private boolean confirma(String questao)
    {
        String strConfirma;
        do
        {
            strConfirma = Utils.readLineFromConsole(questao);
        } while (!strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));

        return strConfirma.equalsIgnoreCase("s");
    }
}
