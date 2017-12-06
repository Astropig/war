package com.example.astro.war;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static Army playerOneArmy = new Army(1, 1, 10, 20);
    public static Army playerTwoArmy = new Army(1, 1, 10, 20);
    public Button playerOneButton;
    public Button playerTwoButton;

    public TextView message;

    public TextView armyOneText;
    public TextView armyTwoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Random rnd = new Random();
        final ImageView armyOneImage = (ImageView) findViewById(R.id.armyOneImage);
        final ImageView armyTwoImage = (ImageView) findViewById(R.id.armyTwoImage);


        playerOneButton = (Button) findViewById(R.id.playerOneButton);
        playerTwoButton = (Button) findViewById(R.id.playerTwoButton);

        message = (TextView) findViewById(R.id.message);

        armyTwoText = (TextView) findViewById(R.id.armyTwoText);
        armyOneText = (TextView) findViewById(R.id.armyOneText);



        playerTwoButton.setEnabled(false);

        playerOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fight = playerOneArmy.attack(rnd.nextInt(3));

                playerOneButton.setEnabled(false);
                playerTwoButton.setEnabled(true);
                message.setText("Player 2 turn");
                checkIfWin(playerTwoArmy.battle(fight));

            }
        });

        playerTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fight = playerTwoArmy.attack(rnd.nextInt(3));
                playerTwoButton.setEnabled(false);
                playerOneButton.setEnabled(true);

                message.setText("Player 1 turn");
                checkIfWin(playerOneArmy.battle(fight));

            }
        });
    }

    public void checkIfWin(int battle)
    {
        if (battle == -1)
        {
            if (playerOneArmy.getMen() > 0)
            {
                Log.d("end", "Player 2 wins");
                message.setText("Player 2 wins");
                playerOneButton.setEnabled(false);
                playerTwoButton.setEnabled(false);
            }
            else
            {
                Log.d("end", "Player 1 wins");
                message.setText("Player 1 wins");
                playerOneButton.setEnabled(false);
                playerTwoButton.setEnabled(false);
            }
        }
    }

}
