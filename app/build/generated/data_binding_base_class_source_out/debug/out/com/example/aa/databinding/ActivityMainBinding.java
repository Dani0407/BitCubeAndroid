// Generated by view binder compiler. Do not edit!
package com.example.aa.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton btnfc;

  @NonNull
  public final ImageButton btnig;

  @NonNull
  public final Button btnregis;

  @NonNull
  public final TextView etcorreo;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final Button inicia;

  private ActivityMainBinding(@NonNull LinearLayout rootView, @NonNull ImageButton btnfc,
      @NonNull ImageButton btnig, @NonNull Button btnregis, @NonNull TextView etcorreo,
      @NonNull ImageView imageView, @NonNull Button inicia) {
    this.rootView = rootView;
    this.btnfc = btnfc;
    this.btnig = btnig;
    this.btnregis = btnregis;
    this.etcorreo = etcorreo;
    this.imageView = imageView;
    this.inicia = inicia;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnfc;
      ImageButton btnfc = ViewBindings.findChildViewById(rootView, id);
      if (btnfc == null) {
        break missingId;
      }

      id = R.id.btnig;
      ImageButton btnig = ViewBindings.findChildViewById(rootView, id);
      if (btnig == null) {
        break missingId;
      }

      id = R.id.btnregis;
      Button btnregis = ViewBindings.findChildViewById(rootView, id);
      if (btnregis == null) {
        break missingId;
      }

      id = R.id.etcorreo;
      TextView etcorreo = ViewBindings.findChildViewById(rootView, id);
      if (etcorreo == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.inicia;
      Button inicia = ViewBindings.findChildViewById(rootView, id);
      if (inicia == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, btnfc, btnig, btnregis, etcorreo,
          imageView, inicia);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}