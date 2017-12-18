package com.example.carlosrkm.bio_pappelscribe;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlosrkm.bio_pappelscribe.utilidades.Utilidades;

public class ConsultarUsuariosActivity extends AppCompatActivity {

    EditText campId, campNombre, campDepartamento, campDireccionIp, campMarcamonitor, campModelomonitor, campSeriemonitor, campMarcaCPU, campModeloCPU, campSerieCPU, campMarcateclado, campModeloteclado, campSerieteclado, campMarcamouse, campModelomouse, campSeriemouse;

    ConexionSQLiteHelper conn;
    Button btnConsulBuscar;
    Button btnConsulActuali;
    Button btnConsulElimin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuarios);

        conn= new ConexionSQLiteHelper(getApplicationContext(), Utilidades.TABLA_USUARIO,null,1);


        btnConsulBuscar = findViewById(R.id.btnConsulBuscar);
        btnConsulActuali = findViewById(R.id.btnConsulActuali);
        btnConsulElimin = findViewById(R.id.btnConsulElimin);
        campId= (EditText) findViewById(R.id.consulId);
        campNombre= (EditText) findViewById(R.id.consulNombre);
        campDepartamento= (EditText) findViewById(R.id.consulDepartamento);
        campDireccionIp= (EditText) findViewById(R.id.consulDireccionIp);
        campMarcamonitor= (EditText) findViewById(R.id.consulMarcamonitor);
        campModelomonitor= (EditText) findViewById(R.id.consulModelomonitor);
        campSeriemonitor= (EditText) findViewById(R.id.consulSeriemonitor);
        campMarcaCPU= (EditText) findViewById(R.id.consulMarcaCPU);
        campModeloCPU= (EditText) findViewById(R.id.consulModeloCPU);
        campSerieCPU= (EditText) findViewById(R.id.consulSerieCPU);
        campMarcateclado= (EditText) findViewById(R.id.consulMarcateclado);
        campModeloteclado= (EditText) findViewById(R.id.consulModeloteclado);
        campSerieteclado= (EditText) findViewById(R.id.consulSerieteclado);
        campMarcamouse= (EditText) findViewById(R.id.consulMarcamouse);
        campModelomouse= (EditText) findViewById(R.id.consulModelomouse);
        campSeriemouse= (EditText) findViewById(R.id.consulSeriemouse);

        btnConsulBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultar();
            }
        });

        btnConsulActuali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarUsuario();
            }
        });
         btnConsulElimin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 eliminarUsuario();
             }
         });

    }


    private void eliminarUsuario() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campId.getText().toString()};

        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(), "YSe elimino el usuario", Toast.LENGTH_LONG).show();
        campId.setText("");
        limpiar();
        db.close();


    }

    private void actualizarUsuario() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campId.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campNombre.getText().toString());
        values.put(Utilidades.CAMPO_DEPARTAMENTO,campDepartamento.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCIONIP,campDireccionIp.getText().toString());
        values.put(Utilidades.CAMPO_MARCAMONITOR,campMarcamonitor.getText().toString());
        values.put(Utilidades.CAMPO_MODELOMONITOR,campModelomonitor.getText().toString());
        values.put(Utilidades.CAMPO_SERIEMONITOR,campSeriemonitor.getText().toString());
        values.put(Utilidades.CAMPO_MARCACPU,campMarcaCPU.getText().toString());
        values.put(Utilidades.CAMPO_MODELOCPU,campModeloCPU.getText().toString());
        values.put(Utilidades.CAMPO_SERIECPU,campSerieCPU.getText().toString());
        values.put(Utilidades.CAMPO_MARCATECLADO,campMarcateclado.getText().toString());
        values.put(Utilidades.CAMPO_MODELOTECLADO,campModeloteclado.getText().toString());
        values.put(Utilidades.CAMPO_SERIETECLADO,campSerieteclado.getText().toString());
        values.put(Utilidades.CAMPO_MARCAMOUSE,campMarcamouse.getText().toString());
        values.put(Utilidades.CAMPO_MODELOMOUSE,campModelomouse.getText().toString());
        values.put(Utilidades.CAMPO_SERIEMOUSE,campSeriemouse.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_ID+"=?", parametros);
        Toast.makeText(getApplicationContext(), "Ya se actualizo el usuario", Toast.LENGTH_LONG).show();
        db.close();

    }

    private void consult (){
        SQLiteDatabase db = conn.getReadableDatabase();

        String[] campos={Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_DEPARTAMENTO,Utilidades.CAMPO_DIRECCIONIP, Utilidades.CAMPO_MARCAMONITOR, Utilidades.CAMPO_MODELOMONITOR, Utilidades.CAMPO_SERIEMONITOR, Utilidades.CAMPO_MARCACPU, Utilidades.CAMPO_MODELOCPU, Utilidades.CAMPO_SERIECPU, Utilidades.CAMPO_MARCATECLADO, Utilidades.CAMPO_MODELOTECLADO, Utilidades.CAMPO_SERIETECLADO, Utilidades.CAMPO_MARCAMOUSE, Utilidades.CAMPO_MODELOMOUSE, Utilidades.CAMPO_SERIEMOUSE};
        String selectQuery = "SELECT "+  Utilidades.CAMPO_NOMBRE +", "+ Utilidades.CAMPO_DEPARTAMENTO + "  FROM usuario WHERE id=" + campId.getText().toString();
        Cursor  c = db.rawQuery(selectQuery,null);

        c.moveToFirst();

        Log.i("query", selectQuery);

        Log.i("prueba", c.getString(0));

        /*
        if (c.moveToFirst()) {
            temp_address = c.getString(c.getColumnIndex("lastchapter"));
        }
        */
        c.close();
    }

    private void consultar() {
        SQLiteDatabase db =conn.getReadableDatabase();
        String[] parametros={campId.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_DEPARTAMENTO,Utilidades.CAMPO_DIRECCIONIP, Utilidades.CAMPO_MARCAMONITOR, Utilidades.CAMPO_MODELOMONITOR, Utilidades.CAMPO_SERIEMONITOR, Utilidades.CAMPO_MARCACPU, Utilidades.CAMPO_MODELOCPU, Utilidades.CAMPO_SERIECPU, Utilidades.CAMPO_MARCATECLADO, Utilidades.CAMPO_MODELOTECLADO, Utilidades.CAMPO_SERIETECLADO, Utilidades.CAMPO_MARCAMOUSE, Utilidades.CAMPO_MODELOMOUSE, Utilidades.CAMPO_SERIEMOUSE};

        try {

            Cursor cursor = db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID + "=?", parametros,null,null,null);

            cursor.moveToFirst();

            campNombre.setText(cursor.getString(0));
            campDepartamento.setText(cursor.getString(1));
            campDireccionIp.setText(cursor.getString(2));
            campMarcamonitor.setText(cursor.getString(3));
            campModelomonitor.setText(cursor.getString(4));
            campSeriemonitor.setText(cursor.getString(5));
            campMarcaCPU.setText(cursor.getString(6));
            campModeloCPU.setText(cursor.getString(7));
            campSerieCPU.setText(cursor.getString(8));
            campMarcateclado.setText(cursor.getString(9));
            campModeloteclado.setText(cursor.getString(10));
            campSerieteclado.setText(cursor.getString(11));
            campMarcamouse.setText(cursor.getString(12));
            campModelomouse.setText(cursor.getString(13));
            campSeriemouse.setText(cursor.getString(14));


            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El registro no existe",Toast.LENGTH_LONG).show();
            limpiar();

        }


    }

    private void limpiar() {
        campNombre.setText("");
        campDepartamento.setText("");
        campDireccionIp.setText("");
        campMarcamonitor.setText("");
        campModelomonitor.setText("");
        campSeriemonitor.setText("");
        campMarcaCPU.setText("");
        campModeloCPU.setText("");
        campSerieCPU.setText("");
        campMarcateclado.setText("");
        campModeloteclado.setText("");
        campSerieteclado.setText("");
        campMarcamouse.setText("");
        campModelomouse.setText("");
        campSeriemouse.setText("");
    }
}

