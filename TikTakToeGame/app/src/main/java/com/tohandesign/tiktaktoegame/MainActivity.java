package com.tohandesign.tiktaktoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

        public Intent gameIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameIntent = new Intent(this, GameActivity.class);
        Button playbutton = (Button) findViewById(R.id.playGame);

        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean bl = false;
                gameIntent.putExtra("CPU_VALUE", bl);
                startActivity(gameIntent);
            }
        });

        Button cpuButton = (Button) findViewById(R.id.playCPU);

        cpuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean bl = true;
                gameIntent.putExtra("CPU_VALUE", bl);
                startActivity(gameIntent);
            }
        });

    }
}
