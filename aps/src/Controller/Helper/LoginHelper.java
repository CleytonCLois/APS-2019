/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Usuario;
import View.Login;

/**
 *
 * @author Dinopc
 */
public class LoginHelper implements IHelper{
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario retornaUsuario(){
        String usuario = view.getInputUsuario().getText();
        char[] senha = view.getInputSenha().getPassword();
        
        String senhaConverter = this.converterSenha(senha);
        
        Usuario retornoUsuario = new Usuario(0, usuario, senhaConverter);
        return retornoUsuario;
    };
    
    public void setarUsuario(Usuario retornoUsuario){
        String nome = retornoUsuario.getNome();
        String senha = retornoUsuario.getSenha();
        
        view.getInputUsuario().setText(nome);
        view.getInputSenha().setText(senha);
    }
    
    public void limparTela(){
        view.getInputUsuario().setText("");
        view.getInputSenha().setText("");
    }
    
    private String converterSenha(char[] senha){
        String senhaConvertida = String.copyValueOf(senha);
        return senhaConvertida;
    }
    
    
}
