/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Agendamento;
import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.DAO.AgendamentoDAO;
import java.util.Scanner;

/**
 *
 * @author tiago
 */
public class AgendamentoDAO {
    
    private Scanner s = new Scanner(System.in);
    private ResultSet result;
    
    /**
     * Insere um agendamento dentro do banco de dados
     * @param agendamento exige que seja passado um objeto do tipo agendamento
     */
    public void insert(Agendamento agendamento){
          
        
            Banco.agendamento.add(agendamento);
            
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param agendamento
     * @return 
     */
    public boolean update(Agendamento agendamento){
        
        for (int i = 0; i < Banco.agendamento.size(); i++) {
            if(idSaoIguais(Banco.agendamento.get(i),agendamento)){
                Banco.agendamento.set(i, agendamento);
                return true;
            }
        }
        return false;      
    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do agendamento passado
     * @param agendamento
     * @return 
     */
    public boolean delete(Agendamento agendamento){
        for (Agendamento agendamentoLista : Banco.agendamento) {
            if(idSaoIguais(agendamentoLista,agendamento)){
                Banco.agendamento.remove(agendamentoLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os agendamentos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Agendamento> selectAll(){
        System.out.println("LISTA AGENDAMENTO" + Banco.agendamento);
        Banco.inicia();
        return Banco.agendamento;
        
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param agendamento
     * @param agendamentoAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Agendamento agendamento, Agendamento agendamentoAComparar) {
        return agendamento.getId() ==  agendamentoAComparar.getId();
    }
    
    private int proximoId(){
        
        int maiorId = 0;
        
        for (Agendamento agendamento : Banco.agendamento) {           
           int id = agendamento.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
        }
        return maiorId + 1;
    }
    
    public void AgendarQuadra(Agendamento agend) throws SQLException{
      Integer count = 1;
      String sql = "insert into agendamento (cod_cliente, cod_quadra, dt_agendamento, horario_agendamento) values(?,?,?,?)";
        try {
                ConnectionBD.Conectar();
                PreparedStatement stm = ConnectionBD.preparedStament(sql);
                try {
                    result = ConnectionBD.SelectQuery("select * from agendamento;");
                    while ( result.next() ) {
                        count = count + 1;
                    }
                } catch (SQLException | NumberFormatException e) {
                    System.out.println("Erro ao realizar transferencia" + e);
                }
                        
                stm.setInt(1, count);
                stm.setInt(2, agend.getId_quadra());
                stm.setString(3, agend.getData());
                stm.setString(4, agend.getHora());
                                
                ConnectionBD.runPreparedStatment(stm);

                } catch (NumberFormatException e) {
                System.out.println("Erro ao cadastrar usuario" + e);
        }finally{ 
                ConnectionBD.Desconectar();
        }
    }
    
    public ResultSet SelecionarTudo(){
        
        ConnectionBD.Conectar();
    
        result = ConnectionBD.SelectQuery("select * from agendamento;");
        
        ConnectionBD.Desconectar();
        
        return result;
    }
    
    
}
