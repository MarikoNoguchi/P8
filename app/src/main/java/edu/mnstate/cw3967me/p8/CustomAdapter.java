package edu.mnstate.cw3967me.p8;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 set an Array of Result objects into a ListView
 Mariko Noguchi
 10/31/2016
 */
public class CustomAdapter extends ArrayAdapter<Result> {
    PackageManager packageManager;
    LayoutInflater inflater;
    ArrayList<Result> results; //array of Result objects

    public CustomAdapter(Context context, int textViewResourceId, ArrayList<Result> results) {
        super(context, textViewResourceId, results);
        this.results = results;
        inflater = LayoutInflater.from(context);
        packageManager = context.getPackageManager();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.results_item, null);
        TextView user = (TextView) view.findViewById(R.id.user);
        TextView round = (TextView) view.findViewById(R.id.round);
        TextView computer = (TextView) view.findViewById(R.id.computer);

        user.setText(results.get(i).getUser());
        round.setText(results.get(i).getRound());
        computer.setText(results.get(i).getComputer());

        return view;
    }
}
