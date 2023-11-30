package com.example.aa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

public class Registroo extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText cod, nombre, apePat, apeMat, correo, tel, contra, rfc, nomInf, apePatInf, apeMatInf, edadinf;
    Spinner sexoinf;
    Button btnregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registroo);

        btnregis = findViewById(R.id.btnregis);
        btnregis.setOnClickListener(this);

        cod = findViewById(R.id.cod);
        nombre = findViewById(R.id.nombre);
        apePat = findViewById(R.id.apePat);
        apeMat = findViewById(R.id.apeMat);
        correo = findViewById(R.id.correo);
        tel = findViewById(R.id.tel);
        contra = findViewById(R.id.contra);
        rfc = findViewById(R.id.rfc);
        nomInf = findViewById(R.id.nomInf);
        apePatInf = findViewById(R.id.apePatInf);
        apeMatInf = findViewById(R.id.apeMatInf);
        sexoinf = findViewById(R.id.sexoinf);
        sexoinf.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexoinf.setAdapter(adapter);
        edadinf = findViewById(R.id.edadinf);
    }

    @Override
    public void onClick(View view) {
        String cadenita = ((Button) view).getText().toString();
        if (cadenita.equals("Regístrate")) {
            if (validarCamposLlenos()) {
                String nom = nombre.getText().toString();
                String aPat = apePat.getText().toString();
                String aMat = apeMat.getText().toString();
                String cor = correo.getText().toString();
                String tEl = tel.getText().toString();
                String cont = contra.getText().toString();
                String RFC = rfc.getText().toString();
                String cOd = cod.getText().toString();
                String nominf = nomInf.getText().toString();
                String aPatinf = apePatInf.getText().toString();
                String aMatinf = apeMatInf.getText().toString();
                String edadInf = edadinf.getText().toString();
                String sexinf = sexoinf.getSelectedItem().toString();

                Base admin = new Base(this, "administrador", null, 1);
                boolean isInserted = admin.insertData(nom, aPat, aMat, tEl, cor, cont, RFC, cOd, nominf, aPatinf, aMatinf, edadInf, sexinf);

                if (isInserted) {
                    SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasUsuario", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("correoUsuario", cor);
                    editor.apply();
                    Log.d("Registroo", "Usuario registrado con correo: " + cor);
                    Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder mensa = new AlertDialog.Builder(this);
                    mensa.setTitle("Porfavor llena el formulario de <Especificaciones Médicas>");
                    mensa.setMessage("Puede llenarlo más tarde, sin embargo no contarás con reporte de progreso mensual hasta que lo lllenes");
                    mensa.setNegativeButton("Llenar más tarde", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(Registroo.this, InicioSesion.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Gracias por Registrarte, Inicia Sesión para continuar", Toast.LENGTH_SHORT).show();
                        }
                    });
                    mensa.setPositiveButton("Ir a llenar Especificaciones", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(Registroo.this, EspMedicas.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog dialog = mensa.create();
                    dialog.show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error en el registro", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Datos no llenados", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validarCamposLlenos() {
        return !nombre.getText().toString().isEmpty() &&
                !apePat.getText().toString().isEmpty() &&
                !apeMat.getText().toString().isEmpty() &&
                !correo.getText().toString().isEmpty() &&
                !tel.getText().toString().isEmpty() &&
                !contra.getText().toString().isEmpty() &&
                !rfc.getText().toString().isEmpty() &&
                !nomInf.getText().toString().isEmpty() &&
                !apePatInf.getText().toString().isEmpty() &&
                !apeMatInf.getText().toString().isEmpty() &&
                !edadinf.getText().toString().isEmpty() &&
                sexoinf.getSelectedItem() != null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Manejo de la selección de elementos en el Spinner.
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Manejo cuando no se selecciona ningún elemento en el Spinner.
    }
}
