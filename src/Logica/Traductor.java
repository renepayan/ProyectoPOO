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
public class Traductor {
    private String nombre;
    private String nacionalidad;

    public Traductor (){
        this("","");
    }
    public Traductor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    public Traductor (Traductor traductor){
        nombre = traductor.nombre;
        nacionalidad = traductor.nacionalidad;
    }

    public void destruir(){
        if(nombre != null)nombre = null;
        if(nacionalidad != null)nacionalidad = null;
        System.gc();
    }   

    @Override
    public String toString(){
        return "Nombre del traductor: "+nombre+"\n"+
                "Nacionalidad del traductor: "+nacionalidad;
    }   
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Traductor)) return false;
        Traductor traductor = (Traductor) obj;
        return nombre.equals(traductor.nombre) && nacionalidad.equals(traductor.nacionalidad);
    }   

    void traducir(){
        System.out.println("Traduciendo: ");
    }
    
    void traducir(Libro libro){
        traducir();
        System.out.println(libro.toString());
    }
}
