package eventoscientificos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
    private String m_date;

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
     *
     * @return objeto do tipo Autor
     */
    public Autor getM_autor() {
        return m_autor;
    }

    /**
     * Define o Autor.
     *
     * @param m_autor
     */
    public void setM_autor(Autor m_autor) {
        this.m_autor = m_autor;
    }

    /**
     * Procura a lista de Submissões aceites do autor num determinado evento.
     *
     * @return lista de submissões aceites
     */
    public List<Submissao> getM_listaSubmisoesAceites() {
        return m_listaSubmisoesAceites;
    }

    /**
     * Defina uma lista de submissões aceites para o autor.
     *
     * @param m_listaSubmisoesAceites lista de submissões aceites
     */
    public void setM_listaSubmisoesAceites(List<Submissao> m_listaSubmisoesAceites) {
        this.m_listaSubmisoesAceites = m_listaSubmisoesAceites;
    }

    /**
     * Procura o valor a pagar pelo resgito no evento.
     *
     * @return valor a pagar pelo registo.
     */
    public double getM_valor() {
        return m_valor;
    }

    /**
     * Procura o valor a data em que foi efetuado o resgito no evento.
     *
     * @return data em que o registo. registo foi efetuado
     */
    public String getM_data() {
        return m_date;
    }

    /**
     * Define o valor a pagar pelo registo no evento.
     *
     * @param m_valor valor a pagar pelo registo
     */
    public void setM_valor(double m_valor) {
        this.m_valor = m_valor;
    }

    /**
     * Instância de um método de pagamento externo aceite pelo sistema.
     *
     * @param strNumCC numero cartão de crédito
     * @param dataValidadeCC data de validade do cartão
     * @param valorAutoriza valor autorizado a ser debitado
     * @param dataLimiteAutoriza data limite de autorização
     */
    public void pagamentoVisaoLight(String strNumCC, String dataValidadeCC, float valorAutoriza, String dataLimiteAutoriza) {
        this.m_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        VisaoLight.getAutorizacaoDCC(strNumCC, dataValidadeCC, valorAutoriza, dataLimiteAutoriza);
    }

    /**
     * Instância de um método de pagamento externo aceite pelo sistema.
     *
     * @param dataValidade data de validade do cartão
     * @param strNumCC numero cartão de crédito
     * @param fValorADCC valor autorizado a ser debitado
     * @param dataLimite data limite de autorização
     */
    public void pagamentoCanadaExpress(Date dataValidade, String strNumCC, float fValorADCC, Date dataLimite) {
        this.m_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        this.m_pagCanadaExpress = new CanadaExpress();
        Pedido pagamento = new Pedido(dataValidade, strNumCC, fValorADCC, dataLimite);
        this.m_pagCanadaExpress.ValidaPedido(pagamento);
    }

    /**
     * Reescrita do método toString da classe Object com informação do registo
     * no evento.
     *
     * @return informação sobre o registo no evento
     */
    @Override
    public String toString() {
        String result = "";
        result += "Autor: " + this.m_autor.getM_strNome() + "\nSubmissões: ";
        for (int i = 0; i < this.m_listaSubmisoesAceites.size(); i++) {
            result += "\n" + this.m_listaSubmisoesAceites.get(i).getArtigo().getTitulo();
        }
        result += "\nValor: " + this.m_valor;
        return result;
    }

    /**
     * Reescrita do método equals da classe object para comparar dois objetos do
     * tipo Registo no Evento.
     *
     * @param obj objeto do tipo RegistoNoEvento
     * @return verdadeiro se igual e falso se diferente
     */
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
