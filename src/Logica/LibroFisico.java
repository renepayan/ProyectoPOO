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
public class LibroFisico extends Libro{
    private String lugarDePublicacion;
    private String nivelDeterioro;
    
    public LibroFisico (){
        this("",0000,"","","","","","");
    }
    public LibroFisico(String titulo, 
            int anioDePublicacion, String isbn, String edicion, String volumen, 
            String idioma, String lugar, String deterioro) {
        
        super(titulo, anioDePublicacion, isbn, edicion, volumen, idioma);
        lugarDePublicacion=lugar;
        nivelDeterioro=deterioro;
    }
    public LibroFisico(Libro libro, String lugarDePublicacion, String nivelDeterioro){
        super(libro);
        this.lugarDePublicacion = lugarDePublicacion;
        this.nivelDeterioro = nivelDeterioro;
    }
    public LibroFisico (LibroFisico libroFisico){
        super(libroFisico);
        lugarDePublicacion = libroFisico.lugarDePublicacion;
        nivelDeterioro= libroFisico.nivelDeterioro;
    }        

    public void destruir(){
        super.destruir();
        if(lugarDePublicacion != null)lugarDePublicacion = null;
        if(nivelDeterioro != null)nivelDeterioro = null;
        System.gc();
    }   

    @Override
    public String toString(){
        return super.toString()+" Lugar de publicacion: "+lugarDePublicacion
                                +"Deterioro: "+nivelDeterioro;
    }   
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof LibroFisico)) return false;
        LibroFisico libroFisico = (LibroFisico) obj;
        return super.equals(libroFisico) && lugarDePublicacion.equals(libroFisico.lugarDePublicacion)
                        && nivelDeterioro.equals(libroFisico.nivelDeterioro);
    }   

    void deteriorar(LibroFisico libro, String deterioro){
        libro.nivelDeterioro = deterioro;
    }
    
    void deteriorar(){
        System.out.println("Estableciendo deterioro");
        this.deteriorar(this, "normal");
    }

    public String getLugarDePublicacion() {
        return lugarDePublicacion;
    }

    public String getNivelDeterioro() {
        return nivelDeterioro;
    }
    
}
