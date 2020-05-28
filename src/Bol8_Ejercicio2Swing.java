//Bol8_Ejercicio2 - Álvaro Rodríguez Vila
// ESTE EJERCICIO NO CUENTA, ESTÁ INACABADO

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Bol8_Ejercicio2Swing extends JFrame implements ActionListener {
    JButton cambiar;
    JButton crear;
    JButton mostrar;
    JButton anadir;
    JButton borrar;
    JButton salir;
    StringWriter mostrartxt;
    Scanner sc = null;
    String rutaMostrar;

    public Bol8_Ejercicio2Swing() {
        super("Ejercicio 2");
        this.setLayout(new FlowLayout());

        cambiar = new JButton("Cambiar archivo");
        cambiar.addActionListener(this);
        cambiar.setSize(cambiar.getPreferredSize());
        cambiar.setToolTipText("Cambia el archivo a gestionar");
        this.add(cambiar);

        crear = new JButton("Crear archivo");
        crear.addActionListener(this);
        crear.setSize(crear.getPreferredSize());
        crear.setToolTipText("Crea o sobreescribe un archivo");
        this.add(crear);

        mostrar = new JButton("Mostrar archivo");
        mostrar.addActionListener(this);
        mostrar.setSize(mostrar.getPreferredSize());
        mostrar.setToolTipText("Muestra el contenido de un archivo");
        this.add(mostrar);

        anadir = new JButton("Añadir contenido");
        anadir.addActionListener(this);
        anadir.setSize(anadir.getPreferredSize());
        anadir.setToolTipText("Añade contenido al final de un archivo");
        this.add(anadir);

        borrar = new JButton("Borrar archivo");
        borrar.addActionListener(this);
        borrar.setSize(borrar.getPreferredSize());
        borrar.setToolTipText("Borra un archivo");
        this.add(borrar);

        salir = new JButton("Salir");
        salir.addActionListener(this);
        salir.setSize(salir.getPreferredSize());
        salir.setToolTipText("Finaliza el programa");
        this.add(salir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String home = System.getProperty("user.home");
        PrintWriter archivo;
        
        try {
            if (e.getSource() == cambiar) {
                String ruta = (String) JOptionPane.showInputDialog(null, "Escribe la ruta del archivo a gestionar");
                archivo = new PrintWriter(ruta);
            }
        } catch (FileNotFoundException e1) {
            JOptionPane.showMessageDialog(null, "Ruta errónea. No se podido encontrar el archivo", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            if (e.getSource() == crear) {
                String nombre = (String) JOptionPane.showInputDialog(null, "Escribe el nombre del archivo");
                if (nombre == nombre) {
                    int confirmar = JOptionPane.showConfirmDialog(null,
                            "Ya existe un archivo con ese nombre, ¿quieres sobreescribirlo?", "Ojo cuidado",
                            JOptionPane.YES_NO_OPTION);
                    if (confirmar == JOptionPane.YES_OPTION) {
                        archivo = new PrintWriter(home + nombre + ".txt");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha creado el archivo", "Información",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    archivo = new PrintWriter(home + nombre + ".txt");
                }
            }
        } catch (FileNotFoundException e1) {
            JOptionPane.showMessageDialog(null, "No se ha podido crear el archivo", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        } finally {
            if (archivo != null) {
                try {
                    archivo.close();
                } catch (Exception e2) {
                    System.err.println("Error");
                }
            }
        }

        if (e.getSource() == mostrar) {
            String ruta = (String) JOptionPane.showInputDialog(null, "Escribe la ruta del archivo que quieras leer");
            try {
                archivo = new PrintWriter(ruta);
            } catch (FileNotFoundException e2) {
                JOptionPane.showMessageDialog(null, "Ruta errónea. No se podido encontrar el archivo", "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
            }
            rutaMostrar = mostrartxt.toString();
            try (Scanner archivo = new Scanner(new File(rutaMostrar))) {
                while (archivo.hasNext()) {
                    ruta = ruta + archivo.nextLine();
                    JOptionPane.showMessageDialog(null, ruta, "Contenido", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Ruta errónea. No se podido encontrar el archivo", "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == anadir) {
            
        }
    }
}