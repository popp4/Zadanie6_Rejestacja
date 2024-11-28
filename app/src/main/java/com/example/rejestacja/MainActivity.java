package com.example.rejestacja;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button confirm;
    private EditText email;
    private EditText haslo;
    private EditText haslo2;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        confirm=findViewById(R.id.zatwierdz);
        email=findViewById(R.id.email);
        haslo=findViewById(R.id.haslo);
        haslo2=findViewById(R.id.haslo2);
        info=findViewById(R.id.info);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_email=email.getText().toString().trim();
                String input_haslo=haslo.getText().toString().trim();
                String input_haslo_p=haslo2.getText().toString().trim();

                if(input_email.isEmpty()) {
                    info.setText("Podaj adres e-mail");
                    return;
                }
                    if(!Patterns.EMAIL_ADDRESS.matcher(input_email).matches()){
                        info.setText("Nie poprawny adres e-mail");
                        return;
                }
                if(input_haslo.isEmpty()){
                    info.setText("Podaj haslo");
                    return;
                }
                if(input_haslo_p.isEmpty()){
                    info.setText("Powtorz hasŁo");
                    return;
                }
                if(!input_haslo_p.equals(input_haslo)){
                    info.setText("Hasla muszą byc takie same");
                    return;
                }
                if(!input_email.isEmpty() && !input_haslo.isEmpty() && !input_haslo_p.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(input_email).matches() && input_haslo_p.equals(input_haslo)){
                    info.setText("Witaj "+input_email);
                    return;
                }
            }
        });
    }
}