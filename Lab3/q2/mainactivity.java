package com.example.lab4q1;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    ArrayList<String> sports = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        list = findViewById(R.id.LISTview);
        sports.add("Football (Soccer)");
        sports.add("Cricket");
        sports.add("Basketball");
        sports.add("Tennis");
        sports.add("Rugby");
        sports.add("Volleyball");
        sports.add("Baseball");
        sports.add("Table Tennis (Ping Pong)");
        sports.add("Golf");
        sports.add("Badminton");
        sports.add("American Football");
        sports.add("Ice Hockey");
        sports.add("Athletics");
        sports.add("Boxing");
        sports.add("Swimming");
        sports.add("Handball");
        sports.add("Wrestling");
        sports.add("Martial Arts");
        sports.add("Cycling");
        sports.add("Hockey");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,sports);


        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Selected" + sports.get(position) , Toast.LENGTH_LONG).show();
