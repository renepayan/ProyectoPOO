/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Autor;
import Logica.Ilustrador;
import Logica.Traductor;
import Persistencia.AutorDB;
import Persistencia.IlustradorDB;
import Persistencia.TraductorDB;
import Vista.VentanaPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author AlanPalacios
 */
public class ControladorAutor {
    private VentanaPrincipal jframe;   
    public ControladorAutor(JFrame jframe){
        this.jframe = (VentanaPrincipal)jframe;
    }
    public void insertarAutor(){
        Autor autor = new Autor(jframe.getCampoNombre().getText(),
                                jframe.getCampoNacionalidad().getText(),
                                jframe.getCampoFecha().getText());        
        AutorDB adb = new AutorDB();
        adb.addAutor(autor);        
    }
    public void insertarIlustrador(){
        Ilustrador ilustrador = new Ilustrador(jframe.getCampoNombre().getText());        
        IlustradorDB idb = new IlustradorDB();
        idb.addIlustrador(ilustrador);        
    }
    public void insertarTraductor(){
        Traductor traductor = new Traductor(jframe.getCampoNombre().getText(),
                                jframe.getCampoNacionalidad().getText());        
        TraductorDB tdb = new TraductorDB();
        tdb.addTraductor(traductor);        
    }
}
