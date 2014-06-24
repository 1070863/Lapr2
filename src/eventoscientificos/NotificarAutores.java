/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import states.*;

/**
 *
 * @author Pereira
 * Esta classe apenas tem 2 métodos um para escrever e criar um ficheiro xml onde consta as informações relativas á revisão
 * e a sua decisão e outro que valida o estado da submissão
 */
public class NotificarAutores implements Serializable  
{
    private static final long serialVersionUID = 1L;
    
  private Empresa empresa;
    private RegistoEventos re;
    private Utilizador u;
    private  Organizador org;
    private  Evento e;
    private  Artigo a;
    private Autor autor ;
    private Submissao s;
  private Utilizador m_utilizador;
  private Artigo m_artigo;
  private Autor m_autor;
  private EventoState e_state;
  private Submissao sub;
  private SubmissaoState sub_state;
  private String parafile;
  
//  private String nameFile= m_artigo.getTitulo();
  
  
  /**
   * Recebe um evento e corre as listas de submissoes e de revisores da sua cp e 
   * escreve o conteudo 
   * @param e
   * @throws TransformerException
   * @throws ParserConfigurationException
   * @throws IOException 
   */
  
 public void NotificarAutores(Evento e) throws TransformerException, ParserConfigurationException, IOException {
      
   this.e=e;
     
        String root = "notification_list";
        String folder="Submissao";
        String coments="comments";
        DocumentBuilderFactory documentBuilderFactory =DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder =documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

        Element rootElement = document.createElement(root);
       
        Element folderElement= document.createElement(folder);
        rootElement.appendChild(folderElement);
            document.appendChild(rootElement);

        for (int i = 0; i < e.getListaSubmissoes().size(); i++) {
            
    
          String element ="paper_title";
          String data = e.getListaSubmissoes().get(i).getArtigo().getTitulo();
          Element em = document.createElement(element);
          em.appendChild(document.createTextNode(data));
          folderElement.appendChild(em);

          String element1 ="paper_type";
          String data1 = e.getListaSubmissoes().get(i).getArtigo().getTipo();
          Element em1 = document.createElement(element1);
          em1.appendChild(document.createTextNode(data1));
          folderElement.appendChild(em1);
          
          String element2 ="author_name";
          String data2 = e.getListaSubmissoes().get(i).getArtigo().getAutor("Sergio").getM_strNome();
          Element em2 = document.createElement(element2);
          em2.appendChild(document.createTextNode(data2));
          folderElement.appendChild(em2);

          String element3 ="author_email";
          String data3 = e.getListaSubmissoes().get(i).getArtigo().getAutor("Sergio").getM_strEMail();
          Element em3 = document.createElement(element3);
          em3.appendChild(document.createTextNode(data3));
          folderElement.appendChild(em3);
          
             if(sub.getState() instanceof SubmissaoNotificadaAceiteState)
             {
          String element4 ="decision";
          String data4 = "Aceite";
          Element em4 = document.createElement(element4);
          em4.appendChild(document.createTextNode(data4));
          folderElement.appendChild(em4);}
             else
                  {
          String element4 ="decision";
          String data4 = "Rejeitado";
          Element em4 = document.createElement(element4);
          em4.appendChild(document.createTextNode(data4));
          folderElement.appendChild(em4);}
             
 
    
        
         Element comentsElement= document.createElement(coments);
         folderElement.appendChild(comentsElement);
        
        for (int a = 0; a < e.getCP().getListaRevisores().size(); a++) {
         
  
          String element5 ="review_number";
          String data5 = String.valueOf(a);
          Element em5 = document.createElement(element5);
          em5.appendChild(document.createTextNode(data5));
          comentsElement.appendChild(em5);
          
          String element6 ="review_comments";
          String data6 = e.getSubmissao(m_artigo).getRevisaoArtigo().getTextoJustificativo();
          Element em6 = document.createElement(element6);
          em6.appendChild(document.createTextNode(data6));
          comentsElement.appendChild(em6);
      } 
        }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

           StreamResult result =  new StreamResult(new File("notificationlist.xml"));
            
          //t.setParameter(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org}indent-amount", "5");
            transformer.transform(source, result);
                System.out.println("Done");
     
            }
/**
 * testa se o estado de submissao é notificado aceite ou rejeitado
 */
          
 }

