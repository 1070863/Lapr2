/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author iazevedo
 */
public class Topico implements Serializable{
    private static final long serialVersionUID = 1L;

    private String m_strDescricao;

    private String m_strCodigoACM;

    public Topico(String m_strDescricao, String m_strCodigoACM) {
        this.m_strDescricao = m_strDescricao;
        this.m_strCodigoACM = m_strCodigoACM;
    }

    public Topico() {
        this.m_strDescricao = null;
        this.m_strCodigoACM = null;
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Topico other = (Topico) obj;
        if (!Objects.equals(this.m_strDescricao, other.m_strDescricao)) {
            return false;
        }
        if (!Objects.equals(this.m_strCodigoACM, other.m_strCodigoACM)) {
            return false;
        }
        return true;
    }


}
