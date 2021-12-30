package com.example.abrirprogramaswindows;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ImageButton gta, f1, mw, forza;
    private EditText endereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gta = (ImageButton) findViewById(R.id.gta);
        f1 = (ImageButton) findViewById(R.id.f1);
        mw = (ImageButton) findViewById(R.id.mw);
        forza = (ImageButton) findViewById(R.id.forza);



        //Configurar permissão de internet
        if(ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[] { Manifest.permission.INTERNET}, 0);
        }

        eventos();
    }

    private void eventos(){
        gta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abrir = "gta";
                fazerRequest(abrir);
            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abrir ="f1";
                fazerRequest(abrir);
            }
        });
        mw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abrir = "cod";
                fazerRequest(abrir);
            }
        });
        forza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abrir = "forza";
                fazerRequest(abrir);
            }
        });
    }

    private void fazerRequest(String abrir){
        endereco =  findViewById(R.id.endereco);
        String url = endereco.getText().toString().trim();
        //url += "/abrir?aplicacao="+abrir;
        url += "/servidorArduino/abrir";

        RequestQueue pilha = Volley.newRequestQueue(this);
        StringRequest reuqest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                /*
                try {
                    JSONObject resposta = new JSONObject(response);

                    if (resposta.getInt("cod") == 200) {
                        //Sucesso
                        Toast.makeText(MainActivity.this, "Programa entrando em execução", Toast.LENGTH_SHORT);
                    } else {
                        //Erro
                        Toast.makeText(MainActivity.this, "Erro", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException ex) {

                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(MainActivity.this, "Cheque sua conexão", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> parametros = new HashMap<>();
                parametros.put("aplicacao", abrir);

                return parametros;
            }
        };
        pilha.add(reuqest);
    }
}