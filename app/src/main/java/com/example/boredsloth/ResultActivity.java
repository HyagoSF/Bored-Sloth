package com.example.boredsloth;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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

        String jsonData = getIntent().getStringExtra("json_data");
        try {
            JSONObject jsonObject = new JSONObject(jsonData);

            TextView activityValue = findViewById(R.id.activity_value);
            activityValue.setText(jsonObject.getString("activity"));

            TextView typeValue = findViewById(R.id.type_value);
            typeValue.setText(jsonObject.getString("type"));

            TextView participantsValue = findViewById(R.id.participants_value);
            participantsValue.setText(jsonObject.getString("participants"));

            TextView durationValue = findViewById(R.id.duration_value);
            durationValue.setText(jsonObject.getString("duration"));

            TextView accessibilityValue = findViewById(R.id.accessibility_value);
            accessibilityValue.setText(jsonObject.getString("accessibility"));

            TextView kidFriendlyValue = findViewById(R.id.kid_friendly_value);
            kidFriendlyValue.setText(jsonObject.getString("kidFriendly"));

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