package com.mycompany.proyectolibreria1;

import java.util.Date;

public class ProyectoLibreria1 {
    public static void main(String[] args) {
        
        ControladorLogica control = new ControladorLogica();
        
        //CREATE
        /*Libro libro = new Libro(1,"Fantasia","La historia sin fin","Michael Ende", "santillana");
        control.crearLibro(libro);

        UsuarioLibreria usuarioLibreria= new UsuarioLibreria(1,"Gabriel Cifuentes");
        control.crearUsuariuo(usuarioLibreria);
        
        PrestamoLibro prestamoLibro= new PrestamoLibro(1,new Date(),new Date(),true, 2);
        control.crearPrestamo(prestamoLibro);
        */
        
        //DELETE
        //control.eliminarUsuario(3);
        //control.eliminarLibro(1);
        //control.eliminarPrestamo(1);
        
        //UPDATE
        /*usuarioLibreria.setNombreUsu("Maicol");
        control.editarUsuario(usuarioLibreria);
        */
        //READ
        /*Libro libro1=control.traerLibro(1);
        UsuarioLibreria usu1=control.traerUsuario(1);
        PrestamoLibro pres1=control.traerPrestamo(1);
       
    }
}
