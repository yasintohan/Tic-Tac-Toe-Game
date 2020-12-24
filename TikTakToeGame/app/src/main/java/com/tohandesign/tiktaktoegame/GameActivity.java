package com.tohandesign.tiktaktoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    public int[][] press = new int[3][3];
    public int round = 1;
    public int turn = 1;

    public boolean wintester = false;
    public boolean drawtester = false;
    public boolean resettest = false;
    public boolean pause = false;
    public boolean CPUtest;


    public TextView turnText;
    public TextView roundText;
    public TextView p1scoretext;
    public TextView p2scoretext;
    public int p1score = 0;
    public int p2score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        turnText = (TextView) findViewById(R.id.turnText);
        roundText = (TextView) findViewById(R.id.roundText);
        p1scoretext = (TextView) findViewById(R.id.p1score);
        p2scoretext = (TextView) findViewById(R.id.p2score);
        CPUtest = getIntent().getBooleanExtra("CPU_VALUE", false);


    }


    //--------------------top left--------------------
    public void topleft(View v) {
        if(press[0][0] == 0 && pause == false) {

            press[0][0] = turn;


            drawTable();
            winTest();
            if(!wintester && !pause)
                changeTurn();

        }


    }
    //--------------------#top left--------------------


    //--------------------top mid--------------------
    public void topmid(View v) {
        if(press[0][1] == 0 && pause == false) {

            press[0][1] = turn;


            drawTable();
            winTest();
            if(!wintester && !pause)
                changeTurn();

        }
    }
    //--------------------#top mid--------------------

    //--------------------top right--------------------
    public void topright(View v) {
        if(press[0][2] == 0 && pause == false) {

            press[0][2] = turn;


            drawTable();
            winTest();
            if(!wintester && !pause)
                changeTurn();

        }
    }
    //--------------------#top mid--------------------







    //--------------------mid left--------------------
    public void midleft(View v) {
        if(press[1][0] == 0 && pause == false) {

            press[1][0] = turn;


            drawTable();
            winTest();
            if(!wintester && !pause)
                changeTurn();

        }


    }
    //--------------------#mid left--------------------


    //--------------------mid mid--------------------
    public void midmid(View v) {
        if(press[1][1] == 0 && pause == false) {

            press[1][1] = turn;


            drawTable();
            winTest();
            if(!wintester && !pause)
                changeTurn();

        }
    }
    //--------------------#mid mid--------------------

    //--------------------mid right--------------------
    public void midright(View v) {
        if(press[1][2] == 0 && pause == false) {

            press[1][2] = turn;


            drawTable();
            winTest();
            if(!wintester && !pause)
                changeTurn();

        }
    }
    //--------------------#mid mid--------------------






    //--------------------bot left--------------------
    public void botleft(View v) {
        if(press[2][0] == 0 && pause == false) {

            press[2][0] = turn;


            drawTable();
            winTest();
            if(!wintester && !pause)
                changeTurn();

        }


    }
    //--------------------#bot left--------------------


    //--------------------bot mid--------------------
    public void botmid(View v) {
        if(press[2][1] == 0 && pause == false) {

            press[2][1] = turn;


            drawTable();
            winTest();
            if(!wintester && !pause)
                changeTurn();

        }
    }
    //--------------------#bot mid--------------------

    //--------------------bot right--------------------
    public void botright(View v) {
        if(press[2][2] == 0 && pause == false) {

            press[2][2] = turn;


            drawTable();
            winTest();
            if(!wintester && !pause)
                changeTurn();

        }
    }
    //--------------------#bot mid--------------------






    //--------------------Change Turn--------------------
    public void changeTurn() {
        if(turn == 1) {

            if(CPUtest){
                turn = 2;
                if(!wintester && !drawtester){
                    CPU cpu = new CPU(press);
                    cpu.chechMove();
                    int[] move = cpu.getMove();
                    press[move[0]][move[1]] = 2;
                    drawTable();
                    winTest();
                    turn = 1;
                }

            }else {
                turn = 2;
                turnText.setText("Player 2 Turn");
            }

        }
        else {
            turn = 1;
            turnText.setText("Player 1 Turn");
        }

    }
    //--------------------#Change Turn--------------------


    //--------------------Draw Table--------------------
    private void drawTable() {

        ImageView topleftimage = (ImageView) findViewById(R.id.topleft);
        ImageView topmidimage = (ImageView) findViewById(R.id.topmid);
        ImageView toprightimage = (ImageView) findViewById(R.id.topright);

        ImageView midleftimage = (ImageView) findViewById(R.id.midleft);
        ImageView midmidimage = (ImageView) findViewById(R.id.midmid);
        ImageView midrightimage = (ImageView) findViewById(R.id.midright);

        ImageView botleftimage = (ImageView) findViewById(R.id.botleft);
        ImageView botmidimage = (ImageView) findViewById(R.id.botmid);
        ImageView botrightimage = (ImageView) findViewById(R.id.botright);

        if(resettest== false) {
        if (press[0][0] > 0) {
            if (press[0][0] == 1)
                topleftimage.setImageResource(R.drawable.x);
            if (press[0][0] == 2)
                topleftimage.setImageResource(R.drawable.o);
        }

        if (press[0][1] > 0) {
            if (press[0][1] == 1)
                topmidimage.setImageResource(R.drawable.x);
            if (press[0][1] == 2)
                topmidimage.setImageResource(R.drawable.o);
        }

        if (press[0][2] > 0) {
            if (press[0][2] == 1)
                toprightimage.setImageResource(R.drawable.x);
            if (press[0][2] == 2)
                toprightimage.setImageResource(R.drawable.o);
        }


        if (press[1][0] > 0) {
            if (press[1][0] == 1)
                midleftimage.setImageResource(R.drawable.x);
            if (press[1][0] == 2)
                midleftimage.setImageResource(R.drawable.o);
        }

        if (press[1][1] > 0) {
            if (press[1][1] == 1)
                midmidimage.setImageResource(R.drawable.x);
            if (press[1][1] == 2)
                midmidimage.setImageResource(R.drawable.o);
        }

        if (press[1][2] > 0) {
            if (press[1][2] == 1)
                midrightimage.setImageResource(R.drawable.x);
            if (press[1][2] == 2)
                midrightimage.setImageResource(R.drawable.o);
        }


        if (press[2][0] > 0) {
            if (press[2][0] == 1)
                botleftimage.setImageResource(R.drawable.x);
            if (press[2][0] == 2)
                botleftimage.setImageResource(R.drawable.o);
        }

        if (press[2][1] > 0) {
            if (press[2][1] == 1)
                botmidimage.setImageResource(R.drawable.x);
            if (press[2][1] == 2)
                botmidimage.setImageResource(R.drawable.o);
        }

        if (press[2][2] > 0) {
            if (press[2][2] == 1)
                botrightimage.setImageResource(R.drawable.x);
            if (press[2][2] == 2)
                botrightimage.setImageResource(R.drawable.o);
        }

        }
        else if(resettest) {
            topleftimage.setImageDrawable(null);
            toprightimage.setImageDrawable(null);
            topmidimage.setImageDrawable(null);

            midleftimage.setImageDrawable(null);
            midmidimage.setImageDrawable(null);
            midrightimage.setImageDrawable(null);

            botleftimage.setImageDrawable(null);
            botmidimage.setImageDrawable(null);
            botrightimage.setImageDrawable(null);
            resettest = false;
        }



    }
    //--------------------#Draw Table--------------------



    //--------------------win test--------------------
    public void winTest() {


        for(int i = 0; i<3; i++) {
            if(press[i][0] >0 && press[i][1] > 0 && press[i][2] > 0) {
                if(press[i][0] == press[i][1] && press[i][1] == press[i][2]){
                    wintester = true;
                    winDialog();
                }
            }
            if(press[0][i] >0 && press[1][i] > 0 && press[2][i] > 0) {
                if(press[0][i] == press[1][i] && press[1][i] == press[2][i]){
                    wintester = true;
                    winDialog();
                }
            }
        }

        if(press[0][0] >0 && press[1][1] > 0 && press[2][2] > 0) {
            if(press[0][0] == press[1][1] && press[1][1] == press[2][2]){
                wintester = true;
                winDialog();
            }
        }

        if(press[0][2] >0 && press[1][1] > 0 && press[2][0] > 0) {
            if(press[0][2] == press[1][1] && press[1][1] == press[2][0]){
                wintester = true;
                winDialog();
            }
        }

        if(press[0][0] > 0 && press[0][1] > 0 && press[0][2] > 0 &&
                press[1][0] > 0 && press[1][1] > 0 && press[1][2] > 0 &&
                press[2][0] > 0 && press[2][1] > 0 && press[2][2] > 0 && wintester == false){
            drawtester = true;
            drawDialog();
        }





    }
    //--------------------#win test--------------------


    //--------------------new round--------------------
    public void newRound() {
        changeTurn();

        if(wintester){
            if(turn == 1) {
                p1score++;
                p1scoretext.setText(String.valueOf(p1score));
            }else if(turn == 2){
                p2score++;
                p2scoretext.setText(String.valueOf(p2score));
            }
            wintester = false;

        }


        round++;
        roundText.setText(String.valueOf(round));
        press = new int[3][3];
        resettest = true;
        pause = false;
        drawTable();
        drawtester = false;
        if(CPUtest && turn == 2 && !wintester) {
            turn = 1;
            changeTurn();
        }

    }
    //--------------------#new round--------------------

    //--------------------win dialog--------------------
    public void winDialog(){
        pause = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle("Player " + turn + " win the game");
        builder.setMessage("Will you continue the game?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pause = false;
                drawtester = false;
                newRound();


            }
        });
        final AlertDialog dialog=builder.create();
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if(pause)
                    dialog.show();
            }
        });
    }
    //--------------------#win dialog--------------------

    //--------------------draw dialog--------------------
    public void drawDialog(){
        pause = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle("Draw Game");
        builder.setMessage("Will you continue the game?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pause = false;
                newRound();

            }
        });
        final AlertDialog dialog=builder.create();
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if(pause)
                    dialog.show();
            }
        });
    }
    //--------------------#draw dialog--------------------


    //--------------------back dialog--------------------
    @Override
    public void onBackPressed() {
        pause = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle("Exit Game");
        builder.setMessage("Do you want to exit the game?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pause = false;
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);


            }
        });
        final AlertDialog dialog=builder.create();
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                pause = false;
            }
        });


    }
    //--------------------#back dialog--------------------






}
