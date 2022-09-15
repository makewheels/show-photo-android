package com.github.makewheels.android.showphoto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private File getPhotoFile() {
        return new File(getFilesDir(), "photoFile");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start();
    }

    private void start() {
        File photoFile = getPhotoFile();
        if (!photoFile.exists()){

        }
    }
}