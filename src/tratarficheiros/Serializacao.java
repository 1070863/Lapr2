/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tratarficheiros;

import eventoscientificos.Empresa;
import eventoscientificos.RegistoEventos;
import eventoscientificos.RegistoUtilizador;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Pedro
 */
public class Serializacao {
    private static final String FICHEIRO = "eventos_cientificos.bin";
    
    private Empresa empresa; 

    public Serializacao(Empresa empresa) {
        this.empresa = empresa;
    }
    
    public void escreverDadosFicheiro() throws FileNotFoundException, IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FICHEIRO));
        out.writeObject(empresa.getM_registaUtilizador());
        out.writeObject(empresa.getM_registoEventos());
        out.close();
    }
    
    public void lerDadosFicheiro() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(FICHEIRO));
            this.empresa.setM_registaUtilizador((RegistoUtilizador) in.readObject());
            this.empresa.setM_registoEventos((RegistoEventos) in.readObject());
            in.close();
    }
    
}
