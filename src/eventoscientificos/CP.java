package eventoscientificos;

import java.util.*;

/**
 * Classe responsável pela criação e gestão da CP (Comissão de Programa) criando
 * para isso Revisores e respetiva lista.
 *
 * @author Grupo 66 LPR2
 */
public class CP {

    /**
     * Atributos de intância.
     */
    List<Revisor> m_listaRevisores;

    /**
     * Construtor responsável por instânciar lista de Revisores da CP (Comissão
     * de Programa).
     */
    public CP() {
        this.m_listaRevisores = new ArrayList();
    }

    /**
     * Cria um objeto do tipo Revisor membro da CP (Comissão de Programa).
     *
     * @param strId endereço de email ou username do revisor
     * @param u objeto do tipo utilizador a ser associado a Revisor
     * @return objeto do tipo Revisor se passar as validações e null se não
     * passar
     */
    public Revisor addMembroCP(String strId, Utilizador u) {
        Revisor r = new Revisor(u);

        if (r.valida() && validaMembroCP(r)) {
            return r;
        } else {
            return null;
        }
    }

    /**
     * Verifica se o revisor já existe na CP (Comissão de Programa)
     *
     * @param r objeto do tipo Revisor
     * @return verdadeiro se o Revisor já existe na CP e falso se ele já não existe
     * na CP (Comissão de Programa)
     */
    public boolean validaMembroCP(Revisor r) {
        for (Revisor rev : this.m_listaRevisores) {
            if (rev.getUtilizador().getUsername().equalsIgnoreCase(r.getUtilizador().getUsername())
                    && rev.getUtilizador().getEmail().equalsIgnoreCase(r.getUtilizador().getEmail())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Regista revisor na CP (Comissão de Programa).
     *
     * @param r objeto do tipo Revisor
     * @return verdadeiro/falso em função do seu registo
     */
    public boolean registaMembroCP(Revisor r) {
        return this.m_listaRevisores.add(r);
    }

    /**
     * Cria um objeto do tipo String contendo toda a informação dos revisores
     * presentes na CP (Comissão de programa).
     *
     * @return String com toda a informação da lista de revisores
     */
    @Override
    public String toString() {
        String strCP = "Membros de CP: ";
        for (ListIterator<Revisor> it = this.m_listaRevisores.listIterator(); it.hasNext();) {
            strCP += it.next().toString();
            if (it.hasNext()) {
                strCP += ", ";
            }
        }
        return strCP;
    }

    /**
     * Procura a lista de revisores instânciada
     *
     * @return lista de revisores
     */
    public List<Revisor> getListaRevisores() {
        return this.m_listaRevisores;
    }
}
