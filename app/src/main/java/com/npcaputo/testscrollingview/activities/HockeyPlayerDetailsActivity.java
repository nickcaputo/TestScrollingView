package com.npcaputo.testscrollingview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import com.npcaputo.testscrollingview.R;
import com.squareup.picasso.Picasso;

public class HockeyPlayerDetailsActivity extends AppCompatActivity {

    public static final String NAME_EXTRA = "name";
    public static final String POSITION_EXTRA = "position";
    public static final String IMAGE_URL_EXTRA = "image_url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hockey_player_details);

        Intent delivered = getIntent();
        String name = delivered.getStringExtra(NAME_EXTRA);
        String position = delivered.getStringExtra(POSITION_EXTRA);
        String imageUrl = delivered.getStringExtra(IMAGE_URL_EXTRA);

        TextView nameView = findViewById(R.id.hockey_player_activity_title);
        TextView positionView = findViewById(R.id.hockey_player_activity_position);
        ImageView image = findViewById(R.id.hockey_player_activity_image);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        double height = displayMetrics.heightPixels * .75;
        image.getLayoutParams().height = (int) height;

        nameView.setText(name);
        positionView.setText(position);
        Picasso.with(this).load(imageUrl).into(image);
    }

}
