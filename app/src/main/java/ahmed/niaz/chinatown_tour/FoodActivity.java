package ahmed.niaz.chinatown_tour;

import android.content.Intent;
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
    private ArrayList<String> restaurantNames = new ArrayList<>();
    private ArrayList<String> restaurantImages = new ArrayList<>();
    private ImageView app_logo;
    public ImageButton settings_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);

        app_logo = (ImageView) findViewById(R.id.appIcon);

        // Main Menu Link

        app_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        // Settings Icon Link

        settings_btn = (ImageButton) findViewById(R.id.setting_image_button);
        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });

        //calling getRestaurants
        getRestaurants();

    }

    //Adding images and names into both ArrayLists
    private void getRestaurants(){
        restaurantImages.add("https://lh3.ggpht.com/p/AF1QipMEoMt8cVRSKjfif0BfqIIslp3i8Co0FwHYWqGH=w512-h384-n");
        restaurantNames.add("Shanghai Asian Manor");

        restaurantImages.add("http://nomwah.com/wordpress/wp-content/uploads/2016/09/nom-wah-nyc-exterior.jpg");
        restaurantNames.add("Nom Wah Tea Parlor");

        restaurantImages.add("https://media-cdn.tripadvisor.com/media/photo-s/08/cf/58/14/great-new-york-noodletown.jpg");
        restaurantNames.add("Great NY Noodletown");

        restaurantImages.add("https://lh3.ggpht.com/p/AF1QipPn8_jvRT2Get0V9Br2ofaw3IZSrFBkS4fkJHkv=w578-h384-n");
        restaurantNames.add("Ping");

        restaurantImages.add("http://www.tinyurbankitchen.com/wp-content/uploads/2012/08/7700889588_dce80e09ac_z.jpg");
        restaurantNames.add("Tasty Had-Pulled Noodles");

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
