/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Autor;
import Persistencia.AutorDB;
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
        
        List<Autor> autores = adb.getAutoresBySearch(busqueda);
        for(Autor autor: autores){
            modelo.addElement(autor.getNombre());
        }        
        lista.setModel(modelo);                
    }
}
