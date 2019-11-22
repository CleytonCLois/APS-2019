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
import java.sql.SQLException;
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
    
    public void atualizarTabela(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> listaDeClientes = clienteDAO.selectAll();
        helper.popularTabela(listaDeClientes);
    }
    
    public void agendar(){
        Cliente cliente = helper.retornaUsuario();
        try {
            new ClienteDAO().cadastrarCliente(cliente);
        } catch (SQLException | NumberFormatException e) {
             System.out.println("Erro ao realizar transferencia" + e);
        }

        atualizarTabela();
        helper.limparTela();
    }
    
    public void deletar(){
        Cliente cliente = helper.retornaUsuario();
        new ClienteDAO().delete(cliente);
        atualizarTabela();
        helper.limparTela();
    }
}       
