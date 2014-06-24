package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Utilizador;

/**
 * Esta classe serve como controladora do fluxo entre a interface gráfica e a as
 * classes intervenientes para a criação de eventos
 *
 * @author Grupo 66 LPR2
 */
public class CriarEventoCientificoController
{
    /**
     * Atributos de intância.
     */
    private Empresa m_empresa;
    private Evento m_evento;

    /**
     * Construtor responsável por criar instância de empresa.
     *
     * @param empresa Empresa a ser intâncida
     */
    public CriarEventoCientificoController(Empresa empresa)
    {
        m_empresa = empresa;
    }
    /**
     * Registo de novo evento na empresa. Atribuição de estado "Criado".
     */
    public void novoEvento()
    {
        m_evento = m_empresa.getM_registoEventos().novoEvento();
        m_evento.getState().setCriado();
    }
    /**
     * Define titulo do evento que está a ser criado. 
     *
     * @param strTitulo titulo do novo evento
     */
    public void setTitulo(String strTitulo)
    {
        m_evento.setTitulo(strTitulo);
    }
    /**
     * Define descricao do evento que está a ser criado. 
     *
     * @param strDescricao descricao do novo evento
     */
    public void setDescricao(String strDescricao)
    {
        m_evento.setDescricao(strDescricao);
    }
    /**
     * Define local do evento que está a ser criado. 
     *
     * @param strLocal local do novo evento
     */
    public void setLocal(String strLocal)
    {
        m_evento.setLocal(strLocal);
    }
    /**
     * Define cidade do evento que está a ser criado. 
     *
     * @param strCidade cidade do novo evento
     */
    public void setCidade(String strCidade) {
        m_evento.setCidade(strCidade);
    }
    /**
     * Define país do evento que está a ser criado. 
     *
     * @param strPais país do novo evento
     */
    public void setPais(String strPais) {
        m_evento.setPais(strPais);
    }
    /**
     * Define data de inicio do evento que está a ser criado. 
     *
     * @param strDataInicio data de início para o novo evento
     */
    public void setDataInicio(String strDataInicio)
    {
        m_evento.setDataInicio(strDataInicio);
    }
    /**
     * Define data de fim do evento que está a ser criado. 
     *
     * @param strDataFim data de fim para o novo evento
     */
    public void setDataFim(String strDataFim)
    {
        m_evento.setDataFim(strDataFim);
    }
    /**
     * Define data limite de submissão do evento que está a ser criado. 
     *
     * @param strDataLimiteSubmissao data limite de submissao para o novo evento
     */
    public void setDataLimiteSubmissão(String strDataLimiteSubmissão)
    {
        m_evento.setDataLimiteSubmissao(strDataLimiteSubmissão);
    }
    /**
     * Define data limite de revisao do evento que está a ser criado. 
     *
     * @param strDataLimiteRevisao data limite de revisao para o novo evento
     */
    public void setDataLimiteRevisao(String strDataLimiteRevisao) {
        m_evento.setDataLimiteRevisao(strDataLimiteRevisao);
    }
    /**
     * Define data limite de registo do evento que está a ser criado. 
     *
     * @param strDataLimiteRegisto data limite de registo para o novo evento
     */    
    public void setDataLimiteRegisto(String strDataLimiteRegisto) {
        m_evento.setDataLimiteRegisto(strDataLimiteRegisto);
    }
     /**
     * Define data limite para submissao final do evento que está a ser criado. 
     *
     * @param strDataLimiteSubmissaoFinal  data limite para submissao final do novo evento
     */
    public void setDataLimiteSubmissaoFinal(String strDataLimiteSubmissaoFinal) {
        m_evento.setDataLimiteSubmissaoFinal(strDataLimiteSubmissaoFinal);
    }
    /**
     * Define número máximo de tópicos aceites pelo evento que está a ser criado. 
     *
     * @param nMaxTopicos número máximo de tópicos para o novo evento
     */
    public void setNumeroMaximoTopicos(int nMaxTopicos) {
        m_evento.setnMaxTopicos(nMaxTopicos);
    }
    /**
     * Adiciona novo organizador ao evento que está a ser criado
     *
     * @param strId id (username ou email) do utilizador a adicionar
     * @return verdadeiro se conseguiu adicionar utilizador (utilizador existe e 
     * foi possível de adicionar ao evento), falso caso tenha ocorrido algum problema.
     */
    public boolean addOrganizador(String strId)
    {
        Utilizador u = m_empresa.getM_registaUtilizador().getUtilizador(strId);
        System.out.println("addOrganizador: " + m_empresa.getM_registaUtilizador().getM_listaUtilizadores().size());
        if( u!=null)
            return m_evento.addOrganizador( strId, u );
        else
            return false;
    }
    /**
     * Altera estado do evento actual para "Registado" (estado anterior: "Criado") 
     * e adiciona evento ao registo de eventos da empresa
     * 
     * @return verdadeiro se conseguiu adicionar evento à empresa
     */
    public boolean registaEvento()
    {
        m_evento.getState().setRegistado();
        return m_empresa.getM_registoEventos().registaEvento(m_evento);
    }
    
    /**
    * Valida o nome do evento
    * @param ID nome do evento que tem de ser unico
    * @return true se não existir, false se já existir um evento com este nome
    */
    public boolean validaEvento(String ID) {
        if (m_empresa.getM_registoEventos().getEvento(ID) == null) {
            return true;
        } else {
            return false;
        }
    }
}

