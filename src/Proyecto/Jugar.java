package Proyecto;

import static Proyecto.Valores.alto;
import static Proyecto.Valores.tposystd;
import static Proyecto.Valores.troposxstd;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 * Panel principal donde se desarrolla el juego
 * @author Walter Rubio, Paola Perez
 */
public class Jugar extends JPanel implements Valores {
  
    AudioClip fx, fx2; //efecto de sonido de cortar el arbol y perder una vida respectivamente        
    int aux_cerrar=0; //auxiliar para cerrar el juego  
    Timberman t1, t2, td, ti; //memoria a las 4 posiciones del personaje    
    Tronco tronco1, tronco2, tronco3, tronco4, tronco5, tronco6, tronco7, tronco8; //memoria a los objetos de tronco que pueden contener una imagen aleatoria entre los 3 troncos posibles
    Tronco tr1, tr2, tr3, tr4, tr5, tr6, tr7;  //memoria a los objetos de tronco que por defecto tendra el tronco base
    Tronco tr_volador;//memoria a la animacion de cortar el tronco
    int posx1, posx2, posx3, posx4, posx5, posx6, posx7, posx8; //coordenadas en x para los troncos
    int posy1, posy2, posy3, posy4, posy5, posy6, posy7, posy8; //coordenadas en y para los tronocs  
    int posx9, posx10, posx11, posx12, posx13, posx14, posx15;
    int posy9, posy10, posy11, posy12, posy13, posy14, posy15;    
    
    Image base_tronco, gameover, fondo;
    int posxgo, posygo;
    
    Image fondo1,fondo2,fondo3,fondo4,fondo5,fondo6,fondo7,fondo8,fondo9;
    int posvalor_fondo1, posvalor_fondo2, posvalor_fondo3, posvalor_fondo4;//posiciones para manejar el cambio de fondos
    int posvalor_fondo5, posvalor_fondo6, posvalor_fondo7, posvalor_fondo8, posvalor_fondo9;
    
