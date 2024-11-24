package com.example.workwise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private Button buttonHoy, buttonProgramado, buttonSemanal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Asegúrate de que el nombre coincide

        // Inicializar componentes
        calendarView = findViewById(R.id.calendarView2);

        // Inicializa los botones
        buttonHoy = findViewById(R.id.button5);
        buttonProgramado = findViewById(R.id.button6);
        buttonSemanal = findViewById(R.id.button9);

        // Listener para el botón "Hoy"
        buttonHoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTaskListActivity();
            }
        });

        // Listener para el botón "Programado"
        buttonProgramado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTaskListActivity();
            }
        });

        // Listener para el botón "Semanal"
        buttonSemanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTaskListActivity();
            }
        });
    }

    // Método para abrir TaskListActivity
    private void abrirTaskListActivity() {
        Intent intent = new Intent(MainActivity.this, TaskListActivity.class);
        startActivity(intent);
    }
}

