package ahmed.niaz.chinatown_tour;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class HotelActivity extends AppCompatActivity {


    private ImageView app_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_page);

        app_logo = (ImageView) findViewById(R.id.appIcon);

        // === LINK APP ICON TO MAIN MENU ====
        app_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotelActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
