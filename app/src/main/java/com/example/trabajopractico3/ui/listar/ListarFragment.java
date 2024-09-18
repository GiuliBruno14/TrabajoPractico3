package com.example.trabajopractico3.ui.listar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trabajopractico3.R;
import com.example.trabajopractico3.databinding.FragmentListarBinding;

import java.util.ArrayList;

public class ListarFragment extends Fragment {
    private ListarViewModel mv;
    private FragmentListarBinding binding;
    private ListarAdapter listarAdapter;


    public static ListarFragment newInstance() {
        return new ListarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mv = new ViewModelProvider(this).get(ListarViewModel.class);
        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Configurar RecyclerView
        binding.recyclerViewNotas.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inicializar Adapter
        listarAdapter = new ListarAdapter(new ArrayList<>());  // Se pasa una lista vacía por defecto
        binding.recyclerViewNotas.setAdapter(listarAdapter);

        // Observer para actualizar la lista cuando cambien los datos
        mv.getListaNotas().observe(getViewLifecycleOwner(), notas -> {
            listarAdapter.actualizarLista(notas);  // Actualiza los datos del Adapter
        });

        mv.actualizarLista();  // Actualiza la lista desde el ViewModel

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;  // Limpiar referencia de binding
    }
}