
package modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario {

    
    private IntegerProperty idusuario;
    private StringProperty nombreusuario;
    private StringProperty username;
    private StringProperty password;
    
    private static Usuario usuario;

    public Usuario(int idusuario, String nombreusuario, String user, String pass ) {
        this.idusuario = new SimpleIntegerProperty(idusuario);
        this.nombreusuario = new SimpleStringProperty(nombreusuario);
        this.username = new SimpleStringProperty(user);
        this.password = new SimpleStringProperty(pass);
    }
    
    public static Usuario getInstanceUser(int id, String nombreusuario, String user, String pass){
        if(usuario== null){
            usuario = new Usuario(id, nombreusuario, user, pass);
        }
        return usuario;
    }

    public Integer getIdusuario() {
        return idusuario.get();
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = new SimpleIntegerProperty(idusuario);
    }

    public String getNombreusuario() {
        return nombreusuario.get();
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = new SimpleStringProperty(nombreusuario);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username = new SimpleStringProperty(username);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPasswordusuario(String password) {
        this.password = new SimpleStringProperty(password);
    }
    
    
}
