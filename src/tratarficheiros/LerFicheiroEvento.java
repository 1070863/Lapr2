package tratarficheiros;

import eventoscientificos.Empresa;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Lopes
 */
public interface LerFicheiroEvento {
    
    public abstract void LerFicheiro(String fichEvento, Empresa empresa)throws ParserConfigurationException, SAXException, IOException;
}
