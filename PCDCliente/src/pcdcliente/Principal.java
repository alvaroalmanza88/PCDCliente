package pcdcliente;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;


/**
 * Clase de iniciación de la interfaz del cliente 
 * @author Álvaro Camilo Almanza Báez, David Encinas de Frutos, José Miguel Olivares Gil, José Manuel Serrano Ojeda
 * @version 1.0.0
 */
public class Principal extends javax.swing.JFrame {

    private Socket yo = null;
    private String direccion;
    private int puerto;
    
    /**
     * Se inician los componentes de la interfaz
     * @version 1.0.0
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        et_ip = new javax.swing.JLabel();
        fi_puerto = new javax.swing.JTextField();
        et_puerto = new javax.swing.JLabel();
        bt_conectar = new javax.swing.JButton();
        fi_ip = new javax.swing.JTextField();
        bt_fichero = new javax.swing.JButton();
        fi_fichero = new javax.swing.JTextField();
        et_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PCDCliente");

        et_ip.setText("IP:");

        et_puerto.setText("Puerto:");

        bt_conectar.setText("Conectar");
        bt_conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_conectarActionPerformed(evt);
            }
        });

        bt_fichero.setText("Seleccionar Archivo");
        bt_fichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ficheroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(et_ip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fi_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(et_puerto)
                        .addGap(18, 18, 18)
                        .addComponent(fi_puerto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_fichero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(bt_conectar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(fi_fichero))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(et_ip)
                    .addComponent(fi_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fi_puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(et_puerto))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_fichero)
                    .addComponent(fi_fichero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_conectar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        et_titulo.setText("Programa Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(et_titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(et_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Selección de fichero
     * Al seleccionar el fichero se almacena la dirección absoluta para 
     * posteriormente abrir el fichero. Debería ser un archivo de texto, pero
     * no se controla.
     * @return Nada
     * @param evt Evento de selección de fichero
     */
    private void bt_ficheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ficheroActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int respuesta = fc.showOpenDialog(this);
        if(respuesta == JFileChooser.APPROVE_OPTION)
        {
            File seleccion = fc.getSelectedFile();
            fi_fichero.setText(seleccion.getAbsolutePath());
            
        }
    }//GEN-LAST:event_bt_ficheroActionPerformed

    /**
     * Cuando se podruce un evento en el botón Conectar se leen los
     * datos: IP, puerto y fichero. Se validan IP y puerto y se comienza
     * la conexión y comunicación con el servidor.
     * @see ipvalida
     * @see puertoValido
     * @see Comunicacion
     * @see Escuchar
     * @see Escribir
     * @param evt 
     */
    private void bt_conectarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //implementacion del codigo
        String linea = "";
        BufferedReader fichero = null;
        Comunicacion comunicador = null;
        Escuchar escucha = null;
        Escribir escribe = null;
        // Validamos la IP
        if (ipvalida(fi_ip.getText()))
        {
            direccion=fi_ip.getText();
        }else
        {
            JOptionPane.showMessageDialog(this,"No Ha introducido una direccion valida");
            fi_ip.setText("");
            fi_puerto.setText("");
            return;
        }
        // Validamos el puerto
        if(puertoValido(fi_puerto.getText()))
        {
            puerto=Integer.parseInt(fi_puerto.getText());
            try {
                // Se intenta abrir ell fichero
                fichero = new BufferedReader(new FileReader(fi_fichero.getText()));
                // Creamos el socket
                yo = new Socket(direccion,puerto);                
                bt_conectar.setEnabled(false);
                // Instanciamos los objetos comunicador, escucha y escribe
                comunicador = new Comunicacion(yo);
                escucha = new Escuchar(comunicador);
                escribe = new Escribir(comunicador, fichero);
                // Iniciamos los hilos de escucha y escribe
                escucha.start();
                escribe.start();
            }
            catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this,"No se pudo abrir el fichero\n"+ex);
            }
            catch (UnknownHostException ex)
            {
                JOptionPane.showMessageDialog(this,"Host desconocido");
            } catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(this,"Se ha detectado un error, vuelva a intentarlo de nuevo");
            }
            
        }
    }

    /**
     * Clase que pricipal
     * Llama a la función que inicia la interfaz
     * @param args no se usan
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_conectar;
    private javax.swing.JButton bt_fichero;
    private javax.swing.JLabel et_ip;
    private javax.swing.JLabel et_puerto;
    private javax.swing.JLabel et_titulo;
    private javax.swing.JTextField fi_fichero;
    private javax.swing.JTextField fi_ip;
    private javax.swing.JTextField fi_puerto;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Valida la IP
     * @param ipAddr IP a validar
     * @return true si es válida o false si no lo es
     */
    public static boolean ipvalida(String ipAddr)
    {
        boolean valida=false;
        if (ipAddr.equals("localhost"))
        {
            valida=true;
        }else
        {
            Pattern ptn = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
            Matcher mtch = ptn.matcher(ipAddr);
            valida= mtch.find();
        }
        return valida;
    }
    
    /**
     * Valida el puerto
     * @param p puerto a validar
     * @return true si es válido o false si no lo es
     */
    public static boolean puertoValido(String p)
    {
        int puerto = 0;
        boolean valido=false;
        try{
            puerto = Integer.parseInt(p);
        }catch(NumberFormatException e){
            valido = false;
        }
        if (1024 <= puerto && 65535 >= puerto)
        {
            valido=true;
        }
        return valido;
    }
    
    /**
     * Clase Comunicación
     * Se encarga de abrir los  bufferes de comunicación con el servidor.
     * Tiene funciones para leer y escribir en los buffers
     */
    public class Comunicacion {
        private Socket cliente = null;
        private BufferedReader entrada = null;
        private DataOutputStream salida = null;
        private Boolean seguir = true;
        
        /**
         * Constructor de la clase
         * Crea los buffers de entrada y salida
         * @param cliente Socket de conexión con el servidor
         */
        public Comunicacion (Socket cliente){
            this.cliente = cliente;
            try{
                this.salida = new DataOutputStream(cliente.getOutputStream());
                this.entrada = new BufferedReader(
                    new InputStreamReader(
                        cliente.getInputStream()));                
            }catch(IOException e){
                System.out.println("Error: "+e);
            }
        }
        
        /**
         * Lee el contenido del buffer de entrada, por donde recibe el ACK
         * @return true si recibe el ack o false en caso contrario o de error
         */
        public Boolean leer(){
            int recibo = 0;
            int ack = 5; 
            try{
                while(!this.entrada.ready()){}
                recibo = this.entrada.read();
                while(recibo>=0)
                {
                    if (recibo == ack){
                        return true;
                    }
                    recibo = this.entrada.read();
                }
            }catch(IOException e){
                return false;
            }
            if (recibo != ack)
            {
                return false;
            }
            return true;
        }
        /**
         * Escribe en el buffer de salida la cadena que se le pasa como parámetro
         * @param str cadena que deseamos enviar
         */
        public void escribir(String str){
            try{
                for (int i = 0; i < str.length(); i++){
                    this.salida.writeChar(str.charAt(i));
                }
                this.salida.writeChar(-1);
            }catch(Exception e){
                System.out.println("No se pudo enviar el mensaje");
            }
        }
        /**
         * Envia el ACK al servidor, lo usamos para finalizar la comunicación
         */
        public void enviarAck(){
            int ack = 5;
            
            try {
                this.salida.writeChar(ack);
            } catch (IOException ex) {
                System.out.println("No se pudo enviar el mensaje de fin de comunicación");
            }
        }
        /**
         * Cierra tanto los bufferes de comunicación como el Socket. Vuelve a
         * habilitar el botón de conectar.
         */
        public void Cerrar(){
            try {
                this.seguir=false;
                //this.entrada.close();
                //this.salida.close();
                //this.cliente.close();
                
                bt_conectar.setEnabled(true);
                
            } catch (Exception ex) {
                System.out.println("No se pudo cerrar la comunicación");
            }
        }
        /**
         * Obtiene el valor de "seguir"
         * @return seguir 
         */
        public Boolean getSeguir(){
            return this.seguir;
        }
    }
    /**
     * Clase Escuchar
     * Se encarga de controlar la escucha del buffer de entrada
     */
    public class Escuchar extends Thread{
        private Comunicacion comunicador = null;
        
        /**
         * Constructor de la clase Escuchar, guarda el objeto Comunicador
         * @param cm objeto Comunicador
         */
        public Escuchar (Comunicacion cm){
            this.comunicador = cm;
        }
        
        /**
         * Se inicia la escucha en espera, cuando se despierta a este hilo se
         * comienza la escucha hasta que recibe el ack, momento en que despierta
         * la escritura y se vuelve a poner en espera.
         */
        public void run(){
            synchronized (this.comunicador){
                try {
                    this.comunicador.wait();
                    while (this.comunicador.getSeguir()){
                        this.comunicador.leer();
                        this.comunicador.notify();
                        this.comunicador.wait();
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Hubo un error en la escucha del buffer");
                }
            }
        }
    }
    
    /**
     * Clase Escribir
     * Se encarga de controlar la escritura en el buffer de salida
     */
    public class Escribir extends Thread{
        private Comunicacion comunicador = null;
        private BufferedReader fichero = null;
        private String linea = "";
        
        /**
         * Constructor de la clase.
         * 
         * @param cm objeto comunicador
         * @param fi buffer del fichero a enviar
         */
        public Escribir(Comunicacion cm, BufferedReader fi){
            this.comunicador = cm;
            this.fichero = fi;
        }
        /**
         * Se inicia la escritura en el buffer de salida. Para ello va leyendo
         * las líneas del fichero a enviar. Cada vez que envia una línea notifica
         * a la escucha para que lea el ACK y se pone a la espera.
         * Una vez enviado el fichero, manda el ACK de fin de conexión, cieera
         * la comunicación y notifica a la escucha para que se cierre tambien
         */
        public void run(){
            synchronized (this.comunicador){
                try {
                    while ((linea = fichero.readLine()) != null){
                        this.comunicador.escribir(linea);
                        this.comunicador.notify();
                        this.comunicador.wait();
                    }
                    this.comunicador.enviarAck();
                    this.comunicador.Cerrar();
                    this.comunicador.notify();
                    this.fichero.close();
                } catch (Exception ex) {
                    System.out.println("No se pudo escribir en el buffer");
                }
            }
        }
        
    }
}
