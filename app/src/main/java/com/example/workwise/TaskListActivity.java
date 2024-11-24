// TaskListActivity.java
package com.example.workwise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        ListView taskListView = findViewById(R.id.taskListView);
        String taskType = getIntent().getStringExtra("taskType");
        if (taskType == null) {
            taskType = ""; // O establece un valor predeterminado
        }
        // Datos de ejemplo de tareas


        String[] tasks = taskType.equals("daily") ?
                new String[]{"Tarea 1", "Tarea 2", "Tarea 3"} :
                new String[]{"Tarea 4", "Tarea 5", "Tarea 6"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        taskListView.setAdapter(adapter);

        taskListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(TaskListActivity.this, TaskDetailActivity.class);
            intent.putExtra("taskName", tasks[position]);
            startActivity(intent);
        });
    }
}
