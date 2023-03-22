import java.io.*;
public class Matriz_2x2 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            long startTime = System.nanoTime(); // Obtener tiempo inicial en nanosegundos
            MatrizLoca();
            long endTime = System.nanoTime(); // Obtener tiempo final en nanosegundos
            long duration = endTime - startTime; // Calcular la duración en nanosegundos
            // Convertir a diferentes unidades de tiempo y mostrar por consola
            System.out.println("0,"+duration + " nanosegundos");
        }

    }

    public static void MatrizLoca(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File ("Matriz_2x2.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            String linea;
            while((linea=br.readLine())!=null){
                String[] anchAlt = linea.split(" ");
                int alto = Integer.parseInt(anchAlt[0]);
                int ancho = Integer.parseInt(anchAlt[1]);
                int[][] matriz = new int[alto][ancho];
                int pos = 0;
                while(alto > 0){
                    String[] numeros = br.readLine().split(" ");
                    for (int i = 0; i < numeros.length; i++) {
                        matriz[pos][i] = Integer.parseInt(numeros[i]);
                        if(pos == 0 || pos % 2 == 0) {
                            matriz[pos][i] += 1;
                        }
                        if(i == 0 || i % 2 == 0){
                            matriz[pos][i] += 2;
                        }
                        if(pos % 2 != 0 && i % 2 != 0){
                            matriz[pos][i] -= 3;
                        }
                    }
                    pos++;
                    alto--;
                }
                String imprimir = "";
                for(int i = 0; i < pos; i++){
                    for (int j = 0; j < ancho; j++) {
                        if(ancho-1 == j){
                            imprimir += matriz[i][j] + "\n";
                        }else{
                            imprimir += matriz[i][j] + " ";
                        }
                    }
                }
            }
                
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        
    }
}