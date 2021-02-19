package com.example.workingwithpixels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.workingwithpixels.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    DisplayMetrics displayMetrics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(this::showPixels);


    }

    private void showOutput(String text) {
        binding.tv.setText(text);
    }

    private void showPixels(View view) {
        displayMetrics = new DisplayMetrics();

        int pixelHeight = displayMetrics.heightPixels;
        int pixelWidth = displayMetrics.widthPixels;

        Log.e("tag", pixelWidth + " x " + pixelHeight);


        float density = displayMetrics.density;

        float dpWidth = pixelWidth / density;
        float dpHeight = pixelHeight / density;

        showOutput("Absolute Pixels");
        showOutput(pixelWidth + " x " + pixelHeight);

        Log.e("tag2", dpWidth + " x " + dpHeight);
        showOutput("DP Pixels");
        showOutput(dpWidth + " x " + dpHeight);

    }

    private void showScreenDensity() {
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float density = displayMetrics.density;

        Toast.makeText(this, "DPI "+density, Toast.LENGTH_SHORT).show();
    }

}