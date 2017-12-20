package com.example.carlosrkm.bio_pappelscribe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
    }

    public void AbrirQr(View view){
        Intent RegistrarUsuarios = new Intent(MainActivity.this, MainActivityGenerator.class);
        startActivity(RegistrarUsuarios);
    }

    public void AbrirRegistrarUsuarios(View view){
        Intent RegistrarUsuarios = new Intent(MainActivity.this,RegistroUsuariosActivity.class);
        startActivity(RegistrarUsuarios);
    }

    public void AbrirConsultarUsuarios(View view){
        Intent ConsultarUsuarios = new Intent(MainActivity.this,ConsultarUsuariosActivity.class);
        startActivity(ConsultarUsuarios);
    }
}