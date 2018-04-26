package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    //Instance Variables
    //Restaurant Variables
    private ArrayList<Integer> restaurantNames = new ArrayList<>();
    private ArrayList<Integer> restaurantImages = new ArrayList<>();

    //Fast Food Variables
    private ArrayList<Integer> fastFoodNames = new ArrayList<>();
    private ArrayList<Integer> fastFoodImages = new ArrayList<>();

    //Sweets Variables
    private ArrayList<Integer> sweetsName = new ArrayList<>();
    private ArrayList<Integer> sweetsImage = new ArrayList<>();

    //App Logo and Settings Variables
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

        // === Calling getRestaurants, getFastFood, and getSweets ===
        getRestaurants();
        getFastFood();
        getSweets();

    }

    // == Adding images and names into Restaurant ArrayList ==
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

    // == Adding images and names into Fast Food ArrayList ==
    private void getFastFood(){
        fastFoodImages.add(R.drawable.fast_food_5_front_image);
        fastFoodNames.add(R.string.fast_food5_name);

        fastFoodImages.add(R.drawable.fast_food_2_front_image);
        fastFoodNames.add(R.string.fast_food2_name);

        fastFoodImages.add(R.drawable.fast_food_3_front_image);
        fastFoodNames.add(R.string.fast_food3_name);

        fastFoodImages.add(R.drawable.fast_food_4_front_image);
        fastFoodNames.add(R.string.fast_food4_name);

        fastFoodImages.add(R.drawable.fast_food_1_front_image);
        fastFoodNames.add(R.string.fast_food1_name);

        initFFRecycleView();
    }

    // == Adding images and names into the Sweets ArrayList ==
    private void getSweets(){
        sweetsImage.add(R.drawable.sweets_1_front_image);
        sweetsName.add(R.string.sweets1_name);

        sweetsImage.add(R.drawable.sweets_2_front_image);
        sweetsName.add(R.string.sweets2_name);

        sweetsImage.add(R.drawable.sweets_3_front_image);
        sweetsName.add(R.string.sweets3_name);

        sweetsImage.add(R.drawable.sweets_4_front_image);
        sweetsName.add(R.string.sweets4_name);

        sweetsImage.add(R.drawable.sweets_5_front_image);
        sweetsName.add(R.string.sweets5_name);

        initSRecycleView();
    }

    // == These methods create the recycler view to be made so the string values get attached to them ==
    // == Restaurant Recycler Viewer ==
    private void initRecycleView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, restaurantNames, restaurantImages);
        recyclerView.setAdapter(adapter);
    }

    // == Fast Food Recycler Viewer ==
    private void initFFRecycleView(){
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewFF = findViewById(R.id.recyclerview2);
        recyclerViewFF.setLayoutManager(layoutManager2);
        RecyclerViewAdapter adapterFF = new RecyclerViewAdapter(this, fastFoodNames, fastFoodImages);
        recyclerViewFF.setAdapter(adapterFF);

    }

    // == Sweets Recycler Viewer ==
    private void initSRecycleView(){
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewS = findViewById(R.id.recyclerview3);
        recyclerViewS.setLayoutManager(layoutManager3);
        RecyclerViewAdapter adapterS = new RecyclerViewAdapter(this, sweetsName, sweetsImage);
        recyclerViewS.setAdapter(adapterS);
    }


}
