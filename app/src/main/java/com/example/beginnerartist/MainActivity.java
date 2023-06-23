package com.example.beginnerartist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private PaintingView paintingView;
    private ImageButton fabBroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paintingView = findViewById(R.id.painting);
        fabBroom = findViewById(R.id.fabBroom);

        fabBroom.setOnClickListener(listener);

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.fabBroom) {
                    AlertDialog.Builder broomDialog = new AlertDialog.Builder(MainActivity.this);
                    broomDialog.setTitle("Новый рисунок");
                    broomDialog.setMessage("Создать новый рисунок? (текущий будет удален!)");

                    broomDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            paintingView.broom();
                            dialog.dismiss();
                        }
                    });
                    broomDialog.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    broomDialog.show();
            }
        }
    };
}