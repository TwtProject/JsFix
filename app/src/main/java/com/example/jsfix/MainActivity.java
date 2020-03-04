package com.example.jsfix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.hanks.passcodeview.PasscodeView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    PasscodeView passcodeView;
    String pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref =getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        passcodeView = findViewById(R.id.passcode_view);
        pin = pref.getString("pin", null);
//        Log.d("PIN : ",pin);

        if (pin!=null){
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("pin", pin);
            startActivity(intent);
        }

        passcodeView.setPasscodeLength(4).setListener(new PasscodeView.PasscodeViewListener() {
            @Override
            public void onFail() {

            }

            @Override
            public void onSuccess(String number) {
                passcodeView.setLocalPasscode(number);
                pin = number;
                editor.putString("pin", number); // Storing string
                editor.apply();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("pin", pin);
                startActivity(intent);
            }
        });
    }
}
