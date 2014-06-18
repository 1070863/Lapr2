/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mecanismo1 implements MecanismoDistribuicao {
    
    List<Distribuicao> listaDistribuicaos;
    private final String nome = "Mecanismo1";

    /**
     * Variáveis de instância
     */
    private List<Revisor> lRev;

    /**
     * Variáveis de classe
     */
    private static int nAtribuicoes = 3;

    /**
     * Procura lista de revisores
     *
     * @return lista de revisores
     */
    public List<Revisor> getlRev() {
        return lRev;
    }

    /**
     * Define uma lista de revisores
     *
     * @param lRev lista de objecto do tipo Revisor
     */
    public void setlRev(List<Revisor> lRev) {
        this.lRev = lRev;
    }

    /**
     * Procura numero atribuiçoes do artigo neste mecanismo
     *
     * @return numero atribuiçoes do artigo neste mecanismo
     */
    public static int getnAtribuicoes() {
        return nAtribuicoes;
    }

    /**
     * Define um numero atribuiçoes do artigo neste mecanismo
     *
     * @param nAtribuicoes objecto do tipo int
     */
    public static void setnAtribuicoes(int nAtribuicoes) {
        Mecanismo1.nAtribuicoes = nAtribuicoes;
    }
       @Override
    public List<Distribuicao> distribui(ProcessoDistribuicao processoDistribuicao) {
        listaDistribuicaos = new ArrayList<>();
        List<Submissao> listSub = processoDistribuicao.getM_listaSubmissoes();
          
        for (Submissao submissao : listSub) {
            lRev = new ArrayList();
            Distribuicao nd = processoDistribuicao.novaDistribuicao();
            int artigoIndex = listSub.indexOf(submissao);
            List<Topico> lta = listSub.get(artigoIndex).getArtigo().getM_listaTopicos();
            nd.setM_artigo(submissao.getArtigo());
            for (Revisor revisor : processoDistribuicao.getM_cp().getListaRevisores()) {
                List<Topico> ltr = revisor.getM_listaTopicos();
                boolean adicionouRevisor = false;
                for (Topico topicoRevisor : ltr) {
                    for (Topico topicoLista : lta) {
                        if (topicoLista.getM_strCodigoACM().equals(topicoRevisor.getM_strCodigoACM()) && !adicionouRevisor) {
                            lRev.add(revisor);
                            adicionouRevisor = true;
                        }
                    }
                }
            }
            if (lRev.size() > 2) {
                gerarRandomRev(nd);

               listaDistribuicaos.add(nd);
               return listaDistribuicaos;
            }else{
                return null;
            }
        }
        return null;       
    }


    /**
     * gera uma atribuição aleatória de revisores ao artigo
     *
     * @param nd distribuição a ser alterada
     * @return distribuição alterada
     */
    private Distribuicao gerarRandomRev(Distribuicao nd) {
        Collections.shuffle(lRev);
        for (int i = 0; i < nAtribuicoes; i++) {
            nd.getM_listaRevisores().add(lRev.get(i));
        }
        return nd;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mecanismo1 other = (Mecanismo1) obj;
        return true;
    }
    
    
    
}
