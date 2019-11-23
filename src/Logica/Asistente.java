/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author AlanPalacios
 */
public class Asistente {
    private boolean activado;
    private Autor autor;
    private Ilustrador ilustrador;
    private Traductor traductor;
    private Libro libro;    

    public Asistente (){
        this(true);
    }
    public Asistente(boolean activado){
        this.activado = activado;
    }
    public Asistente (Asistente asist){
        autor = asist.autor;
        ilustrador = asist.ilustrador;
        traductor = asist.traductor;
        libro=asist.libro;
        activado = asist.activado;
    }

    void guardar(){
        System.out.print("Guardando ");
    }
    void guardar(Libro libro){
        guardar();
        System.out.println(libro.toString());
    }
    void guardar(Autor autor){
        guardar();
        System.out.println(autor.toString());
    }
    void guardar(Ilustrador ilusrtrador){
        guardar();
        System.out.println(ilustrador.toString());
    }
    void crearIlstrador(Traductor traductor){
        guardar();
        System.out.println(traductor.toString());
    }
    
    public void destruir(){
        if(ilustrador != null)ilustrador = null;
        if(autor != null)autor = null;
        if(traductor != null)traductor = null;
        if (libro!=null)libro=null;
        System.gc();
    }   

    @Override
    public String toString(){
        return "Libro: "+libro.toString()+"\n"+
                "Ilustrador: "+ilustrador.toString()+"\n"+
                "Autor: "+autor.toString()+"\n"+
                "Traductor: "+traductor.toString()+"\n";
    }   
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Asistente)) return false;
        Asistente asist = (Asistente) obj;
        return activado==asist.activado 
                && ilustrador.equals(asist.ilustrador) 
                && autor.equals(asist.autor) 
                && traductor.equals(asist.traductor)
                && libro.equals(asist.libro);
    }   

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setIlustrador(Ilustrador ilustrador) {
        this.ilustrador = ilustrador;
    }

    public void setTraductor(Traductor traductor) {
        this.traductor = traductor;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}
