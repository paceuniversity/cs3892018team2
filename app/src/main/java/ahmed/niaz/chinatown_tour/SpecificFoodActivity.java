package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.net.URL;

public class SpecificFoodActivity extends AppCompatActivity {

    private ImageView app_logo;
    public ImageButton settings_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        getIncomingIntent();

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

    //== GETS INTENT FROM ADAPTER ==
    private void getIncomingIntent(){
        if(getIntent().hasExtra("food_Image") && getIntent().hasExtra("food_Name") && getIntent().hasExtra("food_Description") && getIntent().hasExtra("food_Menu") && getIntent().hasExtra("food_Website") && getIntent().hasExtra("food_Map"))
        {
            Integer foodImage = getIntent().getIntExtra("food_Image",0);
            Integer foodName = getIntent().getIntExtra("food_Name",0);
            Integer foodDescription = getIntent().getIntExtra("food_Description", 0);
            String foodMenu = getIntent().getStringExtra("food_Menu");
            String foodWebsite = getIntent().getStringExtra("food_Website");
            String foodMap = getIntent().getStringExtra("food_Map");

            setImage(foodImage, foodName, foodDescription, foodMenu, foodWebsite, foodMap);
        }
    }

    //== ADDS THE NAME, PHOTO, DESCRIPTION, & MENU FOR EACH FOOD LOCATION ==
    private void setImage(Integer foodImage, Integer foodName, Integer foodDescription, final String foodMenu, final String foodWebsite, final String foodMap){
        //== NAME SET FOR FOOD LOCATIONS ==
        TextView name = findViewById(R.id.foodName);
        name.setText(foodName);

        //== DESCRIPTION SET FOR FOOD LOCATIONS ==
        TextView description = findViewById(R.id.food_description);
        description.setText(foodDescription);

        //== MENU BUTTON SET FOR FOOD LOCATIONS ==
        ImageButton menu = findViewById(R.id.food_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMenu = new Intent(Intent.ACTION_VIEW,Uri.parse(foodMenu));
                startActivity(intentMenu);
            }
        });

        //== GOOGLE MAPS SET FOR FOOD LOCATIONS ==
        ImageButton map = findViewById(R.id.food_location);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMap = new Intent(Intent.ACTION_VIEW,Uri.parse(foodMap));
                startActivity(intentMap);
            }
        });

        //== WEBSITE BUTTON SET FOR FOOD LOCATIONS ==
        ImageButton website = findViewById(R.id.food_website);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW,Uri.parse(foodWebsite));
                startActivity(intentWebsite);
            }
        });


        //== IMAGE SET FOR FOOD LOCATIONS ==
        ImageView image = findViewById(R.id.foodPic);
        Glide.with(this)
                .asBitmap()
                .load(foodImage)
                .into(image);
    }
}


