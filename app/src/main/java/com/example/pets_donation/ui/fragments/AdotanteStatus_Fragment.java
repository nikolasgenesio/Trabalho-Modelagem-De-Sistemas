package com.example.pets_donation.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pets_donation.Adotante;
import com.example.pets_donation.R;

public class AdotanteStatus_Fragment extends Fragment {

    private Adotante adotante;
    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.adotante = (Adotante) getActivity().getIntent().getSerializableExtra("adotante");
        Log.i("Tarefa 1 - status Status", "NOME: " + adotante.getNome());
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adotante_status_, container, false);
    }
}