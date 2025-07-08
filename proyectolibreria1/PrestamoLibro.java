package com.mycompany.proyectolibreria1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PrestamoLibro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPrestamo;
    
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo,fechaDevolucion;
    
    private boolean disponibilidad;
    private int cantLibro;

    @OneToOne     
    private UsuarioLibreria usuarioLibreria;

    //constructores


    public PrestamoLibro(int idPrestamo, Date fechaPrestamo, Date fechaDevolucion, boolean disponibilidad, int cantLibro, UsuarioLibreria usuarioLibreria) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.disponibilidad = disponibilidad;
        this.cantLibro = cantLibro;
        this.usuarioLibreria = usuarioLibreria;
    }

    
    

    public int getIdPrestamo() {
        return idPrestamo;

    }
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getCantLibro() {
        return cantLibro;
    }
    public void setCantLibro(int cantLibro) {    
        this.cantLibro = cantLibro;
    }

    public UsuarioLibreria getUsuarioLibreria() {
        return usuarioLibreria;
    }
    public void setUsuarioLibreria(UsuarioLibreria usuarioLibreria) {
        this.usuarioLibreria = usuarioLibreria;
    }
    
    

    /*public String prestamoLibro() {
        if (cantLibro > 1) {
            disponibilidad = true;
            System.out.println("se presta el libro");
        } else {
            System.out.println("no se presta el libro");
            disponibilidad = false;
        }
        return null;*/

    @Override
    public String toString() {
        return "PrestamoLibro{" + "idPrestamo=" + idPrestamo + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", disponibilidad=" + disponibilidad + ", cantLibro=" + cantLibro + '}';
    }
    
}
