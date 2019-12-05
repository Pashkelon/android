package com.example.homeworkone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    private String[] cities;

    public CityAdapter(String[] data){
        cities = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.city_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setLabel(cities[position]);
    }

    @Override
    public int getItemCount() {
        return cities.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView label;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.label);
        }
        void setLabel(String text){
                label.setText(text);
        }
    }
}
