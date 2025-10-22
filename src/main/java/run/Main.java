package run;

import entities.*;
import services.interfaces.ICRUD;
import services.dao.MyDao;

import java.util.List;

public class Main {

    public static final ICRUD dao = new MyDao();

    public static void insertarAutor() {
        Autor autor = new Autor();
        autor.setNombre("Gabriel García Márquez");
        autor.setNacionalidad("Colombiana");
        dao.insert(autor);

        Autor autor2 = new Autor();
        autor2.setNombre("Isabel Allende");
        autor2.setNacionalidad("Colombiana");
        dao.insert(autor2);
    }

    public static void listarAutores(){

        System.out.println("Registros almacenados");
        List<Autor> autores = dao.getALL("autores.ALL", Autor.class);
        autores.forEach(autor -> System.out.println(autor.getNombre()));
    }

    public static void actualizarAutor(){
        Autor autor = new Autor();
        autor = dao.findById(1, Autor.class);
        autor.setNacionalidad("Argentina");
        dao.update(autor);
    }

    public static void eliminarAutor(){
        Autor autor = new Autor();
        autor = dao.findById(2, Autor.class);
        dao.delete(autor);
    }

    // Punto de entrada de la aplicación
    public static void main(String[] args) {
        insertarAutor();
        listarAutores();
        actualizarAutor();
        listarAutores();
        eliminarAutor();
        listarAutores();
    }
}
