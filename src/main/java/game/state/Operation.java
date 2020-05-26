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

    public static void balra(int actualMatrix[][]){
        bejaras(actualMatrix);
        bejaras(actualMatrix);
        bejaras(actualMatrix);
        osszead(actualMatrix);
        bejaras(actualMatrix);
        bejaras(actualMatrix);
        bejaras(actualMatrix);

    }

    /**
     * This method adds the elements in the matrix
     * and gives another not zero element.
     * The sum goes to the left side of the matrix.
     *
     * @param actualMatrix A matrix which contains integers.
     */

    public static void balrahiv(int actualMatrix[][]){
        int[][] seged = new int[actualMatrix.length][];
        for(int i = 0; i < actualMatrix.length; i++){
            seged[i] = new int[actualMatrix[i].length];
            System.arraycopy(actualMatrix[i], 0, seged[i], 0, actualMatrix[i].length);
        }
        balra(actualMatrix);
        boolean azonosak=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(actualMatrix[i][j]!=seged[i][j]){
                    azonosak=false;
                }
            }
        }
        if(azonosak) {
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


    public static void jobbrahiv(int actualMatrix[][]){
        int[][] seged = new int[actualMatrix.length][];
        for(int i = 0; i < actualMatrix.length; i++){
            seged[i] = new int[actualMatrix[i].length];
            System.arraycopy(actualMatrix[i], 0, seged[i], 0, actualMatrix[i].length);
        }
        forgatas(actualMatrix);
        forgatas(actualMatrix);
        balra(actualMatrix);
        forgatas(actualMatrix);
        forgatas(actualMatrix);
        boolean azonosak=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(actualMatrix[i][j]!=seged[i][j]){
                    azonosak=false;
                }
            }
        }
        if(azonosak){
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

    public static void lehiv(int actualMatrix[][]){
        int[][] seged = new int[actualMatrix.length][];
        for(int i = 0; i < actualMatrix.length; i++){
            seged[i] = new int[actualMatrix[i].length];
            System.arraycopy(actualMatrix[i], 0, seged[i], 0, actualMatrix[i].length);
        }
        forgatas(actualMatrix);
        forgatas(actualMatrix);
        forgatas(actualMatrix);
        balra(actualMatrix);
        forgatas(actualMatrix);
        boolean azonosak=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(actualMatrix[i][j]!=seged[i][j]){
                    azonosak=false;
                }
            }
        }
        if(azonosak){
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

    public static void felhiv(int actualMatrix[][]){
        int[][] seged = new int[actualMatrix.length][];
        for(int i = 0; i < actualMatrix.length; i++){
            seged[i] = new int[actualMatrix[i].length];
            System.arraycopy(actualMatrix[i], 0, seged[i], 0, actualMatrix[i].length);
        }
        forgatas(actualMatrix);
        balra(actualMatrix);
        forgatas(actualMatrix);
        forgatas(actualMatrix);
        forgatas(actualMatrix);
        boolean azonosak=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(actualMatrix[i][j]!=seged[i][j]){
                    azonosak=false;
                }
            }
        }
        if(azonosak){
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


    

