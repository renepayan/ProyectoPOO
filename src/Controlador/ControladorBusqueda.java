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
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author AlanPalacios
 */
public class ControladorBusqueda {
    private VentanaPrincipal jframe;
    public ControladorBusqueda(JFrame jframe){
        this.jframe = (VentanaPrincipal)jframe;
    }
    
    public void buscar(String busqueda){
        JList lista = jframe.getListAutores();
        DefaultListModel modelo = new DefaultListModel();                
        AutorDB adb = new AutorDB();
        IlustradorDB idb = new IlustradorDB();
        TraductorDB tdb = new TraductorDB();
        
        List<Autor> autores = adb.getAutoresBySearch(busqueda);
        List<Ilustrador> ilustradores = idb.getIlustradoresBySearch(busqueda);
        List<Traductor> traductores = tdb.getTraductoresBySearch(busqueda);
        for(Autor autor: autores){
            modelo.addElement("Autor    "+autor.getNombre());
        }        
        for(Ilustrador ilustrador: ilustradores){
            modelo.addElement("Ilustrador   "+ilustrador.getNombre());
        }        
        for(Traductor traductor: traductores){
            modelo.addElement("Traductor    "+traductor.getNombre());
        }        
        lista.setModel(modelo);                
    }
    
    public void ponerAutorSeleccionado(String nombre){//nombre = "Autor    Isaac Asimov"
        AutorDB adb = new AutorDB();
        Autor autor = adb.getAutorByName(nombre);
        jframe.getCampoNombre().setText(autor.getNombre());
        jframe.getCampoFecha().setText(autor.getFechaNacimiento());
        jframe.getCampoNacionalidad().setText(autor.getNacionalidad());
    }
}
