package eventoscientificos;

/**
 * Esta classe trata uma exceção criada no caso do utilizador do sistema tentar
 * atribuir valores negativos ao preço de publicação dos artigos.
 *
 * @author GRUPO66 LAPR2
 */
public class PrecoInvalidoException extends IllegalArgumentException {

    /**
     * Cosntrutor intânciado quando é passado por parâmetro uma memsagem.
     *
     * @param mensagem mensagem de erro
     */
    public PrecoInvalidoException(String mensagem) {
        super(mensagem);
    }

    /**
     * Cosntrutor intânciado por omissão de parâmetro.
     */
    public PrecoInvalidoException() {
        super("Levantamento Inválido!!");
    }
}
