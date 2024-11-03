package com.example.workwise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignUpActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Inicializar campos de texto y botón
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        registerButton = findViewById(R.id.register_button);
        client = new OkHttpClient();

        // Configurar el listener para el botón de registro
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                registerUser(username, email, password);
            }
        });
    }

    private void registerUser(String username, String email, String password) {
        // Crear JSON con los datos de registro
        JSONObject json = new JSONObject();
        try {
            json.put("username", username);
            json.put("email", email);
            json.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Configurar la solicitud de registro
        String url = "http://10.0.2.2:5000/register"; // Cambia a la IP del servidor si usas un dispositivo físico
        RequestBody body = RequestBody.create(json.toString(), MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        // Enviar la solicitud
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> Toast.makeText(SignUpActivity.this, "Error de red", Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    runOnUiThread(() -> Toast.makeText(SignUpActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show());
                    // Redirigir al usuario a LoginActivity tras el registro exitoso
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish(); // Termina la actividad actual para evitar regresar aquí
                } else {
                    runOnUiThread(() -> Toast.makeText(SignUpActivity.this, "Error en el registro", Toast.LENGTH_SHORT).show());
                }
            }
        });
    }
}
