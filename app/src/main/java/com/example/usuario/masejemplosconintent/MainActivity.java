package com.example.usuario.masejemplosconintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button compartirWhatsapp, compartirFacebook,mapa, web;
    EditText texto, texto2;
    String aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.editText);
        compartirWhatsapp = findViewById(R.id.button);
        texto2 = findViewById(R.id.editText2);
        compartirFacebook = findViewById(R.id.button2);
        mapa = findViewById(R.id.button3);
        web = findViewById(R.id.button4);

        compartirWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenWhatsapp = new Intent(Intent.ACTION_SEND);
                intenWhatsapp.setType("text/plain");
                intenWhatsapp.putExtra(Intent.EXTRA_TEXT, texto.getText().toString());
                intenWhatsapp.setPackage("com.whatsapp");
                getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                if(aux!=null){
                    startActivity(intenWhatsapp);
                }
                else{
                   Toast.makeText(MainActivity.this, "Debes intalar Whatsapp", Toast.LENGTH_SHORT).show();
                }
            }
        });

        compartirFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenFacebook = new Intent(Intent.ACTION_SEND);
                intenFacebook.setType("text/plain");
                intenFacebook.putExtra(Intent.EXTRA_TEXT, texto.getText().toString());
                intenFacebook.setPackage("com.facebook.katana");
                getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                if(aux!=null){
                    startActivity(intenFacebook);
                }
                else{
                    Toast.makeText(MainActivity.this, "Debes intalar Facebook", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coordenadas = "geo:38.2983421,-5.273682";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(coordenadas));
                Intent seleccionado = Intent.createChooser(intent,"Elige tu app favorita.");

                startActivity(intent);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(texto.getText().toString()));
                Intent seleccionado = Intent.createChooser(intent,"Elige tu app favorita.");

                startActivity(intent);
            }
        });

    }
}
