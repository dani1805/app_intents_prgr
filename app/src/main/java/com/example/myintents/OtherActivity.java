package com.example.myintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextView yourWelcome = findViewById(R.id.yourWelcome);
        TextView congratulation = findViewById(R.id.congratulation);
        TextView adress = findViewById(R.id.adress);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String email = bundle.getString("email");
        int victories = bundle.getInt("victories");

        yourWelcome.setText("Bienvenido " + name);
        adress.setText("Le llegará en los próximos días el Pase Vip Dorado al email " + email);

        if (victories < 15) {
            congratulation.setText("Sigue intentando. Debes seguir mejorando para convertirte en el aunténtico sensei del Fifa");
            congratulation.setBackgroundColor(getResources().getColor(R.color.red));
        } else {
            congratulation.setText("Eres un ejemplo a seguir. Tu esfuerzo ha merecido la pena. Has conseguido lo que otros sueñan");
            congratulation.setBackgroundColor(getResources().getColor(R.color.green));
        }

    }
}