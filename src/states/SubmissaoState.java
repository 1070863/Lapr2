package states;

/**
 * Esta interface serve o propósito de, em acordo com o modelo de negócio de
 * Gestão de Eventos cientificos, gerir o estado de uma Submissão.
 *
 * @author GRUPO66 LAPR2
 */
public interface SubmissaoState {

    /**
     * Define a submissão como criada quando iniciado o processo de Submissão.
     *
     * @return verdadeiro ou falso em função da sua validação
     */
    public abstract boolean SetCriada();

    /**
     * Define a submissão submetida após o sucesso do processo de Submissão.
     *
     * @return verdadeiro ou falso em função da sua validação
     */
    public abstract boolean SetArtigosParaRevisaoSubmetidos();

    /**
     * Define a submissão como distribuida após ter sido distribuida para
     * revisão.
     *
     * @return verdadeiro ou falso em função da sua validação
     */
    public abstract boolean setDestribuida();

    /**
     * Define a submissão como revista após ter sido submetida a sua revisão.
     *
     * @return verdadeiro ou falso em função da sua validação
     */
    public abstract boolean setRevista();

    /**
     * Define a submissão como registada após o pagamento do Registo no Evento.
     *
     * @return
     */
    public abstract boolean setRejeitada();

    /**
     * Define a submissão como aceite após o parecer positivo do Organizador.
     *
     * @return verdadeiro ou falso em função da sua validação
     */
    public abstract boolean setAceite();

    /**
     * Define a submissão como NotificadaAceite após a aceitação do artigo no
     * Evento e a geração da notificação.
     *
     * @return
     */
    public abstract boolean setNotificadoAceite();

    /**
     * Efetua a validação do estado em que se encontra a Submissão.
     *
     * @return verdadeiro ou falso em função da sua validação
     */
    public abstract boolean valida();

    /**
     * Define a submissão como registada após o pagamento do Registo no Evento
     *
     * @return verdadeiro ou falso em função da sua validação
     */
    public abstract boolean setRegistada();
    
    /**
     * Define a submissão como registada após o pagamento do Registo no Evento
     *
     * @return verdadeiro ou falso em função da sua validação
     */
    public abstract boolean setNotificadoRejeitada();

}
