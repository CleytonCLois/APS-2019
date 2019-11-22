/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Cliente;
import java.util.ArrayList;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author tiago
 */
public class ClienteDAO {
    
    private Scanner s = new Scanner(System.in);
    private ResultSet result;
    /**
     * Insere um cliente dentro do banco de dados
     * @param cliente exige que seja passado um objeto do tipo cliente
     */
    public void insert(Cliente cliente){
        Banco.cliente.add(cliente);
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param cliente
     * @return 
     */
    public boolean update(Cliente cliente){
        
        for (int i = 0; i < Banco.cliente.size(); i++) {
            if(idSaoIguais(Banco.cliente.get(i),cliente)){
                Banco.cliente.set(i, cliente);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do cliente passado
     * @param cliente
     * @return 
     */
    public boolean delete(Cliente cliente){
        for (Cliente clienteLista : Banco.cliente) {
            if(idSaoIguais(clienteLista,cliente)){
                Banco.cliente.remove(clienteLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os clientes do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Cliente> selectAll(){
        System.out.println("LISTA CLIENTES" + Banco.cliente);
        Banco.inicia();
        return Banco.cliente;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param cliente
     * @param clienteAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Cliente cliente, Cliente clienteAComparar) {
        return cliente.getId() ==  clienteAComparar.getId();
    }
    
     public void cadastrarCliente(Cliente cliente) throws SQLException{
       
      String sql = "insert into cliente (nome, dt_nascimento, email_cliente,rg_cliente) values(?,?,?,?)";
        try {
                ConnectionBD.Conectar();
                PreparedStatement stm = ConnectionBD.preparedStament(sql);
                

                stm.setString(1, cliente.getNome());
                stm.setString(2, cliente.getDataNascimento());
                stm.setString(3, cliente.getEmail());
                stm.setString(4, cliente.getRg());
                                
                ConnectionBD.runPreparedStatment(stm);

                } catch (NumberFormatException e) {
                System.out.println("Erro ao cadastrar usuario" + e);
        }finally{ 
                ConnectionBD.Desconectar();
        }
    }
    
    public ResultSet SelecionarTudo(){
        
        ConnectionBD.Conectar();
    
        result = ConnectionBD.SelectQuery("select * from cliente;");
        
        ConnectionBD.Desconectar();
        
        return result;
    }
    
 
}
