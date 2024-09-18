package com.example.trabajopractico3.ui.listar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajopractico3.MainActivity;

import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.Collections;

public class ListarViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<ArrayList<String>> listaNotas;

    public ListarViewModel() {
        listaNotas = new MutableLiveData<>(new ArrayList<>(MainActivity.lista));
    }

    public LiveData<ArrayList<String>> getListaNotas() {
        return listaNotas;
    }

    public void actualizarLista() {
        ArrayList<String> notasActualizadas = new ArrayList<>(MainActivity.lista);
        Collections.sort(notasActualizadas);  // Ordenar alfabéticamente
        listaNotas.setValue(notasActualizadas);  // Actualizar LiveData con la lista ordenada
    }
}