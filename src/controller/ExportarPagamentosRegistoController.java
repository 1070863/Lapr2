package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.RegistoNoEvento;
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
    public List<Evento> getEventosOrganizador(String strId) {
        return this.m_empresa.getM_registoEventos().getEventosOrganizador(strId);
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

}
