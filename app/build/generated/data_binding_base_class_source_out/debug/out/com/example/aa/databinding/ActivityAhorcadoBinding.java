// Generated by view binder compiler. Do not edit!
package com.example.aa.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aa.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAhorcadoBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button boton;

  @NonNull
  public final Button boton2;

  @NonNull
  public final TextView busca;

  @NonNull
  public final ImageView imagen;

  @NonNull
  public final TextView numero;

  @NonNull
  public final TextView restantes;

  @NonNull
  public final EditText textito;

  @NonNull
  public final TextView vista;

  private ActivityAhorcadoBinding(@NonNull LinearLayout rootView, @NonNull Button boton,
      @NonNull Button boton2, @NonNull TextView busca, @NonNull ImageView imagen,
      @NonNull TextView numero, @NonNull TextView restantes, @NonNull EditText textito,
      @NonNull TextView vista) {
    this.rootView = rootView;
    this.boton = boton;
    this.boton2 = boton2;
    this.busca = busca;
    this.imagen = imagen;
    this.numero = numero;
    this.restantes = restantes;
    this.textito = textito;
    this.vista = vista;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAhorcadoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAhorcadoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_ahorcado, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAhorcadoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.boton;
      Button boton = ViewBindings.findChildViewById(rootView, id);
      if (boton == null) {
        break missingId;
      }

      id = R.id.boton2;
      Button boton2 = ViewBindings.findChildViewById(rootView, id);
      if (boton2 == null) {
        break missingId;
      }

      id = R.id.busca;
      TextView busca = ViewBindings.findChildViewById(rootView, id);
      if (busca == null) {
        break missingId;
      }

      id = R.id.imagen;
      ImageView imagen = ViewBindings.findChildViewById(rootView, id);
      if (imagen == null) {
        break missingId;
      }

      id = R.id.numero;
      TextView numero = ViewBindings.findChildViewById(rootView, id);
      if (numero == null) {
        break missingId;
      }

      id = R.id.restantes;
      TextView restantes = ViewBindings.findChildViewById(rootView, id);
      if (restantes == null) {
        break missingId;
      }

      id = R.id.textito;
      EditText textito = ViewBindings.findChildViewById(rootView, id);
      if (textito == null) {
        break missingId;
      }

      id = R.id.vista;
      TextView vista = ViewBindings.findChildViewById(rootView, id);
      if (vista == null) {
        break missingId;
      }

      return new ActivityAhorcadoBinding((LinearLayout) rootView, boton, boton2, busca, imagen,
          numero, restantes, textito, vista);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
