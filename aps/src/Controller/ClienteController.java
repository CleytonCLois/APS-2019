/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Controller.Helper.ClienteHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.TipoDAO;
import Model.Pessoa;
import Model.Tipo;
import View.Agenda;
import View.ViewCliente;
import java.util.ArrayList;

/**
 *
 * @author Dinopc
 */
public class ClienteController {
    
    private final ViewCliente view;
    private final ClienteHelper helper;

    public ClienteController(ViewCliente view) {
        this.view = view;
        this.helper = new ClienteHelper(view);
    }

    public ClienteController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void atualizarTabela(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> listaDeClientes = clienteDAO.selectAll();
        helper.popularTabela(listaDeClientes);
    }
    
    public void agendar(){
        Cliente cliente = helper.retornaUsuario();
        new ClienteDAO().insert(cliente);
        atualizarTabela();
        helper.limparTela();
    }
}       