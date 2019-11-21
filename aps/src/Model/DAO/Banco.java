/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Agendamento;
import Model.Cliente;
import Model.Tipo;
import Model.Usuario;
import java.util.ArrayList;

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
    
        //Instancia os Objetos
        usuario = new ArrayList<Usuario>();
        cliente = new ArrayList<Cliente>();
        tipo = new ArrayList<Tipo>();
        agendamento = new ArrayList<Agendamento>();
        
        //criando elementos
        
        Usuario usuario1 = new Usuario(1, "cliente", 'M', "29/12/2000", "cliente@cliente.com", "123456789", "cliente", "administrador");
         
        //Cliente cliente1 = new Cliente(10, "Felipe Luis", 'M', "12/06/1999", "felipeluispet@gmail.com", "845713647", "Rua marechal 1023 Canudos NH");
        
        Tipo quadra01 = new Tipo(1, "Quadra 1", 80);
        Tipo quadra02 = new Tipo(2, "Quadra 2", 80);
        Tipo quadra03 = new Tipo(3, "Quadra 3", 60);
        Tipo quadra04 = new Tipo(4, "Quadra 4", 60);
        Tipo quadra05 = new Tipo(5, "Quadra 5", 50);
        Tipo quadra06 = new Tipo(6, "Quadra 6", 40);

        //Agendamento agendamento01 = new Agendamento(cliente1, quadra01, 18, "14/07/2018 10:30");
        
        //Adiciona Elementos na lista
        usuario.add(usuario1);
        
        //cliente.add(cliente1);
        
        tipo.add(quadra01);
        tipo.add(quadra02);
        tipo.add(quadra03);
        tipo.add(quadra04);
        tipo.add(quadra05);
        tipo.add(quadra06);
        
        //agendamento.add(agendamento01);
    }
}
