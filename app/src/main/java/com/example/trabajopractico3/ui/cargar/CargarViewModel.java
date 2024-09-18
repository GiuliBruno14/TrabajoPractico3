package com.example.trabajopractico3.ui.cargar;

import androidx.lifecycle.ViewModel;

import com.example.trabajopractico3.MainActivity;

public class CargarViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    public void agregarNota(String s){
        MainActivity.lista.add(s);
        System.out.println("Lista actualizada: "+MainActivity.lista.toString());
    }
}