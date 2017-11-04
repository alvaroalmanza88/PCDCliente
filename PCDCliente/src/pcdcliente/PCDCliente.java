
package pcdcliente;

/**
 * Clase principal del proyecto 
 * @author Álvaro Camilo Almanza Báez, David Encinas de Frutos, José Miguel Olivares Gil, José Manuel Serrano Ojeda
 * @version 1.0.0
 */
public class PCDCliente {

    /**
     * Se instancia la interfaz, se hace visible y se evita que se modifique su
     * tamaño.
     * @param args no se usan
     */
    public static void main(String[] args) 
    {
        Principal ventana= new Principal();
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
    }

}