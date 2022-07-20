package com.example.pets_donation.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pets_donation.Cadastro_Abrigo;
import com.example.pets_donation.Cadastro_Animal;
import com.example.pets_donation.Cadastro_Funcionario;
import com.example.pets_donation.Funcionario;
import com.example.pets_donation.Funcionario_Duvidas;
import com.example.pets_donation.Funcionario_ListCadastros;
import com.example.pets_donation.Listar_Abrigos;
import com.example.pets_donation.R;

import java.util.Calendar;

public class FuncionarioCadastro_Fragment extends Fragment {

    private Funcionario funcionario;
    private ListView listView;
    private TextView textView;

    String[] maintitle = {
            "Cadastrar Abrigo",
            "Cadastrar Animal",
            "Cadastrar Funcionário",
    };

    String[] subtitle = {
            "Informações gerais do abrigo", "Registro geral do animal",
            "Efetivar registro do funcionário",
    };

    Integer[] imgid = {
            R.drawable.adicionar_abrigo_vector, R.drawable.pets_vector,
            R.drawable.adicionar_funcionario_vector,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("CADASTROS");

        this.funcionario = (Funcionario) getActivity().getIntent().getSerializableExtra("funcionario");
        Log.i("Funcionario Cadastro", "NOME: " + funcionario.getNome());
        return inflater.inflate(R.layout.fragment_funcionario_cadastro_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        listView = view.findViewById(R.id.listViewPerfil);
        textView = view.findViewById(R.id.textoBoas);

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {
            textView.setText("Bom Dia " + funcionario.getNome());
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            textView.setText("Boa Tarde " + funcionario.getNome());
        } else if (timeOfDay >= 16 && timeOfDay < 24) {
            textView.setText("Boa Noite " + funcionario.getNome());
        }


        Funcionario_ListCadastros adapter = new Funcionario_ListCadastros(getActivity(), maintitle, subtitle, imgid);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Intent intent = new Intent(getActivity(), Cadastro_Abrigo.class);
                        intent.putExtra("funcionario", funcionario);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent = new Intent(getActivity(), Cadastro_Animal.class);
                        intent.putExtra("funcionario", funcionario);

                        startActivity(intent);
                        break;
                    }
                    default: {
                        Intent intent = new Intent(getActivity(), Cadastro_Funcionario.class);
                        intent.putExtra("adm", funcionario);
                        startActivity(intent);
                        break;
                    }
                }
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}