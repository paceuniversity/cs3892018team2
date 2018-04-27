package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public Button transport_lp_btn;
    public Button food_lp_btn;
    public Button hotel_lp_btn;
    public Button activities_lp_btn;
    public Button itinerary_lp_btn;
    public Button history_lp_btn;
    public ImageButton settings_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        // Settings Icon Link

        settings_btn = (ImageButton) findViewById(R.id.setting_image_button);
        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });

        /* Main Menu Variables */

        transport_lp_btn = (Button) findViewById(R.id.transport_landing_pg);
      //  transport_lp_btn.setBackgroundColor(0xFFFF0000);
        transport_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));
        transport_lp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TransportActivity.class);
                startActivity(intent);
            }
        });

        food_lp_btn = (Button) findViewById(R.id.food_landing_pg);
       // food_lp_btn.setBackgroundColor(0xFFFF0000);
        food_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));
        food_lp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FoodActivity.class);
                startActivity(intent);
            }
        });

        hotel_lp_btn = (Button) findViewById(R.id.hotel_landing_pg);
       // hotel_lp_btn.setBackgroundColor(0xFFFF0000);
        hotel_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));
        hotel_lp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,HotelActivity.class);
              startActivity(intent);
            }
        });

        activities_lp_btn = (Button) findViewById(R.id.poi_landing_pg);
       // activities_lp_btn.setBackgroundColor(0xFFFF0000);
        activities_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));
        activities_lp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivitiesActivity.class);
                startActivity(intent);
            }
        });

        itinerary_lp_btn = (Button) findViewById(R.id.itinerary_landing_pg);
       // itinerary_lp_btn.setBackgroundColor(0xFFFF0000);
        itinerary_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));
        itinerary_lp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ItineraryActivity.class);
                startActivity(intent);
            }
        });

        history_lp_btn = (Button) findViewById(R.id.history_landing_pg);
      //  history_lp_btn.setBackgroundColor(0xFFFF0000);
        history_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));
        history_lp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
                startActivity(intent);
            }
        });
        }

}
