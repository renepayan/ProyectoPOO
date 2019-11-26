/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author payan
 */
public abstract class Libro {    
    private String titulo;
    private int anioDePublicacion;
    private String isbn;
    private Autor autor;
    private Ilustrador ilustrador;
    private Traductor traductor;
    private String edicion;
    private String volumen;
    private String idioma;
    private Miniatura portada, contraPortada;
    private Editorial editorial;
    private Estadistica estadistica;
    private GeneroLiterario generos[];
    public abstract boolean guardarEnDB();
    public abstract boolean serLeido();

    public Libro(String titulo, int anioDePublicacion, String isbn, Autor autor, Ilustrador ilustrador, Traductor traductor, String edicion, String volumen, String idioma, Miniatura portada, Miniatura contraPortada, Editorial editorial, Estadistica estadistica, GeneroLiterario[] generos) {
        this.titulo = titulo;
        this.anioDePublicacion = anioDePublicacion;
        this.isbn = isbn;
        this.autor = autor;
        this.ilustrador = ilustrador;
        this.traductor = traductor;
        this.edicion = edicion;
        this.volumen = volumen;
        this.idioma = idioma;
        this.portada = portada;
        this.contraPortada = contraPortada;
        this.editorial = editorial;
        this.estadistica = estadistica;
        this.generos = generos;
    }

    public Libro(Libro libro){
        this(libro.getTitulo(), libro.getAnioDePublicacion(), libro.getIsbn(), libro.getAutor(), libro.getIlustrador(), libro.getTraductor(), libro.getEdicion(), libro.getVolumen(), libro.getIdioma(), libro.getPortada(), libro.getContraPortada(), libro.getEditorial(), libro.getEstadistica(),libro.getGeneros());
    }
    public Libro(){
        this(
                "El guardian entre el centeno",
                1951,
                "XXXXXXXXXXXXX",
                new Autor("J.D. Salinger","Norteamericana","1939-01-19"),
                new Ilustrador(),
                new Traductor(),
                "",
                "",
                "",
                new Miniatura(),
                new Miniatura(),
                new Editorial(),
                new Estadistica(),
                null
        );             
    }
    public void destroy(){
        System.gc();
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioDePublicacion() {
        return anioDePublicacion;
    }

    public void setAnioDePublicacion(int anioDePublicacion) {
        this.anioDePublicacion = anioDePublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Ilustrador getIlustrador() {
        return ilustrador;
    }

    public void setIlustrador(Ilustrador ilustrador) {
        this.ilustrador = ilustrador;
    }

    public Traductor getTraductor() {
        return traductor;
    }

    public void setTraductor(Traductor traductor) {
        this.traductor = traductor;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Miniatura getPortada() {
        return portada;
    }

    public void setPortada(Miniatura portada) {
        this.portada = portada;
    }

    public Miniatura getContraPortada() {
        return contraPortada;
    }

    public void setContraPortada(Miniatura contraPortada) {
        this.contraPortada = contraPortada;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

    public GeneroLiterario[] getGeneros() {
        return generos;
    }

    public void setGeneros(GeneroLiterario[] generos) {
        this.generos = generos;
    }
    @Override
    public String toString(){
        return "Titulo: "+titulo+"\n"+
               "Año de publicacion: "+anioDePublicacion+"\n"+
                "Ilustrador: "+ilustrador.toString()+"\n"+
                "Autor: "+autor.toString()+"\n"+
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
}
