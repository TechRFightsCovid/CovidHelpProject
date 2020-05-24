package com.example.covidhelp.Utils;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidhelp.R;

import java.util.ArrayList;

public class categoryAdapter extends BaseAdapter {

    Context context;

    @NonNull
    ArrayList logos;

    LayoutInflater inflater;

    public categoryAdapter(Context context, ArrayList logos) {
        this.context = context;
        this.logos = logos;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return logos.size();
    }

    @Override
    public Object getItem(int i) {
        return logos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.snippet_category, parent, false);
        }

        // get current item to be displayed


        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.categoryInnerTV);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(logos.get(position).toString());

        // returns the view for the current row
        return convertView;


    }
}
