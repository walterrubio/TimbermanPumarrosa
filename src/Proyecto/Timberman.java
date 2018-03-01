package Proyecto;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Clase que contendra las imagenes del personaje y sus coordenadas en X y en Y
 * @author Walter rubio, Paola Perez
 */
public class Timberman {

    Image timber1, timber2, timberder, timberiz;
    int posx, posy;

    /**
     * se cargan las imagenes
     */
    public Timberman() {


        try {
            timber1 = ImageIO.read(new File("src/imagenes/timbermann1.png"));
            timber2 = ImageIO.read(new File("src/imagenes/timbermann2.png"));
            timberder = ImageIO.read(new File("src/imagenes/timbermanderr.png"));
            timberiz = ImageIO.read(new File("src/imagenes/timbermnanniz.png"));
        } catch (IOException e) {
            System.out.println("No se encontro la imagen" + e);
        }
    }
}