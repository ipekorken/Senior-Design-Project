package com.example.pc.deepmakeupkiller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.pc.deepmakeupkiller.Fragments.ListFragment;
import com.theartofdev.edmodo.cropper.CropImage;

public class UrunlerActivity extends AppCompatActivity implements View.OnClickListener {
    Uri mImageUri;
    private RadioButton boxC, boxM, boxR, box1, box2, box3;
    private RadioGroup rg1, rg2;
    Button ileri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urunler);
        boxC = findViewById(R.id.boxC);
        boxM = findViewById(R.id.boxM);
        boxR = findViewById(R.id.boxR);
        box1 = findViewById(R.id.box1);
        box2 = findViewById(R.id.box2);
        box3 = findViewById(R.id.box3);
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        ileri = findViewById(R.id.ileri);



        CropImage.activity()
                .start(this);
        boxC.setOnClickListener(this);
        boxM.setOnClickListener(this);
        boxR.setOnClickListener(this);
        box1.setOnClickListener(this);
        box2.setOnClickListener(this);
        box3.setOnClickListener(this);

        ileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ileri = new Intent(UrunlerActivity.this, SonucEkraniActivity.class);
                startActivity(ileri);
            }
        });



    }
    public void onClick(View v) {

        int checkedRadioButtonId = rg1.getCheckedRadioButtonId();

        switch (checkedRadioButtonId) {

            case R.id.boxC:
                if (boxC.isChecked()) {

                    SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                    //     editor.putString("profileforteacherid", publisher);
                    editor.putString("marka","Chanel");
                    editor.apply();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new ListFragment()).commit();
                }

                break;

            case R.id.boxM:
                if (boxM.isChecked()) {

                    SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                    //     editor.putString("profileforteacherid", publisher);
                    editor.putString("marka","Mac");
                    editor.apply();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new ListFragment()).commit();
                }

                break;

            case R.id.boxR:
                if (boxR.isChecked()) {


                }

                break;
        }

        int checkedRadioButtonId2 = rg2.getCheckedRadioButtonId();

        switch (checkedRadioButtonId2) {
            case R.id.box1:
                if (box1.isChecked()) {

                }

                break;

            case R.id.box2:
                if (box2.isChecked()) {


                    SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                    //     editor.putString("profileforteacherid", publisher);
                    editor.putString("marka","Mac");
                    editor.apply();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new ListFragment()).commit();

                }

            case R.id.box3:
                if (box3.isChecked()) {


                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {

            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            mImageUri = result.getUri();
            SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
            //     editor.putString("profileforteacherid", publisher);
            editor.putString("marka",null);
            editor.putString("uri",mImageUri.toString());
            editor.apply();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ListFragment()).commit();

        } else {
            Toast.makeText(this, "Something gone wrong!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(UrunlerActivity.this, GirisEkraniActivity.class));
            finish();
        }
    }


}

