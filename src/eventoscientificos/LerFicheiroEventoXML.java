/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Pedro
 */
public class LerFicheiroEventoXML {
    
    private String nomeFicheiro;
    private Empresa empresa;

    public LerFicheiroEventoXML(String nomeFicheiro, Empresa empresa) {
        this.nomeFicheiro = nomeFicheiro;
        this.empresa = empresa;
    }

    public void lerEventosXML() throws ParserConfigurationException, SAXException, IOException {

     //   try {

            //Criação de um parser xml
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documento = docBuilderFactory.newDocumentBuilder();
            Document doc = documento.parse(new File(nomeFicheiro));

            System.out.println(doc.getDocumentElement().getNodeName());
            System.out.println(doc.getDocumentElement().getChildNodes());

            //Obtém a lista de eventos do xml
            NodeList listaEventos = doc.getElementsByTagName("event");
            int totalEventos = listaEventos.getLength();
            System.out.println("Total no of events : " + totalEventos);

            //Obtém os campos de cada evento
            for (int s = 0; s < listaEventos.getLength(); s++) {
                
                Evento evento = new Evento();
                
                Node eventoNode = listaEventos.item(s);
                if (eventoNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eventoElement = (Element) eventoNode;

                    //Ano
                    NodeList anoEventoList = eventoElement.getElementsByTagName("year");
                    Element anoEventoElement = (Element) anoEventoList.item(0);
                    NodeList textoAnoList = anoEventoElement.getChildNodes();
                    String ano = "";
                    if(anoEventoElement.getChildNodes().getLength()>0)
                        ano = ((Node) textoAnoList.item(0)).getNodeValue().trim();

                    //Nome
                    NodeList nomeEventoList = eventoElement.getElementsByTagName("name");
                    Element nomeEventoElement = (Element) nomeEventoList.item(0);
                    NodeList textoNomeEventoList = nomeEventoElement.getChildNodes();
                    //String nome = ((Node) textoNomeEventoList.item(0)).getNodeValue().trim();
                    this.empresa.getM_registoEventos().novoEvento();
                    String nome="";
                    if(nomeEventoElement.getChildNodes().getLength()>0)
                    nome = ((Node) textoNomeEventoList.item(0)).getNodeValue().trim();
                    evento.setTitulo(nome);
                    
                    //Local
                    NodeList localList = eventoElement.getElementsByTagName("host");
                    Element localElement = (Element) localList.item(0);
                    NodeList textLocalList = localElement.getChildNodes();
                    
                    //String local = ((Node) textLocalList.item(0)).getNodeValue().trim();
                    if(localElement.getChildNodes().getLength()>0)
                        evento.setLocal(((Node) textLocalList.item(0)).getNodeValue().trim());

                    //Cidade
                    NodeList cityList = eventoElement.getElementsByTagName("city");
                    Element cityElement = (Element) cityList.item(0);                   
                    NodeList textCityList = cityElement.getChildNodes();
                    
                    String cidade = "";
                    if(cityElement.getChildNodes().getLength()>0)
                        cidade = ((Node) textCityList.item(0)).getNodeValue().trim();
                    
                    //Pais
                    NodeList paisList = eventoElement.getElementsByTagName("country");
                    Element paisElement = (Element) paisList.item(0);                   
                    NodeList textPaisList = paisElement.getChildNodes();                   
                    String pais="";
                    if(paisElement.getChildNodes().getLength()>0)
                        pais = ((Node) textPaisList.item(0)).getNodeValue().trim();

                    //Data inicio
                    NodeList diList = eventoElement.getElementsByTagName("begin_date");
                    Element diElement = (Element) diList.item(0);                   
                    NodeList textDIList = diElement.getChildNodes();
                    String di = "";
                    if(diElement.getChildNodes().getLength()>0)
                        di = ((Node) textDIList.item(0)).getNodeValue().trim();
                    evento.setDataInicio(di);
                    
                    //Data fim
                    NodeList dfList = eventoElement.getElementsByTagName("end_date");
                    Element dfElement = (Element) dfList.item(0);                   
                    NodeList textDFList = dfElement.getChildNodes();
                    String df = "";
                    if (dfElement.getChildNodes().getLength()>0)
                        df = ((Node) textDFList.item(0)).getNodeValue().trim();
                    evento.setDataFim(df);
                    
                    //Webpage
                    NodeList webList = eventoElement.getElementsByTagName("web_page");
                    Element webElement = (Element) webList.item(0);                   
                    NodeList textWebList = webElement.getChildNodes(); 
                    System.out.println(webElement.getChildNodes().getLength());
                    String web = "";
                    if (webElement.getChildNodes().getLength()>0)
                    web = ((Node) textWebList.item(0)).getNodeValue().trim();
                    
                    //Organizadores
                    NodeList organizerList = eventoElement.
                            getElementsByTagName("organizer");

                    int numOrganizadores = organizerList.getLength();

                    String orgName[] = new String[numOrganizadores];
                    String orgEmail[] = new String[numOrganizadores];
                    
                    for (int i = 0; i < numOrganizadores; i++) {

                        Node organizerNode = organizerList.item(i);
                        if (organizerNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element organizerElement = (Element) organizerNode;

                            //Ler o nome do organizador
                            NodeList organizerNameList = organizerElement.
                                    getElementsByTagName("org_name");
                            Element organizerNameElement = (Element) organizerNameList.item(0);

                            NodeList textOrgList = organizerNameElement.getChildNodes();

                            if(organizerNameElement.getChildNodes().getLength()>0)
                                orgName[i]=((Node) textOrgList.item(0)).getNodeValue().trim();
                            
                            //Ler o email
                            NodeList organizerEmailList = organizerElement.
                                    getElementsByTagName("email");
                            Element organizerEmailElement = (Element) organizerEmailList.item(0);

                            NodeList textOrgEmailList = organizerEmailElement.getChildNodes();

                            if(organizerEmailElement.getChildNodes().getLength()>0)
                                orgEmail[i]=((Node) textOrgEmailList.item(0)).getNodeValue().trim();
                        }
                        
                        
                    }
                    this.empresa.getM_registoEventos().registaEvento(evento);
                }

            }
            
            

//        } catch (SAXException e) {
//            Exception x = e.getException();
//            ((x == null) ? e : x).printStackTrace();
//
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }
    }

    public Empresa getEmpresa() {
        return empresa;
    }
}
