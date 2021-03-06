package game.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    public void testToLeft(){
        int testMatrix[][] = {
                {8,8,0,0},
                {8,8,0,0},
                {4,4,0,0},
                {4,4,0,0}};

        Operation.toLeft(testMatrix);
        int testMatrix2[][] = {
                {16,0,0,0},
                {16,0,0,0},
                {8,0,0,0},
                {8,0,0,0}};

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                assertTrue(testMatrix[i][j]==testMatrix2[i][j]);
            }
        }
    }

    @Test
    public void testToLeftCall(){
        int testMatrix[][] = {
                {2,2,2,2},
                {2,2,2,2},
                {2,2,2,2},
                {2,2,2,2}};

        Operation.toLeftCall(testMatrix);
        int testMatrix2[][] = {
                {4,4,0,0},
                {4,4,0,0},
                {4,4,0,0},
                {4,4,0,0}};

        int db = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix[i][j]==2 || testMatrix[i][j]==4){
                    db++;
                }
            }
        }
        Matrix.add(testMatrix2);
        int res = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix2[i][j]==2 || testMatrix2[i][j]==4){
                    res++;
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                assertTrue(testMatrix[i][j]==testMatrix2[i][j]);
            }
        }
        assertTrue(db == res);
    }

    @Test
    public void testToRightCall(){
        int testMatrix[][] = {
                {2,2,2,2},
                {2,2,2,2},
                {2,2,2,2},
                {2,2,2,2}};

        Operation.toRightCall(testMatrix);
        int testMatrix2[][] = {
                {0,0,4,4},
                {0,0,4,4},
                {0,0,4,4},
                {0,0,4,4}};

        int db = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix[i][j]==2 || testMatrix[i][j]==4){
                    db++;
                }
            }
        }
        Matrix.add(testMatrix2);
        int res = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix2[i][j]==2 || testMatrix2[i][j]==4){
                    res++;
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=2;j<4;j++){
                assertTrue(testMatrix[i][j]==testMatrix2[i][j]);
            }
        }
        assertTrue(db == res);
    }

    @Test
    public void testToBottomCall(){
        int testMatrix[][] = {
                {2,2,2,2},
                {2,2,2,2},
                {2,2,2,2},
                {2,2,2,2}};

        Operation.toBottomCall(testMatrix);
        int testMatrix2[][] = {
                {0,0,0,0},
                {0,0,0,0},
                {4,4,4,4},
                {4,4,4,4}};

        int db = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix[i][j]==2 || testMatrix[i][j]==4){
                    db++;
                }
            }
        }
        Matrix.add(testMatrix2);
        int res = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix2[i][j]==2 || testMatrix2[i][j]==4){
                    res++;
                }
            }
        }
        for(int i=2;i<4;i++){
            for(int j=0;j<4;j++){
                assertTrue(testMatrix[i][j]==testMatrix2[i][j]);
            }
        }
        assertTrue(db == res);
    }

    @Test
    public void testToTopCall(){
        int testMatrix[][] = {
                {2,2,2,2},
                {2,2,2,2},
                {2,2,2,2},
                {2,2,2,2}};

        Operation.toTopCall(testMatrix);
        int testMatrix2[][] = {
                {4,4,4,4},
                {4,4,4,4},
                {0,0,0,0},
                {0,0,0,0}};

        int db = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix[i][j]==2 || testMatrix[i][j]==4){
                    db++;
                }
            }
        }
        Matrix.add(testMatrix2);
        int res = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix2[i][j]==2 || testMatrix2[i][j]==4){
                    res++;
                }
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                assertTrue(testMatrix[i][j]==testMatrix2[i][j]);
            }
        }
        assertTrue(db == res);
    }




}