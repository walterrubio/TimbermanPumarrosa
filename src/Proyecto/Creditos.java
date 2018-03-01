package Proyecto;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * Panel que tiene lo referente a los creditos del juego
 * @author Walter Rubio, Paola Perez
 */
public class Creditos extends JPanel implements Valores {
    
    Image portada;  
    JTextArea t_cred, t_cred2, t_cred3, t_cred4;
    JButton b_volver;
      /**
       * Se incializa y se da valor a los componentes del panel de creditos
       */
    public Creditos(){
       
        setLayout(null);
        super.setSize(ancho, alto);
        super.setLocation(0, 0); 
        
        try {
            portada = ImageIO.read(new File("src/imagenes/fondocred1.jpg"));
        } catch (IOException e) {
            System.err.println("No se encontro la imagen: " + e);
        }

        t_cred = new JTextArea("UNIVERSIDAD NACIONAL EXPERIMENTAL DEL TACHIRA\n"
                + "     DEPARTAMENTO DE INGENIERÍA EN INFORMÁTICA\n"
                + "                   PROGRAMACIÓN I LAPSO 2018-1\n"
                + "PROYECTO FINAL - 4 TA EVALUACIÓN 15% (100 PUNTOS)");

        t_cred.setOpaque(false);
        t_cred.setForeground(Color.black);
        t_cred.setFont(new Font("", Font.BOLD, 12));
        t_cred.setEditable(false);
        t_cred.setBounds(150, 20, 1000, 1000);
        
        t_cred2 = new JTextArea("Proyecto inspirado en el juego arcade 'TIMBERMAN' EDICION UNET usando\n"
                + " sus escenarios y uniforme del personal y sus caracteristicas pumarrosas\n"
                + "diseñado para ser multiplataforma sistema IOS y computadores personales. ");  
        t_cred2.setOpaque(false);
        t_cred2.setForeground(Color.black);
        t_cred2.setFont(new Font("", Font.BOLD, 12));
        t_cred2.setEditable(false);
        t_cred2.setBounds(100, 230, 1000, 1000);
        
        t_cred3 = new JTextArea("Desarrolladores:\n"
        + "Paola Perez\n"
        + "Walter Rubio\n");
        t_cred3.setOpaque(false);
        t_cred3.setForeground(Color.black);
        t_cred3.setFont(new Font("", Font.BOLD, 12));
        t_cred3.setEditable(false);
        t_cred3.setBounds(450, 430, 1000, 1000); 
        
        
        t_cred4 = new JTextArea("Copyright© 2018 W&PProductions. All rights reserved.");
        t_cred4.setOpaque(false);
        t_cred4.setForeground(Color.black);
        t_cred4.setFont(new Font("", Font.BOLD, 11));
        t_cred4.setEditable(false);
        t_cred4.setBounds(135, 550, 1000, 1000);         
        
        b_volver = new JButton("Volver");
        b_volver.setBounds(25, 500, 70, 35);
        b_volver.setBackground(Color.yellow);
        b_volver.addActionListener(escuchante);

        add(b_volver);
        add(t_cred);
        add(t_cred2);
        add(t_cred3);  
        add(t_cred4);  
    }
    /**
     * Metodo para pìntar la imagen de portada
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(portada, 0, 0, this);
    }
/**
 * Metodo para detectar que se ha dado click en el boton
 */
    ActionListener escuchante = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Inicio i = new Inicio();
            Creditos.super.removeAll();
            Creditos.super.add(i);
            Creditos.super.revalidate();
            Creditos.super.repaint();
        }
    };    
}
