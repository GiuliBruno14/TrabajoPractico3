package com.example.trabajopractico3.ui.cargar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trabajopractico3.R;
import com.example.trabajopractico3.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {

    private CargarViewModel mv;
    private FragmentCargarBinding binding;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mv = new ViewModelProvider(this).get(CargarViewModel.class);
        binding =FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btGuardar.setOnClickListener(v -> {
            String nota = binding.etNota.getText().toString();
            if(!nota.isEmpty()){
               mv.agregarNota(nota);
                Toast.makeText(getActivity(),"Nota agregada a la lista", Toast.LENGTH_SHORT).show();
                binding.etNota.setText("");
            } else {
            Toast.makeText(getActivity(), "No se puede guardar una nota vacía", Toast.LENGTH_SHORT).show();
        }

    });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mv = new ViewModelProvider(this).get(CargarViewModel.class);
        // TODO: Use the ViewModel
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Limpiar referencia de binding
    }

}