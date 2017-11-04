package com.example.jesus.bd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnGuardar, btnCancelar;
    EditText txtNombre, txtEdad, txtCarrera;
    String nombre, edad, carrera;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        cargaDatos();

        btnGuardar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        guardarClicked();
                    }
                }
        );

        btnCancelar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cancelarClicked();
                    }
                }
        );
    }

    public void inicializaComponentes(){
        btnGuardar=(Button)findViewById(R.id.btnGauardar);
        btnCancelar=(Button)findViewById(R.id.btnCancelar);
        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtEdad=(EditText)findViewById(R.id.txtEdad);
        txtCarrera=(EditText)findViewById(R.id.txtCarrera);

    }

    public void cargaDatos(){
        MiAuxSQL cnx = new MiAuxSQL(this,"Base",null,1);
        SQLiteDatabase bd = cnx.getReadableDatabase();
        String nom="",edad="",carr="";
        String query= "SELECT * FROM Persona";
        if (bd!=null){
            Cursor c = bd.rawQuery(query,null);
            if (c.moveToFirst()){
                nom=c.getString(0);
                edad=c.getString(1);
                carr=c.getString(2);
            }
        }
        bd.close();
        txtNombre.setText(nom.toString());
        txtEdad.setText(edad.toString());
        txtCarrera.setText(carr.toString());
    }

    public void guardarClicked(){
        MiAuxSQL conection = new MiAuxSQL(this,"Base",null,1);
        SQLiteDatabase bd = conection.getWritableDatabase();
        nombre=txtNombre.getText().toString();
        edad=txtEdad.getText().toString();
        carrera=txtCarrera.getText().toString();
        String query = "INSERT INTO Persona VALUES('"+nombre+"','"+edad+"','"+carrera+"')";
        bd.execSQL(query);
    }

    public void cancelarClicked(){

    }
}
