/*
 * CODIGO REALIZADO POR ALVARO ALMANZA.
 * UNIVERSIDAD INTERNACIONAL I DE CASTILLA
 */
package pcdcliente;

// Añadido por Jose Manuel Serrano
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;


/**
 *
 * @author alvar
 */
public class PCDCliente {

    /**
     * @param args the command line arguments
     */
    // Añadido por Jose Manuel Serrano
    // HE AÑADIDO TRES CAMPOS UNO PARA EL NICK, OTRO PARA LA IP DE LA CONEXION Y OTRO PARA EL MENSAJE, JUNTO CON EL BOTON ENVIAR
    txtnick=new JTextField();
        txtnick.setBounds(10,10,400,25);
        txtip=new JTextField();
        txtip.setBounds(10,30,400,25);
        txtmensaje=new JTextField();
        txtmensaje.setBounds(10,50,400,25);
        btnenviar=new JButton("Enviar datos");
        btnenviar.setBounds(10,70,400,25);
        btnenviar.addActionListener(this);
        add(txtnick);
        add(txtip);
        add(txtmensaje);
        add(btnenviar);
        setLayout (null);
        setSize(500,500);
        setVisible(true);
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
