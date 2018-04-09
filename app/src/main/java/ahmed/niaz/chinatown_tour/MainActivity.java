package ahmed.niaz.chinatown_tour;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button transport_lp_btn;
    public Button food_lp_btn;
    public Button hotel_lp_btn;
    public Button poi_lp_btn;
    public Button itinerary_lp_btn;
    public Button history_lp_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        transport_lp_btn = (Button) findViewById(R.id.transport_landing_pg);
        transport_lp_btn.setBackgroundColor(0xFFFF0000);
        transport_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));

        food_lp_btn = (Button) findViewById(R.id.food_landing_pg);
        food_lp_btn.setBackgroundColor(0xFFFF0000);
        food_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));

        hotel_lp_btn = (Button) findViewById(R.id.hotel_landing_pg);
        hotel_lp_btn.setBackgroundColor(0xFFFF0000);
        hotel_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));

        poi_lp_btn = (Button) findViewById(R.id.poi_landing_pg);
        poi_lp_btn.setBackgroundColor(0xFFFF0000);
        poi_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));

        itinerary_lp_btn = (Button) findViewById(R.id.itinerary_landing_pg);
        itinerary_lp_btn.setBackgroundColor(0xFFFF0000);
        itinerary_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));

        history_lp_btn = (Button) findViewById(R.id.history_landing_pg);
        history_lp_btn.setBackgroundColor(0xFFFF0000);
        history_lp_btn.setTextColor(Color.parseColor("#FFFFFF"));

    }
}