    Timer t, t_volador;
    int rand_volador;//numero random para la direccion que volara el tronco cortado
    JProgressBar current;//barra de vida en pantalla
    int num = 1000;//valor ininicla de la barra de vida
    int aux;//contador para controlar la velocidad con la que baja la barra de vida    
    int vida = 1;//numero de vidas del personaje   
    Font fuente, fuente2;
    int puntuacion, puntuacion_mayor, puntuacion_aux;    
    int p1x, p1y, p2x, p2y; //coordenadas para puntuacion y puntuacion mayor  
    JLabel l_salir, usuario;
    int posxlrein;//etiqueta para reiniciar   

    
    /**
     * Se da valor y se inicializa la mayoria de los atributos
     * @throws FileNotFoundException En caso de que no se encuentren las imagenes
     * @throws IOException En caso de que no se encuentren las imagenes o el archivo de texto que contiene el nombre de usuario
     */
    public Jugar() throws FileNotFoundException, IOException{     
        
        super.setLayout(null);
        super.setSize(ancho, alto);
        super.setLocation(0, 0);
        super.addMouseListener(raton);
        super.addKeyListener(teclas);
        
        t_volador = new Timer(1,escuchante2);    
        fuente2 = new Font("Stencil", Font.BOLD, 18);  
        //posicion inicial que tienen los fondos
        posvalor_fondo1 = 0;
        posvalor_fondo2 = inicialfondos;
        posvalor_fondo3 = inicialfondos;
        posvalor_fondo4 = inicialfondos;
        posvalor_fondo5 = inicialfondos;
        posvalor_fondo6 = inicialfondos;
        posvalor_fondo7 = inicialfondos;
        posvalor_fondo8 = inicialfondos;
        posvalor_fondo9 = inicialfondos;        
         
        //posiciones iniciales para las imagenes del personales
        t1 = new Timberman();
        t2 = new Timberman();
        td = new Timberman();
        ti = new Timberman();      
        t1.posx = t1posxstd;
        t1.posy = tposystd;
        t2.posx = tstd;
        t2.posy = tposystd;
        td.posx = tstd;
        ti.posx = tstd;
        td.posy = 438 + 5;
        ti.posy = 438 + 5;
        
        tronco1 = new Tronco();tronco2 = new Tronco();tronco3 = new Tronco();tronco4 = new Tronco();
        tronco5 = new Tronco();tronco6 = new Tronco();tronco7 = new Tronco();tronco8 = new Tronco();
        
        tr1 = new Tronco();tr2 = new Tronco();tr3 = new Tronco();tr4 = new Tronco();tr5 = new Tronco();
        tr6 = new Tronco();tr7 = new Tronco();
        
        tr_volador = new Tronco();
        tr_volador.posx = troposxstd;
        tr_volador.posy = 438;
        
        //posiciones iniciales de las imagenes de tronco que luego se van a imprimir aleatoriamente
        posx1 = troposxstd;posx2 = troposxstd;posx3 = troposxstd;posx4 = troposxstd;posx5 = troposxstd;posx6 = troposxstd;posx7 = 147;
        posy1 = 438;       posy2 = 329;       posy3 = 220;       posy4 = 115;       posy5 = 12;        posy6 = -97;       posy7 = -206;
        posx8 = troposxstd;posx9 = troposxstd;posx10 = troposxstd;posx11 = troposxstd;posx12 = troposxstd;posx13 = troposxstd;posx14 = troposxstd;
        posy8 =-315;       posy9 =-424;       posy10 =-533;       posy11 =-642;       posy12 =-751;       posy13 =-860;       posy14 =-969;
        posx15 = troposxstd;
        posy15 = -1078; 
               
        posxlrein= -200;
        
        current = new JProgressBar(0, 2000);
        current.setForeground(Color.red.darker());
        current.setValue(1000);
        current.setBounds(205, 200, 175, 30);        
 
        l_salir = new JLabel("Esc");
        l_salir.setBounds(0, 0, 100, 20);
        l_salir.setFont(fuente2);
        l_salir.setBackground(Color.white);
        l_salir.addKeyListener(teclas);        
        
               //leer 
                try {
                    FileReader r = new FileReader("src/Resultado/usuario.txt");
                    BufferedReader bf = new BufferedReader(r);
                    String temp = " ";
                    while (temp != null) {
                    temp = bf.readLine();
                    usuario = new JLabel(temp); 
                    usuario.setBounds(500, 460, 100, 20);                   
                    usuario.setFont(fuente2);                    
                    add(usuario);
                        if (temp == null) {
                            break;
                        }                 
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
 
        try {
            fondo1 = ImageIO.read(new File("src/imagenes/fondo1.jpg"));
            fondo2 = ImageIO.read(new File("src/imagenes/fondo2.jpg"));
            fondo3 = ImageIO.read(new File("src/imagenes/fondo3.jpg"));
            fondo4 = ImageIO.read(new File("src/imagenes/fondo4.jpg"));
            fondo5 = ImageIO.read(new File("src/imagenes/fondo5.jpg"));
            fondo6 = ImageIO.read(new File("src/imagenes/fondo6.jpg"));
            fondo7 = ImageIO.read(new File("src/imagenes/fondo7.jpg"));
            fondo8 = ImageIO.read(new File("src/imagenes/fondo8.jpg"));
            fondo9 = ImageIO.read(new File("src/imagenes/fondo9.jpg"));
            base_tronco = ImageIO.read(new File("src/imagenes/base_troncoo.png"));
            gameover = ImageIO.read(new File("src/imagenes/gameover.png"));
        } catch (IOException e) {
            System.err.println("No se ha encontrado la imagen" + e);
        }        
        
        fx = java.applet.Applet.newAudioClip(getClass().getResource("/Proyecto/madera1.wav")); 
        fx2 = java.applet.Applet.newAudioClip(getClass().getResource("/Proyecto/doh.wav"));

        puntuacion = 0;
        puntuacion_aux = 0; 
        p1x = 200;
        p1y = 320;
        p2x = 277;
        p2y = -1000;
   
        posxgo = 150;
        posygo = -435;   
          
        aux=0;
        fuente = new Font("Stencil", Font.BOLD, 44);        
        t = new Timer(1000, escuchante);
        t.start();

        super.add(current);
        super.add(l_salir);
        super.add(usuario);
        super.setFocusable(true);    
    }
    /**
     * metodo para pintar las imagenes de fondos
     * el tronco que va a ir por defecto en la base
     * todas las imagenes de troncos
     * todas las imagenes del personaje
     * aviso de game over
     * y los string de puntuacion, mejor puntuacion y etiqueta para reiniciar y salir
     * @param g casteo
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
      
        g2.drawImage(fondo1, posvalor_fondo1, 0, this);
        g2.drawImage(fondo2, posvalor_fondo2, 0, this);
        g2.drawImage(fondo3, posvalor_fondo3, 0, this);
        g2.drawImage(fondo4, posvalor_fondo4, 0, this);
        g2.drawImage(fondo5, posvalor_fondo5, 0, this);
        g2.drawImage(fondo6, posvalor_fondo6, 0, this);
        g2.drawImage(fondo7, posvalor_fondo7, 0, this);
        g2.drawImage(fondo8, posvalor_fondo8, 0, this);
        g2.drawImage(fondo9, posvalor_fondo9, 0, this);        

        
        g2.drawImage(base_tronco, 233 + 13, 547, this);   
        
        g2.drawImage(tronco1.tronco_base, posx1, posy1, this);
        g2.drawImage(tronco2.tronco2, posx2, posy2, this);
        g2.drawImage(tr1.tronco_base, posx3, posy3, this);
        g2.drawImage(tronco3.tronco3, posx4, posy4, this);
        g2.drawImage(tr2.tronco_base, posx5, posy5, this);
        g2.drawImage(tronco4.tronco4, posx6, posy6, this);
        g2.drawImage(tr3.tronco_base, posx7, posy7, this);
        g2.drawImage(tronco5.tronco5, posx8, posy8, this);
        g2.drawImage(tr4.tronco_base, posx9, posy9, this);
        g2.drawImage(tronco6.tronco6, posx10, posy10, this);
        g2.drawImage(tr5.tronco_base, posx11, posy11, this);
        g2.drawImage(tronco7.tronco7, posx12, posy12, this);
        g2.drawImage(tronco8.tronco8, posx13, posy13, this);
        g2.drawImage(tr6.tronco_base, posx14, posy14, this);
              
        g2.drawImage(tr_volador.tronco_base, tr_volador.posx, tr_volador.posy, this);        
        
        g2.drawImage(t1.timber1, t1.posx, t1.posy, this);
        g2.drawImage(t2.timber2, t2.posx, t2.posy, this);
        g2.drawImage(ti.timberder, ti.posx, ti.posy, this);
        g2.drawImage(td.timberiz, td.posx, td.posy, this);  
        
        g2.drawImage(gameover, posxgo, posygo, this);        
        
        g2.setColor(Color.black);
        g2.setFont(fuente);
        g2.drawString("" + puntuacion, p1x, p1y);
        g2.drawString("" + puntuacion_mayor, p2x, p2y); 
        g2.setFont(fuente2);
        g2.drawString("Pulse R...",posxlrein, 500);
        repaint();
    }
    
    /**
     * escuchante para llevar un control de la barra de vida
     * mientras mas tiempo corra, la barra de vida va a bajar con mas rapidez
     */
    ActionListener escuchante = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
                  
            if (aux > 0 && aux < 20) {
                num -= 50;
            }          
            if (aux >= 20 && aux < 30) {
                num -= 75;
            }            
            if (aux >= 30 && aux < 70) {
                num -= 100;
            } 
            if (aux >= 70 && aux < 100) {
                num -= 150;
            } 
            if (aux >= 100) {
                num -= 200;
            }          
            if(num<=0)
                vida=0;
            else
                vida=1;
            
           current.setValue(num);
           aux++;
           System.out.println(aux);
           repaint();      
        }
    };
    
