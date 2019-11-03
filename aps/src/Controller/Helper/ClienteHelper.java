/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Pessoa;
import Model.Tipo;
import View.ViewCliente;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dinopc
 */
public class ClienteHelper implements IHelper {
    
    private static int ID = 0;
    private final ViewCliente view;

    public ClienteHelper(ViewCliente view) {
        this.view = view;
    }

    public void popularTabela(ArrayList<Cliente> listaDeClientes) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabela().getModel();
        tableModel.setNumRows(0);
        // zerando a tabela pra percorrer ela toda preenchendo/populando ela
        
        for (Cliente listaDeCliente : listaDeClientes) {
            tableModel.addRow(
                    new Object[]{
                        listaDeCliente.getNome(),
                        listaDeCliente.getDataFormatada(),
                        listaDeCliente.getEmail(),
                        listaDeCliente.getRg(),
                    }
            );
        }
        
    }

    public static int getId() {
        return ID++;
    }
    
    @Override
    public Cliente retornaUsuario() {
        int id = getId();
        String nome = view.getInputNome().getText();
        String data = view.getInputData().getText();
        String email = view.getInputEmail().getText();
        String rg = view.getInputRg().getText();
        
        Cliente cliente = new Cliente(id, nome, data, email, rg);
        return cliente;
    }

    @Override
    public void limparTela() {
        view.getInputNome().setText("");
        view.getInputEmail().setText("");
        view.getInputData().setText("");
        view.getInputRg().setText("");
    }
}
