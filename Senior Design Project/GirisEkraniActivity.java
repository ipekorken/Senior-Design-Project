package com.example.pc.deepmakeupkiller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GirisEkraniActivity extends AppCompatActivity {
    Button btnkamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);



            btnkamera = (Button)findViewById(R.id.btnkamera);

            btnkamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(GirisEkraniActivity.this, UrunlerActivity.class);
                    startActivity(intent);
                }
            });

        }

    }


