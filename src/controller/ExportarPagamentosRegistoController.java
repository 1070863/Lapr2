package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.RegistoNoEvento;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class ExportarPagamentosRegistoController {

    private Empresa m_empresa;
    private Evento m_evento;
    private List<RegistoNoEvento> m_listaRegistos;

    public ExportarPagamentosRegistoController(Empresa empresa) {
        this.m_empresa = empresa;
    }

    /**
     * Procura os eventos do organizador em função do seu id.
     *
     * @param strId endereço de email ou username do organizador
     * @return lista de eventos do organizador
     */
    public List<Evento> getEventosOrgDataRegistoPassada(String strId) {
        return this.m_empresa.getM_registoEventos().getEventosOrgDataRegistoPassada(strId);
    }

    /**
     * Seleciona o evento passado por parâmetro.
     *
     * @param e evento a ser selecionado
     */
    public void selectEvento(Evento e) {
        this.m_evento = e;
        this.m_listaRegistos = this.m_evento.getListaRegistos();
    }

    public void escreveCSV(String fileName) throws FileNotFoundException {
        PrintWriter novoCSV = new PrintWriter(fileName);

        novoCSV.write("Autor;Artigo;Data Pagamento\n");

        for (RegistoNoEvento r : this.m_listaRegistos) {
            for (int i = 0; i < r.getM_listaSubmisoesAceites().size(); i++) {
                novoCSV.write(r.getM_autor().getM_strNome() + ";"
                        + r.getM_listaSubmisoesAceites().get(i).getArtigo().getTitulo() + ";"
                        + r.getM_data()+"\n");
            }
        }
        novoCSV.close();
    }
}
