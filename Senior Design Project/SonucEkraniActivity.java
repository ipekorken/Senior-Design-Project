package com.example.pc.deepmakeupkiller;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SonucEkraniActivity extends AppCompatActivity {

    ImageView sonimg;
    Button satinal, kaydet, geri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc_ekrani);

        sonimg = findViewById(R.id.sonimg);
        satinal = findViewById(R.id.satinal);
        kaydet = findViewById(R.id.kaydet);
        geri = findViewById(R.id.geri);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SonucEkraniActivity.this, "Fotoğraf kaydedildi.", Toast.LENGTH_SHORT).show();

            }
        });

        satinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gratis.com"));
                startActivity(website);

            }
        });

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent geri = new Intent(SonucEkraniActivity.this, GirisEkraniActivity.class);
                startActivity(geri);
            }
        });
    }
}
