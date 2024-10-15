package com.example.photogallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ArchivedFragment extends Fragment {
    RecyclerView recyclerView;

    public List<Photo> photoList;

    CustomAdapter customAdapter;

    public ArchivedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        photoList = new ArrayList<>();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_archived, container, false);

        recyclerView = view.findViewById(R.id.recycleView1);

        customAdapter = new CustomAdapter(photoList);

        Photo photo1 = new Photo(R.drawable.bruno);
        Photo photo2 = new Photo(R.drawable.eriksen);
        Photo photo3 = new Photo(R.drawable.deligt);
        Photo photo4 = new Photo(R.drawable.dalot);
        Photo photo5 = new Photo(R.drawable.spotify);
        Photo photo6 = new Photo(R.drawable.casemiro);

        photoList.add(photo1);
        photoList.add(photo2);
        photoList.add(photo3);
        photoList.add(photo4);
        photoList.add(photo5);
        photoList.add(photo6);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(customAdapter);

        return view;

    }
}