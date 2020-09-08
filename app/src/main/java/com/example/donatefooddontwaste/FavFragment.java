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

import com.example.donatefooddontwaste.Interface.ItemClickListner;
import com.example.donatefooddontwaste.Model.Products;
import com.example.donatefooddontwaste.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FavFragment extends Fragment  {
    private View contactView;
    private RecyclerView mycontactList;
    private DatabaseReference productRef;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        contactView = inflater.inflate(R.layout.fragments_fav, container, false);

        mycontactList = (RecyclerView)contactView.findViewById(R.id.recycler_menu);
        mycontactList.setLayoutManager(new LinearLayoutManager(getContext()));
        productRef = FirebaseDatabase.getInstance().getReference().child("Products");
        return contactView;



    }


    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                .setQuery(productRef,Products.class)
                .build();
        FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter =
        new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final ProductViewHolder holder, int position, @NonNull Products model)
            {
                String uid = getRef(position).getKey();
                productRef.child(uid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot)
                    {
                        if(snapshot.hasChild("image"))
                        {
                            String profileImage = snapshot.child("image").getValue().toString();
                            String pname = snapshot.child("pname").getValue().toString();
                            String pmnum = snapshot.child("Mobile number").getValue().toString();
                            String paddr = snapshot.child("Address").getValue().toString();
                            holder.txtProductName.setText(pname);
                            holder.txtProductDescription.setText(pmnum);
                            holder.txtProductPrice.setText(paddr);
                            Picasso.get().load(profileImage).placeholder(R.drawable.ic_baseline_account_box_24).into(holder.imageView);
                        }
                        else
                        {
                            String pname = snapshot.child("pname").getValue().toString();
                            String pmnum = snapshot.child("Mobile number").getValue().toString();
                            String paddr = snapshot.child("Address").getValue().toString();
                            holder.txtProductName.setText(pname);
                            holder.txtProductDescription.setText(pmnum);
                            holder.txtProductPrice.setText(paddr);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @NonNull
            @Override
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donar_items_layout,parent,false);
                ProductViewHolder holder = new ProductViewHolder(view);
                return holder;
            }
        };
        mycontactList.setAdapter(adapter);
        adapter.startListening();
    }
}
