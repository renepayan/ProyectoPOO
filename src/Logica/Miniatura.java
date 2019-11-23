/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;
import java.sql.*;
import java.io.File;
import java.io.OutputStream;

/**
 *
 * @author Palacios Lugo Alan Yoltic                     
           Payan Tellez Rene 
           Zepeta Rivera José Antonio 

 */
public class Miniatura {    
    private int id;
    private int alto;
    private int ancho;
    private Blob imagen;
    
    public Miniatura (){
        alto = 0;
        ancho = 0;
        id = 1;
    }
    public Miniatura( int alto, int ancho, int id, Blob imagen) {
        this.alto = alto;
        this.ancho = ancho;
        this.id = id;
        this.imagen = imagen;
    }
    public Miniatura (Miniatura miniatura){        
        alto = miniatura.alto;
        ancho = miniatura.ancho;
        id = miniatura.id;
        imagen = miniatura.imagen;
    }

    public void destruir(){        
        System.gc();
    }   

    @Override
    public String toString(){
        return "Ancho: "+ancho+"\n"+
                "Alto: "+alto+"\n"+
                "id:"+id+"\n";
    }       
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Miniatura)) return false;
        Miniatura miniatura = (Miniatura) obj;
        return id == miniatura.id;
    }   
    public Blob getImagen(){
        return this.imagen;
    }
    public void setImagen(Blob archivo) {
        imagen = archivo;
    }
    
    public int getId(){
        return this.id;
    }
    public int getAlto(){
        return this.alto;
    }            
    public int getAncho(){
        return this.ancho;
    }   
    public void crear(String path){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void crear(String texto, String tipografia){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
