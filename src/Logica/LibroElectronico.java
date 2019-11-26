/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.LibroElectronicoDB;

/**
 *
 * @author Palacios Lugo Alan Yoltic                     
           Payan Tellez Rene 
           Zepeta Rivera José Antonio 

 */
public class LibroElectronico extends Libro{
    private String ubicacion;
    private String extension;
    private float tamanio;
   
   
    public LibroElectronico(String ubicacion, String extension, float tamanio,
            String titulo, int anioDePublicacion, String isbn, Autor autor,
            Ilustrador ilustrador, Traductor traductor, String edicion,
            String volumen, String idioma, Miniatura portada, Miniatura contraPortada,
            Editorial editorial, Estadistica estadistica, GeneroLiterario [] generos) {
        
        super(titulo, anioDePublicacion, isbn, autor, ilustrador, traductor,
                edicion, volumen, idioma, portada, contraPortada, editorial, estadistica, generos);
        this.ubicacion=ubicacion;
        this.extension=extension;
        this.tamanio=tamanio;
    }
   

    public void destruir(){
        if(ubicacion!=null)ubicacion=null;
        if(extension!=null)extension=null;        
        System.gc();
    }   

    @Override
    public String toString(){
        return super.toString()+" Lugar de publicacion:";
    }   
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof LibroElectronico)) return false;
        LibroElectronico libroFisico = (LibroElectronico) obj;
        return super.equals(libroFisico);
    }   
    
    
    public String leer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String leer(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void escribir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void escribir(String path, String contenido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void eliminar(LibroElectronico libro){
        eliminar();
        System.out.println(libro.toString());
    }
    void eliminar(){
        System.out.println("eliminando: ");
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getExtension() {
        return extension;
    }

    public float getTamanio() {
        return tamanio;
    }

    @Override
    public boolean guardarEnDB() {
        LibroElectronicoDB lfdb = new LibroElectronicoDB();       
        try{
            if(lfdb.addLibroElectronico((LibroElectronico)this.clone()) == 0){
                return true;
            }else{
                return false;
            }
        }catch(CloneNotSupportedException cnse){
            cnse.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean serLeido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
