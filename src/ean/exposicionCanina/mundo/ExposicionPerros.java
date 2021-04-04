/*
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Universidad Ean (Bogot� - Colombia)
  Unidad de Estudio: Desarrollo de Software
  <p>
  Proyecto Exposici�n Canina
  Fecha: Marzo de 2021
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.exposicionCanina.mundo;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Es la clase que se encarga de manejar, organizar, cargar y salvar los perros. <br>
 */
public class ExposicionPerros {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Este objeto representa la base de datos con los perros
     */
    private Dao<Perro, String> perros;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo manejador de perros vac�o.
     */
    public ExposicionPerros(Dao<Perro, String> tablaPerros) {
        perros = tablaPerros;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de perros. La lista que se retorna no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     */
    public Dao<Perro, String> darPerros() {
        return this.perros;
    }

    /**
     * Busca un perro seg�n su nombre y retorna el objeto Perro que tiene ese nombre. Retorna null si no encuentra
     * el perro con el nombre dado.
     */
    public Perro buscarPerro(String nombre) {
        // TODO: Busca un perro seg�n su nombre y retorna el objeto Perro que tiene ese nombre. Retorna null si no encuentra el perro
        for (Perro p : perros) {
            if(p.darNombre().toUpperCase().equals(nombre.toUpperCase()) == true){
                return p;
            }
        }
        return null;
    }

    /**
     * Agrega un nuevo perro a la exposici�n. <br>
     * <b>post: </b> El perro fue agregado a la exposici�n si no existe otro perro con el mismo nombre.
     */
    public boolean agregarPerro(String nombreP, String razaP, String imagenP, int puntosP, int edadP) {
        Perro perroBuscado = buscarPerro(nombreP);
        boolean agregado = false;
        if (perroBuscado == null) {
            Perro nuevoPerro = new Perro(nombreP, razaP, imagenP, puntosP, edadP);
            try {
                perros.create(nuevoPerro);
                agregado = true;
            }
            catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        return agregado;
    }

    /**
     * Busca el perro que tenga el mayor puntaje en la exposici�n.
     */
    public Perro buscarPerroMayorPuntaje() {
        Perro pMayorPuntaje = null;
        int max = 0;
        // TODO: Busca el perro que tenga el mayor puntaje en la exposici�n.
        for (Perro p : perros) {
            if(p.darPuntos() > max){
                pMayorPuntaje = p;
                max = p.darPuntos();
            }
        }

        return pMayorPuntaje;
    }

    /**
     * Busca el perro que tenga el menor puntaje en la exposici�n.
     */
    public Perro buscarPerroMenorPuntaje() {
        Perro pMenorPuntaje = null;
        int min = 1000;
        // TODO: Busca el perro que tenga el menor puntaje en la exposici�n.
        for (Perro p : perros) {
            if(p.darPuntos() < min){
                pMenorPuntaje = p;
                min = p.darPuntos();
            }
        }

        return pMenorPuntaje;
    }

    /**
     * Busca el perro que tenga la mayor edad.
     */
    public Perro buscarPerroMayorEdad() {
        Perro pMayorEdad = null;
        int max = 0;
        // TODO: Busca el perro que tenga la mayor edad.
        for (Perro p : perros) {
            if(p.darEdad() > max){
                pMayorEdad = p;
                max = p.darEdad();
            }
        }
        return pMayorEdad;
    }


    /**
     * Obtiene la cantidad de perros que pertenencen a la raza dada que se recibe como par�metro
     */
    public int contarPerrosRaza(String razaPerro) {
        int cont = 0;

        // TODO: Obtiene la cantidad de perros que pertenencen a la raza dada que se recibe como par�metro
        for (Perro p : perros) {
            if(p.darRaza().toUpperCase().equals(razaPerro.toUpperCase()) == true){
                cont += 1;
            }
        }

        return cont;
    }

    /**
     * Permite eliminar de la base de datos el perro que tiene el nombre dado
     */
    public void eliminarPerro(String nombreP) throws SQLException {
        // TODO: elimina de la base de datos el perro que tiene el nombre dado
        perros.deleteById(nombreP);
    }

    /**
     * Permite cambiarle los puntos asociados al perro con el nombre dado
     */
    public void cambiarPuntosPerro(String nombreP, int nuevosPuntos) throws SQLException {
        // TODO: cambia los puntos asociados al perro con el nombre dado
        Perro p = buscarPerro(nombreP);
        p.cambiarPuntos(nuevosPuntos);


        try {
            perros.update(p);
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        /*
        Perro perroBuscado = buscarPerro(nombreP);
        if (perroBuscado != null) {
            perroBuscado.cambiarPuntos(nuevosPuntos);
            //perros.updateId(perroBuscado, perroBuscado.darNombre());
            System.out.println("raza "+perroBuscado.darRaza()+"  imagen "+perroBuscado.darImagen()+" puntos "+perroBuscado.darPuntos()+" nombre "+perroBuscado.darNombre());
            perro
            perros.update(perroBuscado);
        }

         */
    }

    /**
     * Su misi�n es encontrar el primer perro en la base de datos que tenga una edad superior o igual a
     * la edad que se pasa como par�metro
     */
    public Perro buscarPerroPorEdad(int edad) {
        // TODO: encuentra el primer perro que tenga una edad superior o igual a la edad que se pasa como par�metro
        for (Perro p : perros) {
            if(p.darEdad() >= edad){
                return p;
            }
        }

        return null;
    }
}