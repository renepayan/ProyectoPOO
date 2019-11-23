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
public class GeneroLiterario {
    private String nombreGenero;

    public GeneroLiterario(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
    public GeneroLiterario (){
        this("");
    }
    public GeneroLiterario (GeneroLiterario genero){
        nombreGenero = genero.nombreGenero;
    }

    public void destruir(){
        if(nombreGenero != null)nombreGenero = null;
        System.gc();
    }   
    public String getNombre(){
        return nombreGenero;
    }

    @Override
    public String toString(){
        return "Genero literario"+nombreGenero;
    }   
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof GeneroLiterario)) return false;
        GeneroLiterario genero = (GeneroLiterario) obj;
        return nombreGenero.equals(genero.nombreGenero);
    }   

}
