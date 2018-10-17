package com.example.paco.takephoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        findViewById(R.id.takePhotoBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (takePictureIntent.resolveActivity(getPackageManager()) != null)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        });

        findViewById(R.id.savePhotoBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.buildDrawingCache();
                Bitmap bm = imageView.getDrawingCache();

                saveImageFile(bm);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
            //   saveImageFile(imageBitmap);

        }
    }

    public String saveImageFile(Bitmap bitmap) {
        String filename = getFilename();

        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(filename));
            Toast.makeText(
                    MainActivity.this,
                    "Success: Your photo has been saved!",
                    Toast.LENGTH_LONG
            ).show();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            Toast.makeText(
                    MainActivity.this,
                    "Error: Your photo hasn't been saved!",
                    Toast.LENGTH_LONG
            ).show();
        }
        return filename;
    }

    private String getFilename() {
        File file = new File(
                Environment.getExternalStorageDirectory().getPath(),
                "TestFolder"
        );

        if (!file.exists())
            file.mkdirs();

        String uriSting = (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
        return uriSting;
    }
}
