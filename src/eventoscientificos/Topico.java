/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

/**
 *
 * @author iazevedo
 */
public class Topico {
    
    private String m_strDescricao;
    
    private String m_strCodigoACM;

   
    public void setDescricao(String strDescricao) {
        this.m_strDescricao = strDescricao;
    }



    public void setCodigoACM(String codigoACM) {
        this.m_strCodigoACM = codigoACM;
    }
    
    public boolean valida()
    {
        return true;
    }
    
    @Override
    public String toString()
    {
        return "\nCodigo: " + this.m_strCodigoACM +"\nDescrição: " + this.m_strDescricao;
    }
}
