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

    public Topico(String m_strDescricao, String m_strCodigoACM) {
        this.m_strDescricao = m_strDescricao;
        this.m_strCodigoACM = m_strCodigoACM;
    }

    Topico() {

    }

    public void setDescricao(String strDescricao) {
        this.m_strDescricao = strDescricao;
    }

    public void setCodigoACM(String codigoACM) {
        this.m_strCodigoACM = codigoACM;
    }

    public boolean valida() {
        return true;
    }

    @Override
    public String toString() {
        return "\nCodigo: " + this.m_strCodigoACM + "\nDescrição: " + this.m_strDescricao;
    }

    public String getM_strDescricao() {
        return m_strDescricao;
    }

    public String getM_strCodigoACM() {
        return m_strCodigoACM;
    }
}
