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
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author payan
 */
public class ControladorLibro {
    private VentanaPrincipal jframe;
    public ControladorLibro(JFrame jframe){
        this.jframe = (VentanaPrincipal)jframe;
    }
    public void ponerAutores(){
        JComboBox jcombo= jframe.getComboBoxAutores();
        jcombo.removeAllItems();
        AutorDB adb = new AutorDB();
        List<Autor> autores = adb.getAutores();
        for(Autor autor: autores){
            jcombo.addItem(autor.getNombre());
        }
    }
    public void ponerIlustradores(){
        JComboBox jcombo= jframe.getComboBoxIlustradores();
        jcombo.removeAllItems();
        IlustradorDB idb = new IlustradorDB();
        List<Ilustrador> ilustradores = idb.getIlustradores();
        for(Ilustrador ilustrador: ilustradores){
            jcombo.addItem(ilustrador.getNombre());
        }
        jcombo.addItem("Desconocido");
    }
    public void ponerTraductores(){
        JComboBox jcombo= jframe.getComboBoxTraductores();
        jcombo.removeAllItems();
        TraductorDB tdb = new TraductorDB();
        List<Traductor> traductores = tdb.getTraductores();
        for(Traductor traductor: traductores){
            jcombo.addItem(traductor.getNombre());
        }
        jcombo.addItem("Desconocido");
    }
}
