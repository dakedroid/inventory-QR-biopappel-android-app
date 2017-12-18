package com.example.carlosrkm.bio_pappelscribe;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlosrkm.bio_pappelscribe.utilidades.Utilidades;
import static com.example.carlosrkm.bio_pappelscribe.utilidades.Utilidades.TABLA_USUARIO;

public class RegistroUsuariosActivity extends AppCompatActivity {

    EditText campoId;
    EditText campoNombre;
    EditText campoDepartamento;
    EditText campoDireccionIp;
    EditText campoMarcamonitor;
    EditText campoModelomonitor;
    EditText campoSeriemonitor;
    EditText campoMarcaCPU;
    EditText campoModeloCPU;
    EditText campoSerieCPU;
    EditText campoMarcateclado;
    EditText campoModeloteclado;
    EditText campoSerieteclado;
    EditText campoMarcamouse;
    EditText campoModelomouse;
    EditText campoSeriemouse;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        button = (findViewById(R.id.btnGuardarRegistro));

        campoId = (EditText) findViewById(R.id.campId);
        campoNombre = (EditText) findViewById(R.id.campNombre);
        campoDepartamento = (EditText) findViewById(R.id.campDepartamento);
        campoDireccionIp = (EditText) findViewById(R.id.campDireccionIp);
        campoMarcamonitor = (EditText) findViewById(R.id.campMarcamonitor);
        campoModelomonitor = (EditText) findViewById(R.id.campModelomonitor);
        campoSeriemonitor = (EditText) findViewById(R.id.campSeriemonitor);
        campoMarcaCPU = (EditText) findViewById(R.id.campMarcaCPU);
        campoModeloCPU = (EditText) findViewById(R.id.campModeloCPU);
        campoSerieCPU = (EditText) findViewById(R.id.campSerieCPU);
        campoMarcateclado = (EditText) findViewById(R.id.campMarcateclado);
        campoModeloteclado = (EditText) findViewById(R.id.campModeloteclado);
        campoSerieteclado = (EditText) findViewById(R.id.campSerieteclado);
        campoMarcamouse = (EditText) findViewById(R.id.campMarcamouse);
        campoModelomouse = (EditText) findViewById(R.id.campModelomouse);
        campoSeriemouse = (EditText) findViewById(R.id.campSeriemouse);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuarios();
            }
        });
    }


    private void registrarUsuarios() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, Utilidades.TABLA_USUARIO,null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_ID, campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_DEPARTAMENTO, campoDepartamento.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCIONIP, campoDireccionIp.getText().toString());
        values.put(Utilidades.CAMPO_MARCAMONITOR, campoMarcamonitor.getText().toString());
        values.put(Utilidades.CAMPO_MODELOMONITOR, campoModelomonitor.getText().toString());
        values.put(Utilidades.CAMPO_SERIEMONITOR, campoSeriemonitor.getText().toString());
        values.put(Utilidades.CAMPO_MARCACPU, campoMarcaCPU.getText().toString());
        values.put(Utilidades.CAMPO_MODELOCPU, campoModeloCPU.getText().toString());
        values.put(Utilidades.CAMPO_SERIECPU, campoSerieCPU.getText().toString());
        values.put(Utilidades.CAMPO_MARCATECLADO, campoMarcateclado.getText().toString());
        values.put(Utilidades.CAMPO_MODELOTECLADO, campoModeloteclado.getText().toString());
        values.put(Utilidades.CAMPO_SERIETECLADO, campoSerieteclado.getText().toString());
        values.put(Utilidades.CAMPO_MARCAMOUSE, campoMarcamouse.getText().toString());
        values.put(Utilidades.CAMPO_MODELOMOUSE, campoModelomouse.getText().toString());
        values.put(Utilidades.CAMPO_SERIEMOUSE, campoSeriemouse.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);

        Toast.makeText(getApplicationContext(),"ID Registro: " +idResultante,Toast.LENGTH_SHORT ).show();
        db.close();


        startActivity(new Intent(RegistroUsuariosActivity.this, DemoGeneratorActivity.class).putExtra("id", campoId.getText().toString()));


    }
}
