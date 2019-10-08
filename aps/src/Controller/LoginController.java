/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Login;

/**
 *
 * @author cleyton
 */
public class LoginController {

    private final Login view;

    public LoginController(Login view) { //constructor é obrigado a receber a view login
        this.view = view;
    }
    
    public void FizTarefa(){
        System.out.print("teste");
        this.view.exibirMensagem("Executado");
    }
}
