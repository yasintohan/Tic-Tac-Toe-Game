package com.tohandesign.tiktaktoegame;

public class CPU {

    private int[][] press = new int[3][3];
    private int[][] testmove = new int[3][3];
    private boolean drawTest = false;
    private int[] nextMove = new int[2];

    public CPU(int[][] press) {
        this.press = press;
    }



    public void chechMove(){
        testmove = press;

        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if (testmove[x][y] == 0) {
                    testmove[x][y] = 2;
                    if(winTest(testmove)) {
                        setMove(x, y);
                        return;
                    } else {
                        testmove[x][y] = 0;
                    }
                }
            }
        }

        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if (testmove[x][y] == 0) {
                    testmove[x][y] = 1;
                    if(winTest(testmove)) {
                        setMove(x, y);
                        return;
                    } else {
                        testmove[x][y] = 0;
                    }
                }
            }
        }

        if(testmove[1][1]== 0){
            setMove(1,1);
            return;
        }

        if(cornerTest(testmove) != null) {
            int x = cornerTest(testmove)[0];
            int y = cornerTest(testmove)[1];
            setMove(x,y);
            return;
        }


        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if (testmove[x][y] == 0) {
                    setMove(x,y);
                    return;
                }
            }
        }






    }


    private int[] cornerTest(int[][] test) {
        int[] corner = new int[2];

        if(test[0][0] == 0) {
            corner[0] = 0;
            corner[1] = 0;
            return corner;
        }
        if(test[0][2] == 0) {
            corner[0] = 0;
            corner[1] = 2;
            return corner;
        }
        if(test[2][0] == 0) {
            corner[0] = 2;
            corner[1] = 0;
            return corner;
        }
        if(test[2][2] == 0) {
            corner[0] = 2;
            corner[1] = 2;
            return corner;
        }

       return null;
    }


    private void setMove(int x, int y) {
        nextMove[0] = x;
        nextMove[1] = y;

    }

    public int[] getMove() {
        return nextMove;
    }



    private boolean winTest(int[][] test) {


        for(int i = 0; i<3; i++) {
            if(test[i][0] >0 && test[i][1] > 0 && test[i][2] > 0) {
                if(test[i][0] == test[i][1] && test[i][1] == test[i][2]){
                    return true;

                }
            }
            if(test[0][i] >0 && test[1][i] > 0 && test[2][i] > 0) {
                if(test[0][i] == test[1][i] && test[1][i] == test[2][i]){
                    return true;

                }
            }
        }

        if(test[0][0] >0 && test[1][1] > 0 && test[2][2] > 0) {
            if(test[0][0] == test[1][1] && test[1][1] == test[2][2]){
                return true;

            }
        }

        if(test[0][2] >0 && test[1][1] > 0 && test[2][0] > 0) {
            if(test[0][2] == test[1][1] && test[1][1] == test[2][0]){
                return true;

            }
        }

        return false;





    }
    //--------------------#win test--------------------


    public boolean isDrawTest() {
        return drawTest;
    }

    public void setDrawTest(boolean drawTest) {
        this.drawTest = drawTest;
    }

    public int[][] getPress() {
        return press;
    }

    public void setPress(int[][] press) {
        this.press = press;
    }

    public int getPressi(int x, int y) {
        return press[x][y];
    }
}
