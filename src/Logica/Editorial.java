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
public class Editorial {
    private String nombre;
    private String pais;
    public Editorial (){
        this("","");
    }
    public Editorial (Editorial editorial){
        nombre = editorial.nombre;
        pais = editorial.pais;
    }

    public Editorial(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public void destruir(){
        if(nombre != null)nombre = null;
        if(pais != null)pais = null;
        System.gc();
    }   

    @Override
    public String toString(){
        return "Nombre de la editorial: "+nombre+"\n"+
                "Pais de origen de la editorial: "+pais;
    }   
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Editorial)) return false;
        Editorial editorial = (Editorial) obj;
        return nombre.equals(editorial.nombre) && pais.equals(editorial.pais);
    }   
    void publicar(){
        System.out.println("Publicando: ");
    }
    void publicar(Libro libro){
        publicar();
        System.out.println(libro.toString());
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }
}

