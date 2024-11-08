// TaskDetailActivity.java
package com.example.workwise;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        TextView taskDescription = findViewById(R.id.taskDescription);
        TextView startDate = findViewById(R.id.startDate);
        TextView endDate = findViewById(R.id.endDate);
        TextView comments = findViewById(R.id.comments);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        String taskName = getIntent().getStringExtra("taskName");

        // Datos de ejemplo para los detalles de la tarea
        taskDescription.setText("Descripción detallada de " + taskName);
        startDate.setText("Fecha de inicio: 01/01/2023");
        endDate.setText("Fecha límite: 07/01/2023");
        comments.setText("Comentarios: Ninguno");

        ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> {
            // Puedes guardar o usar la calificación aquí.
        });
    }
}
