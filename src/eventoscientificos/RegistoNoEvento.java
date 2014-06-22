package eventoscientificos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que gere o registo num evento.
 *
 * @author GRUPO66 LAPR2
 */
import pt.ipp.isep.dei.eapli.canadaexpress.CanadaExpress;
import pt.ipp.isep.dei.eapli.canadaexpress.Pedido;
import pt.ipp.isep.dei.eapli.visaolight.VisaoLight;

public class RegistoNoEvento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Autor m_autor;
    private List<Submissao> m_listaSubmisoesAceites;
    private double m_valor;
    private VisaoLight m_pagVisaoLight;
    private CanadaExpress m_pagCanadaExpress;

    /**
     * Construtor completo quando todos os atributos são passados por parâmetro.
     *
     * @param m_autor autor do(s) artigos
     * @param m_listaSubmisoesAceites lista de submissões dos artigos aceites
     * @param m_valor valor pago
     */
    public RegistoNoEvento(Autor m_autor, List<Submissao> m_listaSubmisoesAceites, double m_valor) {
        this.m_autor = m_autor;
        this.m_listaSubmisoesAceites = new ArrayList<>();
        this.m_valor = m_valor;
    }

    /**
     * Construtor por omissão de atributos.
     */
    public RegistoNoEvento() {
        this.m_autor = null;
        this.m_listaSubmisoesAceites = new ArrayList<>();
        this.m_valor = 0;
    }

    /**
     * Procura o Autor.
     * @return objeto do tipo Autor
     */
    public Autor getM_autor() {
        return m_autor;
    }

    public void setM_autor(Autor m_autor) {
        this.m_autor = m_autor;
    }

    public List<Submissao> getM_listaSubmisoesAceites() {
        return m_listaSubmisoesAceites;
    }

    public void setM_listaSubmisoesAceites(List<Submissao> m_listaSubmisoesAceites) {
        this.m_listaSubmisoesAceites = m_listaSubmisoesAceites;
    }

    public double getM_valor() {
        return m_valor;
    }

    public void setM_valor(double m_valor) {
        this.m_valor = m_valor;
    }

    public void pagamentoVisaoLight(String strNumCC, String dataValidadeCC, float valorAutoriza, String dataLimiteAutoriza) {
        VisaoLight.getAutorizacaoDCC(strNumCC, dataValidadeCC, valorAutoriza, dataLimiteAutoriza);
    }

    public void pagamentoCanadaExpress(Date dataValidade, String strNumCC, float fValorADCC, Date dataLimite) {
        this.m_pagCanadaExpress = new CanadaExpress();
        Pedido pagamento = new Pedido(dataValidade, strNumCC, fValorADCC, dataLimite);
        this.m_pagCanadaExpress.ValidaPedido(pagamento);
    }

    @Override
    public String toString() {
        String result = "";
        result += "Autor: " + this.m_autor.getM_strNome() + "\nSubmissões: ";
        for (int i = 0; i < this.m_listaSubmisoesAceites.size(); i++) {
            result += "\n" + this.m_listaSubmisoesAceites.get(i).getArtigo().getTitulo();
        }
        result += "Valor:" + this.m_valor;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof RegistoNoEvento) {
            RegistoNoEvento aux = (RegistoNoEvento) obj;
            return (this.m_autor.equals(aux.m_autor)
                    || this.m_listaSubmisoesAceites.equals(aux.m_listaSubmisoesAceites)
                    || (this.m_valor == aux.m_valor));
        } else {
            return false;
        }
    }

}
