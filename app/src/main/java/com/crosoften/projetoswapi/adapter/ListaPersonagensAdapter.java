package com.crosoften.projetoswapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.crosoften.projetoswapi.R;
import com.crosoften.projetoswapi.data.responses.ListaPersonagensRespose;

import java.util.List;

public class ListaPersonagensAdapter extends RecyclerView.Adapter<ListaPersonagensAdapter.RecyclerViewHolder> {
    List<ListaPersonagensRespose> personagens;

    public ListaPersonagensAdapter(List<ListaPersonagensRespose> personagens) {
        this.personagens = personagens;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people,parent,false);
        return new ListaPersonagensAdapter.RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        if(!personagens.isEmpty()) {
            holder.name.setText(personagens.get(position).getName());
            StringBuilder sb = new StringBuilder();
            sb.append(holder.mass.getText());
            sb.append(personagens.get(position).getMass());
            sb.append(" KG");
            holder.mass.setText(sb.toString());
            holder.eyeColor.setText(personagens.get(position).getEye_color());
        }
    }

    @Override
    public int getItemCount() {
        return personagens.isEmpty() ? 0 : personagens.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView name,eyeColor,mass;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            eyeColor = itemView.findViewById(R.id.tvEyeColor);
            mass = itemView.findViewById(R.id.tvMass);
        }
    }
}
