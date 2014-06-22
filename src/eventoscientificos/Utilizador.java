package eventoscientificos;

import java.io.Serializable;
import utils.Utils;

/**
 * Classe que cria e gere a informação de um Utilizador.,
 *
 * @author Grupo66 LAPR2
 */
public final class Utilizador implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Atributos de instância do Utilizador.
     */
    private String m_strNome;
    private String m_strUsername;
    private String m_strPassword;
    private String m_strEmail;

    /**
     * Cria instância do tipo Utilizador quando são passados todos os
     * parâmetros.
     *
     * @param m_strNome nome do Utilizador
     * @param m_strUsername username do Utilizador
     * @param m_strPassword password do Utilizador
     * @param m_strEmail email do Utilizador
     */
    public Utilizador(String m_strNome, String m_strUsername, String m_strPassword, String m_strEmail) {
        this.m_strNome = m_strNome;
        this.m_strUsername = m_strUsername;
        this.m_strPassword = m_strPassword;
        this.m_strEmail = m_strEmail;
    }

    /**
     * Cria instância do tipo Utilizdor por omissão de parâmetros.
     */
    public Utilizador() {
        this.m_strNome = "sem_nome";
        this.m_strUsername = "sem_user";
        this.m_strPassword = "sem_pasword";
        this.m_strEmail = "sem_email";
    }

    /**
     * Procura nome do Utilizador.
     *
     * @return nome do Utilizador
     */
    public String getM_strNome() {
        return this.m_strNome;
    }

    /**
     * Define o nome do Utilizador.
     *
     * @param m_strNome nome do utilizador
     */
    public void setM_strNome(String m_strNome) {
        this.m_strNome = m_strNome;
    }

    /**
     * Procura o username do Utilizador.
     *
     * @return o username do Utilizador
     */
    public String getM_strUsername() {
        return m_strUsername;
    }

    /**
     * Define o username do Utilizador.
     *
     * @param m_strUsername username do Utilizador
     */
    public void setM_strUsername(String m_strUsername) {
        this.m_strUsername = m_strUsername;
    }

    /**
     * Procura a password do Utilizador.
     *
     * @return password do Utilizador
     */
    public String getM_strPassword() {
        return m_strPassword;
    }

    /**
     * Define a password do Utilizador.
     *
     * @param m_strPassword password do Utilizador
     */
    public void setM_strPassword(String m_strPassword) {
        this.m_strPassword = m_strPassword;
    }

    /**
     * Procrua o email do Utilizador.
     *
     * @return emaisl do Utilizador
     */
    public String getM_strEmail() {
        return m_strEmail;
    }

    /**
     * Define o email do Utilizador.
     *
     * @param m_strEmail email do Utilizador
     */
    public void setM_strEmail(String m_strEmail) {
        this.m_strEmail = m_strEmail;
    }

    /**
     * Valida se a estrutura do endereço é similar à de um endereço válido.
     *
     * @return verdadeiro se o email é válido e falso no caso contrário
     */
    public boolean validaEmail() {
        return Utils.validaEmail(this.m_strEmail);
    }
    public void valida() {
       
    }
    
    /**
     * Reescrita do método toString herdado da classe Object com a informação do
     * Utilizador.
     *
     * @return informação de um utilizador
     */
    @Override
    public String toString() {
        String str = "Utilizador:\n";
        str += "\tNome: " + this.m_strNome + "\n";
        str += "\tUsername: " + this.m_strUsername + "\n";
        str += "\tPassword: " + this.m_strPassword + "\n";
        str += "\tEmail: " + this.m_strEmail + "\n";

        return str;
    }

    /**
     * Reescrita de método equals herdado da classe Object para validaEmailção do
 utilizador.
     *
     * @param obj objeto do tipo Utilizador
     * @return verdadeiro se já existir um utilizador igual e falso se não
     * existir
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Utilizador) {
            Utilizador aux = (Utilizador) obj;
            return this.m_strUsername.equals(aux.m_strUsername)
                    || this.m_strEmail.equals(aux.m_strEmail);
        } else {
            return false;
        }
    }


}
