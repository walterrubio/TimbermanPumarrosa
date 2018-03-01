package Proyecto;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * Panel que tiene lo referente a las instrucciones del juego
 * @author Walter Rubio, Paola Perez
 */
public class Instrucciones extends JPanel implements Valores {
    
    Image portada;
    JTextArea inst, t_cred4;
    JButton b_volver;
    Font fuente;
      /**
       * Se incializa y se da valor a los componentes del panel de instrucciones
       */    
    public Instrucciones(){
        
        setLayout(null);
        super.setSize(ancho, alto);
        super.setLocation(0,0);
        fuente = new Font("Impact", Font.BOLD, 14); 
  
        
        try {
            portada = ImageIO.read(new File("src/imagenes/fondoinst3.jpg"));
        } catch (IOException e) {
            System.err.println("No se encontro la imagen: " + e);
        }  
        
        inst = new JTextArea("              LA TEMPORADA DE PUMARROSAS HA LLEGADO A LA UNET!!!\n\n\n\n\n" +
                             "               AGARRA EL HACHA, PONTE LAS BOTAS Y A BAJAR PUMARROSAS!\n" +
                             "          EL JUEGO CONSISTE EN BAJAR LA MAYOR CANTIDAD DE PUMARROSAS \n" +
                             "      CORTANDO LAS RAMAS DE LOS ARBOLES DE LA UNIVERSIDAD \n" +
                             "    PERO TEN CUIDADO! DEBES EVITAR QUE LAS RAMAS TE CAIGAN ENCIMA! \n"+                
                             "         TIENES QUE MOVERTE DE LADO A LADO ESQUIVANDO LAS RAMAS,\n\n" +
                             "    PARA ELLO PULSA LAS FLECHAS DIRECCIONALES (IZQUIERDA O DERECHA)\n" +
                             "    O PULSA EN PANTALLA CON EL RATON EN EL LADO DEL ARBOL AL CUAL\n" +
                             "    QUIERES CORTAR. \n" +
                             "     TIENES QUE BAJAR BAJAR LA MAYOR CANTIDAD DE PUMARROSAS\n" +
                             "     ANTES QUE LA BARRA DE ENERGIA LLEGUE A 0!\n"+
                             "     PULSA ''R'' PARA REINICIAR\n"+
                             "     PULSA ''ESC'' PARA SALIR");
        
        inst.setBounds(80, 90, 1000, 1000);
        inst.setEditable(false);
        inst.setOpaque(false);
        inst.setFont(fuente);
        inst.setForeground(Color.black.darker());
        
        b_volver = new JButton("Volver");
        b_volver.setBounds(25, 500, 70, 35);
        b_volver.setBackground(Color.yellow);
        b_volver.addActionListener(escuchante);
        
        t_cred4 = new JTextArea("Copyright© 2018 W&PProductions. All rights reserved.");
        t_cred4.setOpaque(false);
        t_cred4.setForeground(Color.black);
        t_cred4.setFont(new Font("", Font.BOLD, 11));
        t_cred4.setEditable(false);
        t_cred4.setBounds(135, 550, 1000, 1000);         
        
        add(b_volver);
        add(inst);
        add(t_cred4);
        
        super.setVisible(true);       
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
            Instrucciones.super.removeAll();
            Instrucciones.super.add(i);
            Instrucciones.super.revalidate();
            Instrucciones.super.repaint();
        }
    };     
}
