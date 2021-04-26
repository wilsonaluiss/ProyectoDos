/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lexlp
 */
public class Conexion {
    private Connection conexion;
    private Statement st;

    public Conexion(){
        
        try {
            //Class.forName("oracle.jdbc.OracleDriver");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","TEST","admin");
            st = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public ResultSet CONSULTAR(String sql) throws SQLException{
        return st.executeQuery(sql);
    }
    
    public int GUARDAR(String sql) throws SQLException{
        return st.executeUpdate(sql);
    }
    
    public void CERRAR()throws SQLException{
        try {
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
