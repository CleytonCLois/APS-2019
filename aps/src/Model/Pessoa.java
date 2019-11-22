/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dinopc
 */
 public class Pessoa {
    public int id;
    protected String nome;
    protected String sexo;
    protected String dataNascimento;
    protected String email;
    protected String Rg;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Pessoa(int id, String nome, String dataNascimento, String email, String Rg) {
        this.nome = nome;

            this.dataNascimento = dataNascimento;
//            this.dataNascimento = new SimpleDateFormat("dd/mm/yyyy").parse(dataNascimento);


        this.email = email;
        this.Rg = Rg;
    }
    
    public Pessoa(int id, String nome, String sexo, String dataNascimento, String email, String Rg) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
 this.dataNascimento = dataNascimento;
        this.email = email;
        this.Rg = Rg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataFormatada(){
        return this.dataNascimento;
    }
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }
}
