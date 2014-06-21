package states;

/**
 * Interface para a gestão dos diferentes estados de um objeto.
 *
 * @author GRUPO66 LAPR2
 */
public interface EventoState {

    public abstract boolean setCriado();
    public abstract boolean setRegistado();
    public abstract boolean setTopicosDefinidos();
    public abstract boolean setCPDefinida();
    public abstract boolean setDistribuido();
    public abstract boolean setRevisto();
    public abstract boolean setDecidido();
    public abstract boolean setNotificado();
    public abstract boolean setCameraReady();
    public abstract boolean setValorRegistoDefinido();
    public abstract boolean valida();
}
