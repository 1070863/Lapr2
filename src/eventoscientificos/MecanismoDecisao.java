/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.util.List;

/**
 *
 * @author Pereira
 */
public interface MecanismoDecisao {
     public abstract Decisao decide(ProcessoDecisao pd);

    public abstract String getNome();
}
