/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorsocket;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
/*** @author Marina
 */
public class LectorSocket {
    
    
     public void startCliente() //Método para iniciar el cliente
    {
        ServerSocket conexion = null;
        Socket canal = null;
        int contRecibido;     
        String fichlog = "javalogcons.txt";  // Fichero de logging     
        String fichruta = "buffer.txt";   // Fichero para buffer       
        PrintStream ps = null;// Se redirigen las salidas estandar
        
        try {   //Flujo de datos hacia el servidor
            BufferedReader br = new BufferedReader(new InputStreamReader(canal.getInputStream()));
           
            contRecibido=br.read();

            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File(fichlog), true)), true);
            
            canal.close();//Fin de la conexión
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        
    }
    
}
