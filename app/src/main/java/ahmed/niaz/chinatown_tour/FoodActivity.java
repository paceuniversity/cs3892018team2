package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    //Instance Variables
    private ArrayList<Integer> restaurantNames = new ArrayList<>();
    private ArrayList<Integer> restaurantImages = new ArrayList<>();
    private ImageView app_logo;
    public ImageButton settings_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);

        app_logo = (ImageView) findViewById(R.id.appIcon);

        // === Main Menu Link ===


        app_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        // === Settings Icon Link ===

        settings_btn = (ImageButton) findViewById(R.id.setting_image_button);
        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });

        // === Calling getRestaurants ===
        getRestaurants();

    }

    //Adding images and names into both ArrayLists
    private void getRestaurants(){
        restaurantImages.add(R.drawable.restaurant_1_front_image);
        restaurantNames.add(R.string.restaurant1_name);

        restaurantImages.add(R.drawable.restaurant_2_front_image);
        restaurantNames.add(R.string.restaurant2_name);

        restaurantImages.add(R.drawable.restaurant_3_front_image);
        restaurantNames.add(R.string.restaurant3_name);

        restaurantImages.add(R.drawable.restaurant_4_front_image);
        restaurantNames.add(R.string.restaurant4_name);

        restaurantImages.add(R.drawable.restaurant_5_front_image);
        restaurantNames.add(R.string.restaurant5_name);

        initRecycleView();
    }

    private void initRecycleView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, restaurantNames, restaurantImages);
        recyclerView.setAdapter(adapter);
    }


}
