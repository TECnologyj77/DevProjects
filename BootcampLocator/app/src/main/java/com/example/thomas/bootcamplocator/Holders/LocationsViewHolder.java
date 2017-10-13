package com.example.thomas.bootcamplocator.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thomas.bootcamplocator.Model.DevSlopes;
import com.example.thomas.bootcamplocator.R;

/**
 * Created by Thomas on 4/1/2017.
 */

public class LocationsViewHolder extends RecyclerView.ViewHolder {

    private ImageView locationImg;
    private TextView locationTitle;
    private TextView locationAddress;

    public LocationsViewHolder(View itemView) {
        super(itemView);

        locationImg = (ImageView) itemView.findViewById(R.id.location_img);
        locationTitle = (TextView) itemView.findViewById(R.id.location_title);
        locationAddress = (TextView) itemView.findViewById(R.id.location_address);

    }
        public void updateUI(DevSlopes location){

            String uri = location.getImgURL();
            int resource = locationImg.getResources().getIdentifier(uri, null, locationImg.getContext().getPackageName());
            locationImg.setImageResource(resource);
            locationTitle.setText(location.getLocationTitle());
            locationAddress.setText(location.getLocationAddress());
    }

}
