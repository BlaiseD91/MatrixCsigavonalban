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
            for (int j = 0; j < oszlopok; j++) {  matrix[i][j] = -1; }
        }
        return matrix;   
    }//matrixInit
    
    static void matrixBejar(int[][] matrix){
        int szam = 0, sszam = 0, oszam = 0;
        
        //feltöltés balról jobbra
        for (int oszlop = 0; oszlop < matrix[sszam].length; oszlop++) {
                matrix[sszam][oszlop] = szam;
                szam++;
                if (oszlop == matrix[sszam].length-1)
                    oszam=oszlop;
        }
        sszam++;
        //feltöltés fentről lefelé
        for (int sor = sszam; sor < matrix.length; sor++) {
            matrix[sor][oszam] = szam;
            szam++;
            if (sor == matrix.length-1)
                    sszam=sor;
        }
        oszam--;
        //feltöltés jobbról balra
        for (int oszlop = oszam; oszlop >-1; oszlop--) {
            matrix[sszam][oszlop] = szam;
            szam++;
            if (oszlop == 0)
                    oszam=oszlop;
            
        }
        sszam--;
        //feltöltés lentről felfelé
        for (int sor = sszam; sor > -1; sor--) {
            if(matrix[sor][oszam] != -1){
                sszam=sor-1;
                break;
            }
            matrix[sor][oszam] = szam;
            szam++;
        }
        oszam++;
    }//matrixInit
    
    public static void main(String[] args) {
        
        
        int[][] matrix = matrixInit(5, 5);
        
        matrixBejar(matrix);
        tombKiir(matrix);
    }
    
}
