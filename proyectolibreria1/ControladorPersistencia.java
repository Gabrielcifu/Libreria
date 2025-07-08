package com.mycompany.proyectolibreria1;

import com.mycompany.proyectolibreria1.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPersistencia {
    
 
    
    LibroJpaController libroJpa = new LibroJpaController();
    UsuarioLibreriaJpaController1 usuarioJpa=new UsuarioLibreriaJpaController1();
    PrestamoLibroJpaController prestamoJpa= new PrestamoLibroJpaController();

    public void crearLibro(Libro libro) {
        libroJpa.create(libro);
    }
    public void crearUsuaruo(UsuarioLibreria usuarioLibreria) {
        usuarioJpa.create(usuarioLibreria);
        
    }
    public void crearPrestamo(PrestamoLibro prestamoLibro) {
        prestamoJpa.create(prestamoLibro);
    }

    public void eliminarLibro(int idLibro) {
        try {
            libroJpa.destroy(idLibro);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarUsuaruio(int idUsuario) {
        try {
            usuarioJpa.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarPrestamo(int idPrestamo) {
        try {
            prestamoJpa.destroy(idPrestamo);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarLibro(Libro libro) {
        try {
            libroJpa.edit(libro);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
    }
    public void editarUsuario(UsuarioLibreria usuarioLibreria) {
        try {
            usuarioJpa.edit(usuarioLibreria);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void editarPrestamo(PrestamoLibro prestamoLibro) {
        try {
            prestamoJpa.edit(prestamoLibro);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    Libro traerLibro(int idLibro) {
        return libroJpa.findLibro(idLibro);
    }
    UsuarioLibreria traerUsuario(int idUsuario) {
        return usuarioJpa.findUsuarioLibreria(idUsuario);
    }
    PrestamoLibro traerPrestamo(int idPrestamo) {
        return prestamoJpa.findPrestamoLibro(idPrestamo);
    }

  
    
}   
