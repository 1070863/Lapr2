
package controller;

import eventoscientificos.ProcessoDistribuicao;
import eventoscientificos.Distribuicao;
import eventoscientificos.*;
import java.util.ArrayList;
import java.util.List;
import states.EventoCPDefinidaState;
import states.SubmissaoArtigosParaRevisaoSubmetidosState;

/**
 * Esta classe serve como controladora do fluxo entre a interface gráfica e a as
 * classes intervenientes para a distribuicao de revisoes.
 *
 * @author Grupo 66 LPR2
 */
public class DistribuirRevisoesController {

    /**
     * Atributos de intância.
     */
    private Empresa m_empresa;
    private Evento m_evento;
    private ProcessoDistribuicao processoDistribuicao;
    private List<Distribuicao> listaDistribuicoes = new ArrayList<>();
    private List<MecanismoDistribuicao> listaMecanismos;

     /**
     * Construtor responsável por criar instância de empresa.
     *
     * @param empresa Empresa a ser instânciada
     */
    public DistribuirRevisoesController(Empresa empresa) {
        m_empresa = empresa;
    }  
    /**
    * @return Evento m_evento
    */    
    public Evento getM_evento() {
        return m_evento;
    }
    /**
     * Define evento a distribuir, inicia novo processo de distribuicao
     * e atribui lista de submissoes
     *
     * @param e Evento a tratar
     */
    public void setEvento(Evento e) {
        m_evento = e;
        processoDistribuicao = m_evento.novoProcessoDistribuicao();
        processoDistribuicao.setM_listaSubmissoes(m_evento.getListaSubmissoes());
    }

    /**
     * Devolve lista de eventos de organizador que estejam disponiveis para revisao
     *
     * @param orgID id do organizador (email ou username)
     * @return listaEventosOrganizador em estado "CPDefinida" e com submissao 
     * em estado "ArtigosParaRevisaoSubmetidos"
     */
    public List<Evento> novaDistribuicaoOrganizador(String orgID) {
       List<Evento> listaEventosOrganizador = new ArrayList<Evento>();
                for(Evento e : m_empresa.getM_registoEventos().getEventosOrganizador(orgID)){
                    for (Submissao submissao : e.getListaSubmissoes()) {
                    if(e.getState() instanceof EventoCPDefinidaState &&
                            submissao.getState() instanceof SubmissaoArtigosParaRevisaoSubmetidosState)
                   listaEventosOrganizador.add(e);}
                }
                return listaEventosOrganizador;
    }
    /**
    * @return processoDistribuicao
    */ 
    public ProcessoDistribuicao getProcessoDistribuicao() {
        return processoDistribuicao;
    }
    /**
    * @return lista de mecanismos de distribuicao disponiveis em registo de eventos
    */ 
    public List<MecanismoDistribuicao> getMecanismoDistribuicao() {
        listaMecanismos = m_empresa.getM_registoEventos().criarListaMecanismoDistribuicaos();
        return listaMecanismos;
    }
    /**
    * Definicao de mecanismo de destribuicao. Distribuicao de artigos segundo mecanismo escolhido.
    * 
    * @param m id do mecanismo de distribuicao
    */ 
    public void setMecanismoDistribuicao(int m) {
        m_evento.getProcessoDistribuicao().setMecanismoDistribuicao(m);
        listaDistribuicoes = m_evento.getProcessoDistribuicao().getMecanismoDistribuicao().distribui(processoDistribuicao);
    }
    /**
    * Atribuição de processo de distribuição ao evento
    */ 
    public void RegistaDistribuicao() {
        m_evento.setProcessoDistribuicao(processoDistribuicao);
    }
    /**
    * @return lista de distribuicoes
    */ 
    public List<Distribuicao> getListaDistribuicoes() {
        return listaDistribuicoes;
    }
    /**
    * Definicao de lista de distribuicoes
    * 
    * @param listaDistribuicoes 
    */ 
    public void setListaDistribuicoes(List<Distribuicao> listaDistribuicoes) {
        this.listaDistribuicoes = listaDistribuicoes;
    }
     /**
     * Quando terminado, define submissoes com de evento em estado "ArtigosParaRevisaoSubmetidos"
     * e atribuido ao evento o estado "CPDefinida"
     *
     * @return verdadeiro ou falso em funcao da transição correcta ou errada de estado do evento.
     */
    public boolean termina()
    {
         for (Submissao submissao : m_evento.getListaSubmissoes())
         {
             submissao.getState().SetArtigosParaRevisaoSubmetidos();
         }
    return m_evento.getState().setCPDefinida();
    
    }
}
