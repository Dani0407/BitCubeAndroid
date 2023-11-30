package com.example.aa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity implements View.OnClickListener {
    Button btninise, btnVolver;
    EditText editCorreo, editContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        btninise = findViewById(R.id.btninic);
        editCorreo = findViewById(R.id.editcorreoo);
        editContrasena = findViewById(R.id.contra);
        btnVolver = findViewById(R.id.volver);

        btninise.setOnClickListener(this);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InicioSesion.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        String correo = editCorreo.getText().toString().trim();
        String contrasena = editContrasena.getText().toString().trim();

        if (!correo.isEmpty() && !contrasena.isEmpty()) {
            if (validarUsuario(correo, contrasena)) {

                SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasUsuario", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("correoUsuario", correo);
                editor.apply();

                Intent intentadito = new Intent(this, NavDrawerActivity.class);
                startActivity(intentadito);
                Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Por favor, ingrese su correo y contraseña", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validarUsuario(String correo, String contrasena) {
        Base admin = new Base(this, "administrador", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        String[] parametros = {correo, contrasena};
        String[] campos = {"nombreUsuario"};

        Cursor cursor = db.query("Usuario", campos, "correoUsuario =? AND contrasenaUsuario =?", parametros, null, null, null);

        boolean existeUsuario = cursor.moveToFirst();
        cursor.close();
        db.close();

        return existeUsuario;
    }
}
