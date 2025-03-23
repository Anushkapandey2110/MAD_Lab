package com.example.lab6ques1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
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
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater optionsmenu = new MenuInflater(this);
        optionsmenu.inflate(R.menu.options,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.menuWorkout)
        {
            Intent intent = new Intent(MainActivity.this,Workouts.class);
            startActivity(intent);
        }
        if(itemId == R.id.menuMembership)
        {
            Intent intent = new Intent(MainActivity.this,Membership.class);
            startActivity(intent);
        }
        if(itemId == R.id.menuTrainer)
        {
            Intent intent = new Intent(MainActivity.this, Trainer.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
