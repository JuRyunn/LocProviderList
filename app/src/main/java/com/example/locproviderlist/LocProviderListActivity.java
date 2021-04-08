package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {

    TextView nTextView;
    LocationManager locMgr;
    List<String> locProvList;
    Button mbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nTextView = findViewById(R.id.txtOutput);

        mbutton = findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                locMgr = (LocationManager) getSystemService (LOCATION_SERVICE);

                locProvList = locMgr.getAllProviders();

                String s = "";
                nTextView.setText(s);
                for (String locProvList : locProvList){
                    nTextView.append("Loc.Provider: "+locProvList+"\n");
                    nTextView.append("Status: "+locMgr.isProviderEnabled(locProvList)+"\n");
                }

            }
        });

    }
}