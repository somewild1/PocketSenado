package com.diegoabreu.pocketsenado.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diegoabreu.pocketsenado.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComissoesFragment extends Fragment {


    public ComissoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comissoes, container, false);
    }

}
