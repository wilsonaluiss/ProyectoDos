
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
//import main.Main;
import modelo.Conexion;

/**
 *
 * @author lexlp
 */
public class UsuarioDAO {

    public UsuarioDAO() {
    }
    
    public boolean login(String user, String pass){
        Conexion con = new Conexion();
        try {
            ResultSet rs = con.CONSULTAR("select * from usuario where usuario= '"+user+"' and contrasena='"+pass+"' ");
            if(rs.next()){
                modelo.Usuario usuario = modelo.Usuario.getInstanceUser(
                        rs.getInt("idusuario"),
                        rs.getString("nombre"),
                        rs.getString("usuario"),
                        rs.getString("contrasena"));
                return true;
            }
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Mensaje");
            a.showAndWait();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }
}
