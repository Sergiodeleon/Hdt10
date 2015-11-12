package hdt10;
import java.io.IOException;
/**
 *
 * @author Sergio
 */
public class Floyd {
    ReadFile archivo= new ReadFile();
    Interfaz nodo;
    int[][] medios;
    int[] cantidad;
    int centro;
    int minimo=9999;
    
    public Floyd(){
        
        try {
            archivo.LeerArchivo("datos.txt");
            nodo = archivo.Arcos(); 
            medios = new int[30][30];
            cantidad = new int[30];
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int n=0;n<archivo.graf.largo();n++){
            for(int m=0;m<archivo.graf.largo();m++){
                medios[n][m]=9999;
            }
        }
    }
    
    public void Corto(){
        for(int k=0;k<nodo.largo();k++){
            for(int i=0;i<nodo.largo();i++){
                for(int j=0;j<nodo.largo();j++){
                    if(nodo.getD(nodo.get(i),nodo.get(j))>(nodo.getD(nodo.get(i), nodo.get(k))+nodo.getD(nodo.get(k), nodo.get(j)))){
                        nodo.agregarGrafo(nodo.get(i), nodo.get(j), (nodo.getD(nodo.get(i), nodo.get(k))+nodo.getD(nodo.get(k), nodo.get(j))));
                        medios[i][j]=k;
                    }
                }
            }
        }
        
    }
    
    public void Grafo(){
        Corto();
        int n=0;       
        // Encontrar los maximos de cada columna de la matriz
        for(int i=0;i<nodo.largo();i++){
            for(int j=0;j<nodo.largo()-1;j++){
                int num1=nodo.getD(nodo.get(j), nodo.get(i));
                n=j;
                n++;
                int num2=nodo.getD(nodo.get(n), nodo.get(i));
                if(num1>num2){
                    cantidad[i]=num1;
                }
                else{
                    cantidad[i]=num2;
                }
            }
            n++;
        }
        // Encontrar el minimo de los maximos de cada columna
        for(int i=0;i<nodo.largo();i++){
            int num1=cantidad[i];
            if(num1<minimo){
                centro=i;
                minimo=num1;
            }
        }
        System.out.println(""+nodo.get(centro));
        
    }
    
    public void Intermedias(int num, int num2){
        try {
            if(medios[num][num2]!=9999){
            Intermedias(num,medios[num][num2]);   //recursion
            System.out.print(", "+nodo.get(medios[num][num2]));
            Intermedias(medios[num][num2],num2);   //recursion
            return;
            }else return;
        } catch (Exception e) {
                System.out.println("");
                return;
        }
               
    }
}
