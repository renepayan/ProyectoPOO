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
public class Autor {
    private String nombre;
    private String nacionalidad;
    private String fechaNacimiento;
    private Libro libro;
    public Autor (){
        this("","","");
    }
    public Autor(String nombre, String nacionalidad, String fechaNacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Autor (Autor autor){
        nombre = autor.nombre;
        nacionalidad = autor.nacionalidad;
        fechaNacimiento = autor.fechaNacimiento;
    }

    public void destruir(){
        if(nombre != null)nombre = null;
        if(nacionalidad != null)nacionalidad = null;
        if(fechaNacimiento != null)fechaNacimiento = null;
        System.gc();
    }   
    
    void escribirLibro(Libro libro){
        this.libro = libro;
        System.out.println("Escribiendo libro: "+libro.toString());
    }
    public String getNombre(){
        return nombre;
    }
    public String getNacionalidad(){
        return nacionalidad;
    }
    public String getFechaNacimiento(){
        return fechaNacimiento;
    }
    @Override
    public String toString(){
        return "Nombre del autor: "+nombre+"\n"+
               "Nacionalidad del autor: "+nacionalidad+"\n"+
               "Fecha de nacimiento: "+fechaNacimiento;
    }   
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Autor)) return false;
        Autor autor = (Autor) obj;
        return nombre.equals(autor.nombre) 
                && nacionalidad.equals(autor.nacionalidad) 
                && fechaNacimiento.equals(autor.fechaNacimiento);
    }   

}
