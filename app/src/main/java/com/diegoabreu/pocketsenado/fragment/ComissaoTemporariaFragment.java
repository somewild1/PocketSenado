package com.diegoabreu.pocketsenado.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diegoabreu.pocketsenado.R;

public class ComissaoTemporariaFragment extends Fragment {

    View myView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_comissao_temporaria, container, false);
        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}
