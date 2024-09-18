package com.example.trabajopractico3.ui.listar;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;

import com.example.trabajopractico3.R;
import com.example.trabajopractico3.databinding.ItemNotaBinding;

import java.util.ArrayList;
import java.util.List;

public class ListarAdapter extends RecyclerView.Adapter<ListarAdapter.ViewHolder> {

    private List<String> listaNotas;

    public ListarAdapter(List<String> listaNotas) {
        this.listaNotas = listaNotas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_nota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nota = listaNotas.get(position);
        holder.textViewNota.setText(nota);  // Asignar texto de la nota al TextView
    }

    @Override
    public int getItemCount() {
        return listaNotas.size();
    }
    public void actualizarLista(List<String> nuevasNotas) {
        this.listaNotas = nuevasNotas;
        notifyDataSetChanged();  // Notificar al adaptador que los datos cambiaron
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNota;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNota = itemView.findViewById(R.id.textViewNota);  // Enlazar el TextView
        }
    }
}

