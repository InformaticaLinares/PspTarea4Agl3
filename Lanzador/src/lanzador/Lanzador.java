package lanzador;

import java.io.IOException;

public class Lanzador {


    public static void main(String[] args) throws IOException {
        
        
        // EscritorSocket pro = new EscritorSocket();//Se crea el productor
        System.out.println("Inicio el productor\n");
        
    
    

        for (int i = 0; i < 100; i++) {
          
            // LectorSocket cli = new LectorSocket(); //Se crea el cliente
            System.out.println("Iniciando cliente nº " + i + "\n");
//            cli.startCliente(); //Se inicia el cliente
//              pro.startServer();
        }
    }
}
