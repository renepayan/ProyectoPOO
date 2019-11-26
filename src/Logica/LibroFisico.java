/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.LibroDB;
import Persistencia.LibroElectronicoDB;
import Persistencia.LibroFisicoDB;

/**
 *
 * @author payan
 */
public class LibroFisico extends Libro{
    private String lugarDePublicacion;
    private String nivelDeterioro;

    public LibroFisico(String lugarDePublicacion, String nivelDeterioro, String titulo, int anioDePublicacion, String isbn, Autor autor, Ilustrador ilustrador, Traductor traductor, String edicion, String volumen, String idioma, Miniatura portada, Miniatura contraPortada, Editorial editorial, Estadistica estadistica, GeneroLiterario[] generos) {
        super(titulo, anioDePublicacion, isbn, autor, ilustrador, traductor, edicion, volumen, idioma, portada, contraPortada, editorial, estadistica, generos);
        this.lugarDePublicacion = lugarDePublicacion;
        this.nivelDeterioro = nivelDeterioro;
    }

    public String getLugarDePublicacion() {
        return lugarDePublicacion;
    }

    public void setLugarDePublicacion(String lugarDePublicacion) {
        this.lugarDePublicacion = lugarDePublicacion;
    }

    public String getNivelDeterioro() {
        return nivelDeterioro;
    }

    public void setNivelDeterioro(String nivelDeterioro) {
        this.nivelDeterioro = nivelDeterioro;
    }
    
    public void deteriorar(){
        this.nivelDeterioro = "Mas deteriorado";
    }
    public void restaurar(){
        this.nivelDeterioro = "Menos deteriorado";
    }    
    @Override
    public boolean guardarEnDB() {
        LibroFisicoDB lfdb = new LibroFisicoDB();       
        try{
            if(lfdb.addLibroFisico((LibroFisico)this.clone()) == 0){
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
    @Override
    public String toString(){
        return super.toString()+" Lugar de publicacion: "+lugarDePublicacion+"Deterioro: "+nivelDeterioro;
    }
    
}
