package com.example.cgaleanah.adogtame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrar(View v){
        Intent intent = new Intent(MainActivity.this, Registro.class);
        //Bundle b = new Bundle();
        //b.putString("Nombre", txUno.getText().toString());
        //intent.putExtras(b);
        startActivity(intent);
    }
}
