/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Unidad de Estudio: Desarrollo de Software
 * <p>
 * Proyecto Exposici�n Canina
 * Fecha: Marzo de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.exposicionCanina.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Este es el panel donde se encuentran los botones para realizar los ordenamientos por distintos criterios y las b�squedas.
 */
public class PanelBusquedaOrdenamientos extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String BUSCAR = "Buscar";

    private static final String CAMBIAR_PUNTOS = "CambiarPuntos";

    private static final String BUSCAR_EDAD = "BuscarEdad";

    private static final String ELIMINAR = "Eliminar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazExposicionCanina principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es el bot�n para ordenar la lista de perros por raza
     */
    private JButton botonEliminar;

    /**
     * Es el bot�n para ordenar la lista de perros por puntos
     */
    private JButton botonCambiarPuntos;

    /**
     * Es el bot�n para ordenar la lista de perros por edad
     */
    private JButton buscarPorEdad;

    /**
     * Es el bot�n para realizar una b�squeda
     */
    private JButton botonBuscar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes.
     * @param ventanaPrincipal es una referencia a la clase principal de la interfaz - ventanaPrincipal != null
     */
    public PanelBusquedaOrdenamientos(InterfazExposicionCanina ventanaPrincipal) {
        principal = ventanaPrincipal;

        setPreferredSize(new Dimension(200, 0));
        setBorder(new CompoundBorder(new EmptyBorder(4, 3, 3, 3), new TitledBorder("Buscar y Modificar")));
        setLayout(new GridBagLayout());

        botonEliminar = new JButton("Eliminar Perro");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.fill = GridBagConstraints.BOTH;
        botonEliminar.setActionCommand(ELIMINAR);
        botonEliminar.addActionListener(this);
        add(botonEliminar, gbc);

        botonCambiarPuntos = new JButton("Cambiar Puntos Perro");
        botonCambiarPuntos.setActionCommand(CAMBIAR_PUNTOS);
        botonCambiarPuntos.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(botonCambiarPuntos, gbc);

        buscarPorEdad = new JButton("Buscar por Edad");
        buscarPorEdad.setActionCommand(BUSCAR_EDAD);
        buscarPorEdad.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(buscarPorEdad, gbc);

        botonBuscar = new JButton("Buscar Perro");
        botonBuscar.setActionCommand(BUSCAR);
        botonBuscar.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(botonBuscar, gbc);
    }

    /**
     * Ejecuta una acci�n seg�n el bot�n que se haya presionado.
     * @param evento es el evento de click sobre un bot�n
     */
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();

        if (ELIMINAR.equals(comando)) {
            principal.eliminarPerroSeleccionado();
        }
        else if (CAMBIAR_PUNTOS.equals(comando)) {
            principal.cambiarPuntosPerroSeleccionado();
        }
        else if (BUSCAR_EDAD.equals(comando)) {
            principal.buscarPorEdad();
        }
        else if (BUSCAR.equals(comando)) {
            principal.buscar();
        }
    }
}
