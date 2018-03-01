package Proyecto;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Clase que va a contener los botones del juego y la imagen de portada
 *
 * @author Walter Rubio, Paola Perez
 */
public class Inicio extends JPanel implements Valores {

    Image portada;
    JButton b_iniciar, b_inst, b_cred, b_salir;
    JTextArea t_cred4;

    /**
     * Se da valor a los componentes del panel y se inicializan
     */
    public Inicio() {

        setLayout(null);
        super.setLocation(0, 0);
        super.setSize(ancho, alto);

        try {
            portada = ImageIO.read(new File("src/imagenes/portadita1.jpg"));
        } catch (IOException e) {
            System.err.println("No se encontro la imagen: " + e);
        }

        b_iniciar = new JButton("JUGAR");
        b_iniciar.setBounds(225, 225 + 20, 150, 40);
        b_iniciar.setBackground(Color.red.darker());
        b_iniciar.addMouseListener(escuchante);

        b_inst = new JButton("INSTRUCCIONES");
        b_inst.setBounds(225, 290 + 20, 150, 40);
        b_inst.setBackground(Color.red.darker());
        b_inst.addMouseListener(escuchante);

        b_cred = new JButton("CREDITOS");
        b_cred.setBounds(225, 290 + 65 + 20, 150, 40);
        b_cred.setBackground(Color.red.darker());
        b_cred.addMouseListener(escuchante);

        b_salir = new JButton("SALIR");
        b_salir.setBounds(225, 290 + 65 + 65 + 20, 150, 40);
        b_salir.setBackground(Color.red.darker());
        b_salir.addMouseListener(escuchante);

        t_cred4 = new JTextArea("Copyright© 2018 W&PProductions. All rights reserved.");
        t_cred4.setOpaque(false);
        t_cred4.setForeground(Color.black);
        t_cred4.setFont(new Font("", Font.BOLD, 11));
        t_cred4.setEditable(false);
        t_cred4.setBounds(135, 550, 1000, 1000);

        add(b_iniciar);
        add(b_inst);
        add(b_cred);
        add(b_salir);
        add(t_cred4);

        super.setVisible(true);
    }

    /**
     * Metodo para pintar la imagen de portada
     *
     * @param g casteo
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(portada, 0, 0, this);
    }

    /**
     * Metodo para poder detectar los eventos de raton y verificar sobre cual
     * boton se ha hecho click
     */
    MouseListener escuchante = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {

            if (me.getSource() == b_iniciar) {
                PedirUsuario ped = null;
                ped = new PedirUsuario();
                Inicio.super.removeAll();
                Inicio.super.add(ped);
                Inicio.super.revalidate();
                Inicio.super.repaint();
            }

            if (me.getSource() == b_inst) {
                Instrucciones inst = new Instrucciones();
                Inicio.super.removeAll();
                Inicio.super.add(inst);
                Inicio.super.revalidate();
                Inicio.super.repaint();
            }

            if (me.getSource() == b_cred) {
                Creditos cred = new Creditos();
                Inicio.super.removeAll();
                Inicio.super.add(cred);
                Inicio.super.revalidate();
                Inicio.super.repaint();
            }

            if (me.getSource() == b_salir) {
                System.exit(0);
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    };
}

/**
 * Panel contenido en el Frame ventana, en el se solicita el nombre de usuario y
 * se abrira un nuevo Frame para contener el Panel principal del Juego
 *
 * @author Walter rubio, Paola Perez
 */
class PedirUsuario extends JPanel implements Valores {

    Image portada;
    JButton b_volver, b_aceptar;
    JTextField t_usu;
    Font fuente;

    /**
     * Se da valor y se inicializan los componentes del panel
     */
    public PedirUsuario() {

        setLayout(null);
        super.setSize(ancho, alto);
        super.setLocation(0, 0);
        fuente = new Font("Stencil", Font.BOLD, 22);

        try {
            portada = ImageIO.read(new File("src/imagenes/fondoped.jpg"));
        } catch (IOException e) {
            System.err.println("No se encontro la imagen: " + e);
        }

        t_usu = new JTextField("", 20);
        t_usu.setFont(fuente);
        t_usu.setBounds(200, 230, 200, 40);
        t_usu.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if (t_usu.getText().length() == 8) {
                    ke.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });

        b_aceptar = new JButton("Aceptar");
        b_aceptar.setBounds(250, 305, 90, 20);
        b_aceptar.setBackground(Color.red);
        b_aceptar.addActionListener(escuchante);

        b_volver = new JButton("Volver");
        b_volver.setBounds(25, 500, 70, 35);
        b_volver.setBackground(Color.red);
        b_volver.addActionListener(escuchante);

        add(t_usu);
        add(b_aceptar);
        add(b_volver);
    }

    /**
     * Metodo para pintar la imagen de portada
     *
     * @param g casteo
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(portada, 0, 0, this);
    }
    /**
     * Escuchante para detectar sobre cual boton se ha hecho click
     */
    ActionListener escuchante = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            /*se va a guardar en un aarchivo de texto el nombre de usuario para luego
            mostarlo en pantalla*/
            if (ae.getSource() == b_aceptar) {
                try {
                    File f;
                    f = new File("src/Resultado/usuario.txt");
                    try {
                        FileWriter w = new FileWriter(f);
                        BufferedWriter bw = new BufferedWriter(w);
                        PrintWriter wr = new PrintWriter(bw);
                        wr.write("" + t_usu.getText());
                        wr.close();
                        bw.close();
                    } catch (Exception e) {
                        System.out.println("");
                    }
                    Inicio i;
                    i = new Inicio();
                    PedirUsuario.super.removeAll();
                    PedirUsuario.super.add(i);
                    PedirUsuario.super.revalidate();
                    PedirUsuario.super.repaint();

                    Framejug jugar = new Framejug();
                    jugar.correr();
                } catch (IOException ex) {
                    Logger.getLogger(PedirUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (ae.getSource() == b_volver) {
                Inicio i = new Inicio();
                b_volver.setBackground(Color.YELLOW);
                PedirUsuario.super.removeAll();
                PedirUsuario.super.add(i);
                PedirUsuario.super.revalidate();
                PedirUsuario.super.repaint();
            }
        }
    };
}
