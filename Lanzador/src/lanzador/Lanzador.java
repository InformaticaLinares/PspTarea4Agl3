package lanzador;

import java.io.IOException;

public class Lanzador {


    public static void main(String[] args) throws IOException {
        
        Runtime.getRuntime().exec("java -jar Productor.jar");

        System.out.println("Inicio el productor\n");
        
    
    

        for (int i = 0; i < 100; i++) {
          Runtime.getRuntime().exec("java -jar Consumidor.jar");

            System.out.println("Iniciando cliente nº " + i + "\n");

        }
    }
}
