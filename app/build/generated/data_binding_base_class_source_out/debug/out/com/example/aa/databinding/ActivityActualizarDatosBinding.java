// Generated by view binder compiler. Do not edit!
package com.example.aa.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aa.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityActualizarDatosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText apeMat;

  @NonNull
  public final EditText apeMatInf;

  @NonNull
  public final EditText apePat;

  @NonNull
  public final EditText apePatInf;

  @NonNull
  public final Button btnregis;

  @NonNull
  public final EditText cod;

  @NonNull
  public final EditText edadinf;

  @NonNull
  public final EditText nomInf;

  @NonNull
  public final EditText nombre;

  @NonNull
  public final EditText rfc;

  @NonNull
  public final ScrollView scrol;

  @NonNull
  public final EditText tel;

  private ActivityActualizarDatosBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText apeMat, @NonNull EditText apeMatInf, @NonNull EditText apePat,
      @NonNull EditText apePatInf, @NonNull Button btnregis, @NonNull EditText cod,
      @NonNull EditText edadinf, @NonNull EditText nomInf, @NonNull EditText nombre,
      @NonNull EditText rfc, @NonNull ScrollView scrol, @NonNull EditText tel) {
    this.rootView = rootView;
    this.apeMat = apeMat;
    this.apeMatInf = apeMatInf;
    this.apePat = apePat;
    this.apePatInf = apePatInf;
    this.btnregis = btnregis;
    this.cod = cod;
    this.edadinf = edadinf;
    this.nomInf = nomInf;
    this.nombre = nombre;
    this.rfc = rfc;
    this.scrol = scrol;
    this.tel = tel;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityActualizarDatosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityActualizarDatosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_actualizar_datos, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityActualizarDatosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.apeMat;
      EditText apeMat = ViewBindings.findChildViewById(rootView, id);
      if (apeMat == null) {
        break missingId;
      }

      id = R.id.apeMatInf;
      EditText apeMatInf = ViewBindings.findChildViewById(rootView, id);
      if (apeMatInf == null) {
        break missingId;
      }

      id = R.id.apePat;
      EditText apePat = ViewBindings.findChildViewById(rootView, id);
      if (apePat == null) {
        break missingId;
      }

      id = R.id.apePatInf;
      EditText apePatInf = ViewBindings.findChildViewById(rootView, id);
      if (apePatInf == null) {
        break missingId;
      }

      id = R.id.btnregis;
      Button btnregis = ViewBindings.findChildViewById(rootView, id);
      if (btnregis == null) {
        break missingId;
      }

      id = R.id.cod;
      EditText cod = ViewBindings.findChildViewById(rootView, id);
      if (cod == null) {
        break missingId;
      }

      id = R.id.edadinf;
      EditText edadinf = ViewBindings.findChildViewById(rootView, id);
      if (edadinf == null) {
        break missingId;
      }

      id = R.id.nomInf;
      EditText nomInf = ViewBindings.findChildViewById(rootView, id);
      if (nomInf == null) {
        break missingId;
      }

      id = R.id.nombre;
      EditText nombre = ViewBindings.findChildViewById(rootView, id);
      if (nombre == null) {
        break missingId;
      }

      id = R.id.rfc;
      EditText rfc = ViewBindings.findChildViewById(rootView, id);
      if (rfc == null) {
        break missingId;
      }

      id = R.id.scrol;
      ScrollView scrol = ViewBindings.findChildViewById(rootView, id);
      if (scrol == null) {
        break missingId;
      }

      id = R.id.tel;
      EditText tel = ViewBindings.findChildViewById(rootView, id);
      if (tel == null) {
        break missingId;
      }

      return new ActivityActualizarDatosBinding((ConstraintLayout) rootView, apeMat, apeMatInf,
          apePat, apePatInf, btnregis, cod, edadinf, nomInf, nombre, rfc, scrol, tel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
