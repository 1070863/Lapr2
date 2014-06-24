package controller;

import eventoscientificos.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Esta classe controla o fluxo de informação entre a interface gráfica e o
 * sistema.
 *
 * @author Grupo66 LAPR2
 */
public class DefinirTopicEventController {

    private Topico m_topico;
    private Empresa m_empresa;
    private Evento m_evento;
    private String m_codigo;
    private String m_descricao;

    /**
     * Construtor completo quando é passado por parâmetro a empresa.
     *
     * @param m_empresa objeto do tipo Empresa
     */
    public DefinirTopicEventController(Empresa m_empresa) {
        this.m_empresa = m_empresa;
    }

    /**
     * Construtor por omissão de parâmetros.
     */
    public DefinirTopicEventController() {
        this.m_empresa = null;
    }

    /**
     * Procuara os eventos do organizador em função do seu id.
     *
     * @param strId endereço de email ou username do organizador
     * @return lista de eventos do organizador
     */
    public List<Evento> getEventosOrganizador(String strId) {
        return this.m_empresa.getM_registoEventos().getEventosOrgValoresDef(strId);
    }

    public void setEvento(Evento e) {
        this.m_evento = e;
    }

    /**
     * Procura o código do tópico ACM na lista de tópicos devolvendo uma String
     * com o resulatdo da pesquisa
     *
     * @param codeACM código introduzido na UI
     * @return devolve o resultado da pesquisa
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws XPathExpressionException
     */
    public String procurarTopicoACM(String codeACM) throws ParserConfigurationException,
            SAXException, IOException, XPathExpressionException {

        String resultado = "";
        NodeList nodes = lerXML();

        String codPai = "" + codeACM.charAt(0) + codeACM.charAt(1);
        for (int i = 0; i < nodes.getLength(); i++) {

            Node node = nodes.item(i);
            NamedNodeMap attributes = node.getAttributes();

            if (attributes.getNamedItem("id").getTextContent().equalsIgnoreCase(codPai)) {
                codPai = attributes.getNamedItem("label").getTextContent();
            }
        }
        for (int j = 0; j < nodes.getLength(); j++) {

            Node node = nodes.item(j);
            NamedNodeMap attributes = node.getAttributes();

            if (attributes.getNamedItem("id").getTextContent().equalsIgnoreCase(codeACM)) {

                this.m_codigo = codeACM;
                this.m_descricao = codPai + "/" + attributes.getNamedItem("label").getTextContent();
                resultado += this.m_codigo + this.m_descricao;

                System.out.println(resultado);
            }
        }
        return resultado;
    }

    /**
     * Inicia a análise do documento xml contendo os códigos ACM e devolve todos
     * os nós que contêm atributos do tipo id label.
     *
     * @return lista de nós "notação XML" contendo atributos id e label
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws XPathExpressionException
     */
    private NodeList lerXML() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilderFactory.setNamespaceAware(true);
        DocumentBuilder documento = docBuilderFactory.newDocumentBuilder();
        Document doc = documento.parse(new File("acmccs98-1.2.3.xml"));

        XPathFactory xpfactory = XPathFactory.newInstance();
        XPath path = xpfactory.newXPath();

        XPathExpression expr = path.compile("//node[@id and @label]");
        Object result = expr.evaluate(doc, XPathConstants.NODESET);

        NodeList nodes = (NodeList) result;
        return nodes;
    }

    /**
     * Regista Tópico na lista de tópicos do evento.
     *
     * @return verdadeiro ou falso em função do registo do tópico no evento
     */
    public boolean registaTopico() {
        this.m_topico = new Topico(this.m_descricao, this.m_codigo);
        if (!validaTopico(this.m_topico)) {
            return this.m_evento.getM_listaTopicos().add(this.m_topico);
        } else {
            return false;
        }
    }

    /**
     * Quando terminado o caso de uso este método irá iniciar a validação do
     * evento.
     *
     * @return verdadeiro ou falso em função da validação do evento e dos seus
     * estados.
     */
    public boolean termina() {
        return this.m_evento.getState().setTopicosDefinidos();
    }

    /**
     * Valida o tópico antes de acicioná-lo à lista de tópicos de evento.
     *
     * @param topico topico a ser validado
     * @return verdadeiro falso em função da sua existência na atual mista de
     * tópicos.
     */
    public boolean validaTopico(Topico topico) {
        for (Topico t : this.m_evento.getM_listaTopicos()) {
            if (t.equals(topico)) {
                return true;
            }
        }
        return false;
    }
}
