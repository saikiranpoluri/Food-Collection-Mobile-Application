package com.example.donatefooddontwaste;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.viewHolder>{
    private static final String TAG = "AdapterHome";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();

    private HomeFragment mcontext;

    public AdapterHome(HomeFragment context, ArrayList<String> mImageNames, ArrayList<String> mImages) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.articles,parent,false);
        viewHolder holder =  new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(mcontext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.iv);
        holder.t1.setText(mImageNames.get(position));
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        TextView t1;
        ImageView iv;
        RelativeLayout parentLayout;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.product_name);
            iv = itemView.findViewById(R.id.product_image);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }


}
