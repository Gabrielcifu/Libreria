package com.mycompany.proyectolibreria1;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idLibro;
    
    @Basic
    private String categoriaLibro,nombreLibro,autorLibro,editLibro;



    //constructor
    public Libro(int idLibro, String categoriaLibro, String nombreLibro,String autorLibro,String editLibro) {
        this.idLibro = idLibro;
        this.categoriaLibro = categoriaLibro;
        this.nombreLibro = nombreLibro;
        this.autorLibro= autorLibro;
        this.editLibro= editLibro;
    }
    
    //GYS
    
    public int getIdLibro() {
        return idLibro;
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    public String getCategoriaLibro() {
        return categoriaLibro;
    }
    public void setCategoriaLibro(String categoriaLibro) {
        this.categoriaLibro = categoriaLibro;
    }
    public String getNombreLibro() {
        return nombreLibro;
    }
    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }
    public String getAutorLibro() {
        return autorLibro;
    }
    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }
    public String getEditLibro() {
        return editLibro;
    }
    public void setEditLibro(String editLibro) {
        this.editLibro = editLibro;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", categoriaLibro=" + categoriaLibro + ", nombreLibro=" + nombreLibro + ", autorLibro=" + autorLibro + ", editLibro=" + editLibro + '}';
    }
    
    

       
     
    
}
