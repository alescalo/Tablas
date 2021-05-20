package com.example.tablas;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageView);
        img.setImageResource(R.drawable.tabla_periodica);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Tablas quimicas
        if (id == R.id.formulacionInorganica) {
            img.setImageResource(R.drawable.formulacion_inorganica);
        } else if(id == R.id.formulacionOrganica) {
            img.setImageResource(R.drawable.formulacion_organica);
        } else if(id == R.id.tabla_periodica) {
            img.setImageResource(R.drawable.tabla_periodica);

        //Tablas Matematicas
        } else if(id == R.id.Derivadas) {
            img.setImageResource(R.drawable.derivadas);
        } else if(id == R.id.integrales) {
            img.setImageResource(R.drawable.integrales);

         //Tablas Estadistica
        } else if(id == R.id.tabla_xi2) {
            img.setImageResource(R.drawable.tabla_xi2);
        } else if(id == R.id.valores_criticos_xi2) {
            img.setImageResource(R.drawable.valores_criticos_xi2);
        } else if(id == R.id.tabla_normal) {
            img.setImageResource(R.drawable.tabla_normal);


        //Tablas ingenieria
        } else if(id == R.id.aleaciones) {
            img.setImageResource(R.drawable.aleaciones);
        }  else if(id == R.id.tablas_de_la_verdad) {
            img.setImageResource(R.drawable.tablas_de_la_verdad);
        } else if(id == R.id.tabla_de_resistencias) {
            img.setImageResource(R.drawable.tabla_resistencias);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        scaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            img.setScaleX(mScaleFactor);
            img.setScaleY(mScaleFactor);
            return true;
        }
    }
}