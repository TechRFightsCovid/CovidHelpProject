package com.example.covidhelp.Shopkeeper;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.covidhelp.DataModels.Items;
import com.example.covidhelp.R;
import com.example.covidhelp.Utils.itemsAdapter;

import java.util.ArrayList;
import java.util.Objects;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class OrderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CUST_NAME = "param1";
    private static final String LIST_ITEMS = "param3";

    // TODO: Rename and change types of parameters
    private String cNameArg;
    private Items[] itemsArg;
    private TextView cName;
    private TextView total;
    private RecyclerView itemsRV;
    private Button accept;
    private Button decline;


    public OrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param3 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, Items[] param3) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putString(CUST_NAME, param1);
        args.putParcelableArray(LIST_ITEMS, param3);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            cNameArg = getArguments().getString(CUST_NAME);
            itemsArg = (Items[]) getArguments().getSerializable(LIST_ITEMS);
            Log.d(TAG, "onCreate: " + itemsArg);
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cName = (TextView) Objects.requireNonNull(getView()).findViewById(R.id.cname_tv);
        total = (TextView) getView().findViewById(R.id.total_val_tv);
        itemsRV = (RecyclerView) getView().findViewById(R.id.order_items_RV);
        accept = (Button) getView().findViewById(R.id.btn_accept);
        decline = (Button) getView().findViewById(R.id.btn_cancel);
        final itemsAdapter adapter = new itemsAdapter(getContext(), itemsArg);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        itemsRV.setLayoutManager(manager);
        itemsRV.setAdapter(adapter);
        final int totalArg = adapter.getTotal();

        cName.setText(cNameArg);
        total.setText(String.valueOf(totalArg));
        adapter.setTotalListener(new itemsAdapter.totalListener() {
            @Override
            public void OnTotalChanged(int newTotal) {
                total.setText(String.valueOf(newTotal));
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}
