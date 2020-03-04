package com.example.jsfix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hanks.passcodeview.PasscodeView;

public class MainActivity2 extends AppCompatActivity {
    PasscodeView passcodeView;
    String pin;
    SharedPreferences pref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        pin = intent.getStringExtra("pin");
        passcodeView = findViewById(R.id.passcode_view);
        passcodeView.setPasscodeLength(4)
                .setLocalPasscode(pin)
                .setListener(new PasscodeView.PasscodeViewListener() {
                    @Override
                    public void onFail() {
                        Toast.makeText(getApplicationContext(),
                                "password is wrong",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onSuccess(String number) {
                        Intent intent = new Intent(MainActivity2.this, HomeActivity.class);
                        startActivity(intent);
                    }
                });
    }
}
