package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Niaz on 4/9/18.
 */


public class ItineraryActivity extends AppCompatActivity {

    private ImageView app_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itinerary);

        app_logo = (ImageView) findViewById(R.id.appIcon);

        // === LINK APP ICON TO MAIN MENU ===
        app_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItineraryActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
