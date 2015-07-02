package com.example.hp.affordablenyctour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class AttractionActivity extends ActionBarActivity {
    ListView list;
    String[] itemname ={
            "Central Park",
            "Battery Park",
            "Statue of Liberty",
            "Bronx Museum of the Arts",
            "New York Public Library",
            "Roosevelt Island",
            "Times Square",
            "911 Memorial & Musium"
    };
    String[] description ={
            "59th Street, Admission: Free",
            "75 Battery Place, Admission: Free",
            "Liberty Island, Addmission: $18",
            "1040 Grand Concourse, Bronx Addmission: Free",
            "5th Ave at 42nd St, Admission: Free",
            "NY's East River, Admission: Free",
            "47th St, Admission: Free",
            "180 Greenwich St, Admission: Free"
    };

    Integer[] imgid={
            R.drawable.central_park,
            R.drawable.battery_park,
            R.drawable.statue_liberty,
            R.drawable.bronx_museum,
            R.drawable.nypl,
            R.drawable.roosevelt_island,
            R.drawable.times_square,
            R.drawable.memorial
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        RestaurantAdapter adapter=new RestaurantAdapter(this, itemname, imgid,description);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(view.getContext(),AttractionDetail.class );
                        startActivity(intent);
                }

            }
        });
    }



}
