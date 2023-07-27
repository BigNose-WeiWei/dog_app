package com.example.dog_app.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dog_app.Adapter.MypetAdapter;
import com.example.dog_app.Model.Mypet;
import com.example.dog_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import static android.content.Context.MODE_PRIVATE;

public class MypetDetailFragment extends Fragment {

    String postid;

    private RecyclerView recyclerView;
    private MypetAdapter mypetAdapter;
    private List<Mypet> mypetsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mypet, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("Mypet", MODE_PRIVATE);
        postid = prefs.getString("postid", "none");

        recyclerView = view.findViewById(R.id.recycler_view_u);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        mypetsList = new ArrayList<>();
        mypetAdapter = new MypetAdapter(getContext(), mypetsList);
        recyclerView.setAdapter(mypetAdapter);

        readPost();

        return view;
    }

    private void readPost(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Mypet").child(postid);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mypetsList.clear();
                Mypet mypet = dataSnapshot.getValue(Mypet.class);
                mypetsList.add(mypet);

                mypetAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
