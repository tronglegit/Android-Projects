package com.example.hp.affordablenyctour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class RestaurantActivity extends ActionBarActivity {
    ListView list;
    String[] itemname ={
            "Big Wong Restaurant",
            "Pure Thai Cookhouse",
            "Shake Shack",
            "Nam Son Restaurant",
            "Peking Duck House",
            "Mika Japanese Cuisine",
            "Le Baobab",
            "Basta Pasta"
    };
    String[] description ={
            "Chinese Restaurant",
            "Thai Restaurant",
            "American Restaurant",
            "Vietnamese Restaurant",
            "Chinese Restaurant",
            "Japanese Restaurant",
            "African Restaurant",
            "Italian Restaurant"
    };

    Integer[] imgid={
            R.drawable.big_wong,
            R.drawable.pure_thai,
            R.drawable.shake_shack,
            R.drawable.nam_son,
            R.drawable.peking_duck,
            R.drawable.mika,
            R.drawable.le_baobab,
            R.drawable.basta_pasta
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
                      Intent intent = new Intent(view.getContext(),RestaurantDetail.class );
                      startActivity(intent);
              }

            }
        });
    }



}
