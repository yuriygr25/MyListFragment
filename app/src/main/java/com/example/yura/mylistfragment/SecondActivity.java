package com.example.yura.mylistfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckedTextView;

public class SecondActivity extends AppCompatActivity  {
    public String flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flag = getIntent().getStringExtra("flag");
        setContentView(R.layout.activity_second);
    }

    public String GetFlag() {
        return flag;
    }



}
