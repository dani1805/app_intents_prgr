package com.example.myintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int numVictories = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        EditText etName = findViewById(R.id.etName);
        EditText etAdress = findViewById(R.id.etAdress);
        EditText etAge = findViewById(R.id.etAge);
        EditText etEmail = findViewById(R.id.etEmail);
        RadioGroup numberVictories = findViewById(R.id.numberVictories);
        RadioGroup playCompetition = findViewById(R.id.playCompetition);
        Button btnStart = findViewById(R.id.btnStart);
        Button btnRestart = findViewById(R.id.btnRestart);

        numberVictories.setVisibility(View.INVISIBLE);

        numberVictories.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.less15) {
                    numVictories = 0;
                } else if (checkedId == R.id.more15) {
                    numVictories = 15;
                }
            }
        });

        playCompetition.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.play) {
                    numberVictories.setVisibility(View.VISIBLE);
                } else {
                    numberVictories.setVisibility(View.INVISIBLE);
                }

            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String age = etAge.getText().toString();

                if (age.isEmpty()) {
                    etAge.setError("Campo obligatorio");
                } else {
                    int parseAge = Integer.parseInt(age);
                    if (parseAge < 18) {
                        Toast toast = Toast.makeText(MainActivity.this, "Debes ser mayor de edad", Toast.LENGTH_SHORT);
                        toast.show();
                    } else if (name.isEmpty()) {
                        etName.setError("Campo obligatorio");
                    } else if (email.isEmpty()) {
                        etEmail.setError("Campo obligatorio");
                    } else {
                        Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("email", email);
                        intent.putExtra("victories", numVictories);

                        startActivity(intent);
                    }
                }
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etEmail.setText("");
                etName.setText("");
                playCompetition.clearCheck();
                numberVictories.clearCheck();
                etAdress.setText("");
                etAge.setText("");

            }
        });


    }
}