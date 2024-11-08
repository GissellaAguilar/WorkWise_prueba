// MainActivity.java
package com.example.workwise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dailyTasksButton = findViewById(R.id.dailyTasksButton);
        Button weeklyTasksButton = findViewById(R.id.weeklyTasksButton);

        dailyTasksButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TaskListActivity.class);
            intent.putExtra("taskType", "daily");
            startActivity(intent);
        });

        weeklyTasksButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TaskListActivity.class);
            intent.putExtra("taskType", "weekly");
            startActivity(intent);
        });
    }
}
