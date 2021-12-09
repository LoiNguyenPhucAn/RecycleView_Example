package com.example.recycleviewgridlayout;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewgridlayout.databinding.ActivityMainBinding;
import com.example.recycleviewgridlayout.databinding.IconRecyclerviewBinding;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CustomAdapterView extends RecyclerView.Adapter<CustomAdapterView.CustomViewHolder>{

    IconRecyclerviewBinding iconRecyclerviewBinding;
    Context mContext;
    ArrayList<String> recyclerViewPageList;

    public CustomAdapterView(Context mContext, ArrayList<String> recyclerViewPageList) {
        this.mContext = mContext;
        this.recyclerViewPageList = recyclerViewPageList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Lồng icon_recyclerview vào ViewGroup parent trong ngữ cảnh mContext
        iconRecyclerviewBinding = IconRecyclerviewBinding.inflate(LayoutInflater.from(mContext),parent,false);

        return new CustomViewHolder(iconRecyclerviewBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        AssetManager assetManager = mContext.getAssets();
        String srcName = recyclerViewPageList.get(position).substring(3);

        try{
            InputStream ims = assetManager.open(recyclerViewPageList.get(position));
            Drawable d = Drawable.createFromStream(ims, srcName);
            iconRecyclerviewBinding.ivIcon.setImageDrawable(d);

        }catch (Exception ex){
            Log.d("onBindViewHolder","Exception" + ex);
        }


    }

    @Override
    public int getItemCount() {
        return recyclerViewPageList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        ImageView ivIcon;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }
}
