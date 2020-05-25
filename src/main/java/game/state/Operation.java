package game.state;


import static game.state.Matrix.*;

/**
 * This class represents the operations of the 2048 game.
 */
public class Operation {

    /**
     * These variables represent the opportunity if we can move to the given direction or not.
     * If it is possible to move they give false if it is not they give true.
     */

    public static boolean vege1=false;
    public static boolean vege2=false;
    public static boolean vege3=false;
    public static boolean vege4=false;

    /**
     * This method adds the elements in the matrix.
     * The values go to the left.
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
     * This method adds the elements in the matrix and gives another not zero element.
     * The values go to the left.
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
            vege1=true;
        }else{
            add(actualMatrix);
            vege1=false;
            vege2=false;
            vege3=false;
            vege4=false;
        }
    }


    /**
     * This method adds the elements in the matrix and gives another not zero element.
     * The values go to the right.
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
            vege2=true;
        }else{
            add(actualMatrix);
            vege1=false;
            vege2=false;
            vege3=false;
            vege4=false;
        }
    }


    /**
     * This method adds the elements in the matrix and gives another not zero element.
     * The values go to the bottom.
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
            vege3=true;
        }else{
            add(actualMatrix);
            vege1=false;
            vege2=false;
            vege3=false;
            vege4=false;
        }
    }


    /**
     * This method adds the elements in the matrix and gives another not zero element.
     * The values go to the top.
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
            vege4=true;
        }else{
            add(actualMatrix);
            vege1=false;
            vege2=false;
            vege3=false;
            vege4=false;
        }
    }
}


    

