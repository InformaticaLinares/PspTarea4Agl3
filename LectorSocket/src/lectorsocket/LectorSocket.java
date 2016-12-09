package lectorsocket;
import java.io.*;
import java.net.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LectorSocket {
    
    
     public static void main(String[] args) {

        Socket canal = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;

        FileLock lock = null;
        FileChannel channel = null;
        File fbuffer = new File("../registros.log");
        RandomAccessFile raf = null;

        String numero = null;
        String contador = null;

        try {
            canal = new Socket("localhost", 12500);
            if (canal.isConnected()) {
                raf = new RandomAccessFile(fbuffer, "rwd");
                channel = raf.getChannel();
                lock = channel.lock();
                System.out.println("Consumidor conectado.\r\n");
                raf.seek(raf.length());

                raf.writeBytes("Consumidor conectado.\r\n");
                lock.release();
                raf.close();
            }
        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(-1);
        }

        try {

            entrada = new BufferedReader(new InputStreamReader(canal.getInputStream()));
            contador = entrada.readLine();
            numero = entrada.readLine();
            raf = new RandomAccessFile(fbuffer, "rwd");
            channel = raf.getChannel();
            lock = channel.lock();
            raf.seek(raf.length());
         

            raf.writeBytes("Consumidor " + contador + " coge el número " + numero + "\r\n.");
            lock.release();
            raf.close();
            entrada.close();

        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(-1);
        }

        try {
            canal.close();
        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(-1);
        }
    }
    
}
