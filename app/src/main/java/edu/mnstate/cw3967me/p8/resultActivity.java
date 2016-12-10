package edu.mnstate.cw3967me.p8;

/*
judge and show the result
Mariko Noguchi
10/31/2016
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class resultActivity extends AppCompatActivity {

    ImageView imgUserHand;
    ImageView imgCompHand;
    int userHand;
    int compHand;
    TextView lblWinner;

    Globals globals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        globals = (Globals) this.getApplication();
        setContentView(R.layout.activity_result);

        //get references for each resource on the interface
        imgUserHand = (ImageView) findViewById(R.id.imgUserHand);
        imgCompHand = (ImageView) findViewById(R.id.imgCompHand);
        lblWinner = (TextView) findViewById(R.id.lblWinner);

        Intent intent = getIntent();
        userHand = intent.getIntExtra("userHand", 0);//which hand the user chose
        if (userHand == 0) {
            imgUserHand.setImageResource(R.drawable.user_rock);
        } else if (userHand == 1) {
            imgUserHand.setImageResource(R.drawable.user_scissors);
        } else {
            imgUserHand.setImageResource(R.drawable.user_paper);
        }

        //choose computer's hand randomly
        Random rand = new Random();
        compHand = rand.nextInt(3);
        if (compHand == 0) {
            imgCompHand.setImageResource(R.drawable.comp_rock);
        } else if (compHand == 1) {
            imgCompHand.setImageResource(R.drawable.comp_scissors);
        } else {
            imgCompHand.setImageResource(R.drawable.com_paper);
        }

        String winner = resultLogic();
        lblWinner.setText(winner);

    }

    private String resultLogic() {//judge the result
        Result result = new Result();
        globals.rounds++;
        result.setRound(Integer.toString(globals.rounds));

        if (userHand == compHand) {
            result.setUser("draw");
            result.setComputer("draw");
            globals.results.add(result);
            return getString(R.string.draw);//draw
        } else if ((userHand == 0 && compHand == 1) || (userHand == 1 && compHand == 2) || (userHand == 2 && compHand == 0)) {
            result.setUser("win!");
            globals.results.add(result);
            return globals.name + " " + getString(R.string.won);//user won
        } else {
            result.setComputer("win!");
            globals.results.add(result);
            return getString(R.string.com_won);//computer won
        }
    }

    public void onClick(View v) {//try again button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
