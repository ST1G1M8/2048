package game.state;


import static game.state.Matrix.*;

/**
 * This class represents the operations of the 2048 game.
 */
public class Operation {

    /**
     * These variables represent the possibility
     * if we can move to the given direction or not.
     * If it is possible to move they give false
     * otherwise they give true.
     */

    public static boolean endLeft = false;
    public static boolean endRight = false;
    public static boolean endBottom = false;
    public static boolean endTop = false;

    /**
     * This method adds the elements in the matrix.
     * The sum goes to the left side of the matrix.
     *
     * @param actualMatrix A matrix which contains integers.
     */

    public static void toLeft(int actualMatrix[][]){
        move(actualMatrix);
        move(actualMatrix);
        move(actualMatrix);
        sumValue(actualMatrix);
        move(actualMatrix);
        move(actualMatrix);
        move(actualMatrix);

    }

    /**
     * This method adds the elements in the matrix
     * and gives another not zero element.
     * The sum goes to the left side of the matrix.
     *
     * @param actualMatrix A matrix which contains integers.
     */

    public static void toLeftCall(int actualMatrix[][]){
        int[][] helper = new int[actualMatrix.length][];
        for(int i = 0; i < actualMatrix.length; i++){
            helper[i] = new int[actualMatrix[i].length];
            System.arraycopy(actualMatrix[i], 0, helper[i], 0, actualMatrix[i].length);
        }
        toLeft(actualMatrix);
        boolean same=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(actualMatrix[i][j]!=helper[i][j]){
                    same=false;
                }
            }
        }
        if(same) {
            endLeft=true;
        }else{
            add(actualMatrix);
            endLeft=false;
            endRight=false;
            endBottom=false;
            endTop=false;
        }
    }


    /**
     * This method adds the elements in the matrix
     * and gives another not zero element.
     * TThe sum goes to the right side of the matrix.
     *
     * @param actualMatrix A matrix which contains integers.
     */


    public static void toRightCall(int actualMatrix[][]){
        int[][] helper = new int[actualMatrix.length][];
        for(int i = 0; i < actualMatrix.length; i++){
            helper[i] = new int[actualMatrix[i].length];
            System.arraycopy(actualMatrix[i], 0, helper[i], 0, actualMatrix[i].length);
        }
        rotate(actualMatrix);
        rotate(actualMatrix);
        toLeft(actualMatrix);
        rotate(actualMatrix);
        rotate(actualMatrix);
        boolean same=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(actualMatrix[i][j]!=helper[i][j]){
                    same=false;
                }
            }
        }
        if(same){
            endRight=true;
        }else{
            add(actualMatrix);
            endLeft=false;
            endRight=false;
            endBottom=false;
            endTop=false;
        }
    }


    /**
     * This method adds the elements in the matrix
     * and gives another not zero element.
     * The sum goes to the bottom side of the matrix.
     *
     * @param actualMatrix A matrix which contains integers.
     */

    public static void toBottomCall(int actualMatrix[][]){
        int[][] helper = new int[actualMatrix.length][];
        for(int i = 0; i < actualMatrix.length; i++){
            helper[i] = new int[actualMatrix[i].length];
            System.arraycopy(actualMatrix[i], 0, helper[i], 0, actualMatrix[i].length);
        }
        rotate(actualMatrix);
        rotate(actualMatrix);
        rotate(actualMatrix);
        toLeft(actualMatrix);
        rotate(actualMatrix);
        boolean same=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(actualMatrix[i][j]!=helper[i][j]){
                    same=false;
                }
            }
        }
        if(same){
            endBottom=true;
        }else{
            add(actualMatrix);
            endLeft=false;
            endRight=false;
            endBottom=false;
            endTop=false;
        }
    }


    /**
     * This method adds the elements in the matrix
     * and gives another not zero element.
     * The sum goes to the top side of the matrix.
     *
     * @param actualMatrix A matrix which contains integers.
     */

    public static void toTopCall(int actualMatrix[][]){
        int[][] helper = new int[actualMatrix.length][];
        for(int i = 0; i < actualMatrix.length; i++){
            helper[i] = new int[actualMatrix[i].length];
            System.arraycopy(actualMatrix[i], 0, helper[i], 0, actualMatrix[i].length);
        }
        rotate(actualMatrix);
        toLeft(actualMatrix);
        rotate(actualMatrix);
        rotate(actualMatrix);
        rotate(actualMatrix);
        boolean same=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(actualMatrix[i][j]!=helper[i][j]){
                    same=false;
                }
            }
        }
        if(same){
            endTop=true;
        }else{
            add(actualMatrix);
            endLeft=false;
            endRight=false;
            endBottom=false;
            endTop=false;
        }
    }
}


    

