package com.example.admissionhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int[] flags;
    private LayoutInflater inflater;

    CustomAdapter(Context context,int[] flags)
    {
        this.context=context;
        this.flags=flags;
    }

    @Override
    public int getCount() {
        return 7;
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

        if(convertView==null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.sample_view_dashboard_grid,parent,false);
        }

        ImageView imageView=(ImageView) convertView.findViewById(R.id.sampleViewDashGridImgId);

        imageView.setImageResource(flags[position]);

        return convertView;
    }
}
