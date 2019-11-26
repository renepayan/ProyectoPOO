/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Autor;
import Logica.Ilustrador;
import Logica.Libro;
import Logica.LibroElectronico;
import Logica.LibroFisico;
import Logica.Traductor;
import Persistencia.AutorDB;
import Persistencia.IlustradorDB;
import Persistencia.LibroElectronicoDB;
import Persistencia.LibroFisicoDB;

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
            modelo.addElement(autor.getNombre());
        }        
        lista.setModel(modelo);                
        lista = jframe.getListIlustradores();
        modelo = new DefaultListModel();
        for(Ilustrador ilustrador: ilustradores){
            modelo.addElement(ilustrador.getNombre());           
        }        
        lista.setModel(modelo);              
        lista = jframe.getListTraductores();
        modelo = new DefaultListModel();
        for(Traductor traductor: traductores){
            modelo.addElement(traductor.getNombre());
        }                
        lista.setModel(modelo);              
        jframe.setAutores(autores);
        jframe.setIlustradores(ilustradores);
        jframe.setTraductores(traductores);
        //Aqui van los libros osi osi
        LibroFisicoDB lbF = new LibroFisicoDB();
        LibroElectronicoDB lbE = new LibroElectronicoDB();
        
        
        List<LibroFisico> librosF= lbF.getLibrosBySearch(busqueda);
        List<LibroElectronico> librosE = lbE.getLibrosBySearch(busqueda);
        jframe.setLibros(libros);
        modelo = new DefaultListModel();
        for(Libro libro: libros){
            modelo.addElement(libro.getTitulo());
        }
        JList lista2 = jframe.getListLibros();
        lista2.setModel(modelo);
    }
    
    public void ponerObjetoDeLista(Object objeto){
        if(objeto instanceof Autor){
            ponerAutorSeleccionado((Autor)objeto);
        }else if(objeto instanceof Ilustrador){
            ponerIlustradorSeleccionado((Ilustrador)objeto);
        }else if(objeto instanceof Libro){
            ponerLibroSeleccionado((Libro)objeto);
        }else{
            ponerTraductorSeleccionado((Traductor)objeto);
        }
    }
    public void ponerLibroSeleccionado(Libro libro){
        jframe.getInfoLibroVolumen().setText(libro.getVolumen());
        jframe.getInfoLibroTitulo().setText(libro.getTitulo());
        jframe.getInfoLibroISBN().setText(libro.getIsbn());
        jframe.getInfoLibroEdicion().setText(libro.getEdicion());
        jframe.getInfoLibroEditorial().setText(libro.getEditorial().getNombre());
        jframe.getInfoLibroPuntuacion().setText(libro.getEstadistica().getCalificacion());
        
    }
    public void ponerAutorSeleccionado(Autor autor){//nombre = "Autor    Isaac Asimov"        
        jframe.getCampoNombre().setText(autor.getNombre());
        jframe.getCampoFecha().setText(autor.getFechaNacimiento());
        jframe.getCampoNacionalidad().setText(autor.getNacionalidad());
    }
    public void ponerTraductorSeleccionado(Traductor traductor){//nombre = "Autor    Isaac Asimov"        
        jframe.getCampoNombre().setText(traductor.getNombre());        
        jframe.getCampoNacionalidad().setText(traductor.getNacionalidad());
    }
    public void ponerIlustradorSeleccionado(Ilustrador ilustrador){
        jframe.getCampoNombre().setText(ilustrador.getNombre());                
    }
}
