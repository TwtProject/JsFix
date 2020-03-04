package com.example.jsfix;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class whatshapp extends AppCompatActivity {

    ImageView wa;

    @Override
        protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        wa = findViewById(R.id.wa);

        wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6282112927843?text=Saya%20tertarik%20dengan%20mobil%20Anda%20yang%20dijual"));
               startActivity(i);
            }
        });
    }

}
