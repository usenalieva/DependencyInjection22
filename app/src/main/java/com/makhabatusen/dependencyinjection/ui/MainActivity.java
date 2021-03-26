package com.makhabatusen.dependencyinjection.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.makhabatusen.dependencyinjection.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
    }
}