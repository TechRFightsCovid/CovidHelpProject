package com.example.covidhelp.Onboarding;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.covidhelp.Auth.FirstActivity;
import com.example.covidhelp.Auth.Getuser;
import com.example.covidhelp.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class Onboarding5 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_onboarding5, container, false);

        view.findViewById(R.id.nextBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextBtn();
            }
        });

        return view;

    }

    private void nextBtn(){
        Intent intent = new Intent(getActivity(), FirstActivity.class);
        startActivity(intent);
    }
}
