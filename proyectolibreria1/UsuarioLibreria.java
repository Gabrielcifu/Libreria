package com.mycompany.proyectolibreria1;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Entity
    public class UsuarioLibreria implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idUsuario;
    private String nombreUsu;



    //constructor
    
    public UsuarioLibreria(int idUsuario, String nombreUsu) {
        this.idUsuario = idUsuario;
        this.nombreUsu = nombreUsu;
    }
    
    //GYS
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombreUsu() {
        return nombreUsu;
    }
    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    @Override
    public String toString() {
        return "UsuarioLibreria{" + "idUsuario=" + idUsuario + ", nombreUsu=" + nombreUsu + '}';
    }
   
    
    
}
