package com.example.hp.affordablenyctour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;


public class AttractionDetail extends ActionBarActivity implements View.OnClickListener{
    private static ImageView imageView;
    private static Button nextButton;
    private static Button prevButton;
    private static int img_index;
    private static TextView textView;
    private static Button citiBike;
    private static final String Tag_restaurant ="Restaurants";
    private static final String Tag_attraction ="Attractions";

    int [] images ={R.drawable.central1,R.drawable.central2,R.drawable.central3,R.drawable.central4,R.drawable.central5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);
        nextBntClick();
        prevBntClick();


        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher);
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(imageView)
                .build();

        ImageView attractionPage = new ImageView(this);
        attractionPage.setImageResource(R.drawable.att_icon);
        ImageView restaurantPage = new ImageView(this);
        restaurantPage.setImageResource(R.drawable.rest_icon);
        ImageView freewifiPage = new ImageView(this);
        freewifiPage.setImageResource(R.drawable.wif_icon);
        ImageView couponsPage = new ImageView(this);
        couponsPage.setImageResource(R.drawable.coup_icon);
        ImageView entertainmentPage = new ImageView(this);
        entertainmentPage.setImageResource(R.drawable.ent_icon);
        ImageView budgetPage = new ImageView(this);
        budgetPage.setImageResource(R.drawable.bud_icon);


        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        SubActionButton attraction = itemBuilder.setContentView(attractionPage).build();
        SubActionButton restaurant = itemBuilder.setContentView(restaurantPage).build();
        SubActionButton freewifi = itemBuilder.setContentView(freewifiPage).build();
        SubActionButton coupons = itemBuilder.setContentView(couponsPage).build();
        SubActionButton entertainment = itemBuilder.setContentView(entertainmentPage).build();
        SubActionButton budget = itemBuilder.setContentView(budgetPage).build();

        restaurant.setTag(Tag_restaurant);
        attraction.setTag(Tag_attraction);

        restaurant.setOnClickListener(this);
        attraction.setOnClickListener(this);


        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(attraction)
                .addSubActionView(restaurant)
                .addSubActionView(freewifi)
                .addSubActionView(coupons)
                .addSubActionView(entertainment)
                .addSubActionView(budget)
                .attachTo(actionButton)
                .build();

    }


    public void nextBntClick() {
        imageView = (ImageView) findViewById(R.id.imageView);
        nextButton = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        nextButton = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_index++;
                img_index = img_index % images.length;
                imageView.setImageResource(images[img_index]);

            }
        });

    }

    public void prevBntClick() {
        imageView = (ImageView) findViewById(R.id.imageView);
        prevButton = (Button) findViewById(R.id.button2);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_index--;
                if (img_index <= -1) {
                    img_index = images.length - 1;
                    imageView.setImageResource(images[img_index]);


                } else {
                    imageView.setImageResource(images[img_index]);
                }
            }

        });
    }

    public void attractionClick(View view) {
        Intent intent = new Intent(getApplicationContext(),CentralParkMap.class);
        startActivity(intent);
    }


    public void getCityBike(View view) {
        citiBike = (Button) findViewById(R.id.button10);
        citiBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:40.7359831,-74.0012547?q=Citibike+locations+New+York+NY");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getTag().equals(Tag_attraction)){
            Intent intent = new Intent(v.getContext(),AttractionActivity.class );
            startActivity(intent);

        }
        if(v.getTag().equals(Tag_restaurant)){
            Intent intent = new Intent(v.getContext(),RestaurantActivity.class );
            startActivity(intent);

        }

    }
}
