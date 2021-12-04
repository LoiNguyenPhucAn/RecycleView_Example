/**
 * Steps for implementing your RecyclerView
 * https://developer.android.com/guide/topics/ui/layout/recyclerview#steps-for-implementing
 * First of all, decide what the list or grid is going to look like. Ordinarily you'll be able to use one of the RecyclerView library's standard layout managers.
 * Design how each element in the list is going to look and behave. Based on this design, extend the ViewHolder class. Your version of ViewHolder provides all the functionality for your list items. Your view holder is a wrapper around a View, and that view is managed by RecyclerView.
 * Define the Adapter that associates your data with the ViewHolder views.
 * */

package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String[] name;
    int[] image = {R.drawable.ic_c, R.drawable.ic_c_plus_plus, R.drawable.ic_c_sharp,
            R.drawable.ic_java, R.drawable.ic_javascript, R.drawable.ic_html_5,
            R.drawable.ic_kotlin, R.drawable.ic_flutter, R.drawable.ic_python,
            R.drawable.ic_react_native, R.drawable.ic_php, R.drawable.ic_sql};

    RecyclerView recyclerViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = getResources().getStringArray(R.array.programming_language);

        recyclerViewMain = findViewById(R.id.recycleViewMain);

        //Define the Adapter that associates your data with the ViewHolder views.
        MyRecycleAdapterView adapterView = new MyRecycleAdapterView(name, image, this);
        recyclerViewMain.setAdapter(adapterView);

        //The items in your RecyclerView are arranged by a LayoutManager class.
        //https://developer.android.com/guide/topics/ui/layout/recyclerview#plan-your-layout
        /**
         * LinearLayoutManager: arranges the items in a one-dimensional list.
         * https://developer.android.com/reference/androidx/recyclerview/widget/LinearLayoutManager
         *
         * GridLayoutManager: arranges all items in a two-dimensional grid: arranged vertically or arranged horizontally
         * https://developer.android.com/reference/androidx/recyclerview/widget/GridLayoutManager
         *
         * StaggeredGridLayoutManager: is similar to GridLayoutManager, but it does not require that items in a row have the same height (for vertical grids)
         * or items in the same column have the same width (for horizontal grids). The result is that the items in a row or column can end up offset from each other.
         * https://developer.android.com/reference/androidx/recyclerview/widget/StaggeredGridLayoutManager
         * */
        recyclerViewMain.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,true));

    }
}