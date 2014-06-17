/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

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
 */
public class NotificarAutores  {

  private Utilizador m_utilizador;
  private Artigo m_artigo;
  private Autor m_autor;
  private Evento e;
  private EventoState e_state;
  private Submissao sub;
  private SubmissaoState sub_state;
  private String parafile;
//  private String nameFile= m_artigo.getTitulo();
  
 public boolean NotificarAutores() throws  ParserConfigurationException, TransformerException, IOException{
           
    String root = "ListaSubmissões";
        DocumentBuilderFactory documentBuilderFactory =DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder =documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

        Element rootElement = document.createElement(root);

            document.appendChild(rootElement);
//      for (int i = 1; i <= no; i++)
//        System.out.print("Enter the element: ");
//        String element = bf.readLine();
           
          String element ="Titulo";
          
          String data = m_artigo.getTitulo();
          Element em = document.createElement(element);
          em.appendChild(document.createTextNode(data));
          rootElement.appendChild(em);

          String element1 ="Tipo";
          String data1 = "Artigo";
          Element em1 = document.createElement(element1);
          em1.appendChild(document.createTextNode(data1));
          rootElement.appendChild(em1);
          
          String element2 ="Autor";
          String data2 = m_autor.getM_strNome();
          Element em2 = document.createElement(element2);
          em2.appendChild(document.createTextNode(data2));
          rootElement.appendChild(em2);

          String element3 ="E-mailAutor";
          String data3 = m_utilizador.getM_strEmail();
          Element em3 = document.createElement(element3);
          em3.appendChild(document.createTextNode(data3));
          rootElement.appendChild(em3);
          
          String element4 ="Decisao";
          String data4 = "Aceite";
          Element em4 = document.createElement(element4);
          em4.appendChild(document.createTextNode(data4));
          rootElement.appendChild(em4);
          
          
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult result =  new StreamResult(new StringWriter());

          //t.setParameter(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org}indent-amount", "5");
            transformer.transform(source, result);

             
          //writing to file
          FileOutputStream fop = null;
          File file;
          
          try {

           
                   if(valida())
                   {
                file = new File("Submissao.xml");
                fop = new FileOutputStream(file);
                   
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
               
                   }
             
                // get the content in bytes
                String xmlString = result.getWriter().toString();
                System.out.println(xmlString);
                byte[] contentInBytes = xmlString.getBytes();

                fop.write(contentInBytes);
                fop.flush();
                fop.close();
               
                System.out.println("Done");
               
               return true;
          
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    if (fop != null) {
                        fop.close();
                        return false;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
                
                
              
            }
    
 }

          public boolean valida()
                {
                  /*  e=new Evento();
                    sub= new Submissao();
                 if(e.getState() instanceof EventoDecididoState)
                     if(sub.getState() instanceof SubmissaoNotificadaAceiteState)
                         return true;
                 return false;*/
                    return false;
                }
        
 }

