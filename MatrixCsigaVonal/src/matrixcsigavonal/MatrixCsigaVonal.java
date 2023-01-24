
package matrixcsigavonal;

/**
 *
 * @author Székely Balázs
 * 
 */
public class MatrixCsigaVonal {

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
    
    static void matrixBejar(int[][] matrix) {
        int sor = 0, oszlop = 0, szam = 0;
        
            //1. balról jobbra
            while(oszlop < matrix[sor].length){
                if(sor > 0){
                    if(matrix[sor][oszlop+1] == -1){
                        matrix[sor][oszlop]=szam;
                        szam++;
                        oszlop++;
                    }
                    else{ break; }
                }
                else{//elsõ futásnál
                    matrix[sor][oszlop]=szam;
                    szam++;
                    oszlop++;
                }   
            }
            oszlop--;
            sor++;
            
            //1. fentrõl lefelé
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
            
            //1. jobbról balra
            while(oszlop > -1){
                matrix[sor][oszlop]= szam;
                szam++;
                oszlop--;
            }
            sor--;
            oszlop++;
            
            //1. lentrõl felfelé
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
            
            //n-dik körbefuttatás
            while(szam <= (matrix.length*matrix[sor].length)-1){
                
                //balról jobbra
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

                //fentrõl lefelé
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

                //jobbról balra
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
        
        int[][] matrix3 = matrixInit(5, 7);
        System.out.println("Feltöltés elõtt:");
        tombKiir(matrix3);
        
        
        matrixBejar(matrix3);
        System.out.println("Feltöltés után:");
        tombKiir(matrix3);
    }

}
