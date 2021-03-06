package com.example.yura.mylistfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleListFragment extends ListFragment  {

    // определяем массив типа String
    final String[] catNames = new String[]{"Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка",
            "Кузя", "Китти", "Масяня", "Симба"};


    private ArrayAdapter<String> mAdapter;
    private MyListAdapter myListAdapter;

    private ArrayList<String> catNamesList = new ArrayList<>(Arrays.asList(catNames));

    private String flag="0";



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SecondActivity act = (SecondActivity) getActivity();
        flag=act.GetFlag();

        if (flag.equals("1")) {
            myListAdapter = new MyListAdapter (getActivity(), android.R.layout.simple_list_item_multiple_choice, catNames);
        } else {
            myListAdapter = new MyListAdapter (getActivity(), android.R.layout.simple_list_item_1, catNames);
        }
        setListAdapter(myListAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listfragment, null);
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (flag.equals("0"))
        {
            Toast.makeText(getActivity(),
                    getListView().getItemAtPosition(position).toString(),
                    Toast.LENGTH_LONG).show();
        } else
        {

            CheckedTextView cView = (CheckedTextView) v.findViewById(R.id.text1);
                cView.toggle();

            String prompt = "Вы выбрали: "
                    + getListView().getItemAtPosition(position).toString()
                    +"\n";

            prompt += "Выбранные элементы: \n";
            int count = getListView().getCount();
            SparseBooleanArray sparseBooleanArray = getListView()
                    .getCheckedItemPositions();
            for (int i = 0; i < count; i++) {
                if (sparseBooleanArray.get(i)) {
                    prompt += getListView().getItemAtPosition(i).toString() + "\n";
                }
            }
            Toast.makeText(getActivity(), prompt, Toast.LENGTH_LONG).show();
        }
    }


    public class MyListAdapter extends ArrayAdapter<String> {

        private Context mContext;

        public MyListAdapter(Context context, int textViewResourceId,
                             String[] objects) {
            super(context, textViewResourceId, objects);
            mContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //super.getView(position, convertView, parent); ///было закомментарено

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.listfragment_row, parent,
                    false);


            CheckedTextView checkTextView = (CheckedTextView) row.findViewById(R.id.text1);


            if (flag.equals("1")) {
                checkTextView.setVisibility(View.VISIBLE);} else
            {checkTextView.setVisibility(View.INVISIBLE);}


            TextView catNameTextView = (TextView) row.findViewById(R.id.textViewName);
            catNameTextView.setText(catNames[position]);


            ImageView iconImageView = (ImageView) row.findViewById(R.id.imageViewIcon);

            // Присваиваем значок
            iconImageView.setImageResource(R.drawable.ic_launcher_cat);

            return row;
        }
    }




}