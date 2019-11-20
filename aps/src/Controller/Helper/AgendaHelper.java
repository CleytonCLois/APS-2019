/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.DAO.ConnectionBD;
import Model.Tipo;
import View.Agenda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dinopc
 */
public class AgendaHelper implements IHelper {
    
    private final Agenda view;
    private ResultSet result;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }
    
    public String getNameClient(Integer id_cliente){
         
        ConnectionBD.Conectar();
        String cliente = "";
        try {
            result = ConnectionBD.SelectQuery("select * from cliente;");
            while ( result.next() ) {
                if ( result.getInt("cod_cliente") == id_cliente ) {
                   cliente = result.getString("nome");
                }
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao realizar transferencia" + e);
        }
        
        ConnectionBD.Desconectar();
        
        return cliente;
    }
    
    public Integer getIdClient(Cliente cliente){
        ConnectionBD.Conectar();
//        System.out.println("CLiente..." + cliente + cliente.getNome());
        Integer id_cliente = 0;
        try {
            result = ConnectionBD.SelectQuery("select * from cliente;");
            while ( result.next() ) {
                if ( result.getString("nome") == "Vitor" ) {
                   id_cliente = result.getInt("cod_cliente");
                }
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao realizar transferencia" + e);
        }
        
        ConnectionBD.Desconectar();
        
        return id_cliente;   
    }

    public void popularTabela(ArrayList<Agendamento> listaDeAgendamentos) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabela().getModel();
        tableModel.setNumRows(0);
        // zerando a tabela pra percorrer ela toda preenchendo/populando ela
        System.out.println("TESTE" + obterCliente() );
        for (Agendamento listaDeAgendamento : listaDeAgendamentos) {
            tableModel.addRow(
                    new Object[]{
                            listaDeAgendamento.getId_quadra(),  
                            getNameClient(getIdClient(obterCliente())), // conseguir nome cliente
//                        listaDeAgendamento.getId(),
//                        listaDeAgendamento.getCliente().getNome(),
                        listaDeAgendamento.getTipo().getDescricao(),
                        listaDeAgendamento.getValor(),
                        listaDeAgendamento.getData(),
                        listaDeAgendamento.getHora(),
                        listaDeAgendamento.getObservacao(),
                    }
            );
        }
        
    }

    public void preencherClientes(ArrayList<Cliente> buscaClientes) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getSelectCliente().getModel();
 
        for (Cliente buscaCliente : buscaClientes) { // adicionando objeto cliente no combobox
            comboBoxModel.addElement(buscaCliente);
        }
    }

    public void preencherTipo(ArrayList<Tipo> buscaTipos) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getSelectTipo().getModel();
        
        for (Tipo buscaTipo : buscaTipos) {
            comboBoxModel.addElement(buscaTipo);
        }
    }
    
    public Tipo obterTipo(){
        return (Tipo) view.getSelectTipo().getSelectedItem();
    }
    
    public Cliente obterCliente(){
        return (Cliente) view.getSelectCliente().getSelectedItem();
    }
    
    @Override
    public Agendamento retornaUsuario() {
        Cliente cliente = obterCliente();
        System.out.println("CLIENTE>>>>>" + cliente);
        Tipo tipo = obterTipo();
        System.out.println("TIPO>>>>>" + tipo);
//        String valorString = view.getInputValor().getText();
//        float valor = Float.parseFloat(valorString);
//        String data = view.getInputData().getText();
//        String hora = view.getInputHorario().getText();
//        String dataHora = (data + " " + hora);
//        String observacao = view.getInputObservacao().getText();
//        
//        Agendamento agendamento = new Agendamento(cliente, tipo, valor, dataHora, observacao);
//        return agendamento;
          
          Agendamento agendamento = new Agendamento(1, 1, "12/02/2000", "12/02/2000");
          return agendamento;
    }

    @Override
    public void limparTela() {
        view.getInputNome().setText("");
        view.getInputValor().setText("");
        view.getInputData().setText("");
        view.getInputHorario().setText("");
        view.getInputObservacao().setText("");
    }
}
