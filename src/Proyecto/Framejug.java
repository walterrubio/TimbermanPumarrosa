package Proyecto;

import java.awt.Image;
import java.io.IOException;
import javax.swing.*;

/**
 * Frame que va a contener el metodo para llamar a mi Lamina de Juego
 * @author Walter rubio, Paola Perez
 */
public class Framejug extends JFrame implements Valores{
    
    Lamina jug;
    Image portada;
    
    /**
     * Se inicializan los valores del Frame 
     * @throws IOException En caso de que no se encuentre el archivo de texto donde
     * se ha guardado el nombre de usuario
     */
    public Framejug() throws IOException {
        this.jug = new Lamina();
             
        super.setTitle("Timberman.exe");
        super.setSize(ancho, alto);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/imagenes/i2.png")).getImage();
        super.setIconImage(icono);
    }
    /**
     * Se añada el Frame de la Lamina de juego
     */
        public void correr() {        
        add(jug);       
        super.setVisible(true);
    }
}
