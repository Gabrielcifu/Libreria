package com.mycompany.proyectolibreria1;

public class ControladorLogica {
    
    ControladorPersistencia controlPersis = new ControladorPersistencia();
    
    public void crearLibro (Libro libro) {
        controlPersis.crearLibro (libro);
    }
    public void crearUsuario (UsuarioLibreria usuarioLibreria) {
        controlPersis.crearUsuaruo (usuarioLibreria);
    }
    public void crearPrestamo (PrestamoLibro prestamoLibro) {
        controlPersis.crearPrestamo (prestamoLibro);
    }
    
    public void eliminarLibro(int idLibro){
        controlPersis.eliminarLibro(idLibro);
    }
    public void eliminarUsuario(int idUsuario){
        controlPersis.eliminarUsuaruio(idUsuario);
    }
    public void eliminarPrestamo(int idPrestamo){   
        controlPersis.eliminarPrestamo(idPrestamo);
    }
    
    public void editarLibro (Libro libro) {
        controlPersis.editarLibro (libro);   
    }   
    public void editarUsuario (UsuarioLibreria usuarioLibreria) {
        controlPersis.editarUsuario (usuarioLibreria);   
    }    
    public void editarPrestamo (PrestamoLibro prestamoLibro) {
        controlPersis.editarPrestamo (prestamoLibro);
    }
    
    public Libro traerLibro(int idLibro){
        return controlPersis.traerLibro(idLibro);   
    }
    public UsuarioLibreria traerUsuario(int idUsuario){
        return controlPersis.traerUsuario(idUsuario);   
    }
    public PrestamoLibro traerPrestamo(int idPrestamo){
        return controlPersis.traerPrestamo(idPrestamo);   
    }


  


    
}
