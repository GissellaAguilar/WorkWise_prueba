package com.example.workwise;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Iniciar MainActivity después de un retraso de 3 segundos
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();  // Finaliza SplashActivity para que no se vuelva a abrir al presionar "atrás"
        }, 1000);  // 3000 milisegundos = 3 segundos
    }
}
