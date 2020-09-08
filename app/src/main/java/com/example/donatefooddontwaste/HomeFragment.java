package com.example.donatefooddontwaste;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private View contactView;
    private RecyclerView mycontactList;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contactView = inflater.inflate(R.layout.fragment_homefin, container, false);
        mycontactList = contactView.findViewById(R.id.recycler_menu);
        mycontactList.setLayoutManager(new LinearLayoutManager(contactView.getContext()));

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("The food industry accounts for 26% of all greenhouse gas emissions vs 2% from airplanes");

        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("The impact of food waste is 4 times greater than the impact of all flights in the world combined");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Food waste has increased by 204% since 1960 and 50% since 1990");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("If food waste was represented as a country, it would be 3 largest global greenhouse gas emitter");


        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Yearly CO2 emissions from food waste amount to the equivalent of 3 million cars on the road");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add(" Globally, 750 billion dollars each year is lost due to waste food");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("Saving food from being wasted, is environmentally smarter than eliminating cars and flights");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("100 rescued bananas equal as much greenhouse gas emissions as 20 cars");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Not all plastic is bad! Plastic-packed food can often result in the food being kept edible for longer and not wasted");

        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("Nuts have a positive impact on greenhouse gas emissions - trees bind carbon dioxide");

        AdapterHome adapter = new AdapterHome(this,mNames,mImageUrls);
        mycontactList.setAdapter(adapter);


        return contactView;

    }

}
