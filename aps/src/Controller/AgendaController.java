/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.TipoDAO;
import Model.Tipo;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author Dinopc
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }

    public AgendaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void atualizarTabela(){
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> listaDeAgendamentos = agendamentoDAO.selectAll();
        helper.popularTabela(listaDeAgendamentos);
    }
    
    public void atualizarCliente(){ //busca cliente e exibe no comboBox
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> buscaClientes = clienteDAO.selectAll();
        helper.preencherClientes(buscaClientes);
    }
    
    public void atualizarTipos(){
        TipoDAO tipoDAO = new TipoDAO();
        ArrayList<Tipo> buscaTipo = tipoDAO.selectAll();
        helper.preencherTipo(buscaTipo);
    }
    
    public void agendar(){
        Agendamento agendamento = helper.retornaUsuario();
        new AgendamentoDAO().insert(agendamento);
        atualizarTabela();
        helper.limparTela();
    }
}       
