package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    //Instance Variables
    //Restaurant Variables
    private ArrayList<Integer> restaurantNames = new ArrayList<>();
    private ArrayList<Integer> restaurantImages = new ArrayList<>();
    private ArrayList<Integer> restaurantDescriptions = new ArrayList<>();
    private ArrayList<String> restaurantMenu = new ArrayList<>();
    private ArrayList<String> restaurantWebsite = new ArrayList<>();
    private ArrayList<String> restaurantMap = new ArrayList<>();

    //Fast Food Variables
    private ArrayList<Integer> fastFoodNames = new ArrayList<>();
    private ArrayList<Integer> fastFoodImages = new ArrayList<>();
    private ArrayList<Integer> fastFoodDescriptions = new ArrayList<>();
    private ArrayList<String> fastFoodMenu = new ArrayList<>();
    private ArrayList<String> fastFoodWebsite = new ArrayList<>();
    private ArrayList<String> fastFoodMap = new ArrayList<>();

    //Sweets Variables
    private ArrayList<Integer> sweetsName = new ArrayList<>();
    private ArrayList<Integer> sweetsImage = new ArrayList<>();
    private ArrayList<Integer> sweetsDescriptions = new ArrayList<>();
    private ArrayList<String> sweetsMenu = new ArrayList<>();
    private ArrayList<String> sweetsWebsite = new ArrayList<>();
    private ArrayList<String> sweetsMap = new ArrayList<>();

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

        // === CALLING getRestaurants, getFastFood, AND getSweets ==
        getRestaurants();
        getFastFood();
        getSweets();

    }

    // == Adding images and names into Restaurant ArrayList ==
    private void getRestaurants(){
        restaurantImages.add(R.drawable.restaurant_1_front_image);
        restaurantNames.add(R.string.restaurant1_name);
        restaurantDescriptions.add(R.string.restaurant1_description);
        restaurantMenu.add("http://shanghaiasianmanor.com/menu");
        restaurantWebsite.add("http://shanghaiasianmanor.com/");
        restaurantMap.add("http://bit.ly/SAMmap");

        restaurantImages.add(R.drawable.restaurant_2_front_image);
        restaurantNames.add(R.string.restaurant2_name);
        restaurantDescriptions.add(R.string.restaurant2_description);
        restaurantMenu.add("http://nomwah.com/chinatown");
        restaurantWebsite.add("http://nomwah.com/");
        restaurantMap.add("http://bit.ly/NWTPmap");

        restaurantImages.add(R.drawable.restaurant_3_front_image);
        restaurantNames.add(R.string.restaurant3_name);
        restaurantDescriptions.add(R.string.restaurant3_description);
        restaurantMenu.add("http://places.singleplatform.com/great-ny-noodletown/menu?ref=google");
        restaurantWebsite.add("https://www.yelp.com/biz/great-ny-noodle-town-new-york");
        restaurantMap.add("http://bit.ly/GNNTmap");

        restaurantImages.add(R.drawable.restaurant_5_front_image);
        restaurantNames.add(R.string.restaurant5_name);
        restaurantDescriptions.add(R.string.restaurant5_description);
        restaurantMenu.add("http://places.singleplatform.com/tasty-hand-pulled-noodles/menu?ref=google");
        restaurantWebsite.add("https://www.yelp.com/biz/tasty-hand-pulled-noodles-new-york");
        restaurantMap.add("http://bit.ly/THPNmap");

        restaurantImages.add(R.drawable.restaurant_4_front_image);
        restaurantNames.add(R.string.restaurant4_name);
        restaurantDescriptions.add(R.string.restaurant4_description);
        restaurantMenu.add("http://places.singleplatform.com/pings/menu?ref=google");
        restaurantWebsite.add("https://www.yelp.com/biz/pings-seafood-new-york");
        restaurantMap.add("http://bit.ly/Pingmap");


        initRecycleView();
    }

    // == Adding images and names into Fast Food ArrayList ==
    private void getFastFood(){
        fastFoodImages.add(R.drawable.fast_food_5_front_image);
        fastFoodNames.add(R.string.fast_food5_name);
        fastFoodDescriptions.add(R.string.fast_food5_description);
        fastFoodMenu.add("http://www.maywahfastfood.com/menu/");
        fastFoodWebsite.add("http://www.maywahfastfood.com/ ");
        fastFoodMap.add("http://bit.ly/MWFFmap");

        fastFoodImages.add(R.drawable.fast_food_2_front_image);
        fastFoodNames.add(R.string.fast_food2_name);
        fastFoodDescriptions.add(R.string.fast_food2_description);
        fastFoodMenu.add("https://www.menuwithprice.com/menu/wah-fung-1-fast-food/");
        fastFoodWebsite.add("https://www.yelp.com/biz/wah-fung-no-1-new-york");
        fastFoodMap.add("http://bit.ly/WFFFmap");

        fastFoodImages.add(R.drawable.fast_food_3_front_image);
        fastFoodNames.add(R.string.fast_food3_name);
        fastFoodDescriptions.add(R.string.fast_food3_description);
        fastFoodMenu.add("http://www.menupages.com/restaurants/hua-ji-pork-chop-fast-food/menu");
        fastFoodWebsite.add("https://www.yelp.com/biz/hua-ji-pork-chop-fast-food-new-york");
        fastFoodMap.add("http://bit.ly/HJPCmap");

        fastFoodImages.add(R.drawable.fast_food_4_front_image);
        fastFoodNames.add(R.string.fast_food4_name);
        fastFoodDescriptions.add(R.string.fast_food4_description);
        fastFoodMenu.add("https://popeyes.com/menu/");
        fastFoodWebsite.add("https://popeyes.com/");
        fastFoodMap.add("http://bit.ly/PFFmap");

        fastFoodImages.add(R.drawable.fast_food_1_front_image);
        fastFoodNames.add(R.string.fast_food1_name);
        fastFoodDescriptions.add(R.string.fast_food1_description);
        fastFoodMenu.add("https://www.mcdonalds.com/us/en-us/full-menu.html?cid=RF:YXT_LS:SI::MGBM");
        fastFoodWebsite.add("https://www.mcdonalds.com/us/en-us/mobile-order-and-pay.html");
        fastFoodMap.add("http://bit.ly/MickyDmap");

        initFFRecycleView();
    }

    // == Adding images and names into the Sweets ArrayList ==
    private void getSweets(){
        sweetsImage.add(R.drawable.sweets_1_front_image);
        sweetsName.add(R.string.sweets1_name);
        sweetsDescriptions.add(R.string.sweets1_description);
        sweetsMenu.add("http://www.menupages.com/restaurants/the-sweet-life/menu");
        sweetsWebsite.add("http://thesweetlifenyc.com/");
        sweetsMap.add("http://bit.ly/SweetLifemap");

        sweetsImage.add(R.drawable.sweets_2_front_image);
        sweetsName.add(R.string.sweets2_name);
        sweetsDescriptions.add(R.string.sweets2_description);
        sweetsMenu.add("https://www.facebook.com/pg/TaiyakiNYC/menu/");
        sweetsWebsite.add("https://taiyakinyc.com/");
        sweetsMap.add("http://bit.ly/TYKmap");

        sweetsImage.add(R.drawable.sweets_3_front_image);
        sweetsName.add(R.string.sweets3_name);
        sweetsDescriptions.add(R.string.sweets3_description);
        sweetsMenu.add("https://www.sweetmoment.nyc/menu");
        sweetsWebsite.add("https://www.sweetmoment.nyc/");
        sweetsMap.add("http://bit.ly/SweetMmap");

        sweetsImage.add(R.drawable.sweets_4_front_image);
        sweetsName.add(R.string.sweets4_name);
        sweetsDescriptions.add(R.string.sweets4_description);
        sweetsMenu.add("http://www.chinatownicecreamfactory.com/ice-cream/");
        sweetsWebsite.add("http://www.chinatownicecreamfactory.com/");
        sweetsMap.add("http://bit.ly/OGICmap");

        sweetsImage.add(R.drawable.sweets_5_front_image);
        sweetsName.add(R.string.sweets5_name);
        sweetsDescriptions.add(R.string.sweets5_description);
        sweetsMenu.add("http://fayda.com/shop/");
        sweetsWebsite.add("http://fayda.com/");
        sweetsMap.add("http://bit.ly/FDBmap");

        initSRecycleView();
    }

    // == These methods create the recycler view to be made so the string values get attached to them ==
    // == Restaurant Recycler Viewer ==
    private void initRecycleView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, restaurantNames, restaurantImages, restaurantDescriptions, restaurantMenu, restaurantWebsite, restaurantMap);
        recyclerView.setAdapter(adapter);
    }

    // == Fast Food Recycler Viewer ==
    private void initFFRecycleView(){
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewFF = findViewById(R.id.recyclerview2);
        recyclerViewFF.setLayoutManager(layoutManager2);
        RecyclerViewAdapter adapterFF = new RecyclerViewAdapter(this, fastFoodNames, fastFoodImages, fastFoodDescriptions, fastFoodMenu, fastFoodWebsite, fastFoodMap);
        recyclerViewFF.setAdapter(adapterFF);

    }

    // == Sweets Recycler Viewer ==
    private void initSRecycleView(){
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewS = findViewById(R.id.recyclerview3);
        recyclerViewS.setLayoutManager(layoutManager3);
        RecyclerViewAdapter adapterS = new RecyclerViewAdapter(this, sweetsName, sweetsImage, sweetsDescriptions, sweetsMenu, sweetsWebsite, sweetsMap);
        recyclerViewS.setAdapter(adapterS);
    }


}
