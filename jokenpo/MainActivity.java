package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgP1;
    private ImageView imgP2;
    Random RandJokenpo1 = new Random();
    Random RandJokenpo2 = new Random();
    private TextView p1Name;
    private TextView p2Name;
    private TextView p1NameDisplay;
    private TextView p2NameDisplay;
    private TextView winnerText;


    int[] images = {R.drawable.papel, R.drawable.tesoura, R.drawable.pedra};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgP1 = findViewById(R.id.imageP1);
        imgP2 = findViewById(R.id.imageP2);
        p1Name = findViewById(R.id.p1Display);
        p2Name = findViewById(R.id.p2Display);
        p1NameDisplay = findViewById(R.id.idPl1Turn);
        p2NameDisplay = findViewById(R.id.idPl2Turn);
        winnerText = findViewById(R.id.txtWinner);

    }

    public void play(View view){
        String name1 = p1Name.getText().toString();
        String name2 = p2Name.getText().toString();
        p1NameDisplay.setText(name1);
        p2NameDisplay.setText(name2);
        p2NameDisplay.setVisibility(View.VISIBLE);
        p1NameDisplay.setVisibility(View.VISIBLE);

        int p1TurnPlay = RandJokenpo1.nextInt(3);
        int p2TurnPlay = RandJokenpo2.nextInt(3);
        imgP1.setImageResource(images[p1TurnPlay]);
        imgP2.setImageResource(images[p2TurnPlay]);
        imgP1.setVisibility(View.VISIBLE);
        imgP2.setVisibility(view.VISIBLE);

        String winner = "Empate!";

        if(((p1TurnPlay == 1) && (p2TurnPlay == 0)) || ((p1TurnPlay == 2) && (p2TurnPlay == 1)) || ((p1TurnPlay == 0) && (p2TurnPlay == 2))){
            winner = name1;
        }else if(p1TurnPlay != p2TurnPlay){
            winner = name2;
        }

        if (winner == "Empate!"){
            winnerText.setVisibility(View.VISIBLE);
            winnerText.setText(winner);
        }else{
            winnerText.setVisibility(View.VISIBLE);
            winnerText.setText(winner + " Ganhou!");
        }
    }
}
