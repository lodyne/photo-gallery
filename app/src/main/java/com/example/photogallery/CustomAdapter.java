package com.example.photogallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {


    private List<Photo> photoList;

    public CustomAdapter(List<Photo> photoList) {
        this.photoList = photoList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_list_layout,
                parent,
                false
        );
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Photo photo = photoList.get(position);
        holder.imagePhoto.setImageResource(photo.getImagePhoto());

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }


    static class CustomViewHolder extends RecyclerView.ViewHolder{

        ImageView imagePhoto;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePhoto = itemView.findViewById(R.id.imageView);
        }
    }

}
