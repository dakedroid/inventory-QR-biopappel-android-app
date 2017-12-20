package com.example.carlosrkm.bio_pappelscribe;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlosrkm.bio_pappelscribe.utilidades.Utilidades;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ConsultarUsuariosActivity extends AppCompatActivity {

    EditText campId, campNombre, campDepartamento, campDireccionIp, campMarcamonitor, campModelomonitor, campSeriemonitor, campMarcaCPU, campModeloCPU, campSerieCPU, campMarcateclado, campModeloteclado, campSerieteclado, campMarcamouse, campModelomouse, campSeriemouse;

    ConexionSQLiteHelper conn;
    Button btnConsulBuscar;
    Button btnConsulActuali;
    Button btnConsulElimin;

    String id;
    String nombre;
    String departamento;
    String direccionip;
    String marcamonitor;
    String modelomonitor;
    String seriemonitor;
    String marcacpu;
    String modelocpu;
    String seriecpu;
    String marcateclado;
    String modeloteclado;
    String serieteclado;
    String marcamouse;
    String modelomouse;
    String seriemouse;

    String url = "http://192.168.1.68/biopapel-server/consult.php?id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuarios);

        conn = new ConexionSQLiteHelper(getApplicationContext(), Utilidades.TABLA_USUARIO,null,1);

        btnConsulBuscar = findViewById(R.id.btnConsulBuscar);
        btnConsulActuali = findViewById(R.id.btnConsulActuali);
        btnConsulElimin = findViewById(R.id.btnConsulElimin);
        campId = findViewById(R.id.consulId);
        campNombre=  findViewById(R.id.consulNombre);
        campDepartamento = findViewById(R.id.consulDepartamento);
        campDireccionIp = findViewById(R.id.consulDireccionIp);
        campMarcamonitor = findViewById(R.id.consulMarcamonitor);
        campModelomonitor = findViewById(R.id.consulModelomonitor);
        campSeriemonitor = findViewById(R.id.consulSeriemonitor);
        campMarcaCPU = findViewById(R.id.consulMarcaCPU);
        campModeloCPU = findViewById(R.id.consulModeloCPU);
        campSerieCPU = findViewById(R.id.consulSerieCPU);
        campMarcateclado = findViewById(R.id.consulMarcateclado);
        campModeloteclado = findViewById(R.id.consulModeloteclado);
        campSerieteclado = findViewById(R.id.consulSerieteclado);
        campMarcamouse = findViewById(R.id.consulMarcamouse);
        campModelomouse = findViewById(R.id.consulModelomouse);
        campSeriemouse = findViewById(R.id.consulSeriemouse);

        btnConsulBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // consultar();
                getData(campId.getText().toString());
            }
        });

        btnConsulActuali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*actualizarUsuario();*/

                String url = "http://192.168.1.68/biopapel-server/edit.php?id=" + id
                        + "&nombre=" + campNombre.getText().toString()
                        + "&departamento=" + campDepartamento.getText().toString()
                        + "&direccionip=" + campDireccionIp.getText().toString()
                        + "&marcamonitor=" + campMarcamonitor.getText().toString()
                        + "&modelomonitor=" + campModelomonitor.getText().toString()
                        + "&seriemonitor=" + campSeriemonitor.getText().toString()
                        + "&marcacpu=" + campMarcaCPU.getText().toString()
                        + "&modelocpu=" + campModeloCPU.getText().toString()
                        + "&seriecpu=" + campSerieCPU.getText().toString()
                        + "&marcateclado=" + campMarcateclado.getText().toString()
                        + "&modeloteclado=" + campModeloteclado.getText().toString()
                        + "&serieteclado=" + campSerieteclado.getText().toString()
                        + "&marcamouse=" + campMarcamouse.getText().toString()
                        + "&modelomouse=" + campModelomouse.getText().toString()
                        + "&seriemouse=" + campSeriemouse.getText().toString();

                System.out.println("QUERY: " + url);
                updateData(url);
            }
        });
        btnConsulElimin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                // eliminarUsuario();
                 String url = "http://192.168.1.68/biopapel-server/edit.php?id=" + id ;
                 deleteData(url);
             }
         });

    }

    private void eliminarUsuario() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {campId.getText().toString()};
        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(), "YSe elimino el usuario", Toast.LENGTH_LONG).show();
        campId.setText("");
        limpiar();
        db.close();
    }

    public void updateData(final String url){

        class SendGetReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                try {

                    HttpClient httpClient = new DefaultHttpClient();

                    HttpGet httpGet = new HttpGet(url);

                    httpGet.setParams(new BasicHttpParams());

                    HttpResponse httpResponse = httpClient.execute(httpGet);

                    HttpEntity httpEntity = httpResponse.getEntity();

                    String retSrc = EntityUtils.toString(httpEntity);

                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }

                return "Información obtenida";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                startActivity(new Intent(ConsultarUsuariosActivity.this, DemoGeneratorActivity.class)
                        .putExtra("id", campId.getText().toString())
                        .putExtra("nombre", campNombre.getText().toString())
                        .putExtra("departamento", campDepartamento.getText().toString())
                        .putExtra("direccionip", campDireccionIp.getText().toString())
                        .putExtra("marcamonitor", campMarcamonitor.getText().toString())
                        .putExtra("modelomonitor", campModelomonitor.getText().toString())
                        .putExtra("seriemonitor", campSeriemonitor.getText().toString())
                        .putExtra("marcacpu", campMarcaCPU.getText().toString())
                        .putExtra("modelocpu", campModeloCPU.getText().toString())
                        .putExtra("seriecpu", campSerieCPU.getText().toString())
                        .putExtra("marcateclado", campMarcateclado.getText().toString())
                        .putExtra("modeloteclado", campModeloteclado.getText().toString())
                        .putExtra("serieteclado", campSerieteclado.getText().toString())
                        .putExtra("marcamouse", campMarcamouse.getText().toString())
                        .putExtra("modelomouse", campModelomouse.getText().toString())
                        .putExtra("seriemouse", campSeriemouse.getText().toString()));

                Toast.makeText(ConsultarUsuariosActivity.this, "Operacion completada", Toast.LENGTH_LONG).show();

            }
        }

        SendGetReqAsyncTask sendGetReqAsyncTask = new SendGetReqAsyncTask();

        sendGetReqAsyncTask.execute(url);

    }

    public void deleteData(final String url){

        class SendGetReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                try {

                    HttpClient httpClient = new DefaultHttpClient();

                    HttpGet httpGet = new HttpGet(url);

                    httpGet.setParams(new BasicHttpParams());

                    HttpResponse httpResponse = httpClient.execute(httpGet);

                    HttpEntity httpEntity = httpResponse.getEntity();

                    String retSrc = EntityUtils.toString(httpEntity);

                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }

                return "Información obtenida";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(ConsultarUsuariosActivity.this, "Registro Elminado", Toast.LENGTH_LONG).show();

            }
        }

        SendGetReqAsyncTask sendGetReqAsyncTask = new SendGetReqAsyncTask();

        sendGetReqAsyncTask.execute(url);

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

    private void consultar() {

        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {campId.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_DEPARTAMENTO, Utilidades.CAMPO_DIRECCIONIP, Utilidades.CAMPO_MARCAMONITOR, Utilidades.CAMPO_MODELOMONITOR, Utilidades.CAMPO_SERIEMONITOR, Utilidades.CAMPO_MARCACPU, Utilidades.CAMPO_MODELOCPU, Utilidades.CAMPO_SERIECPU, Utilidades.CAMPO_MARCATECLADO, Utilidades.CAMPO_MODELOTECLADO, Utilidades.CAMPO_SERIETECLADO, Utilidades.CAMPO_MARCAMOUSE, Utilidades.CAMPO_MODELOMOUSE, Utilidades.CAMPO_SERIEMOUSE};

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
        id = "";
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

    public void getData(final String p1){

        limpiar();

        class SendGetReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String  Id = p1;

                try {

                    HttpClient httpClient = new DefaultHttpClient();

                    HttpGet httpGet = new HttpGet(url + Id);

                    httpGet.setParams(new BasicHttpParams());

                    HttpResponse httpResponse = httpClient.execute(httpGet);

                    HttpEntity httpEntity = httpResponse.getEntity();

                    String retSrc = EntityUtils.toString(httpEntity);

                    JSONArray jsonarray = new JSONArray(retSrc);

                    JSONObject jsonobject = jsonarray.getJSONObject(0);

                    id = jsonobject.getString("id");
                    nombre = jsonobject.getString("nombre");
                    departamento = jsonobject.getString("departamento");
                    direccionip = jsonobject.getString("direccionip");
                    marcamonitor = jsonobject.getString("marcamonitor");
                    modelomonitor = jsonobject.getString("modelomonitor");
                    seriemonitor = jsonobject.getString("seriemonitor");
                    marcacpu = jsonobject.getString("marcacpu");
                    modelocpu = jsonobject.getString("modelocpu");
                    seriecpu = jsonobject.getString("seriecpu");
                    marcateclado = jsonobject.getString("marcateclado");
                    modeloteclado = jsonobject.getString("modeloteclado");
                    serieteclado = jsonobject.getString("serieteclado");
                    marcamouse = jsonobject.getString("marcamouse");
                    modelomouse = jsonobject.getString("modelomouse");
                    seriemouse = jsonobject.getString("seriemouse");

                    System.out.println("RESPONSE: " + id);


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return "Información obtenida";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                if(!id.equals("")){
                    campNombre.setText(nombre);
                    campDepartamento.setText(departamento);
                    campDireccionIp.setText(direccionip);
                    campMarcamonitor.setText(marcamonitor);
                    campModelomonitor.setText(modelomonitor);
                    campSeriemonitor.setText(seriemonitor);
                    campMarcaCPU.setText(marcacpu);
                    campModeloCPU.setText(modelocpu);
                    campSerieCPU.setText(seriecpu);
                    campMarcateclado.setText(marcateclado);
                    campModeloteclado.setText(modeloteclado);
                    campSerieteclado.setText(serieteclado);
                    campMarcamouse.setText(marcamouse);
                    campModelomouse.setText(modelomouse);
                    campSeriemouse.setText(seriemouse);

                }else {
                    Toast.makeText(ConsultarUsuariosActivity.this, "No se encontro el registro", Toast.LENGTH_LONG).show();
                }
            }
        }

        SendGetReqAsyncTask sendGetReqAsyncTask = new SendGetReqAsyncTask();

        sendGetReqAsyncTask.execute(p1);

    }
}

