package Proyecto;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 * Clase Principal que hereda de JFrame y va a contener los componentes del Panel del Menu
 * @author Walter rubio, Paola Perez
 */
public class Ventana extends JFrame implements Valores{
    
    /**
     * Se da valor por primera vez a los componentes de la ventana del panel inicial
     * y se añade el panel Inicio
     * @author Walter rubio, Paola Perez
     */
    public Ventana(){
        
        super.setTitle("TIMBERMAN.exe");
        super.setSize(ancho,alto);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/imagenes/i2.png")).getImage();
        super.setIconImage(icono);   
        Inicio i = new Inicio();
        add(i);
        super.setVisible(true);  
        
    }

    public static void main(String[] args) {
        new Ventana();
    }   
}