/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Autor;
import Persistencia.AutorDB;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author payan
 */
public class ControladorLibro {
    private JFrame jframe;
    public ControladorLibro(JFrame jframe){
        this.jframe = jframe;
    }
    public void ponerAutores(JComboBox jcombo){
        jcombo.removeAllItems();
        AutorDB adb = new AutorDB();
        List<Autor> autores = adb.getAutores();
        for(Autor autor: autores){
            jcombo.addItem(autor.getNombre());
        }
    }
}
