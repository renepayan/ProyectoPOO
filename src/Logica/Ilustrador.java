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
public class Ilustrador {
    private String nombre;    
    
    public Ilustrador (){
        this("");
    }
    public Ilustrador(String nombre){
        this.nombre = nombre;
    }
    public Ilustrador (Ilustrador ilustrador){
        nombre = ilustrador.nombre;
    }

    public void destruir(){
        if(nombre != null)nombre = null;
        System.gc();
    }   
    
    public String getNombre(){
        return nombre;
    }
    @Override
    public String toString(){
        return "Nombre del ilustradot: "+nombre;
    }   
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Ilustrador)) return false;
        Ilustrador ilustrador = (Ilustrador) obj;
        return nombre.equals(ilustrador.nombre);
    }   

    void ilustrar(){
        System.out.print("ilustrando: ");
    }
    void ilustrar(Miniatura miniatura){
        ilustrar();
        System.out.print(miniatura.toString());        
    }
    void ilustrar(Miniatura miniatura, Libro libro){
        ilustrar(miniatura);
        System.out.println(" del libro"+libro.toString());
               
    }
}
