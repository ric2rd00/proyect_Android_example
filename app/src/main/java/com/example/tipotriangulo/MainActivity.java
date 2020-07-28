package com.example.tipotriangulo;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imgT;
    Button btnOK;
    Spinner opc1, opc2, opc3;
    private int ladoA, ladoB, ladoC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgT = (ImageView) findViewById(R.id.imgTr);
        btnOK = (Button) findViewById(R.id.btn_click);
        opc1 = (Spinner) findViewById(R.id.spinner);
        opc2 = (Spinner) findViewById(R.id.spinner2);
        opc3 = (Spinner) findViewById(R.id.spinner3);


        ArrayList<String> combos = new ArrayList<>();
        for(int i=1; i<=50; i++){
            combos.add(String.valueOf(i));
        }
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,combos);
        opc1.setAdapter(adapter);
        opc2.setAdapter(adapter);
        opc3.setAdapter(adapter);


        opc1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(parent.getContext(),"seleccionado "+ parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                ladoA = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        opc2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(parent.getContext(),"seleccionado "+ parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                ladoB = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        opc3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(parent.getContext(),"seleccionado "+ parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                ladoC = Integer.parseInt(parent.getItemAtPosition(position).toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void verificar_triangulo(View vista){

        if(ladoA == ladoB && ladoB == ladoC){
            Toast.makeText(this,"Elegiste un triangulo EQUILATERO", Toast.LENGTH_SHORT).show();
            imgT.setImageResource(R.drawable.equilatero);

        }

        else if((ladoA == ladoB && ladoA != ladoC) || (ladoA == ladoC && ladoA!= ladoB) || (ladoB == ladoC && ladoB != ladoA)){
            Toast.makeText(this,"Elegiste un triangulo ISÓSCELES", Toast.LENGTH_SHORT).show();
            imgT.setImageResource(R.drawable.isoseles);
        }
        else if(ladoA != ladoB && ladoA!= ladoC){
            Toast.makeText(this,"Elegiste un triangulo ESCALENO", Toast.LENGTH_SHORT).show();
            imgT.setImageResource(R.drawable.escaleno);
        }

    }

}
