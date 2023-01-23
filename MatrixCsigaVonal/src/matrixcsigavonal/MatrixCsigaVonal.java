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
    static void tombKiir(int[] tomb) {
        tombKiir(tomb, tomb.length);
    }//tombKiir

    static void tombKiir(int[][] tomb) {
        for (int i = 0; i < tomb.length; i++) {
            tombKiir(tomb[i]);
        }
    }//tombKiir

    static void tombKiir(int[] tomb, int elem) {
        for (int i = 0; i < elem; i++) {
            System.out.print(tomb[i] + "; ");
        }
        System.out.println("");
    }//tombKiir

    static int[][] matrixInit(int sorok, int oszlopok) {
        int[][] matrix = new int[sorok][oszlopok];
        for (int i = 0; i < sorok; i++) {
            for (int j = 0; j < oszlopok; j++) {
                matrix[i][j] = -1;
            }
        }
        return matrix;
    }//matrixInit

    static void matrixBejar(int[][] matrix) {
        int szam = 0, sszam = 0, oszam = 0;

        do{
            //feltöltés balról jobbra
            for (int oszlop = oszam; oszlop < matrix[sszam].length; oszlop++) {
                if (matrix[sszam][oszlop] != -1) {
                    oszam = oszlop;
                    break;
                }
                matrix[sszam][oszlop] = szam;
                szam++;
                oszam = oszlop;
            }
            sszam++;
            

            //feltöltés fentrõl lefelé
            for (int sor = sszam; sor < matrix.length; sor++) {
                if(matrix[sor][oszam]!=-1){
                    sszam = sor;
                    break;
                }
                matrix[sor][oszam] = szam;
                szam++;
                sszam = sor;
            }
            oszam--;

            //feltöltés jobbról balra
            for (int oszlop = oszam; oszlop > -1; oszlop--) {
                System.out.println(sszam+" és "+oszam);//VALAHOL ITT VAN A HIBA
                if(matrix[sszam][oszlop]!=-1){
                    oszam=oszlop;
                    break;
                }
                matrix[sszam][oszlop] = szam;
                szam++;
                oszam=oszlop;
            }
            sszam--;
            
            //feltöltés alulról felfelé
            for (int sor = sszam; sor > -1; sor--) {
                if (matrix[sor][oszam] != -1) {
                    sszam = sor + 1;
                    break;
                }
                matrix[sor][oszam] = szam;
                szam++;
            }
            oszam++;
            
        }while(szam!=20);
    }//matrixInit

    public static void main(String[] args) {

        int[][] matrix = matrixInit(5, 5);
        //matrix[0][2]=100;

        matrixBejar(matrix);
        tombKiir(matrix);
    }

}
