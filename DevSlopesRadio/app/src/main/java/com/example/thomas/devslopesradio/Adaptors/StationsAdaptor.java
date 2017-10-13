package com.example.thomas.devslopesradio.Adaptors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.devslopesradio.Activities.MainActivity;
import com.example.thomas.devslopesradio.Holders.StationViewHolder;
import com.example.thomas.devslopesradio.Models.Station;
import com.example.thomas.devslopesradio.R;

import java.util.ArrayList;

/**
 * Created by Thomas on 2/19/2017.
 */

public class StationsAdaptor extends RecyclerView.Adapter<StationViewHolder>{

    private ArrayList<Station> stations;

    public StationsAdaptor(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, final int position) {
        final Station station = stations.get(position);
        holder.updateUI(station);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the details screen
                MainActivity.getMainActivity().loadDetailsScreen(station);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View stationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_station,parent,false);

        return new StationViewHolder(stationCard);
    }
}
