package Proyecto;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Clase que contendra las imagenes del tronco y sus coordenadas en X y en Y
 * @author Walter rubio, Paola Perez
 */
public class Tronco {
    
    Image tronco1, tronco2, tronco3, tronco4, tronco5, tronco6, tronco7, tronco8, tronco_base;
    int posx, posy, num;
    /**
     * se cargan las imagenes, se genera un numero random para cargar cierta imagen 
     */    
    public Tronco(){
        
         num = (int) (Math.random() * 3+1);
        try{
          
            tronco1 = ImageIO.read(new File("src/imagenes/tro1.png"));
            
            tronco2 = ImageIO.read(new File("src/imagenes/tro"+num+".png"));
            tronco3 = ImageIO.read(new File("src/imagenes/tro"+num+".png"));
            tronco4 = ImageIO.read(new File("src/imagenes/tro"+num+".png"));
            tronco5 = ImageIO.read(new File("src/imagenes/tro"+num+".png"));
            tronco6 = ImageIO.read(new File("src/imagenes/tro"+num+".png"));
            tronco7 = ImageIO.read(new File("src/imagenes/tro"+num+".png"));
            tronco8 = ImageIO.read(new File("src/imagenes/tro"+num+".png"));
            
            tronco_base = ImageIO.read(new File("src/imagenes/tro1.png"));
            
        } catch (IOException e) {
            System.out.println("No se encontro la imagen" + e);
        }
    }
 
    /**
     * metodo para volver a pintar las imagenes de los troncos y nuevas posiciones ramdon
     * @param n random entre 1 y 3 para intercalar las imagenes disponibles del tronco
     */
    public void setimage(int n){
        int r;
        num=0;
        num = (int) (Math.random() * 3+1);
        try{
        switch(n){
            case 1:
                //tronco_base = ImageIO.read(new File("src/imagenes/tro"+r+".png"));
                break;
            case 2:
                tronco2=ImageIO.read(new File("src/imagenes/tro"+num+".png"));
                break;
            case 3:
                //tronco_base=ImageIO.read(new File("src/imagenes/tro"+r+".png"));
                break;
            case 4:
                tronco3=ImageIO.read(new File("src/imagenes/tro"+num+".png"));
                break;
            case 5:
                //tronco_base=ImageIO.read(new File("src/imagenes/tro"+r+".png"));
                break;
            case 6:
                tronco4=ImageIO.read(new File("src/imagenes/tro"+num+".png"));
                break;
            case 7:
                //tronco_base=ImageIO.read(new File("src/imagenes/tro"+r+".png"));
                break;
            case 8:
                tronco5=ImageIO.read(new File("src/imagenes/tro"+num+".png"));
                break;
            case 9:
                //tronco_base=ImageIO.read(new File("src/imagenes/tro"+r+".png"));
                break;
            case 10:
                tronco6=ImageIO.read(new File("src/imagenes/tro"+num+".png"));
                break;
            case 11:
                //tronco_base=ImageIO.read(new File("src/imagenes/tro"+r+".png"));
                break;
            case 12:
                tronco7=ImageIO.read(new File("src/imagenes/tro"+num+".png"));
                break;
            case 13:
                tronco8=ImageIO.read(new File("src/imagenes/tro"+num+".png"));
                break;
            case 14:
                //tronco_base=ImageIO.read(new File("src/imagenes/tro"+r+".png"));
                break;
                
        }
        } catch (IOException e) {
            System.out.println("No se encontro la imagen" + e);
        }
    }
    
}