package com.example.finishit;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<task> tasksList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        tasksList = new ArrayList<>();

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        setTaskInfo();
        setAdapter();
    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(tasksList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setTaskInfo() {
        tasksList.add(new task("Resume Design Pattern", "Tugas mockup dan deskripsi solusi", "Due Today", "19.00 pm"));
        tasksList.add(new task("Tugas Matematika Diskrit", "Deskripsi", "Due Tomorrow", "18.00 pm"));
        tasksList.add(new task("Laporan Review PKN", "Deskripsi", "Due 19 April 2021", "20.00 pm"));
        tasksList.add(new task("Aljabar Linear", "Soal latihan mingguan", "Due 17 April 2021", "03.00 pm"));
    }
}