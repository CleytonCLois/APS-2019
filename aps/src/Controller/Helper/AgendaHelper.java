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
import java.sql.PreparedStatement;
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
    
    public void popularTabela(ArrayList<Agendamento> listaDeAgendamentos) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabela().getModel();
        tableModel.setNumRows(0);

        for (Agendamento listaDeAgendamento : listaDeAgendamentos) {
            tableModel.addRow(
                    new Object[]{
                        listaDeAgendamento.getId_quadra(),  
                        listaDeAgendamento.getNome_cliente(),
                        listaDeAgendamento.getNome_quadra(),
                        listaDeAgendamento.getValor(),
                        listaDeAgendamento.getData(),
                        listaDeAgendamento.getHora(),
//                        listaDeAgendamento.getObservacao(),
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
        Tipo tipo = obterTipo();
        String valorString = view.getInputValor().getText();
        float valor = Float.parseFloat(valorString);
        String data = view.getInputData().getText();
        String hora = view.getInputHorario().getText();
        
        Integer count = 1;
        String sql = "insert into agendamento (cod_quadra, nome_cliente, nome_quadra, valor_quadra, dt_agendamento, horario_agendamento ) values(?,?,?,?,?,?)";
        ConnectionBD.Conectar();
        PreparedStatement stm = ConnectionBD.preparedStament(sql);
        try {
            result = ConnectionBD.SelectQuery("select * from agendamento;");
            while ( result.next() ) {
                count = count + 1;
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao coletar agendamento" + e);
        }
        System.out.println("TIPO>>>" + tipo.getDescricao() + tipo);
        Agendamento agendamento = new Agendamento(count, cliente.getNome(), tipo.getDescricao(), valor, data, hora);
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
