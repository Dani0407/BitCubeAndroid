package com.example.aa.ui.perfil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.aa.Base;
import com.example.aa.MainActivity;
import com.example.aa.R;
import com.example.aa.databinding.FragmentPerfilBinding;

public class PerfilFragment extends Fragment {

    private FragmentPerfilBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PerfilViewModel perfilViewModel = new ViewModelProvider(this).get(PerfilViewModel.class);
        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Cargar datos del usuario
        cargarDatosUsuario();

        // Configurar botones
        configurarBotones();

        return root;
    }

    private void cargarDatosUsuario() {
        String correoUsuario = obtenerCorreoAutenticado();
        Base baseDatos = new Base(getContext(), "administrador", null, 1);
        Cursor cursor = baseDatos.obtenerUsuario(correoUsuario);

        if (cursor != null && cursor.moveToFirst()) {
            String nombre = cursor.getString(cursor.getColumnIndex("nombreUsuario"));
            binding.nombreU.setText(nombre);
            binding.correoU.setText(correoUsuario);
            cursor.close();
        }
    }

    private void configurarBotones() {
        binding.btnActualizarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActualizarDatos.class);
                startActivity(intent);
            }
        });

        binding.btnfc.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"))));
        binding.btnig.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com"))));

        binding.btnCS.setOnClickListener(view -> {
            cerrarSesion();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        });
    }

    private String obtenerCorreoAutenticado() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        String correo = sharedPreferences.getString("correoUsuario", "Usuario no identificado");
        Log.d("PerfilFragment", "Correo recuperado: " + correo);
        return correo;
    }

    private void cerrarSesion() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("correoUsuario");
        editor.apply();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
