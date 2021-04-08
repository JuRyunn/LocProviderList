package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {

    TextView nTextView;
    LocationManager locMgr;
    List<String> locProvList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nTextView = findViewById(R.id.txtOutput);
        locMgr = (LocationManager) getSystemService (LOCATION_SERVICE);

        locProvList = locMgr.getAllProviders();

        String s = "";
        for (int i = 0; i < locProvList.size(); i++){
            s += "Loc.Provider: " + locProvList.get(i) + "\n"
                + "Status:" + locMgr.isProviderEnabled(locProvList.get(i)) + "\n\n";

        }

        nTextView.setText(s);


    }
}