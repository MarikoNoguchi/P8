package edu.mnstate.cw3967me.p8;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
show a list of results
 Mariko Noguchi
 10/31/2016
 */
public class ResultsFragment extends Fragment {

    Globals globals;
    TextView name;
    ListView results_list;

    @Override
    public View onCreateView(LayoutInflater inf, ViewGroup container, Bundle savedInstanceState) {
        globals = (Globals) getActivity().getApplication();

        //inflate the layout for this fragment
        View view = inf.inflate(R.layout.results_fragment, container, false);

        //get and set the user's name
        name = (TextView) view.findViewById(R.id.name);
        name.setText(globals.name);

        //display the list of results
        results_list = (ListView) view.findViewById(R.id.results_list);
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), 0, globals.results);
        results_list.setAdapter(customAdapter);

        return view;
    }
}

