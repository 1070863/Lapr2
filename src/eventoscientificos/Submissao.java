/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Submissao {

    private Artigo m_artigo;
    
    private SubmissaoState state;

    public Submissao() {
        
        this.setState(new SubmissaoCriadaState(this));
    }
    public Artigo novoArtigo() {
        return new Artigo();
    }

    public String getInfo() {
        return this.toString();
    }

    public void setArtigo(Artigo artigo) {
        this.m_artigo = artigo;
    }

    public Artigo getArtigo() {
        return this.m_artigo;
    }

    public boolean valida() {
        return this.state.valida();
    }

    @Override
    public String toString() {
        return "Submissão:\n"+m_artigo.toString();
    }
     public void setState(SubmissaoState state) {
        this.state = state;
    }

    public SubmissaoState getState() {
        return state;
    }
    
}
