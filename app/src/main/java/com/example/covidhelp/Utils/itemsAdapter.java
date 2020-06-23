package com.example.covidhelp.Utils;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidhelp.DataModels.Items;
import com.example.covidhelp.R;

public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.itemsViewHolder> {

    private Items[] mItems;
    private Context mContext;
    private int total = 0;
    private TextView totalTV;
    private totalListener listener;

    public class itemsViewHolder extends RecyclerView.ViewHolder{

        public TextView itemName;
        public TextView itemPrice;
        public ImageView itemCheck;

        public itemsViewHolder(View itemView){
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemPrice = (TextView) itemView.findViewById(R.id.item_price);
            itemCheck = (ImageView) itemView.findViewById(R.id.item_check);
        }

    }

    public itemsAdapter(Context context, Items[] items){
        mItems = items;
        mContext = context;
        listener = null;
    }

    @NonNull
    @Override
    public itemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context ctx = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(R.layout.item_card, parent, false);
        return new itemsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final itemsViewHolder holder, final int position) {
        holder.itemName.setText(mItems[position].getiName());
        holder.itemPrice.setText(String.valueOf(mItems[position].getPrice()));
        if(mItems[position].isChecked()){
            holder.itemCheck.setVisibility(View.VISIBLE);
        } else {
            holder.itemCheck.setVisibility(View.GONE);
        }
        holder.itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItems[position].setCheck(!mItems[position].isChecked());
                if(mItems[position].isChecked()){
                    holder.itemCheck.setVisibility(View.VISIBLE);
                } else {
                    holder.itemCheck.setVisibility(View.GONE);
                }
                total = 0;
                for(Items i: mItems){
                    if(i.isChecked()) {
                        total += i.getPrice();
                    }
                }
                listener.OnTotalChanged(total);



            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.length;
    }

    public int getTotal(){
        return total;
    }

    public interface totalListener{
        public void OnTotalChanged(int total);
    }

    public void setTotalListener(totalListener listener){
        this.listener = listener;
    }
}
