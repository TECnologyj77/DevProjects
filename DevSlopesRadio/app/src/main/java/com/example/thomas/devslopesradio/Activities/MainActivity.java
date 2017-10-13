package com.example.thomas.devslopesradio.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.thomas.devslopesradio.Fragments.DetailsFragment;
import com.example.thomas.devslopesradio.Fragments.MainFragment;
import com.example.thomas.devslopesradio.Models.Station;
import com.example.thomas.devslopesradio.R;

public class MainActivity extends AppCompatActivity {

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    private static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment) fragmentManager.findFragmentById(R.id.activity_main);

        if(mainFragment==null){
            mainFragment = MainFragment.newInstance("blah", "cah");
            fragmentManager.beginTransaction().add(R.id.activity_main, mainFragment).commit();
        }
    }

public void loadDetailsScreen(Station selectedStation){
    getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, new DetailsFragment()).addToBackStack(null).commit();
}


}
