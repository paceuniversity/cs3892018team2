package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SpecificFoodActivity extends AppCompatActivity {

    private ImageView app_logo;
    public ImageButton settings_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specific_food_content);



        // Main Menu Link
        app_logo = (ImageView) findViewById(R.id.appIcon);
        app_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpecificFoodActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });





        // Settings Icon Link

        settings_btn = (ImageButton) findViewById(R.id.setting_image_button);
        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpecificFoodActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });

    }
}


