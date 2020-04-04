package com.crosoften.projetoswapi.activiy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crosoften.projetoswapi.R;
import com.crosoften.projetoswapi.adapter.ListaPersonagensAdapter;
import com.crosoften.projetoswapi.data.responses.PaginadoListaPersonagensReponse;

public class ListaPersonagensActivity extends AppCompatActivity {
    private RecyclerView rvPersonagens;
    private ListaPersonagensViewModel viewModel;
    private Button btnNext, btnPrev;
    Integer page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personagens);
        listeners();
        viewModel = new ViewModelProvider(this).get(ListaPersonagensViewModel.class);
        btnNext.setOnClickListener(click -> {
            page++;
            viewModel.getAllPersonagensPaginado(page);
        });
        btnPrev.setOnClickListener(click -> {
            page--;
            viewModel.getAllPersonagensPaginado(page);
        });
        viewModel.getAllPersonagensPaginado(page).observe(this, result -> {
            holdNextPrevButton(result);
            rvPersonagens.setAdapter(new ListaPersonagensAdapter(result.getResults()));
            rvPersonagens.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        });
    }

    private void listeners() {
        rvPersonagens = findViewById(R.id.rvPersonagens);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
    }

    private void holdNextPrevButton(PaginadoListaPersonagensReponse result) {
        if (result.getNext() == null) {
            btnNext.setVisibility(View.GONE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
        }
        if (result.getPrevious() == null) {
            btnPrev.setVisibility(View.GONE);
        } else {
            btnPrev.setVisibility(View.VISIBLE);
        }
    }
}
