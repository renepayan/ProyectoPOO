/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Palacios Lugo Alan Yoltic                     
           Payan Tellez Rene 
           Zepeta Rivera José Antonio 

 */
public class LibroElectronico extends Libro implements Archivo{
    private String ubicacion;
    private String extension;
    private float tamanio;
   
   
    public LibroElectronico (){
        this("",0000,"","","","");
    }
    public LibroElectronico(String titulo, 
            int anioDePublicacion, String isbn, String edicion, String volumen, 
            String idioma) {
        
        super(titulo, anioDePublicacion, isbn, edicion, volumen, idioma);
    }
    public LibroElectronico (LibroElectronico libroFisico){
        super(libroFisico);
    }
     public LibroElectronico(Libro libro, String ubicacion, String extension){
        super(libro);
        this.ubicacion = ubicacion;
        this.extension = extension;
    }

    public void destruir(){
        super.destruir();
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
    
    @Override
    public String leer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String leer(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void escribir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
}
