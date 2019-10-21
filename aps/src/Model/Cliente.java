/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * herda de pessoa e faz constructor da superclasse passando os parametros 
 * definidos no cód abaixo
 */

public class Cliente extends Pessoa{
    private String endereco;
    private String Cep;

    public Cliente (int id, String nome, char sexo, String dataNascimento, String email, String Rg,  String senha, String nivelAcesso) {
        super(id, nome, sexo, dataNascimento, email, Rg);
        this.endereco = endereco;
        this.Cep = Cep;
    }

    public Cliente(String endereco, String Cep, int id, String nome) {
        super(id, nome);
        this.endereco = endereco;
        this.Cep = Cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }
}
