package com.example.aa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aa.ui.gallery.GalleryFragment;

public class Ahorcado extends AppCompatActivity implements View.OnClickListener {
    TextView vistita, buscadito, numero;
    ImageView imagencita;
    EditText editadito;
    Button botoncito, botoncito2;
    String cadenitas[] = {"kike", "kikin", "kiko", "kikito", "kikote"};
    int sorteadito = 0;
    String cadenita = "";
    String cadenitaaux = "";
    String cadena3 = cadenitaaux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado);
        vistita = findViewById(R.id.vista);
        buscadito = findViewById(R.id.busca);
        numero = findViewById(R.id.numero);

        editadito = findViewById(R.id.textito);

        imagencita = findViewById(R.id.imagen);

        botoncito = findViewById(R.id.boton);
        botoncito.setOnClickListener(this);
        botoncito2 = findViewById(R.id.boton2);
        botoncito2.setOnClickListener(this);

        sorteadito = (int) (Math.random() * 5);
        cadenita = cadenitas[sorteadito];
        vistita.setText(cadenitas[sorteadito]);
        imagencita.setImageResource(R.drawable.ahorcado0);
        numero.setText("6");
    }

    @Override
    public void onClick(View view) {
        String contenido = ((Button)view).getText().toString();
        if(contenido.equals("mandar")) {
            int cuantos = cadenita.length();
            String dato = buscadito.getText().toString();
            int banderita = 0;
            int banderita2 = 0;
            int faltan = Integer.parseInt(numero.getText().toString());
            cadenitaaux = "";
            for (int i = 0; i < cuantos; i++) {
                char caracter = editadito.getText().toString().charAt(0);
                if (caracter == cadenita.charAt(i)) {
                    cadenitaaux = cadenitaaux + caracter;
                    banderita2 = 1;
                }
                else if (cuantos > dato.length())
                    cadenitaaux = cadenitaaux + "_";
                else
                    cadenitaaux = cadenitaaux + dato.charAt(i);
            }
            buscadito.setText(cadenitaaux);
            for (int i = 0; i < cuantos; i++) {
                if (cadenitaaux.charAt(i) == '_') {
                    banderita = 1;
                }
            }
            if (banderita == 0) {
                buscadito.setText("¡Ganaste!");
                editadito.setText("");
                editadito.setEnabled(false);
                botoncito.setEnabled(false);
            }
            if(banderita2 == 0){
                faltan = faltan - 1;
                numero.setText("" + faltan);
                switch (faltan){
                    case 6:
                        imagencita.setImageResource(R.drawable.ahorcado0);
                        break;
                    case 5:
                        imagencita.setImageResource(R.drawable.ahorcado1);
                        break;
                    case 4:
                        imagencita.setImageResource(R.drawable.ahorcado2);
                        break;
                    case 3:
                        imagencita.setImageResource(R.drawable.ahorcado3);
                        break;
                    case 2:
                        imagencita.setImageResource(R.drawable.ahorcado4);
                        break;
                    case 1:
                        imagencita.setImageResource(R.drawable.ahorcado5);
                        break;
                    case 0:
                        imagencita.setImageResource(R.drawable.ahorcado6);
                        buscadito.setText("¡Perdiste!");
                        editadito.setEnabled(false);
                        botoncito.setEnabled(false);
                        break;
                }
            }
            editadito.setText("");
        } else if (contenido.equals("reiniciar")) {
            Intent intent = new Intent(Ahorcado.this, Ahorcado.class);
            startActivity(intent);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
