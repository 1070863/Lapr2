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
     * Atributos de instância.
     */
    private List<Revisor> m_listaRevisores;

    /**
     * Construtor responsável por instânciar lista de Revisores da CP (Comissão
     * de Programa).
     */
    public CP() {
        this.m_listaRevisores = new ArrayList();
    }

    /**
     * Procura a lista de revisores.
     *
     * @return lista de revisores
     */
    public List<Revisor> getListaRevisores() {
        return m_listaRevisores;
    }

    /**
     * Define uma lista de revisores.
     *
     * @param m_listaRevisores lista de revisores
     */
    public void setM_listaRevisores(List<Revisor> m_listaRevisores) {
        this.m_listaRevisores = m_listaRevisores;
    }

    /**
     * Cria um objeto do tipo Revisor membro da CP (Comissão de Programa).
     *
     * @param strId endereço de email ou username do revisor
     * @param u objeto do tipo utilizador a ser associado a Revisor
     * @return objeto do tipo Revisor se passar as validaEmailções e null se não
     * passar
     */
    public Revisor addMembroCP(String strId, Utilizador u) {
        Revisor r = new Revisor(u);

        if (!validaMembroCP(r)) {
            return r;
        } else {
            return null;
        }
    }

    /**
     * Verifica a exitência do Revisor na CP (Comissão de Programa).
     *
     * @param r objeto do tipo Revisor
     * @return verdadeiro se o Revisor já consta na lista da CP e falso se ele
     * não existe na CP(Comissão de Programa)
     */
    public boolean validaMembroCP(Revisor r) {
        for (Revisor rev : this.m_listaRevisores) {
            if (rev.getM_utilizador().equals(r.getM_utilizador())) {
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
            strCP += it.next().getM_strNome();
            if (it.hasNext()) {
                strCP += ", ";
            }
        }
        return strCP;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final CP other = (CP) obj;
        if (!Objects.equals(this.m_listaRevisores, other.m_listaRevisores)) {
            return false;
        }
        return true;
    }
    
}
