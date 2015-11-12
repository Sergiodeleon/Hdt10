package hdt10;
import java.util.Vector;
/**
 *
 * @author Sergio
 */
public class Grafo <K,E> implements Interfaz<K,E> {
    private Vector v = new Vector();
    private int[][] graf = new int [20][20];
    /**
     * Constructor
     */
    public Grafo(){
    for(int i=0;i<20;i++){
       for(int j=0;j<20;j++){
        if(i==j){
        graf[i][j]=0;
        }
        else{
        graf[i][j]=9999; //"infinite"   
        }
      }
    }
  }

    public void agregar(K ciudad) {
        if(!v.contains(ciudad)){
            v.add(ciudad);
        } 
    }

    @Override
    public void agregarGrafo(K ciudad1, K ciudad2, E d) {
        int i = v.indexOf(ciudad1);
        int j = v.indexOf(ciudad2);        
        String tmp = ""+d;
        int peso = Integer.parseInt(tmp);
        graf[i][j]=peso;
    }
    
    @Override
    public K get(int ciudad){
        return (K)v.get(ciudad); 
    }
    
    @Override
    public int getD(K ciudad1, K ciudad2){
        return graf[v.indexOf(ciudad1)][v.indexOf(ciudad2)];
    }
    
    @Override
    public boolean contenido(K ciudad){
        return v.contains(ciudad);
    }
    
    @Override
    public int getIndice(K ciudad){
        return v.indexOf(ciudad);
    }
    
    @Override
    public void mostrar(){
        for(int a=0;a<v.size();a++){
         for(int b=0;b<v.size();b++){
         System.out.print(""+graf[a][b]+" ");
            }
        System.out.println("");
      }
        System.out.println("");
    }
    
    @Override
    public int largo(){
        return v.size();
    }




    



}
