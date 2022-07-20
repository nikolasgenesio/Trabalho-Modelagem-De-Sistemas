package com.example.pets_donation.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pets_donation.Funcionario;
import com.example.pets_donation.R;

public class FuncionarioAdocao_Fragment extends Fragment {

    private Funcionario funcionario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.funcionario = (Funcionario) getActivity().getIntent().getSerializableExtra("funcionario");
        Log.i("Funcionario Adocao", "NOME: " + funcionario.getNome());
        return inflater.inflate(R.layout.fragment_funcionario_adocao_, container, false);
    }
}