/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Autor;
import Persistencia.AutorDB;
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
}
