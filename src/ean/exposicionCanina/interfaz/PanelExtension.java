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
 * Es el panel que contiene los botones de extensi�n
 */
public class PanelExtension extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para el bot�n 1
     */
    private final String OPCION_1 = "opcion 1";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia a la interfaz de la aplicaci�n
     */
    private InterfazExposicionCanina principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el bot�n 1
     */
    private JButton botonOpcion1;


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con una referencia a la ventana principal de la aplicaci�n.
     * @param iec es una referencia a la ventana principal - ie!=null
     */
    public PanelExtension(InterfazExposicionCanina iec) {
        principal = iec;
        inicializar();
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa los componentes del panel. <br>
     * <b>post: </b> Se inicializaron y se ubicaron los componentes del panel.
     */
    private void inicializar() {
        setBorder(new TitledBorder("Finalizar programa"));

        setLayout(new FlowLayout());
        botonOpcion1 = new JButton("Salir");
        botonOpcion1.setActionCommand(OPCION_1);
        botonOpcion1.addActionListener(this);

        add(botonOpcion1);
    }

    /**
     * Este m�todo se llama cuando se presiona uno de los botones.
     * @param event es el evento del click en el bot�n
     */
    public void actionPerformed(ActionEvent event) {
        String comando = event.getActionCommand();
        if (OPCION_1.equals(comando)) {
            principal.reqFuncOpcion1();
        }
    }

}
