/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Tipo;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dinopc
 */
public class AgendaHelper implements IHelper {
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void popularTabela(ArrayList<Agendamento> listaDeAgendamentos) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabela().getModel();
        tableModel.setNumRows(0);
        // zerando a tabela pra percorrer ela toda preenchendo/populando ela
        
        for (Agendamento listaDeAgendamento : listaDeAgendamentos) {
            tableModel.addRow(
                    new Object[]{
                        listaDeAgendamento.getId(),
                        listaDeAgendamento.getCliente().getNome(),
                        listaDeAgendamento.getTipo().getDescricao(),
                        listaDeAgendamento.getValor(),
                        listaDeAgendamento.getDataFormatada(),
                        listaDeAgendamento.getHoraFormatada(),
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
        Tipo tipo = obterTipo();
        String valorString = view.getInputValor().getText();
        float valor = Float.parseFloat(valorString);
        String data = view.getInputData().getText();
        String hora = view.getInputHorario().getText();
        String dataHora = (data + " " + hora);
        String observacao = view.getInputObservacao().getText();
        
        Agendamento agendamento = new Agendamento(cliente, tipo, valor, dataHora, observacao);
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
