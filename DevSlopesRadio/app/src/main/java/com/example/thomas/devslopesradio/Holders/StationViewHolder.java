package com.example.thomas.devslopesradio.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thomas.devslopesradio.Models.Station;
import com.example.thomas.devslopesradio.R;

import org.w3c.dom.Text;

/**
 * Created by Thomas on 2/19/2017.
 */

public class StationViewHolder extends RecyclerView.ViewHolder {

    public ImageView mainImage;
    public TextView titleTextView;
    public StationViewHolder(View itemView) {
        super(itemView);

        this.mainImage = (ImageView) itemView.findViewById(R.id.mainImage);
        this.titleTextView = (TextView) itemView.findViewById(R.id.mainText);
    }

    public void updateUI(Station station){
        String uri = station.getImageUri();
        int resource = mainImage.getResources().getIdentifier(uri,null,mainImage.getContext().getPackageName());
        mainImage.setImageResource(resource);

        titleTextView.setText(station.getStationTitle());

    }

}
