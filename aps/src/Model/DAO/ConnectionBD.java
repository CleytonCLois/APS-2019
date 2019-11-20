/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author manuela
 */
public class ConnectionBD {

    private static Connection db = null; // ConexÃ£o
    private static Statement query; // Query
    private static PreparedStatement stm = null; // Query modificavel
    private static ResultSet result; // Resultado da query

    // HOST PADRï¿½O USAR QUANDO ESTIVER SEM O DB "jdbc:postgresql://127.0.0.1:5432/"
    private static String URL = "jdbc:postgresql://localhost:5432/"; // url do servidor 192.168.4.204:5432
    private static String USER = "quadraesporte"; // usuario do db
    private static String PASSWORD = "quadra123"; // senha do usuario alterar
    private static String DATABASE = "esporte"; // banco 

    public static void Conectar() {

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Class.forName("org.postgresql.Driver");
            db = DriverManager.getConnection(URL + DATABASE, USER, PASSWORD);
            System.out.println("DB"+ db);
            db.setAutoCommit(false);
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar o driver");
            cnfe.printStackTrace();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Erro na query");
            sqlex.printStackTrace();
        }
    }

    public static ResultSet SelectQuery(String qr) {

        try {
            result = db.createStatement().executeQuery(qr);
            System.out.println(result);

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }
        return result;

    }

    public static void InsertQuery(String qr) {

        try {
            Statement stmt = db.createStatement();
//    		Statement query = db.prepareStatement(qr);
            stmt.executeUpdate(qr);
            db.commit();
        } catch (Exception e) {
            try {
                db.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println(e);
        }

    }

    public static PreparedStatement preparedStament(String qr) {
        try {
            stm = db.prepareStatement(qr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stm;
    }

    public static ResultSet runPreparedSelect(PreparedStatement qr) throws SQLException {

        try {
            result = qr.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static void runPreparedStatment(PreparedStatement qr) throws SQLException {
        try {
            qr.executeUpdate();
            db.commit();
        } catch (SQLException e) {
            db.rollback();
            e.printStackTrace();
        }
    }

    public static void Desconectar() {
        try {
            db.close();
        } catch (SQLException onConClose) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar o banco");
            onConClose.printStackTrace();
        }
    }
}
