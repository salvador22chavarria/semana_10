package com.example.semana_10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class pedidos_ya extends AppCompatActivity {
    EditText nombre,addres,want;
    ImageButton next;
    public String iwant;
    public String address;
    public String name;

    RequestQueue requestQueue;
    ProgressDialog progressDialog;

    String HttpUrl = "https://demagogical-neutron.000webhostapp.com/carpeta/base.php";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_ya);
        nombre=findViewById(R.id.nombre);
        addres=findViewById(R.id.addres);
        want=findViewById(R.id.want);
        next=findViewById(R.id.img_tankiunext);



        requestQueue = Volley.newRequestQueue(pedidos_ya.this);

        progressDialog = new ProgressDialog(pedidos_ya.this);






        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();


                GetValueFromEditText();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                progressDialog.dismiss();


                                Toast.makeText(pedidos_ya.this, "TU PEDIDO A SIDO ENVIADO CORRECTAMENTE", Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            private VolleyError error;

                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                progressDialog.dismiss();

                                Toast.makeText(pedidos_ya.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {


                        Map<String, String> params = new HashMap<String, String>();

                        params.put("nombre", name);
                        params.put("direccion", address);
                        params.put("pedido", iwant);


                        return params;
                    }



                };
                RequestQueue requestQueue = Volley.newRequestQueue(pedidos_ya.this);
                requestQueue.add(stringRequest);

                nombre.setText("");
                addres.setText("");
                want.setText("");


            }
        });
    }

        public void GetValueFromEditText(){

            name= nombre.getText().toString();
            address= addres.getText().toString();
            iwant=want.getText().toString();

        }

    }



