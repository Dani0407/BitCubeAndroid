package com.example.aa.ui.perfil;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aa.Base;
import com.example.aa.R;
import com.example.aa.Registroo;

public class ActualizarDatos extends AppCompatActivity {

    EditText etNombre, etApePat, etApeMat, etTelefono, etContra, etRFC, etCodigo, etNomInf, etApePatInf, etApeMatInf, etEdadInf;
    Spinner spSexoInf;
    Button btnActualizar;
    String correoUsuario;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos);


        etNombre = findViewById(R.id.nombre);
        etApePat = findViewById(R.id.apePat);
        etApeMat = findViewById(R.id.apeMat);
        etTelefono = findViewById(R.id.tel);
        etContra = findViewById(R.id.contra);
        etRFC = findViewById(R.id.rfc);
        etCodigo = findViewById(R.id.cod);
        etNomInf = findViewById(R.id.nomInf);
        etApePatInf = findViewById(R.id.apePatInf);
        etApeMatInf = findViewById(R.id.apeMatInf);
        etEdadInf = findViewById(R.id.edadinf);
        spSexoInf = findViewById(R.id.sexoinf);
        btnActualizar = findViewById(R.id.btnregis);


        cargarDatosUsuario();

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarDatosUsuario();
                finish();
            }
        });
    }

    @SuppressLint("Range")
    private void cargarDatosUsuario() {
        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasUsuario", MODE_PRIVATE);
        correoUsuario = sharedPreferences.getString("correoUsuario", null);
        if (correoUsuario != null) {
            Base baseDatos = new Base(this, "administrador", null, 1);
            Cursor cursor = baseDatos.obtenerUsuario(correoUsuario);
            if (cursor.moveToFirst()) {
                etNombre.setText(cursor.getString(cursor.getColumnIndex("nombreUsuario")));
                etApePat.setText(cursor.getString(cursor.getColumnIndex("apePatUsuario")));
                etApeMat.setText(cursor.getString(cursor.getColumnIndex("apeMatUsuario")));
                etTelefono.setText(cursor.getString(cursor.getColumnIndex("telUsuario")));
                etContra.setText(cursor.getString(cursor.getColumnIndex("contrasenaUsuario")));
                etRFC.setText(cursor.getString(cursor.getColumnIndex("RFC")));
                etCodigo.setText(cursor.getString(cursor.getColumnIndex("codigo")));
                etNomInf.setText(cursor.getString(cursor.getColumnIndex("nombreInfante")));
                etApePatInf.setText(cursor.getString(cursor.getColumnIndex("apePatInfante")));
                etApeMatInf.setText(cursor.getString(cursor.getColumnIndex("apeMatInfante")));
                etEdadInf.setText(cursor.getString(cursor.getColumnIndex("edadInfante")));
                cursor.close();
            }
        }
    }

    private void actualizarDatosUsuario() {
        ContentValues valores = new ContentValues();
        valores.put("nombreUsuario", etNombre.getText().toString());
        valores.put("apePatUsuario", etApePat.getText().toString());
        valores.put("apeMatUsuario", etApeMat.getText().toString());
        valores.put("telUsuario", etTelefono.getText().toString());
        valores.put("contrasenaUsuario", etContra.getText().toString());
        valores.put("RFC", etRFC.getText().toString());
        valores.put("codigo", etCodigo.getText().toString());
        valores.put("nombreInfante", etNomInf.getText().toString());
        valores.put("apePatInfante", etApePatInf.getText().toString());
        valores.put("apeMatInfante", etApeMatInf.getText().toString());
        valores.put("edadInfante", etEdadInf.getText().toString());

        Base baseDatos = new Base(this, "administrador", null, 1);
        boolean exito = baseDatos.actualizarUsuario(correoUsuario, valores);
        if (exito) {
            Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al actualizar datos", Toast.LENGTH_SHORT).show();
        }
    }
}
