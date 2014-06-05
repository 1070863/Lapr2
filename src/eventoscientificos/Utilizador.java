package eventoscientificos;

import utils.Utils;

/**
 *
 * @author Nuno Silva
 */


public final class Utilizador {

    private String m_strNome;
    private String m_strUsername;
    private String m_strPassword;
    private String m_strEmail;

    public Utilizador() {
   
    }

    public Utilizador(String username, String pwd, String nome, String email) {
        this.setUsername(username);
        this.setPassword(pwd);
        this.setNome(nome);
        this.setEmail(email);
    }

    public final void setNome(String strNome) {
        this.m_strNome = strNome;
    }

    /**
     *
     * @param strUsername
     * @return
     */
    public final boolean setUsername(String strUsername) {
        m_strUsername = strUsername;
        // TODO
        return true;
    }

    public final void setPassword(String strPassword) {
        m_strPassword = strPassword;
    }

    /**
     *
     * @param strEmail
     * @return
     *
     */
    public final void setEmail(String strEmail) {
        this.m_strEmail = strEmail;
    }

    /**
     *
     * @return
     */
    public boolean valida() {

        return Utils.validaEmail(this.m_strEmail);

    }

    /**
     *
     * @param u
     * @return
     *
     * método alterado na iteração 2
     */
    public boolean mesmoQueUtilizador(Utilizador u) {
        if (getUsername().equals(u.getUsername())
                || getEmail().equals(u.getEmail())) {
            return true;
        } else {
            return false;
        }
    }

    // método adicionado na iteração 2
    public String getNome() {
        return m_strNome;
    }

    public String getUsername() {
        return m_strUsername;
    }

    public String getEmail() {
        return m_strEmail;
    }

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
     *
     * @param obj
     * @return
     *
     * a forma de identificar um utilizador é através do seu endereço de e-mail
     * ou username
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.m_strUsername != null ? this.m_strUsername.hashCode() : 0);
        return hash;
    }
}
