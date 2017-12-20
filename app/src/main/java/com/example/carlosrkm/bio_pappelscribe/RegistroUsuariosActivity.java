package com.example.carlosrkm.bio_pappelscribe;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlosrkm.bio_pappelscribe.utilidades.Utilidades;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RegistroUsuariosActivity extends AppCompatActivity {

    EditText campoId;
    EditText campoNombre;
    EditText campoDepartamento;
    EditText campoExtension;
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

    String ServerURL = "http://192.168.1.68/biopapel-server/get_data.php" ;
    String TempId,
            TempNombre,
            TempDepartamento,
            TempExtension,
            TempDireccionIp,
            TempMarcaMonitor,
            TempModeloMonitor,
            TempSerieMonitor,
            TempMarcaCpu,
            TempModeloCpu,
            TempSerieCpu,
            TempMarcaTeclado,
            TempModeloTeclado,
            TempSerieTeclado,
            TempMarcaMouse,
            TempModeloMouse,
            TempSerieMouse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        button = (findViewById(R.id.btnGuardarRegistro));

        campoId = findViewById(R.id.campId);
        campoNombre =  findViewById(R.id.campNombre);
        campoDepartamento =  findViewById(R.id.campDepartamento);
        campoExtension = findViewById(R.id.campExtension);
        campoDireccionIp = findViewById(R.id.campDireccionIp);
        campoMarcamonitor = findViewById(R.id.campMarcamonitor);
        campoModelomonitor = findViewById(R.id.campModelomonitor);
        campoSeriemonitor = findViewById(R.id.campSeriemonitor);
        campoMarcaCPU = findViewById(R.id.campMarcaCPU);
        campoModeloCPU = findViewById(R.id.campModeloCPU);
        campoSerieCPU = findViewById(R.id.campSerieCPU);
        campoMarcateclado = findViewById(R.id.campMarcateclado);
        campoModeloteclado = findViewById(R.id.campModeloteclado);
        campoSerieteclado = findViewById(R.id.campSerieteclado);
        campoMarcamouse = findViewById(R.id.campMarcamouse);
        campoModelomouse = findViewById(R.id.campModelomouse);
        campoSeriemouse = findViewById(R.id.campSeriemouse);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuarios();

                GetData();

                InsertData(TempId,
                        TempNombre,
                        TempDepartamento,
                        TempExtension,
                        TempDireccionIp,
                        TempMarcaMonitor,
                        TempModeloMonitor,
                        TempSerieMonitor,
                        TempMarcaCpu,
                        TempModeloCpu,
                        TempSerieCpu,
                        TempMarcaTeclado,
                        TempModeloTeclado,
                        TempSerieTeclado,
                        TempMarcaMouse,
                        TempModeloMouse,
                        TempSerieMouse);
            }
        });
    }


    private void registrarUsuarios() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, Utilidades.TABLA_USUARIO,null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_ID, campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_DEPARTAMENTO, campoDepartamento.getText().toString());
        values.put(Utilidades.CAMPO_EXTENSION, campoExtension.getText().toString());
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

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);



        Toast.makeText(getApplicationContext(),"ID Registro: " + idResultante, Toast.LENGTH_SHORT ).show();
        db.close();
    }

    public void GetData(){

        TempId = campoId.getText().toString();
        TempNombre = campoNombre.getText().toString();
        TempDepartamento = campoDepartamento.getText().toString();
        TempExtension = campoExtension.getText().toString();
        TempDireccionIp = campoDireccionIp.getText().toString();
        TempMarcaMonitor = campoMarcamonitor.getText().toString();
        TempModeloMonitor = campoModelomonitor.getText().toString();
        TempSerieMonitor = campoSeriemonitor.getText().toString();
        TempMarcaCpu = campoMarcaCPU.getText().toString();
        TempModeloCpu = campoModeloCPU.getText().toString();
        TempSerieCpu = campoSerieCPU.getText().toString();
        TempMarcaTeclado = campoMarcateclado.getText().toString();
        TempModeloTeclado = campoModeloteclado.getText().toString();
        TempSerieTeclado = campoSerieteclado.getText().toString();
        TempMarcaMouse = campoMarcamouse.getText().toString();
        TempModeloMouse = campoModelomouse.getText().toString();
        TempSerieMouse = campoSeriemouse.getText().toString();

    }


    public void InsertData(final String p1, final String p2,  final String p3, final String pext, final String p4, final String p5, final String p6, final String p7, final String p8, final String p9, final String p10, final String p11, final String p12, final String p13, final String p14, final String p15, final String p16 ){

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String  Id = p1;
                String  Nombre = p2;
                String  Departamento = p3;
                String  Extension = pext;
                String  DireccionIp = p4;
                String  MarcaMonitor = p5;
                String  ModeloMonitor = p6;
                String  SerieMonitor = p7;
                String  MarcaCpu = p8;
                String  ModeloCpu = p9;
                String  SerieCpu = p10;
                String  MarcaTeclado = p11;
                String  ModeloTeclado = p12;
                String  SerieTeclado = p13;
                String  MarcaMouse = p14;
                String  ModeloMouse = p15;
                String  SerieMouse = p16;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("id", Id));
                nameValuePairs.add(new BasicNameValuePair("nombre", Nombre));
                nameValuePairs.add(new BasicNameValuePair("departamento", Departamento));
                nameValuePairs.add(new BasicNameValuePair("extension", Extension));
                nameValuePairs.add(new BasicNameValuePair("direccionip", DireccionIp));
                nameValuePairs.add(new BasicNameValuePair("marcamonitor", MarcaMonitor));
                nameValuePairs.add(new BasicNameValuePair("modelomonitor", ModeloMonitor));
                nameValuePairs.add(new BasicNameValuePair("seriemonitor", SerieMonitor));
                nameValuePairs.add(new BasicNameValuePair("marcacpu", MarcaCpu));
                nameValuePairs.add(new BasicNameValuePair("modelocpu", ModeloCpu));
                nameValuePairs.add(new BasicNameValuePair("seriecpu", SerieCpu));
                nameValuePairs.add(new BasicNameValuePair("marcateclado", MarcaTeclado));
                nameValuePairs.add(new BasicNameValuePair("modeloteclado", ModeloTeclado));
                nameValuePairs.add(new BasicNameValuePair("serieteclado", SerieTeclado));
                nameValuePairs.add(new BasicNameValuePair("marcamouse", MarcaMouse));
                nameValuePairs.add(new BasicNameValuePair("modelomouse", ModeloMouse));
                nameValuePairs.add(new BasicNameValuePair("seriemouse", SerieMouse));

                try {

                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(ServerURL);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                Toast.makeText(RegistroUsuariosActivity.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

                limpiar();

                startActivity(new Intent(RegistroUsuariosActivity.this, DemoGeneratorActivity.class)
                        .putExtra("id", TempId)
                        .putExtra("nombre", TempNombre)
                        .putExtra("departamento", TempDepartamento)
                        .putExtra("extension", TempExtension)
                        .putExtra("direccionip",TempDireccionIp)
                        .putExtra("marcamonitor", TempMarcaMonitor)
                        .putExtra("modelomonitor", TempModeloMonitor)
                        .putExtra("seriemonitor", TempSerieMonitor)
                        .putExtra("marcacpu", TempMarcaCpu)
                        .putExtra("modelocpu", TempModeloCpu)
                        .putExtra("seriecpu", TempSerieCpu)
                        .putExtra("marcateclado", TempMarcaTeclado)
                        .putExtra("modeloteclado", TempModeloTeclado)
                        .putExtra("serieteclado", TempSerieTeclado)
                        .putExtra("marcamouse", TempMarcaMouse)
                        .putExtra("modelomouse", TempModeloMouse)
                        .putExtra("seriemouse", TempSerieMouse));
            }





        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(p1, p2, p3, pext, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16);

    }

    private void limpiar() {
        campoNombre.setText("");
        campoDepartamento.setText("");
        campoExtension.setText("");
        campoDireccionIp.setText("");
        campoMarcamonitor.setText("");
        campoModelomonitor.setText("");
        campoSeriemonitor.setText("");
        campoMarcaCPU.setText("");
        campoModeloCPU.setText("");
        campoSerieCPU.setText("");
        campoMarcateclado.setText("");
        campoModeloteclado.setText("");
        campoSerieteclado.setText("");
        campoMarcamouse.setText("");
        campoModelomouse.setText("");
        campoSeriemouse.setText("");
    }

}
