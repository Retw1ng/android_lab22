package com.example.lab2;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class list_activity extends Activity {
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        Button button2 = findViewById(R.id.add);
        Button button3 = findViewById(R.id.del);

        ListView list1 = findViewById(R.id.list);
        EditText text1 = findViewById(R.id.editText);

        ArrayList<String> datalist = new ArrayList<String>();

        ArrayAdapter<String> TextAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_multiple_choice, datalist);

        list1.setAdapter(TextAdapter);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = text1.getText().toString();
                if(!data.isEmpty()) {
                    datalist.add(data);
                    text1.setText("");
                    TextAdapter.notifyDataSetChanged();
                }


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //list1.setSelector(R.color.white);
                TextAdapter.notifyDataSetChanged();
                SparseBooleanArray selected = list1.getCheckedItemPositions();
                for(int i=0; i < datalist.toArray().length;i++)
                {
                    if(selected.get(i)) {
                        datalist.remove(datalist.get(i));
                        TextAdapter.notifyDataSetChanged();
                        //selected.removeAt(i);
                        selected.delete(i);
                    }
                }
            }
        });

//        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //list1.setSelector(R.color.purple_200);
//                data = TextAdapter.getItem(i);
//                TextAdapter.notifyDataSetChanged();
//
//            }
//        });
    }



}

