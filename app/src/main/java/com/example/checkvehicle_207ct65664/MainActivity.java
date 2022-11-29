package com.example.checkvehicle_207ct65664;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText Input;
    Button Run;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matching();
        Run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkVehicle();
            }
        });
    }

    public void checkVehicle() {
        String s = Input.getText().toString();
        String chuoiMau = "5[0-9]-[A-Z][0-9]-[0-9]{3}\\.[0-9]{2}";

        Pattern pattern = Pattern.compile(chuoiMau);
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            Result.setText("Số xe hợp lệ - HCM");
        }
        else {
            Result.setText("Số xe không hợp lệ - HCM");
        }
    }

    public void matching() {
        Input = findViewById(R.id.etInput);
        Run = findViewById(R.id.btnRun);
        Result = findViewById(R.id.tvResult);
    }
}