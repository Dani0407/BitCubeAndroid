package com.example.aa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Base extends SQLiteOpenHelper {

    public Base(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase basesita) {
        basesita.execSQL("create table Usuario(idUsuario int primary key, nombreUsuario text," +
                " apePatUsuario text,apeMatUsuario text, telUsuario int, correoUsuario text, contrasenaUsuario text," +
                "RFC text, codigo int, nombreInfante text, apePatInfante text, apeMatInfante text, " +
                "edadInfante int, sexoInfante text)");
        basesita.execSQL("create table EspecificacionMed(idEsp int primary key," +
                " fechadiag int,masenfer text, tratMed text, alergias text, revision text," +
                "medicamentos text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase basesita, int oldVersion, int newVersion){
        basesita.execSQL("drop Table if exists Usuario");
    }

    public boolean insertData(String nombre, String apePat, String apeMat, String tel, String correo, String contrasena, String RFC, String codigo, String nombreInfante, String apePatInfante, String apeMatInfante, String edadInfante, String sexoInfante) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nombreUsuario", nombre);
        contentValues.put("apePatUsuario", apePat);
        contentValues.put("apeMatUsuario", apeMat);
        contentValues.put("telUsuario", tel);
        contentValues.put("correoUsuario", correo);
        contentValues.put("contrasenaUsuario", contrasena);
        contentValues.put("RFC", RFC);
        contentValues.put("codigo", codigo);
        contentValues.put("nombreInfante", nombreInfante);
        contentValues.put("apePatInfante", apePatInfante);
        contentValues.put("apeMatInfante", apeMatInfante);
        contentValues.put("edadInfante", edadInfante);
        contentValues.put("sexoInfante", sexoInfante);

        long result = db.insert("Usuario", null, contentValues);
        db.close();

        // Si result es -1, entonces hubo un error
        return result != -1;
    }

    public Cursor obtenerUsuario(String correo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Usuario", null, "correoUsuario = ?", new String[]{correo}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Log.d("Base", "Usuario encontrado: " + cursor.getString(cursor.getColumnIndex("nombreUsuario")));
        } else {
            Log.d("Base", "No se encontró usuario con correo: " + correo);
        }
        return cursor;
    }

    public boolean actualizarUsuario(String correo, ContentValues valores) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.update("Usuario", valores, "correoUsuario = ?", new String[]{correo}) > 0;
    }
    public boolean eliminarUsuario(String correo) {
        SQLiteDatabase db = this.getWritableDatabase();
        int resultado = db.delete("Usuario", "correoUsuario = ?", new String[]{correo});
        db.close();
        return resultado > 0;
    }
    public Cursor obtenerDetallesUsuario(String correo) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("Usuario", null, "correoUsuario = ?", new String[]{correo}, null, null, null);
    }

}
