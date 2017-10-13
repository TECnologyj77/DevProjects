package com.example.thomas.bootcamplocator.Adaptors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.bootcamplocator.Holders.LocationsViewHolder;
import com.example.thomas.bootcamplocator.Model.DevSlopes;
import com.example.thomas.bootcamplocator.R;

import java.util.ArrayList;

/**
 * Created by Thomas on 4/1/2017.
 */

public class LoactionsAdaptor extends RecyclerView.Adapter<LocationsViewHolder>{


    private ArrayList<DevSlopes> locations;

    public LoactionsAdaptor(ArrayList<DevSlopes> locations) {
        this.locations = locations;

    }

    @Override
    public void onBindViewHolder(LocationsViewHolder holder, int position) {
        final DevSlopes location = locations.get(position);
        holder.updateUI(location);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load details page
            }
        });
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    @Override
    public LocationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_location, parent, false);
        return new LocationsViewHolder(card);
    }
}
