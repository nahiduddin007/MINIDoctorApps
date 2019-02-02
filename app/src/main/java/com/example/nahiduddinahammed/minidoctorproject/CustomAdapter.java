package com.example.nahiduddinahammed.minidoctorproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int[] flags;
    String[] consult;
    Context context;
    private LayoutInflater inflater;

    public CustomAdapter(Context context,String[] consult,int[] flags ) {
        this.flags = flags;
        this.consult = consult;
        this.context = context;
    }


    @Override
    public int getCount() {
        return consult.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){

            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_sample,parent,false);


        }


        ImageView imageView = convertView.findViewById(R.id.imageViewId);
        TextView textView = convertView.findViewById(R.id.textViewId);

        imageView.setImageResource(flags[position]);
        textView.setText(consult[position]);


        return convertView;
    }
}