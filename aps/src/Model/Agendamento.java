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
 * @author cleyton
 */
public class Agendamento {
    private int id;
    private Cliente cliente;
    private Tipo tipoQuadra;
    private float valor;
    private String data;
    private String observacao;
    private int id_quadra;
    private String hora;

    public Agendamento(Cliente cliente, Tipo tipoQuadra, float valor, String data) {
        this.id = id;
        this.cliente = cliente;
        this.tipoQuadra = tipoQuadra;
        this.valor = valor;
        this.data = data;
    }
    
    public Agendamento (int id_cliente, int id_quadra, String data, String hora){
        this.id = id;
        this.id_quadra = id_quadra;
        this.data = data;
        this.hora = hora;
    }

    public Agendamento(Cliente cliente, Tipo tipoQuadra, float valor, String data, String observacao) {
        this(cliente,tipoQuadra,valor,data);
        this.observacao = observacao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tipo getTipo() {
        return getTipoQuadra();
    }

    public void setTipo(Tipo tipoQuadra) {
        this.setTipoQuadra(tipoQuadra);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }
    
    public String getDataFormatada(){
        return getData();
    }
    
    public String getHoraFormatada(){
        return getData();
    }    

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void SetVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the tipoQuadra
     */
    public Tipo getTipoQuadra() {
        return tipoQuadra;
    }

    /**
     * @param tipoQuadra the tipoQuadra to set
     */
    public void setTipoQuadra(Tipo tipoQuadra) {
        this.tipoQuadra = tipoQuadra;
    }

    /**
     * @return the id_quadra
     */
    public int getId_quadra() {
        return id_quadra;
    }

    /**
     * @param id_quadra the id_quadra to set
     */
    public void setId_quadra(int id_quadra) {
        this.id_quadra = id_quadra;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
}
