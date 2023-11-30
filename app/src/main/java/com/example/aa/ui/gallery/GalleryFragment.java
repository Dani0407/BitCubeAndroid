package com.example.aa.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.aa.Ahorcado;
import com.example.aa.Gato;
import com.example.aa.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        configurarBotones();

        return root;
    }

    private void configurarBotones() {
        binding.btnAhorcado.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Juego Ahorcado");
            builder.setPositiveButton("Aceptar", (dialog, which) -> {
                String mensaje = "¡El otro jugador intenta adivinar las letras de la palabra una por una. " +
                        "Por cada letra incorrecta, " +
                        "se dibuja una parte de un muñeco ahorcado!";
                Intent intent = new Intent(getActivity(), Ahorcado.class);
                intent.putExtra("Hola: ", mensaje);

                startActivity(intent);
            });

            builder.show();
        });

        binding.btnGato.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Juego Gato");
            builder.setPositiveButton("Aceptar", (dialog, which) -> {
                String mensaje = "¡El objetivo es lograr tener tres de sus fichas en línea," +
                        " ya sea horizontal, vertical o diagonal, " +
                        "antes que el oponente!";
                Intent intent = new Intent(getActivity(), Gato.class);
                intent.putExtra("Hola: ", mensaje);

                startActivity(intent);
            });

            builder.show();
        });

    }
        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }
    }
