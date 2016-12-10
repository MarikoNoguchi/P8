package edu.mnstate.cw3967me.p8;

import android.app.Application;

import java.util.ArrayList;

/**
    store global values which every classes can use
 Mariko Noguchi
 10/31/2016
 */

public class Globals extends Application {
    //global values
    int rounds = 0;
    String name = "YOU";
    ArrayList<Result> results = new ArrayList<Result>(); //an array of result objects

}

