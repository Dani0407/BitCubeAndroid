// Generated by view binder compiler. Do not edit!
package com.example.aa.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aa.R;
import com.google.android.material.navigation.NavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityNavDrawerBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final AppBarNavDrawerBinding appBarNavDrawer;

  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final NavigationView navView;

  private ActivityNavDrawerBinding(@NonNull DrawerLayout rootView,
      @NonNull AppBarNavDrawerBinding appBarNavDrawer, @NonNull DrawerLayout drawerLayout,
      @NonNull NavigationView navView) {
    this.rootView = rootView;
    this.appBarNavDrawer = appBarNavDrawer;
    this.drawerLayout = drawerLayout;
    this.navView = navView;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityNavDrawerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityNavDrawerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_nav_drawer, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityNavDrawerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_bar_nav_drawer;
      View appBarNavDrawer = ViewBindings.findChildViewById(rootView, id);
      if (appBarNavDrawer == null) {
        break missingId;
      }
      AppBarNavDrawerBinding binding_appBarNavDrawer = AppBarNavDrawerBinding.bind(appBarNavDrawer);

      DrawerLayout drawerLayout = (DrawerLayout) rootView;

      id = R.id.nav_view;
      NavigationView navView = ViewBindings.findChildViewById(rootView, id);
      if (navView == null) {
        break missingId;
      }

      return new ActivityNavDrawerBinding((DrawerLayout) rootView, binding_appBarNavDrawer,
          drawerLayout, navView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}