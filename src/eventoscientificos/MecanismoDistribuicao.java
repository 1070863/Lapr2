/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

import java.util.List;

/**
 *
 * @author Lopes
 */
public interface MecanismoDistribuicao {

    public abstract List<Distribuicao> distribui(ProcessoDistribuicao pd);

    public abstract String getNome();

}
