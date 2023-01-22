/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrixcsigavonal;

/**
 *
 * @author szeke
 */
public class MatrixCsigaVonal {

    /**
     * @param args the command line arguments
     */
    
    
    static void tombKiir(int[] tomb){
        tombKiir(tomb, tomb.length);
    }//tombKiir
    static void tombKiir(int[][] tomb){
        for (int i = 0; i < tomb.length; i++) {
           tombKiir(tomb[i]);
        }
    }//tombKiir
    static void tombKiir(int[] tomb, int elem){
        for (int i = 0; i < elem; i++) { System.out.print(tomb[i]+"; "); }
        System.out.println("");
    }//tombKiir
    
    
    
    static int[][] matrixInit(int sorok, int oszlopok){
        int[][] matrix = new int[sorok][oszlopok];
        for (int i = 0; i < sorok; i++) {
            for (int j = 0; j < oszlopok; j++) {
                matrix[i][j] = 0;
            }
        }
        
        return matrix;
        
    }//matrixInit
    
    public static void main(String[] args) {
        
        
        int[][] matrix = matrixInit(5, 5);
        tombKiir(matrix);
    }
    
}
