/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.UsuarioDAO;
import java.io.IOException;
import main.Main;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Conexion;

/**
 * FXML Controller class
 *
 * @author lexlp
 */
public class LoginController implements Initializable {
    
    
    @FXML TextField cjUsuario;
    @FXML PasswordField cjPassword;
    @FXML Button btnLogin;
    @FXML Label lblError;
    
    @FXML AnchorPane ap;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML 
    void iniciarSesion(ActionEvent evt){
        Conexion con = new Conexion();
        try {
            ResultSet rs = con.CONSULTAR("select * from usuario where usuario = '" + cjUsuario.getText().trim()+"' and contrasena = '"+cjPassword.getText().trim()+"' ");
            if(rs.next()){
                UsuarioDAO uDAO= new UsuarioDAO();
                if(uDAO.login(cjUsuario.getText(),cjPassword.getText())){
                    FXMLLoader loader = new FXMLLoader();
                    URL location = LoginController.class.getResource("/view/MenuPrincipal.fxml");
                    loader.setLocation(location);
                    
                    BorderPane bp = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Bienvenido "+modelo.Usuario.getInstanceUser(0, null, null, null).getNombreusuario());
                    
                    Scene scena  = new Scene(bp);
                    stage.setScene(scena);
                    stage.initOwner(ap.getScene().getWindow());
                    stage.setMaximized(true);
                    ((Stage)bp.getScene().getWindow()).close();
                    stage.show();
                    
                    
                }
            }else{
                
                lblError.setText("Error al iniciar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
