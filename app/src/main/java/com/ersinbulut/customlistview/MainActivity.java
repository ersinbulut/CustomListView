package com.ersinbulut.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Kisi> kisiler;
    OzelAdapter ozelAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        kisiler = new ArrayList<>();

        Kisi k1 = new Kisi("Ahmet","Öztürk","20","E");
        Kisi k2 = new Kisi("Mehmet","Öz","25","E");
        Kisi k3 = new Kisi("Ayşe","Yılmaz","30","K");
        Kisi k4 = new Kisi("Zeynep","Öztürk","26","K");
        Kisi k5 = new Kisi("Osman","Öztürk","29","E");

        kisiler.add(k1);
        kisiler.add(k2);
        kisiler.add(k3);
        kisiler.add(k4);
        kisiler.add(k5);

        ozelAdapter = new OzelAdapter(this,kisiler);
        listView.setAdapter(ozelAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.item_ekle){
            Intent i =new Intent(this,MainActivity2.class);
            startActivityForResult(i,22);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==22 && resultCode==RESULT_OK){
            String ad = data.getStringExtra("ad");
            String soyad = data.getStringExtra("soyad");
            String yas = data.getStringExtra("yas");
            String cinsiyet = data.getStringExtra("cinsiyet");

            Kisi yeniKisi = new Kisi(ad,soyad,yas,cinsiyet);
            kisiler.add(yeniKisi);
            ozelAdapter.notifyDataSetChanged();
        }
    }
}