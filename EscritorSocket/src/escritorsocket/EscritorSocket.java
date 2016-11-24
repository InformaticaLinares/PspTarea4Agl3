
package escritorsocket;

/**
 * * @author
 */
import java.net.*;
import java.io.*;
import java.util.Random;

public class EscritorSocket {

    public void startServer()//Método para iniciar el servidor
    {
        ServerSocket conexion = null;//OK
        Socket canal = null;
        int contador = 1;//para cada conexion de un consumidor,esto se repite 100 veces
        PrintWriter salidaCliente;

        try {
            conexion = new ServerSocket(12500);

        } catch (IOException ae) {
            System.err.println("No se puede abrir el puerto");
            System.err.println(ae.toString());
            System.exit(-1);
        }

        System.out.println("Esperando conexión..."); //Esperando conexión

        try {

            canal = conexion.accept(); //Accept comienza el socket y espera una conexión desde un cliente
            System.out.println("Cliente en línea");
            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new PrintWriter(canal.getOutputStream());
            Random r = new Random();

            //Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.print(r.nextInt(contador));
            contador++;

            salidaCliente.flush();
            salidaCliente.close();

        } catch (Exception e) {
            System.err.println("Error de conexión o al escribir en el canal");
            System.err.print(e.toString());
        }

        try {
            canal.close();
            conexion.close();

        } catch (IOException e) {
            System.err.println("Error al cerrar el canal o el serverSocket");

        }

    }
    
//    public static void main(String[] args) {
//        System.out.println("hola");
//    }

}
