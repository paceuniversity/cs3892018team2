package ahmed.niaz.chinatown_tour;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

public class HotelActivity extends AppCompatActivity {


    private ImageView app_logo;
    ListView listView;
    public ImageButton settings_btn;

    String[] nameArray = {"Octopus","Pig","Sheep","Rabbit","Snake","Spider"};

    String[] infoArray = {
            "Set at the foot of the Manhattan Bridge in Chinatown, this hip hotel with a midcentury-modern vibe is",
            "Delicious in rolls",
            "Great for jumpers",
            "Nice in a stew",
            "Great for shoes",
            "Scary."
    };

    Integer[] imageArray = {
            R.drawable.hotel1_image1,
            R.drawable.hotel2_image1,
            R.drawable.hotel3_image1,
            R.drawable.hotel4_image1,
            R.drawable.hotel5_image1,
            R.drawable.hotel6_image1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_landing);

        app_logo = (ImageView) findViewById(R.id.appIcon);

        // Main Menu Link

        app_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotelActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        // List Creation

        String[] names = getResources().getStringArray(R.array.hotel_names);
        String[] descriptions = getResources().getStringArray(R.array.hotel_descriptions);

        CustomListAdapter whatever = new CustomListAdapter(this, names, infoArray, imageArray);
        listView = (ListView) findViewById(R.id.listViewID);
        listView.setAdapter(whatever);


        // Settings Icon Link

        settings_btn = (ImageButton) findViewById(R.id.setting_image_button);
        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotelActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });

    }
}


