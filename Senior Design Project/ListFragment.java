package com.example.pc.deepmakeupkiller.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pc.deepmakeupkiller.R;
import com.example.pc.deepmakeupkiller.Urun;
import com.example.pc.deepmakeupkiller.UrunAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class ListFragment extends Fragment {
    private Context mContext;
    private RecyclerView recyclerView;
    private UrunAdapter urunAdapter;
    private List<Urun> urunList;
    private String marka;
    Uri mImageUri;
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setReverseLayout(true);
        img=v.findViewById(R.id.img);
        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(mLayoutManager);
        urunList = new ArrayList<>();
        SharedPreferences prefs = getContext().getSharedPreferences("PREFS", MODE_PRIVATE);
         marka = prefs.getString("marka", null);
        String  mImageUriString = prefs.getString("uri", "none");
        mImageUri =Uri.parse(mImageUriString);
        img.setImageURI(mImageUri);
        urunAdapter = new UrunAdapter(getContext(), urunList);
        recyclerView.setAdapter(urunAdapter);
        if (marka == null){
            urunList.clear();
            readPosts();
        }
        else{
            urunList.clear();
            readMarka(marka);

        }

      return v;
    }

    private void readPosts() {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                urunList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {



                    for (DataSnapshot snap : snapshot.getChildren()) {
                        Urun urun = snap.getValue(Urun.class);
                        urunList.add(urun);
                    }


                    urunAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
    public void readMarka(String marka){
        DatabaseReference reference3 = FirebaseDatabase.getInstance().getReference(marka);

        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                urunList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Urun urun = snapshot.getValue(Urun.class);
                    urunList.add(urun);
                }

                urunAdapter.notifyDataSetChanged();

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
