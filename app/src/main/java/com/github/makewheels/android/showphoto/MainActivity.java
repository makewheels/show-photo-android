package com.github.makewheels.android.showphoto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    private File getPhotoFile() {
        return new File(getFilesDir(), "photoFile");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        start();
    }

    private void start() {
        //先检查有没有图片，如果没有，从相册选，保存到data
        if (!getPhotoFile().exists()) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Uri uri = result.getData().getData();
                File photoFile = new File(uri.toString());
                Log.e("tag", photoFile.length() + "");

            }).launch(intent);
        }
    }
}