    /**
     * animacion para cortar el arbol y salga volando en una direccion aleatoria
     */
    ActionListener escuchante2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
 
            if(rand_volador==1){
            tr_volador.posx+=10;
            tr_volador.posy-=10;
            } 
            
            if(rand_volador==2){
            tr_volador.posx-=10;
            tr_volador.posy-=10;
            }
            
            if(rand_volador==3){
            tr_volador.posx+=10;         
            }
            
            if(rand_volador==4){
            tr_volador.posx-=10;
            }                    
        }
    };
    
    /**
     * escuchante de raton para saber en que lado de la pantalla se ha hecho click
     * y ejecutar la animacion del juego
     */
    MouseListener raton = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {}
        @Override
        public void mousePressed(MouseEvent me) {          
            if(vida==1){
            if (me.getX() > 300) {
                t1.posx = tstd;
                td.posx = tstd;
                t2.posx = tstd;
                ti.posx = 290;
                ti.posy = 438 + 5;
                fx.play();
                rand_volador = (int) (Math.random() * 4+1);
                tr_volador.posx = troposxstd;
                tr_volador.posy = 438; 
                t_volador.start();             
            }            
            if (me.getX() < 300) {
                t1.posx = tstd;
                ti.posx = tstd;
                t2.posx = tstd;
                td.posx = 130 + 10;
                td.posy = 438 + 5;
                fx.play();  
                rand_volador = (int) (Math.random() * 4+1);
                tr_volador.posx = troposxstd;
                tr_volador.posy = 438; 
                t_volador.start();                
            }
            }
        }
        @Override
        public void mouseReleased(MouseEvent me) {
            
            if(vida==1){
            if (me.getX() > 300) {
                t1.posx = tstd;
                ti.posx = tstd;
                td.posx = tstd;
                t2.posx = 345;
                t2.posy = tposystd;        
                num += 20;             
                puntuacion++;
                puntuacion_aux++;             
                posy1 += 109;
                posy2 += 109;
                posy3 += 109;
                posy4 += 109;
                posy5 += 109;
                posy6 += 109;
                posy7 += 109;
                posy8 += 109;                
                validar();
                rand_volador = (int) (Math.random() * 4+1);
                tr_volador.posx = troposxstd;
                tr_volador.posy = 438; 
                t_volador.start();                
                     
            }           
            if (me.getX() < 300) {
                ti.posx = tstd;
                t2.posx = tstd;
                td.posx = tstd;
                t1.posx = t1posxstd;
                num += 20;               
                puntuacion++;
                puntuacion_aux++;                              
                posy1 += 109;
                posy2 += 109;
                posy3 += 109;
                posy4 += 109;
                posy5 += 109;
                posy6 += 109;
                posy7 += 109;
                posy8 += 109;
                validar();  
                rand_volador = (int) (Math.random() * 4+1);
                tr_volador.posx = troposxstd;
                tr_volador.posy = 438; 
                t_volador.start();                
            }
            }
        }
        @Override
        public void mouseEntered(MouseEvent me) {}

        @Override
        public void mouseExited(MouseEvent me) {}
    }; 
    
    /**
     * escuchante de teclas para saber que tecla se presiono y ejecutar la animacion de juego
     * tambien para escuchar si se quiere reiniciar el juego o para salir
     */
    KeyListener teclas = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {}

        @Override
        public void keyPressed(KeyEvent ke) {
            
                if(ke.getKeyCode() == KeyEvent.VK_ESCAPE){
                    aux_cerrar=1;   
            }
            
                if(ke.getKeyCode() == KeyEvent.VK_R){             
                num=1000;
                vida = 1;
                puntuacion=0;
                posxgo = 150;
                posygo = -436;               
                aux=0;
                current.setVisible(true);
                current.revalidate();              
                p1x = 277;
                p1y = 320;
                p2x = 277;
                p2y = -1000;                 
            }
            repaint();            
            
            if(vida==1){
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                t1.posx = tstd;
                ti.posx = tstd;
                t2.posx = tstd;
                td.posx = 130 + 10;
                td.posy = 438 + 5;
                fx.play();  
                rand_volador = (int) (Math.random() * 4+1);
                tr_volador.posx = troposxstd;
                tr_volador.posy = 438; 
                t_volador.start();                
            }
            repaint();
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                t1.posx = tstd;
                td.posx = tstd;
                t2.posx = tstd;
                ti.posx = 290;
                ti.posy = 438 + 5;
                fx.play();  
                rand_volador = (int) (Math.random() * 4+1);
                tr_volador.posx = troposxstd;
                tr_volador.posy = 438; 
                t_volador.start();                
            }         
            repaint();  
            }
        }
        @Override
        public void keyReleased(KeyEvent ke) {  
            
            if(vida==1){
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                ti.posx = tstd;
                t2.posx = tstd;
                td.posx = tstd;
                t1.posx = t1posxstd;
                num += 20;
                
                puntuacion++;
                puntuacion_aux++;                         
                posy1 += 109;
                posy2 += 109;
                posy3 += 109;
                posy4 += 109;
                posy5 += 109;
                posy6 += 109;
                posy7 += 109;
                posy8 += 109;
                validar();                            
            }
            repaint();
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                t1.posx = tstd;
                ti.posx = tstd;
                td.posx = tstd;
                t2.posx = 348;
                t2.posy = tposystd;
                num += 20;               
                puntuacion++;
                puntuacion_aux++;                                 
                posy1 += 109;
                posy2 += 109;
                posy3 += 109;
                posy4 += 109;
                posy5 += 109;
                posy6 += 109;
                posy7 += 109;
                posy8 += 109; 
                validar();
             
            }
            repaint();
            }
        }
    };
    /**
     * metodo para validar que la posicion del tronco en el eje y sea igual que el del personaje
     * en ese caso se debe validar de que el tronco y el personaje esten del mismo lado
     * si ambas condiciones se cumples se pierde la vida
     * luego cuando los troncos bajan de la coordenada limite, se volveran a generar
     * de forma aleatoria
     */
    public void validar() {

            if(posy2>=t1.posy||posy2>=ti.posy){                
                if(t1.posx<300&&t1.posx>0||ti.posx<300&&ti.posx>0){
                    if(tronco2.num==3){
                    vida=0;
                    fx2.play();
                }
                }             
            }
            if(posy4>=t1.posy||posy4>=ti.posy){
                if(t1.posx<300&&t1.posx>-200||ti.posx<300&&ti.posx>-200){
                    if(tronco3.num==3){
                    vida=0;
                    fx2.play();
                }
                }
            }
            if(posy6>=t1.posy||posy6>=ti.posy){
                if(t1.posx<300&&t1.posx>-200||ti.posx<300&&ti.posx>-200){
                    if(tronco4.num==3){
                   vida=0;
                   fx2.play();
                }
                }
            }
            if(posy8>=t1.posy||posy8>=ti.posy){
                if(t1.posx<300&&t1.posx>-200||ti.posx<300&&ti.posx>-200){
                    if(tronco5.num==3){
                    vida=0;
                    fx2.play();
                }
                }
            }
            if(posy10>=t1.posy||posy10>=ti.posy){
                if(t1.posx<300&&t1.posx>-200||ti.posx<300&&ti.posx>-200){
                    if(tronco6.num==3){
                    vida=0;
                    fx2.play();
                }
                }
            }
            if(posy12>=t1.posy||posy12>=ti.posy){
                if(t1.posx<300&&t1.posx>-200||ti.posx<300&&ti.posx>-200){
                    if(tronco7.num==3){
                    vida=0;
                    fx2.play();
                }
                }
            }
            if(posy13>=t1.posy||posy13>=ti.posy){
                if(t1.posx<300&&t1.posx>-200||ti.posx<300&&ti.posx>-200){
                    if(tronco8.num==3){
                    vida=0;
                    fx2.play();
                }
                }
            }
            //-------------------------------------------------------------------           
            if(posy2>=t2.posy||posy2>=td.posy){
                
                if(t2.posx>300||td.posx>300){
                    if(tronco2.num==2){
                    vida=0;
                    fx2.play();
                }
                }
                
            }
            if(posy4>=t2.posy||posy4>=td.posy){
                if(t2.posx>300||td.posx>300){
                    if(tronco3.num==2){
                    vida=0;
                    fx2.play();
                }
                }
            }
            if(posy6>=t2.posy||posy6>=td.posy){
                if(t2.posx>300||td.posx>300){
                    if(tronco4.num==2){
                   vida=0;
                   fx2.play();
                }
                }
            }
            if(posy8>=t2.posy||posy8>=td.posy){
                if(t2.posx>300||td.posx>300){
                    if(tronco5.num==2){
                    vida=0;
                    fx2.play();
                }
                }
            }
            if(posy10>=t2.posy||posy10>=td.posy){
                if(t2.posx>300||td.posx>300){
                    if(tronco6.num==2){
                    vida=0;
                    fx2.play();
                }
                }
            }
            if(posy12>=t2.posy||posy12>=td.posy){
                if(t2.posx>300||td.posx>300){
                    if(tronco7.num==2){
                    vida=0;
                    fx2.play();
                }
                }
            }
            if(posy13>=t2.posy||posy13>=td.posy){
                if(t2.posx>300||td.posx>300){
                    if(tronco8.num==2){
                    vida=0;
                    fx2.play();
                }
                }
            }
       
        if (posy1 > limite) {         
            tronco1.setimage( 1);          
            posy1 = inicial;
        }
        if (posy2 > limite) {
            tronco2.setimage(2);
            posy2 = inicial;}
        
        if (posy3 > limite) {
            tr1.setimage(3);
            posy3 = inicial;}
        
        if (posy4 > limite) {
            tronco3.setimage(4);
            posy4 = inicial;}
        
        if (posy5 > limite) {
            tr2.setimage(5);
            posy5 = inicial;}
        
        if (posy6 > limite) {
            tronco4.setimage(6);
            posy6 = inicial;}
        
        if (posy7 > limite) {
            tr3.setimage(7);
            posy7 = inicial;}
        
        if (posy8 > limite) {
            tronco5.setimage(8);
            posy8 = inicial;}
        
        if (posy9 > limite) {
            tr4.setimage(9);
            posy9 = inicial;}
        
        if (posy10 > limite) {
            tronco6.setimage(10);
            posy10 = inicial;}
        
        if (posy11 > limite) {
            tr5.setimage(11);
            posy11 = inicial;}
        
        if (posy12 > limite) {
            tronco7.setimage(12);
            posy12 = inicial;}
        
        if (posy13 > limite) {
            tronco8.setimage(13);
            posy13 = inicial;}
        
        if (posy14 > limite) {
            tr6.setimage(14);
            posy14 = inicial;}
        
        if (posy15 > limite) {
            posy15 = inicial;}  
    }    
}


