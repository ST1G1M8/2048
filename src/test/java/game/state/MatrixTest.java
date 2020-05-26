package game.state;

import org.junit.jupiter.api.Test;

import static game.state.Matrix.startMatrix;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    public void testStartMatrix() {
        int[][] testMatrix = startMatrix(4,4);
        assertTrue(testMatrix.length == 4);
        assertTrue(testMatrix[0].length == 4);
    }

    @Test
    public void testStartMatrix2() {
        int added = 0;
        int[][] actualMatrix = startMatrix(4,4);
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                if (actualMatrix[i][j] != 0){
                    added++;
                }
            }
        }
        assertTrue(added==2);
    }

    @Test
    public void testAdd() {
        int[][] testMatrix = new int[4][4];
        int zeros = 0;
        Matrix.add(testMatrix);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if (testMatrix[i][j] == 0) {
                    zeros++;
                }
            }
        }
        assertTrue(zeros==15);
    }

    @Test
    public void testBejaras(){
        int[][] testMatrix = new int[4][4];
        int zeros = 0;
        Matrix.bejaras(testMatrix);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if (testMatrix[i][j] == 0) {
                    zeros++;
                }
            }
        }
        assertTrue(zeros==16);
    }

    @Test
    public void testOsszed(){
        int[][] testMatrix = new int[4][4];
        Matrix.osszead(testMatrix);
        int[][] testMatrix2 = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                assertTrue(testMatrix[i][j]==testMatrix2[i][j]);
            }
        }
        int testMatrix3[][] = {
                {1,2,3,4},
                {5,6,8,8},
                {9,10,11,12},
                {13,14,15,16} };
        Matrix.osszead(testMatrix3);
        int testMatrix4[][] = {
                {1,2,3,4},
                {5,6,16,0},
                {9,10,11,12},
                {13,14,15,16} };
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                assertTrue(testMatrix3[i][j]==testMatrix4[i][j]);
            }
        }
    }

    @Test
    public void testTranszponalt(){
        int testMatrix1[][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16} };
        Matrix.transzponalt(testMatrix1);
        int testMatrix2[][] = {
                {1,5,9,13},
                {2,6,10,14},
                {3,7,11,15},
                {4,8,12,16} };
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                assertTrue(testMatrix1[i][j]==testMatrix2[i][j]);
            }
        }
    }

    @Test
    public void testKozepforgat(){
        int testMatrix1[][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16} };
        Matrix.kozepforgat(testMatrix1);
        int testMatrix2[][] = {
                {13,14,15,16},
                {9,10,11,12},
                {5,6,7,8},
                {1,2,3,4} };
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                assertTrue(testMatrix1[i][j]==testMatrix2[i][j]);
            }
        }
    }

    @Test
    public void testForgatas(){
        int testMatrix1[][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16} };
        Matrix.forgatas(testMatrix1);
        int testMatrix2[][] = {
                {4,8,12,16},
                {3,7,11,15},
                {2,6,10,14},
                {1,5,9,13} };
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                assertTrue(testMatrix1[i][j]==testMatrix2[i][j]);
            }
        }
    }


}