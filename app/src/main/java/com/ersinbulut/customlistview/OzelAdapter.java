package com.ersinbulut.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OzelAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Kisi> kisiArrayList;

    public OzelAdapter(Context context, ArrayList<Kisi> kisiArrayList) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//*Tasarımı görünüme aktarma servisi*/
        this.kisiArrayList = kisiArrayList;
    }

    @Override
    /*dizideki eleman sayısını verir*/
    public int getCount() {
        return kisiArrayList.size();
    }

    @Override
    /*dizideki herhangi bir elemanı elde etmek için kullanılır*/
    public Object getItem(int position) {
        return kisiArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    /*satır görünümlerini oluşturan metot*/
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.satir_layout,parent,false);
        TextView txt_ad = convertView.findViewById(R.id.satir_ad);
        TextView txt_soyad = convertView.findViewById(R.id.satir_soyad);
        TextView txt_yas = convertView.findViewById(R.id.satir_yas);
        //TextView txt_cinsiyet = convertView.findViewById(R.id.satir_cinsiyet);
        ImageView img_Cinsiyet=convertView.findViewById(R.id.satir_resim);
        Kisi k = kisiArrayList.get(position);
        txt_ad.setText(k.getAd());
        txt_soyad.setText(k.getSoyad());
        txt_yas.setText(k.getYas());
        //txt_cinsiyet.setText(k.getCinsiyet());
        if (k.getCinsiyet().equals("E")){
            img_Cinsiyet.setImageResource(R.drawable.man);
        }
        else if (k.getCinsiyet().equals("K")){
            img_Cinsiyet.setImageResource(R.drawable.woman);
        }
        return convertView;
    }
}
