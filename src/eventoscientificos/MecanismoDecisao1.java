/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.util.List;

/** 
 *Mecanismo de decisao criado para decidir 
 * @author Pereira
 */
public class MecanismoDecisao1 implements MecanismoDecisao{
    
     private List<Distribuicao> listaDistribuicao;
     private Decisao decisao;
     private List<Decisao> listaDecisao;
     private int aceite;
     private int recusada;
     private final String nome = "MecanismoDecisao1";


    @Override
    public Decisao decide(ProcessoDecisao pd) {
        
        decisao= pd.novaDecisao();
       listaDecisao=pd.getM_listaDecisao();
       listaDistribuicao= pd.getM_listaDistribuicao();
            for (int i = 0; i < listaDistribuicao.size(); i++)   
        {
            if(listaDistribuicao.get(i).getRecomendacao())
                aceite++;
            else
                recusada++;
        }
    if(aceite>recusada)
   decisao.setDecisao("aceite");
    else
    decisao.setDecisao("recusada");
  
    listaDecisao.add(decisao);
    return decisao;
  }
    @Override
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
        final MecanismoDecisao1 other = (MecanismoDecisao1) obj;
        return true;
        
        
    }

    @Override
    public String toString() {
        return "MecanismoDecisao1{" + "listaDistribuicao=" + listaDistribuicao + ", decisao=" + decisao + ", listaDecisao=" + listaDecisao + ", aceite=" + aceite + ", recusada=" + recusada + ", nome=" + nome + '}';
    }
    
    
    
    
}
