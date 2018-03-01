package Proyecto;

import java.applet.AudioClip;
import java.awt.Image;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * Frame que va a contener el Panel del juego principal
 * @author Walter rubio, Paola Perez
 */
public class Lamina extends JFrame implements Valores {
   Jugar panel;
   AudioClip sonido;
   Timer t, tgo, tfondos;
   /**
    * Se agrega el panel del juego, se coloca el fondo musical y se añade el icono del juego 
    * @throws IOException en caso de que no se encuentre el archivo.txt para guardar la mejor puntuacion
    */
   public Lamina() throws IOException{
       
        panel = new Jugar();
        t = new Timer(1, escuchante);
        tgo = new Timer(1, escuchante2);
        tfondos = new Timer(1, escuchante3);
        t.start();
        tfondos.start();
               
        super.setTitle("Timberman.exe");
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setSize(ancho, alto);
        super.setLocationRelativeTo(this);
        super.setResizable(false); 
        super.add(panel);
        super.setVisible(true); 
       
       Image icono = new ImageIcon(getClass().getResource("/imagenes/i2.png")).getImage();
       super.setIconImage(icono); 
       
       sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Proyecto/theme.wav"));
       sonido.loop(); 
    
   }
   
   /**
    * Escuchante para poder cerrar el panel del juego
    * Validar el efecto de sonido de perder una vida
    * Si se esta jugando se le dan posiciones a los componentes de puntuacion
    * Si pierde se le dan nuevas posiciones a los componentes y se guarda y verifica la mejor puntuacion
    */
    ActionListener escuchante = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
           if(panel.num==0&&panel.p1y<=323){
               panel.fx2.play();
           } 
           
            if(panel.aux_cerrar==1){
                Lamina.super.setVisible(false);
                sonido.stop();
            }
            
            if(panel.vida==1&&panel.num>0){
                panel.p1x = 277; 
                panel.posxlrein=-200;
                if (panel.puntuacion >= 10) {
                    panel.p1x = 265;
                }
                if (panel.puntuacion >= 100) {
                    panel.p1x = 253;
                }                 
                panel.p1y = 320;
                panel.p2x = 277;
                panel.p2y = -1000;
                panel.posxgo = 150;
                panel.posygo = -536; 
                System.out.println(panel.vida);
            }
                   
            if (panel.num <=0 || panel.vida==0) {
                panel.vida=0;
                panel.num=0;
                
                panel.posxlrein=500;
                tgo.start();            
                panel.current.setVisible(false);
                //leer 
                try {
                    int numero;
                    FileReader r = new FileReader("src/Resultado/resultado.txt");
                    BufferedReader bf = new BufferedReader(r);
                    String temp = " ";
                    while (temp != null) {
                        temp = bf.readLine();
                        if (temp == null) {
                            break;
                        }
                        numero = Integer.parseInt(temp);
                        panel.puntuacion_mayor = numero;
                        if (panel.puntuacion > numero) { //guardar
                            panel.puntuacion_mayor = panel.puntuacion;
                            File f;
                            f = new File("src/Resultado/resultado.txt");

                            try {
                                FileWriter w = new FileWriter(f);
                                BufferedWriter bw = new BufferedWriter(w);
                                PrintWriter wr = new PrintWriter(bw);
                                wr.write("" + panel.puntuacion);
                                wr.close();
                                bw.close();

                            } catch (Exception e) {
                                System.out.println("");
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            repaint();
        }
    };
    /**
     * Animacion para bajar el aviso de GAME OVER y darle nuevas posiciones a las etiquetas de
     * puntuacion y mejor puntuacion
     */
    ActionListener escuchante2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {

            if (panel.posygo < 0) {
                panel.posygo += 10;}

            if (panel.p1y < 410) {
                panel.p1y += 2;
                if (panel.puntuacion>= 10) {
                    panel.p1x = 265;
                }
                if (panel.puntuacion >= 100) {
                    panel.p1x = 253;
                }             
            }

            if (panel.p2y < 320) {
                panel.p2y += 10;
                if (panel.puntuacion_mayor>= 10) {
                    panel.p2x = 265;
                }
                if (panel.puntuacion_mayor >= 100) {
                    panel.p2x = 253;
                } 
            }
          
        }
    };
    /**
     * Animacion para cambiar las fondos y aparecer la etique de Reiniciar
     */
    ActionListener escuchante3 = new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent ae) {
                
               if(panel.puntuacion>30){     
               if(panel.posvalor_fondo1<600)
                   panel.posvalor_fondo1++;
               }             
               if(panel.posvalor_fondo1>=2){
                   if(panel.posvalor_fondo2<0)
                       panel.posvalor_fondo2++;
               }
               
         
               if(panel.puntuacion>60){
                   if(panel.posvalor_fondo2<600)
                       panel.posvalor_fondo2++;
               }              
               if(panel.posvalor_fondo2>=2){
                   if(panel.posvalor_fondo3<0)
                       panel.posvalor_fondo3++;
               }
               

               if(panel.puntuacion>90){
                   if(panel.posvalor_fondo3<600)
                       panel.posvalor_fondo3++;
               }              
               if(panel.posvalor_fondo3>=2){
                   if(panel.posvalor_fondo4<0)
                       panel.posvalor_fondo4++;
               }              
               
               
               if(panel.puntuacion>120){
                   if(panel.posvalor_fondo4<600)
                       panel.posvalor_fondo4++;
               }              
               if(panel.posvalor_fondo4>=2){
                   if(panel.posvalor_fondo5<0)
                       panel.posvalor_fondo5++;
               }       
               
               if(panel.puntuacion>150){
                   if(panel.posvalor_fondo5<600)
                       panel.posvalor_fondo5++;
               }              
               if(panel.posvalor_fondo5>=2){
                   if(panel.posvalor_fondo6<0)
                       panel.posvalor_fondo6++;
               }      
               
               
               if(panel.puntuacion>180){
                   if(panel.posvalor_fondo6<600)
                       panel.posvalor_fondo6++;
               }              
               if(panel.posvalor_fondo6>=2){
                   if(panel.posvalor_fondo7<0)
                       panel.posvalor_fondo7++;
               }      
               
               if(panel.puntuacion>210){
                   if(panel.posvalor_fondo7<600)
                       panel.posvalor_fondo7++;
               }              
               if(panel.posvalor_fondo7>=2){
                   if(panel.posvalor_fondo8<0)
                       panel.posvalor_fondo8++;
               }      
               
               
               if(panel.puntuacion>240){
                   if(panel.posvalor_fondo8<600)
                       panel.posvalor_fondo8++;
               }              
               if(panel.posvalor_fondo8>=2){
                   if(panel.posvalor_fondo9<0)
                       panel.posvalor_fondo9++;
               }   
       }
   };  
   }