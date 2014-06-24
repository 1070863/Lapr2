package tratarficheiros;

import eventoscientificos.Empresa;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Esta classe serve como controladora do fluxo entre a interface gráfica e a as
 * classes intervenientes para o carregamento de eventos via ficheiro.
 *
 * @author Grupo 66 LPR2
 */
public interface LerFicheiroEvento {
    
    public abstract void LerFicheiro(String fichEvento, Empresa empresa)throws ParserConfigurationException, SAXException, IOException;
}
