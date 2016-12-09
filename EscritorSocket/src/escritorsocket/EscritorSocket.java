
package escritorsocket;

/**
 * * @author
 */
import java.net.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Random;

public class EscritorSocket {

    public static void main(String[] args) {

        String numero = "";
        int contador = 0;

        ServerSocket conexion = null;
        Socket canal = null;
        PrintWriter salida = null;

        FileLock lock = null;
        FileChannel channel = null;
        File fbuffer = new File("../registros.log");
        RandomAccessFile raf = null;

        try {
            conexion = new ServerSocket(12500);
        } catch (IOException e) {
            System.err.println("Error de conexion.");
            System.err.println(e.toString());
            System.exit(-1);
        }

        try {

            for (int i = 0; i < 100; i++) {
                canal = conexion.accept();
                contador++;

                if (canal.isConnected()) {
                    raf = new RandomAccessFile(fbuffer, "rwd");
                    channel = raf.getChannel();
                    lock = channel.lock();
                    raf.seek(raf.length());
                    raf.writeBytes("Productor conectado con consumidor.\r\n");
                    lock.release();
                    raf.close();
                }

                salida = new PrintWriter(canal.getOutputStream());
                numero = "" + (int) (Math.random() * 501);
                salida.println(contador);

                raf = new RandomAccessFile(fbuffer, "rwd");
                channel = raf.getChannel();
                lock = channel.lock();
                raf.seek(raf.length());
                raf.writeBytes("Productor genera el número " + numero + ".\r\n");
                lock.release();
                raf.close();
                salida.println(numero);
                salida.flush();
                salida.close();
            }
        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(-1);
        }

        try {
            canal.close();
            conexion.close();
        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(-1);
        }
    }
}
