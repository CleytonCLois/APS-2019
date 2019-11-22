/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.*;
import java.util.ArrayList;
import Model.DAO.ConnectionBD;
import java.sql.PreparedStatement;
import Model.DAO.ClienteDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controller.LoginController;
import Model.Tipo;
import Model.DAO.AgendamentoDAO;

/**
 *
 * @author tiago
 */
public class Banco {
    
    
    public static ArrayList<Usuario> usuario;
    public static ArrayList<Cliente> cliente;
    public static ArrayList<Tipo> tipo;
    public static ArrayList<Agendamento> agendamento;
    
    
    public static void inicia(){
        
        ConnectionBD.Conectar();
    
        //Instancia os Objetos
        ResultSet result;
        usuario = new ArrayList<Usuario>();
        cliente = new ArrayList<Cliente>();
        tipo = new ArrayList<Tipo>();
        agendamento = new ArrayList<Agendamento>();
        
        try {
            
            result = new UsuarioDAO().SelecionarTudo();
        
<<<<<<< HEAD
        Usuario usuario1 = new Usuario(1, "cliente", 'M', "29/12/2000", "cliente@cliente.com", "123456789", "cliente", "administrador");
         
        //Cliente cliente1 = new Cliente(10, "Felipe Luis", 'M', "12/06/1999", "felipeluispet@gmail.com", "845713647", "Rua marechal 1023 Canudos NH");
=======
            while ( result.next() ) {
                Usuario u = new Usuario(result.getInt("cod_login"),result.getString("login_usuario"), 
                                result.getString("senha_usuario"));
                usuario.add(u);
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao realizar transferencia" + e);
        }
>>>>>>> 5c27a185c8dec6fa14ee51d788aee0e45ad0c35f
        
        //Usuario usuario1 = new Usuario(1, "cliente", "Mar", "29/12/2000", "cliente@cliente.com", "123456789", "cliente", "administrador");

<<<<<<< HEAD
        //Agendamento agendamento01 = new Agendamento(cliente1, quadra01, 18, "14/07/2018 10:30");
=======
        try {
            
            result = new ClienteDAO().SelecionarTudo();
>>>>>>> 5c27a185c8dec6fa14ee51d788aee0e45ad0c35f
        
            while ( result.next() ) {
                Cliente c = new Cliente(result.getInt("cod_cliente"),result.getString("nome"), 
                                result.getString("dt_nascimento"),result.getString("email_cliente"), result.getString("rg_cliente"));
                cliente.add(c);
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao realizar transferencia" + e);
        }
        
<<<<<<< HEAD
        //cliente.add(cliente1);
=======
        try {
            
            result = new TipoDAO().SelecionarTudo();
>>>>>>> 5c27a185c8dec6fa14ee51d788aee0e45ad0c35f
        
            while ( result.next() ) {
                Tipo t = new Tipo(result.getInt("cod_quadra"),result.getString("nome_quadra"), result.getFloat("valor_quadra"));
                tipo.add(t);
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao realizar transferencia" + e);
        }
        
        try {
            
            result = new AgendamentoDAO().SelecionarTudo();
        
            while ( result.next() ) {
                Agendamento a = new Agendamento(result.getInt("cod_quadra"),result.getString("nome_cliente"), result.getString("nome_quadra"), 
                        result.getFloat("valor_quadra"), result.getString("dt_agendamento"), result.getString("horario_agendamento"));
                agendamento.add(a);
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao realizar agendamento" + e);
        }
        
        ConnectionBD.Desconectar();
        
<<<<<<< HEAD
        //agendamento.add(agendamento01);
=======
>>>>>>> 5c27a185c8dec6fa14ee51d788aee0e45ad0c35f
    }
    
    
}
