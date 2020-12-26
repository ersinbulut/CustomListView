package com.ersinbulut.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
        e4=findViewById(R.id.editText4);
    }

    public void btnEkle(View view){
        Intent i = new Intent();
        i.putExtra("ad",e1.getText().toString());
        i.putExtra("soyad",e2.getText().toString());
        i.putExtra("yas",e3.getText().toString());
        i.putExtra("cinsiyet",e4.getText().toString());
        setResult(RESULT_OK,i);
        Toast.makeText(this, "Kişi Eklendi", Toast.LENGTH_SHORT).show();
        finish();
    }
}