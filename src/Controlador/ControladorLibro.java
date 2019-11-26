/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Autor;
import Logica.Editorial;
import Logica.Estadistica;
import Logica.GeneroLiterario;
import Logica.Ilustrador;
import Logica.Libro;
import Logica.Traductor;
import Persistencia.AutorDB;
import Persistencia.EditorialDB;
import Persistencia.EstadisticaDB;
import Persistencia.GeneroLiterarioDB;
import Persistencia.IlustradorDB;
import Persistencia.TraductorDB;
import Vista.VentanaPrincipal;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author payan
 */
public class ControladorLibro {
    private VentanaPrincipal jframe;
    public ControladorLibro(JFrame jframe){
        this.jframe = (VentanaPrincipal)jframe;
    }
    public void insertarLibro(){
        /*Libro libro = new Libro(jframe.getCampoTituloLibro().getText(),
                Integer.parseInt(jframe.getCampoAnioPublicacionLibro().getText()),jframe.getCampoIsbnLibro().getText(),
                jframe.getCampoEdicionLibro().getText(),jframe.getCampoVolumenLibro().getText(),jframe.getCampoIdiomaLibro().getText());        
        LibroDB ldb = new LibroDB();
        EditorialDB edb = new EditorialDB();        
        AutorDB adb = new AutorDB();
        libro.setEditorial(edb.getEditorialByName((String) jframe.getCampoEditorialLibro().getSelectedItem()));        
        libro.setAutor(adb.getAutorByName((String)jframe.getComboBoxAutores().getSelectedItem()));
        EstadisticaDB e1db = new EstadisticaDB();
        Estadistica estadistica = new Estadistica(0, "100", null);
        System.out.println(estadistica.getId()+"");
        e1db.addEstadistica(estadistica);
        libro.setEstadistica(estadistica);
        ldb.addLibro(libro);        
        GeneroLiterarioDB gdb = new GeneroLiterarioDB();
        for(String str: jframe.getListGeneros().getSelectedValuesList()){
            gdb.linkGeneroToLibro(gdb.getGeneroLiterarioByName(str), libro);
        }*/
        //AQUI DEBES DE HACER EL IF ENTRE LIBRO ELECTRONICO Y LIBRO FISICO
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
    public void ponerEditoriales(){
        JComboBox jcombo = jframe.getCampoEditorialLibro();
        jcombo.removeAllItems();
        EditorialDB edb = new EditorialDB();
        List<Editorial> editoriales = edb.getEditoriales();
        for(Editorial editorial: editoriales){
            jcombo.addItem(editorial.getNombre());
        }
        jcombo.addItem("Desconocido");        
    }
    public void ponerGeneros(){
        JList<String> jlist = jframe.getListGeneros();
        jlist.removeAll();
        GeneroLiterarioDB gdb = new GeneroLiterarioDB();
        List<GeneroLiterario> generos = gdb.getGeneros();                
        int i = 1;
        for(GeneroLiterario genero: generos){            
            i++;
        }        
        String[] test = new String[i];
        i = 0;
        for(GeneroLiterario genero: generos){
            test[i++] = genero.getNombre();
        }
        test[i] = "Desconocido";
        jlist.setModel(new javax.swing.AbstractListModel<String>() {            
            public int getSize() { return test.length; }
            public String getElementAt(int i) { return test[i]; }
        });
    }
}
