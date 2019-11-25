/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

/**
 * @author Palacios Lugo Alan Yoltic                     
           Payan Tellez Rene 
           Zepeta Rivera José Antonio 

 */
public class Libro {

    public String getTitulo() {
        return titulo;
    }

    public int getAnioDePublicacion() {
        return anioDePublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public Autor[] getAutor() {
        return autor;
    }

    public Ilustrador getIlustrador() {
        return ilustrador;
    }

    public Traductor getTraductor() {
        return traductor;
    }

    public String getEdicion() {
        return edicion;
    }

    public String getVolumen() {
        return volumen;
    }

    public String getIdioma() {
        return idioma;
    }

    public Miniatura getPortada() {
        return portada;
    }

    public Miniatura getContraPortada() {
        return contraPortada;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public GeneroLiterario[] getGeneros() {
        return generos;
    }
    private String titulo; //Ya
    private int anioDePublicacion; //Ya
    private String isbn; //Ya
    private Autor autor[];  //Ya
    private Ilustrador ilustrador;
    private Traductor traductor;
    private String edicion; //Ya
    private String volumen; //Ya
    private String idioma; //Ya
    private Miniatura portada, contraPortada; //No
    private Editorial editorial; //Ya
    private Estadistica estadistica; //Ya
    private GeneroLiterario generos[];

    public Libro (){
        this("",0000,"","","","");
    }

    public Libro(String titulo, int anioDePublicacion, 
            String isbn, String edicion, String volumen, 
            String idioma) {
        this.titulo = titulo;
        this.anioDePublicacion = anioDePublicacion;
        this.isbn = isbn;        
        this.edicion = edicion;
        this.volumen = volumen;
        this.idioma = idioma;        
    }
    public Libro (Libro libro){
        titulo = libro.titulo;
        anioDePublicacion = libro.anioDePublicacion;
        isbn = libro.isbn;
        autor = libro.autor;
        ilustrador = libro.ilustrador;
        traductor = libro.traductor;
        edicion = libro.edicion;
        volumen = libro.volumen;
        idioma = libro.idioma;
        portada = libro.portada; 
        contraPortada = libro.contraPortada;
        editorial = libro.editorial;
        estadistica = libro.estadistica;
        generos = libro.generos;
    }

    public void destruir(){
        if(titulo != null)titulo = null;
        if(isbn != null)isbn = null;
        if(ilustrador != null)ilustrador = null;
        if(autor != null)autor = null;
        if(traductor != null)traductor = null;
        if(edicion != null)edicion = null;
        if(volumen != null)volumen = null;
        if(idioma != null)idioma = null;
        if(portada != null)portada = null;
        if(contraPortada != null)contraPortada = null;
        if(editorial != null)editorial = null;
        if(estadistica != null)estadistica = null;
        if(generos != null)generos = null;
        System.gc();
    }   

    @Override
    public String toString(){
        return "Titulo: "+titulo+"\n"+
               "Año de publicacion: "+anioDePublicacion+"\n"+
                "Ilustrador: "+ilustrador.toString()+"\n"+
                "Autor: "+autor[0].toString()+"\n"+
                "Traductor: "+traductor.toString()+"\n"+
                "Edicion: "+edicion+"\n"+
                "Volumen: "+volumen+"\n"+
                "Idioma: "+idioma+"\n"+
                "Portada: "+portada.toString()+"\n"+
                "Contraportada: "+contraPortada.toString()+"\n"+
                "Editorial: "+editorial.toString()+"\n"+
                "Estadistica: "+estadistica.toString()+"\n"+
                "Genero: "+generos[0].toString()+"\n";
    }   
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Libro)) return false;
        Libro libro = (Libro) obj;
        return titulo.equals(libro.titulo) && anioDePublicacion == libro.anioDePublicacion &&
                ilustrador.equals(libro.ilustrador) && autor[0].equals(libro.autor[0]) &&
                traductor.equals(libro.traductor) && edicion.equals(libro.edicion) &&
                volumen.equals(libro.volumen) && idioma.equals(libro.idioma) &&
                portada.equals(libro.portada) && contraPortada.equals(libro.contraPortada) &&
                editorial.equals(libro.editorial) && estadistica.equals(libro.estadistica) &&
                generos[0].equals(libro.generos[0]);
    }   
    void establecer(){
        System.out.println("estableciendo libro...");
    }
    
    void establecer(Libro libro){
        establecer();
        setAutor(libro.autor);
        setIlustrador(libro.ilustrador);
        setTraductor(libro.traductor);
        setPortada(libro.portada);
        setContraPortada(libro.contraPortada);
        setEditorial(libro.editorial);
        setEstadistica(libro.estadistica);
        setGeneros(libro.generos);
    }
    public void setAutor(Autor[] autor) {
        this.autor = autor;
    }

    public void setIlustrador(Ilustrador ilustrador) {
        this.ilustrador = ilustrador;
    }

    public void setTraductor(Traductor traductor) {
        this.traductor = traductor;
    }

    public void setPortada(Miniatura portada) {
        this.portada = portada;
    }

    public void setContraPortada(Miniatura contraPortada) {
        this.contraPortada = contraPortada;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

    public void setGeneros(GeneroLiterario[] generos) {
        this.generos = generos;
    }
    
}
