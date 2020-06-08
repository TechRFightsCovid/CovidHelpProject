package com.example.covidhelp.Utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidhelp.Customer.CategoriesActivity;
import com.example.covidhelp.DataModels.Shop;
import com.example.covidhelp.R;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {
    private static final String TAG = "ShopAdapter";
    private final Context mContext;

    private Shop[] mShops;

    public class ShopViewHolder extends RecyclerView.ViewHolder{

        public TextView shopName;
        public TextView shopAddress;
        public TextView shopRatings;
        public CardView parentLayout;

        public ShopViewHolder(View itemView){
            super(itemView);
            shopName = (TextView) itemView.findViewById(R.id.s_name_TV);
            shopAddress = (TextView) itemView.findViewById(R.id.s_address_TV);
            shopRatings = (TextView) itemView.findViewById(R.id.s_ratings_TV);
            parentLayout = (CardView) itemView.findViewById(R.id.cardShop);
        }
    }

    public ShopAdapter(Shop[] shops, Context context){
        mShops = shops;
        mContext = context;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context ctx = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(R.layout.shop_card, parent, false);
        ShopViewHolder viewHolder = new ShopViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, final int position) {
        holder.shopName.setText(mShops[position].getsName());
        holder.shopAddress.setText(mShops[position].getsAddress());
        holder.shopRatings.setText(String.valueOf(mShops[position].getsRating()));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CategoriesActivity.class);
                intent.putExtra("shop", mShops[position].getsName());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShops.length;
    }


}
