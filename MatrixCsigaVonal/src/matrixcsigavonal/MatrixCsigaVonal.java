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
        System.out.println("");
    }//tombKiir

    static void tombKiir(int[] tomb, int elem) {
        for (int i = 0; i < elem; i++) {
            if(tomb[i]<10 && tomb[i]>-1)
                System.out.print("0"+tomb[i] + "; ");
            else
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

    /*static void matrixBejar(int[][] matrix) {
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
            System.out.println(sszam+" és "+oszam);//VALAHOL ITT VAN A HIBA
            tombKiir(matrix);
            //feltöltés jobbról balra
            for (int oszlop = oszam; oszlop > -1; oszlop--) {
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
                    sszam = sor;
                    break;
                }
                matrix[sor][oszam] = szam;
                szam++;
            }
            oszam++;
            
        }while(szam!=20);
    }*/
    
    static void matrixBejar(int[][] matrix) {
        int sor = 0, oszlop = 0, szam = 0;
        
        //do{
            //balról jobbra
            while(oszlop < matrix[sor].length){
                
                if(sor > 0){
                    if(matrix[sor][oszlop+1] == -1){
                        matrix[sor][oszlop]=szam;
                        szam++;
                        oszlop++;
                    }
                    else{
                        break;
                    }
                }
                else{//elsõ futásnál
                    matrix[sor][oszlop]=szam;
                    szam++;
                    oszlop++;
                }
                
            }
            oszlop--;
            sor++;
            //fentrõl lefelé
            while(sor < matrix.length){
                
                if(oszlop != matrix[sor].length-1){
                    
                    if(matrix[sor+1][oszlop] == -1){
                        
                        matrix[sor][oszlop]=szam;
                        szam++;
                        sor++;
                        
                    }
                    else{
                        matrix[sor][oszlop]=szam;
                        szam++;
                        oszlop++;
                        break;
                    }
                }
                else {//elsõ futásnál
                    matrix[sor][oszlop]=szam;
                    szam++;
                    sor++;
                }
                
            }
            sor--;
            oszlop--;
            //jobbról balra
            while(oszlop > -1){
                matrix[sor][oszlop]= szam;
                szam++;
                oszlop--;
            }
            sor--;
            oszlop++;
            //lentrõl felfelé
            while(sor >-1){
                    if(matrix[sor-1][oszlop] == -1){
                        matrix[sor][oszlop]=szam;
                        szam++;
                        sor--;
                    }
                    else {
                        matrix[sor][oszlop]=szam;
                        szam++;
                        sor--;
                        break;
                    }
            }
            sor++;
            oszlop++;
            
            while(szam <= (matrix.length*matrix[sor].length)-1){
                //2. balról jobbra
                while(oszlop < matrix[sor].length){
                    if (szam > (matrix.length*matrix[sor].length)-1) break;
                    
                    if(sor > 0){
                        if(matrix[sor][oszlop+1] == -1){
                            matrix[sor][oszlop]=szam;
                            szam++;
                            oszlop++;
                        }
                        else{
                            matrix[sor][oszlop]=szam;
                            szam++;
                            oszlop++;
                            break;
                        }
                    }
                    else{//elsõ futásnál
                        matrix[sor][oszlop]=szam;
                        szam++;
                        oszlop++;
                    }

                }
                oszlop--;
                sor++;


                //2. fentrõl lefelé
                while(sor < matrix.length){
                    if (szam > (matrix.length*matrix[sor].length)-1) break;
                    
                    if(oszlop != matrix[sor].length-1){
                        
                        if(matrix[sor+1][oszlop] == -1){

                            matrix[sor][oszlop]=szam;
                            szam++;
                            sor++;

                        }
                        else{
                            matrix[sor][oszlop]=szam;
                            szam++;
                            oszlop++;
                            break;
                        }
                    }
                    else {//elsõ futásnál
                        
                        matrix[sor][oszlop]=szam;
                        szam++;
                        oszlop++;
                        sor++;
                    }

                }
                oszlop=oszlop-2;
                
                //sor--;

                //2. jobbról balra
                while(oszlop > -1){
                    if (szam > (matrix.length*matrix[sor].length)-1) break;
                    
                    if(matrix[sor][oszlop-1]== -1){
                        matrix[sor][oszlop]= szam;
                        szam++;
                        oszlop--;
                    }
                    else{
                        matrix[sor][oszlop]= szam;
                        szam++;
                        oszlop--;
                        break;
                    }
                }
                sor--;
                oszlop++;

                //lentrõl felfelé
                while(sor >-1){
                    if (szam > (matrix.length*matrix[sor].length)-1) break;
                    
                        if(matrix[sor-1][oszlop] == -1){
                            matrix[sor][oszlop]=szam;
                            szam++;
                            sor--;
                        }
                        else {
                            matrix[sor][oszlop]=szam;
                            szam++;
                            sor--;
                            break;
                        }
                }
                sor++;
                oszlop++;
            }

    }

    public static void main(String[] args) {

        int[][] matrix = matrixInit(5, 5);
        System.out.println("Feltöltés elõtt:");
        tombKiir(matrix);
        
        
        matrixBejar(matrix);
        System.out.println("Feltöltés után:");
        tombKiir(matrix);
        
        
        int[][] matrix2 = matrixInit(10, 10);
        System.out.println("Feltöltés elõtt:");
        tombKiir(matrix2);
        
        
        matrixBejar(matrix2);
        System.out.println("Feltöltés után:");
        tombKiir(matrix2);
    }

}
