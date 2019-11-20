/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Tipo;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class TipoDAO {
    
    private ResultSet result;
    /**
     * Insere um tipodentro do banco de dados
     * @param tipoexige que seja passado um objeto do tipo tipo
     */
    public void insert(Tipo tipo){
        Banco.tipo.add(tipo);
    }
    
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param tipo
     * @return 
     */
    public boolean update(Tipo tipo){
        
        for (int i = 0; i < Banco.tipo.size(); i++) {
            if(idSaoIguais(Banco.tipo.get(i),tipo)){
                Banco.tipo.set(i, tipo);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do tipopassado
     * @param tipo
     * @return 
     */
    public boolean delete(Tipo tipo){
        for (Tipo tipoLista : Banco.tipo) {
            if(idSaoIguais(tipoLista,tipo)){
                Banco.tipo.remove(tipoLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os tipodo banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Tipo> selectAll(){
        return Banco.tipo;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param tipo
     * @param tipo
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Tipo tipo, Tipo tipoAComparar) {
        return tipo.getId() ==  tipoAComparar.getId();
    }
    
    public ResultSet SelecionarTudo(){
        
        ConnectionBD.Conectar();
    
        result = ConnectionBD.SelectQuery("select * from quadra;");
        
        ConnectionBD.Desconectar();
        
        return result;
    }
    
}
