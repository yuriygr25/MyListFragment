package com.example.yura.mylistfragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, SingleListFragment.class);
        startActivity(intent);

        Intent intent = new Intent(MainActivity.this, SingleListFragment.class);
        startActivity(intent);
*/

    }
}

