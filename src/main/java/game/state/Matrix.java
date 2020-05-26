package game.state;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class which represents matrixes.
 */

@Slf4j
public class Matrix {

    /**
     * Returns a matrix with two arbitrary values.
     *
     * @param n The number of rows in the matrix.
     * @param m The number of columns in the matrix.
     * @return Returns a start matrix.
     */

    public static int[][] startMatrix(int n, int m) {
        int[][] actualMatrix = new int[n][m];
        add(actualMatrix);
        add(actualMatrix);
            return actualMatrix;
    }

    /**
     * From the zero elements of the <code>actualMatrix</code>
     * a random zero turns into a 2 or a 4.
     *
     * If the row and column indexes are already
     * chosen in a matrix, this method will chose
     * other numbers until one of them won't be different.
     *
     * @param actualMatrix A matrix which contains integers.
     */

    public static void add(int actualMatrix[][]){
        int zeros = 0;
        ArrayList<Integer> indexrow = new ArrayList<Integer>();
        ArrayList<Integer> indexcol = new ArrayList<Integer>();
        for(int i = 0;i<actualMatrix.length;i++){
            for(int j = 0;j<actualMatrix.length;j++){
                if(actualMatrix[i][j] == 0 ){
                    zeros++;
                    indexrow.add(i);
                    indexcol.add(j);
                }
            }
        }
        if(zeros!=0){
            Random randomGenerator = new Random();
            int index = randomGenerator.nextInt(indexrow.size());
            int choosenindexrow = indexrow.get(index);
            int choosenindexcol = indexcol.get(index);
            while(actualMatrix[choosenindexrow][choosenindexcol] == 2 || actualMatrix[choosenindexrow][choosenindexcol] == 4 ){
                index = randomGenerator.nextInt(indexrow.size());
                choosenindexrow = indexrow.get(index);
                choosenindexcol = indexcol.get(index);
            }
            actualMatrix[choosenindexrow][choosenindexcol]=Math.random() > 0.2 ? 2 : 4;
        }else{
            log.warn("The Matrix is full");
        }
    }


    /**
     * Going-over the <code>actualMatrix</code>
     * starting with the last element of the matrix.
     *
     * @param actualMatrix A matrix which contains integers.
     */

    public static void bejaras(int actualMatrix[][]){
        for(int i=actualMatrix.length-1;i>=0;i--){
            for(int j=actualMatrix.length-1;j>=0;j--){
                if(j!=0 && actualMatrix[i][j]!=0 && actualMatrix[i][j-1]==0){
                    actualMatrix[i][j-1]+=actualMatrix[i][j];
                    actualMatrix[i][j]=0;
                }
            }
        }
    }

    /**
     * This method adds the equal elements which are next to each other.
     *
     * The sum goes to that row index which is lesser then the other,
     * while the other value will be zero.
     *
     * @param actualMatrix A matrix which contains integers.
     */
    
    public static void osszead(int actualMatrix[][]){
        for (int[] subMatrix : actualMatrix) {
            for (int j = 0; j<actualMatrix.length; j++) {
                if (j!=actualMatrix.length-1 && subMatrix[j] == subMatrix[j+1]) {
                    subMatrix[j] += subMatrix[j+1];
                    subMatrix[j+1] = 0;
                }
            }
        }
    }

    /**
     * This method swaps the rows and the columns in the matrix.
     * It's called mathematical transpose.
     *
     * @param actualMatrix A matrix which contains integers.
     */
   
    private static void transzponalt(int actualMatrix[][] ) {
        for(int i = 0; i < actualMatrix.length; i++){
            for(int j = i+1; j < actualMatrix.length ; j++){
                int temp = actualMatrix[i][j];
                actualMatrix[i][j] = actualMatrix[j][i];
                actualMatrix[j][i] = temp;
            }
        }

    }

    /**
     * This method rotates the matrix in the middle.
     * It swaps the rows which are in the same distance
     * form each other.
     *
     * @param actualMatrix A matrix which contains integers.
     */

    private static void kozepforgat(int actualMatrix[][]) {
        int l = actualMatrix.length ;
        for(int i = 0; i < l/2; i++){
            for(int j = 0;j < l; j++){
                int temp = actualMatrix[i][j];
                actualMatrix[i][j] = actualMatrix[l-1 -i][j];
                actualMatrix[l -1 -i][j] = temp;
            }
        }
    }

    /**
     * This method rotates the matrix.
     *
     * @param actualMatrix A matrix which contains integers.
     */

    public static void forgatas(int actualMatrix[][] ){
        if(actualMatrix == null)
            return;
        if(actualMatrix.length != actualMatrix[0].length)
            return;
        transzponalt(actualMatrix);
        kozepforgat(actualMatrix);
    }
}     

