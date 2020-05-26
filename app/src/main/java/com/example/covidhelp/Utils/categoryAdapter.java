package com.example.covidhelp.Utils;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidhelp.DataModels.Category;
import com.example.covidhelp.R;

import java.util.ArrayList;

public class categoryAdapter extends BaseAdapter {

    Context context;

    @NonNull
    ArrayList<Category> categories;

    LayoutInflater inflater;

    public categoryAdapter(Context context, @NonNull ArrayList<Category> categories) {
        this.context = context;
        this.categories = categories;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.snippet_category, parent, false);
        }

        // get current item to be displayed


        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.categoryInnerTV);

        ImageView imageViewItemName = (ImageView) convertView.findViewById(R.id.categoryInnerIV);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(categories.get(position).getCategory());
        imageViewItemName.setImageResource(categories.get(position).getImg());


        // returns the view for the current row
        return convertView;
    }
}
