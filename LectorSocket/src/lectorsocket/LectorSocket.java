package lectorsocket;
import java.io.*;
import java.net.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LectorSocket {
    
    
     public void startCliente() //Método para iniciar el cliente
    {
        
        Socket canal = null;       
        File fbuffer= new File("../log.txt");// Fichero de log  
        RandomAccessFile raf= null;     
        PrintStream ps = null;// Se redirigen las salidas estandar
        FileLock lock;
        FileChannel channel=null;
        String numero=null,contador=null;
        
        try {  
            
            canal= new Socket("localhost",12500);
            if(canal.isConnected()){
                System.out.println("Consumidor conectado");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(canal.getInputStream()));
           
            contador=br.readLine();
            numero=br.readLine();
            System.out.println("Consumidor "+ contador+" coge el numero "+numero);
            br.close();

            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(fbuffer, true)), true);
            
            canal.close();//Fin de la conexión
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        
    }
    
}
