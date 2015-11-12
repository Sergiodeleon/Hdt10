package hdt10;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class main {

    public static void main(String[] args) {
      
        Floyd matriz = new Floyd();
        matriz.Corto(); 
        int seleccion=1;
        int opcion; 
        Scanner scan = new Scanner(System.in);
       
        while(seleccion!=4){
            System.out.println("1. Encontrar la ruta mas corta entre ciudades");
            System.out.println("2. Ciudad en el centro del grafo");
            System.out.println("3. Ingresar rutas entre ciudades");
            System.out.println("4. Fin");
            System.out.print("Ingrese la opcion: ");
            seleccion = scan.nextInt();      
           
            if(seleccion==1){
                matriz.Corto();
                System.out.print("Ciudad de Inicio: ");
                String ciudad1 = scan.next(); 
                System.out.print("Ciudad de Destino: ");
                String ciudad2 = scan.next();
                if(matriz.nodo.contenido(ciudad1)&&matriz.nodo.contenido(ciudad2)){
                    System.out.println("\nLa distancia minima es: "+matriz.nodo.getD(ciudad1, ciudad2)+".");
                    if(matriz.nodo.getD(ciudad1, ciudad2)!=9999){
                        System.out.print("La ruta es: "+ciudad1);
                        try {
                        matriz.Intermedias(matriz.nodo.getIndice(ciudad1), matriz.nodo.getIndice(ciudad2));
                        } catch (Exception e) {
                           System.out.println("");
                        }
                        
                        System.out.println(", "+ciudad2);
                    }
                }
            }
            
            
            if(seleccion==2){
                System.out.print("El centro del grafo es: ");
                matriz.Grafo();
            }
            
            
            if(seleccion==3){
                System.out.println("1. Establecer interrupcion entre ciudades");
                System.out.println("2. Establecer nueva conexion");
                System.out.print("Ingrese la opcion: ");
                opcion = scan.nextInt(); 
                if(opcion==1){
                    System.out.print("Ciudad de Inicio: ");
                    String ciudad1 = scan.next();
                    System.out.print("Ciudad de destino: ");
                    String ciudad2 = scan.next();
                    if(matriz.nodo.contenido(ciudad1)&&matriz.nodo.contenido(ciudad2)){
                        matriz.nodo.agregarGrafo(ciudad1, ciudad2, 9999);
                        try {
                            matriz.archivo.Escribir(ciudad1+" "+ciudad2+" 9999");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                if(opcion==2){
                    System.out.print("    Ciudad de salida: ");
                    String ciudad1 = scan.next();
                    System.out.print("    Ciudad de destino: ");
                    String ciudad2 = scan.next();
                    System.out.print("    Distancia entre las ciudades: ");
                    int d = scan.nextInt();
                    if(matriz.nodo.contenido(ciudad1)&&matriz.nodo.contenido(ciudad2)){
                        matriz.nodo.agregarGrafo(ciudad1, ciudad2, d);
                    }
                    else{
                        matriz.nodo.agregar(ciudad1);
                        matriz.nodo.agregar(ciudad2);
                        matriz.nodo.agregarGrafo(ciudad1, ciudad2, d);
                    }
                    try {
                        matriz.archivo.Escribir(ciudad1+" "+ciudad2+" "+d);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                matriz.Corto();
            }
        }
         System.out.println("Fin del programa");
    }
    
}
