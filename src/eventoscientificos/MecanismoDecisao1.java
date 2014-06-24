/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.io.Serializable;
import java.util.List;

/** 
 *Mecanismo de decisao criado para decidir sobre um artigo
 * implementa a interface MecanismoDecisao
 * @author Pereira
 */
public class MecanismoDecisao1 implements MecanismoDecisao, Serializable{
    private static final long serialVersionUID = 1L;
    
     private List<RevisaoArtigo> listaRevisaoArtigo;
     private Decisao decisao;
     private int aceite;
     private int recusada;
     private final String nome = "MecanismoDecisao1";

/**
 * O método recebe um processo de decisão ao qual será associado
 * e percorre a lista de revisões casso existam mais recomendações para aceitar
 * a decisão será "aceite.
 * @param pd
 * @return 
 */
    @Override
    public Decisao decide(ProcessoDecisao pd) {
        
        decisao= pd.novaDecisao();
       listaRevisaoArtigo= pd.getM_listaDistribuicao();
            for (int i = 0; i < listaRevisaoArtigo.size(); i++)   
        {
            if(listaRevisaoArtigo.get(i).getRecomendacao())
                aceite++;
            else
                recusada++;
        }
    if(aceite>recusada)
   decisao.setDecisao("aceite");
    else
    decisao.setDecisao("recusada");
  
    pd.getM_listaDecisao().add(decisao);
    return decisao;
  }
    /**
     * devolve o nome
     * @return 
     */
    @Override
    public String getNome() {
        return nome;
    }
/**
 * 
 * @return a posição
 */
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
/**
 * compara objetos
 * @param obj
 * @return 
 */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MecanismoDecisao1 other = (MecanismoDecisao1) obj;
        return true;
        
        
    }
/**
 * escreve a lista de revisões e a decião
 * @return 
 */
    @Override
    public String toString() {
        return "MecanismoDecisao1{" + "listaDistribuicao=" + listaRevisaoArtigo + ", decisao=" + decisao + ", aceite=" + aceite + ", recusada=" + recusada + ", nome=" + nome + '}';
    }
    
    
    
    
}
