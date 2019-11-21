/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;
import Model.DAO.ConnectionBD;
import java.sql.*;

/**
 *
 * @author cleyton
 */
public class LoginController {

    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;    
    
    private final Login view;
    private final LoginHelper helper;

    public LoginController(Login view) { //constructor é obrigado a receber a view login
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void logar(){
        
        Usuario usuario = helper.retornaUsuario();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
        if( usuarioAutenticado != null){ // se o usuario existe no banco loga se n dados invalidos
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        }else{
            view.exibirMensagem("Dados invalidos");
        }
    }
    
       
    public void FizTarefa(){
        System.out.println("teste");
        this.view.exibirMensagem("Executado");
    }
}
