package edu.mnstate.cw3967me.p8;

import android.app.Activity;
import android.os.Bundle;

/**
show the activity_results layout which has a fragment element defined by ResultsFragment class
 Mariko Noguchi
 10/31/2016
 */
public class resultsActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the view for the activity using XML
        setContentView(R.layout.activity_results);
    }
}
