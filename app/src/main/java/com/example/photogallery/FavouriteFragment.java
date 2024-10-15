package com.example.photogallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FavouriteFragment extends Fragment {
    RecyclerView recyclerView;
    public List<Photo> photoList;

    public FavouriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        photoList = new ArrayList<>();

        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        recyclerView = view.findViewById(R.id.recycleView);

        CustomAdapter customAdapter = new CustomAdapter(photoList);

        Photo photo1 = new Photo(R.drawable.bruno);
        Photo photo2 = new Photo(R.drawable.casemiro);
        Photo photo3 = new Photo(R.drawable.dalot);
        Photo photo4 = new Photo(R.drawable.spotify);
        Photo photo5 = new Photo(R.drawable.deligt);
        Photo photo6 = new Photo(R.drawable.eriksen);

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