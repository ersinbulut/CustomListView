package com.ersinbulut.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Kisi> kisiler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        kisiler = new ArrayList<>();

        Kisi k1 = new Kisi("Ahmet","Öztürk");
        Kisi k2 = new Kisi("Mehmet","Öz");
        Kisi k3 = new Kisi("Ayşe","Yılmaz");
        Kisi k4 = new Kisi("Zeynep","Öztürk");
        Kisi k5 = new Kisi("Osman","Öztürk");

        kisiler.add(k1);
        kisiler.add(k2);
        kisiler.add(k3);
        kisiler.add(k4);
        kisiler.add(k5);

        OzelAdapter ozelAdapter = new OzelAdapter(this,kisiler);
        listView.setAdapter(ozelAdapter);

    }
}