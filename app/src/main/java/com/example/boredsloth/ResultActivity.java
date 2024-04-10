package com.example.boredsloth;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button goBackBtn = findViewById(R.id.backBtn);
        goBackBtn.setOnClickListener(v -> goBack());

        ImageView typeImage = findViewById(R.id.type_icon);
        ImageView participantsImage = findViewById(R.id.participants_icon);
        ImageView durationImage = findViewById(R.id.duration_icon);
        ImageView accessibilityImage = findViewById(R.id.accessibility_icon);
        ImageView kidFriendlyImage = findViewById(R.id.kid_friendly_icon);



        String jsonData = getIntent().getStringExtra("json_data");
        try {
            JSONObject jsonObject = new JSONObject(jsonData);

            TextView activityValue = findViewById(R.id.activity_value);
            activityValue.setText(jsonObject.getString("activity"));

            TextView typeValue = findViewById(R.id.type_value);
            typeValue.setText(jsonObject.getString("type"));
            String typeIcon = jsonObject.getString("type");
            switch (typeIcon) {
                case "education":
                    typeImage.setImageResource(R.drawable.type_icon_education);
                    break;
                case "social":
                    typeImage.setImageResource(R.drawable.type_icon_social);
                    break;
                case "busywork":
                    typeImage.setImageResource(R.drawable.type_icon_busywork);
                    break;
                case "relaxation":
                    typeImage.setImageResource(R.drawable.type_icon_relaxation);
                    break;
                case "recreational":
                    typeImage.setImageResource(R.drawable.type_icon_recreational);
                    break;
                case "cooking":
                    typeImage.setImageResource(R.drawable.type_icon_cooking);
                    break;
                case "charity":
                    typeImage.setImageResource(R.drawable.type_icon_charity);
                    break;
                case "music":
                    typeImage.setImageResource(R.drawable.type_icon_music);
                    break;
                case "diy":
                    typeImage.setImageResource(R.drawable.type_icon_diy);
                    break;
                default:
                    typeImage.setImageResource(R.drawable.random_activity_button);
                    break;
            }

            TextView participantsValue = findViewById(R.id.participants_value);
            participantsValue.setText(jsonObject.getString("participants"));
            String participantsIcon = jsonObject.getString("participants");

            switch (participantsIcon) {
                case "1":
                    participantsImage.setImageResource(R.drawable.participants_icon_one);
                    break;
                case "2":
                    participantsImage.setImageResource(R.drawable.participants_icon_two);
                    break;
                default:
                    participantsImage.setImageResource(R.drawable.participants_icon_more);
                    break;
            }

            TextView durationValue = findViewById(R.id.duration_value);
            durationValue.setText(jsonObject.getString("duration"));
            String durationIcon = jsonObject.getString("duration");

            switch (durationIcon) {
                case "minutes":
                    durationImage.setImageResource(R.drawable.duration_icon_minutes);
                    break;
                case "hours":
                    durationImage.setImageResource(R.drawable.duration_icon_hours);
                    break;
                case "days":
                    durationImage.setImageResource(R.drawable.duration_icon_days);
                    break;
                default:
                    durationImage.setImageResource(R.drawable.random_activity_button);
                    break;
            }

            TextView accessibilityValue = findViewById(R.id.accessibility_value);
            accessibilityValue.setText(jsonObject.getString("accessibility"));
            String accessibilityIcon = jsonObject.getString("accessibility");

            switch (accessibilityIcon) {
                case "Few to no challenges":
                    accessibilityImage.setImageResource(R.drawable.access_icon_few);
                    break;
                case "Minor challenges":
                    accessibilityImage.setImageResource(R.drawable.access_icon_minor);
                    break;
                case "Major challenges":
                    accessibilityImage.setImageResource(R.drawable.access_icon_major);
                    break;
                default:
                    accessibilityImage.setImageResource(R.drawable.random_activity_button);
                    break;
            }

            TextView kidFriendlyValue = findViewById(R.id.kid_friendly_value);
            kidFriendlyValue.setText(jsonObject.getString("kidFriendly"));
            String kidIcon = jsonObject.getString("kidFriendly");

            if (kidIcon.equals("true")) {
                kidFriendlyImage.setImageResource(R.drawable.kid_icon_yes);
            } else {
                kidFriendlyImage.setImageResource(R.drawable.kid_icon_no);
            }

            TextView linkValue = findViewById(R.id.link_value);
            linkValue.setText(jsonObject.getString("link"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void goBack(){
        Intent homePage = new Intent(this, MainActivity.class);
        startActivity(homePage);
    }
}