package com.example.boredsloth;

import static com.example.boredsloth.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public ImageView getRandomActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        getRandomActivityButton = (ImageView) findViewById(id.random_activity_button);

        getRandomActivityButton.setOnClickListener(v -> {
            String url = "https://bored-api.appbrewery.com/random";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Intent link = new Intent(MainActivity.this, ResultActivity.class);
                            link.putExtra("json_data", response.toString());
                            startActivity(link);
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error

                        }
                    });

            // Add the request to the RequestQueue.
            Volley.newRequestQueue(this).add(jsonObjectRequest);
        });
    }
}