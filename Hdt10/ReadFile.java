package hdt10;
import java.io.*;
/**
 *
 * @author Sergio
 */
public class ReadFile { 
    File arc;
    FileReader filer;
    BufferedReader buferr;
    FileWriter fw;
    PrintWriter pw;
    Interfaz graf = new Grafo();

    public void LeerArchivo(String direccion) throws FileNotFoundException{
        arc=new File(direccion);
        filer = new FileReader (arc);
        buferr = new BufferedReader(filer);
        String linea;
        try {
            while((linea=buferr.readLine())!=null){
            String[] word;
            word=linea.split(" ");
            graf.agregar(word[0]);
            graf.agregar(word[1]);
            } 
        } catch (IOException e) {
                System.out.println("No se ha encontrado el archivo");
        }         
    } 
    /**
     * Se devuelven los arcos
     */
    public Interfaz Arcos() throws IOException{
        filer = new FileReader (arc);
        buferr = new BufferedReader(filer);
        String linea;
        while((linea=buferr.readLine())!=null){
            String[] temp;
            temp=linea.split(" ");
            graf.agregarGrafo(temp[0], temp[1], temp[2]);
        }
        return graf;
    }
    /**
     * escribe el archivo de texto
     */
    public void Escribir(String cadena) throws IOException{
        fw = new FileWriter(arc);
        pw = new PrintWriter(fw);
        pw.println(cadena);
    }  
    
}
