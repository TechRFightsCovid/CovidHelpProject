package com.example.covidhelp.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidhelp.DataModels.Items;
import com.example.covidhelp.R;

public class checkoutAdapter extends RecyclerView.Adapter<checkoutAdapter.checkoutViewHolder> {

    private Items[] mItems;

    public class checkoutViewHolder extends RecyclerView.ViewHolder{

        public TextView itemName;
        public TextView itemPrice;

        public checkoutViewHolder(View itemView){
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemPrice = (TextView) itemView.findViewById(R.id.item_price);
        }
    }

    public checkoutAdapter(Items[] items){
        mItems = items;
    }

    @NonNull
    @Override
    public checkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context ctx = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(R.layout.item_card, parent, false);
        checkoutViewHolder viewHolder = new checkoutViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull checkoutViewHolder holder, int position) {
        holder.itemName.setText(mItems[position].getiName());
        holder.itemPrice.setText(String.valueOf(mItems[position].getPrice()));
    }

    @Override
    public int getItemCount() {
        return mItems.length;
    }
}
