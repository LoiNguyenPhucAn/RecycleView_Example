package com.example.recycleviewgridlayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    String[] icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            icon = getApplicationContext().getAssets().list("");
            // set a GridLayoutManager with default vertical orientation and 3 number of columns
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3,RecyclerView.VERTICAL,true);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_grid);

            //  call the constructor of CustomAdapter to send the reference and data to Adapter
            CustomAdapterView adapterView = new CustomAdapterView (this,icon);

            // set the Adapter to RecyclerView
            recyclerView.setAdapter(adapterView);
            recyclerView.setLayoutManager(gridLayoutManager);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}