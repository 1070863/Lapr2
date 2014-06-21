package eventoscientificos;

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
    public abstract List<Evento> getListaEventosProvisoria();
    public abstract void setListaEventosProvisoria(List<Evento> listaEventosProvisoria);
}
