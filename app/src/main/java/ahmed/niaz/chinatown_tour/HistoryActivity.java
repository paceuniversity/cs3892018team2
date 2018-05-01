package ahmed.niaz.chinatown_tour;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class HistoryActivity extends AppCompatActivity {


    // === LANDING PAGE WIDGETS ===

    private ImageView app_logo;
    private ListView listView;
    private ImageButton settings_btn;
    private ImageSwitcher img_switcher;

    // === SPECIFIC PAGE VARIABLES ===

    private int name;
    private int img_one;
    private int img_two;
    private int img_three;
    int address;
    private int information;
    private String url;
    private int img_num;


    // === SPECIFIC PAGE WIDGETS ===

    private ImageView navdot1;
    private ImageView navdot2;
    private ImageView navdot3;
    private TextView spec_name;
    private TextView spec_description;
    private Button map_btn;
    private Button web_btn;
    private Button phone_btn;


    // === SWITCH DEPENDING ON ITEM CLICKED ===

    public void createHotelData(int x){
        switch (x) {
            case 1:
                name = R.string.Historical_sight1_name;
                img_one = R.drawable.historical_sights1_image1;
                img_two = R.drawable.historical_sights1_image2;
                img_three = R.drawable.historical_sights1_image3;
                address = R.string.Historical_sight1_address;
                information = R.string.Historical_sight1_historical_information;
                url = getString( R.string.Historical_sight1_website);

                break;

            case 2:
                name = R.string.Historical_sight2_name;
                img_one = R.drawable.historical_sights2_image1;
                img_two = R.drawable.historical_sights2_image2;
                img_three = R.drawable.historical_sights2_image3;
                address = R.string.Historical_sight2_address;
                information = R.string.Historical_sight2_historical_information;
                url = getString( R.string.Historical_sight2_website);

                break;

            case 3:
                name = R.string.Historical_sight3_name;
                img_one = R.drawable.historical_sights3_image1;
                img_two = R.drawable.historical_sights3_image2;
                img_three = R.drawable.historical_sights1_image3;
                address = R.string.Historical_sight3_address;
                information = R.string.Historical_sight3_historical_information;
                url = getString( R.string.Historical_sight3_website);

                break;

            case 4:
                name = R.string.Historical_sight4_name;
                img_one = R.drawable.historical_sights4_image1;
                img_two = R.drawable.historical_sights4_image2;
                img_three = R.drawable.historical_sights4_image3;
                address = R.string.Historical_sight4_address;
                information = R.string.Historical_sight4_historical_information;
                url = getString( R.string.Historical_sight4_website);

                break;

            case 5:
                name = R.string.Historical_sight5_name;
                img_one = R.drawable.historical_sights5_image1;
                img_two = R.drawable.historical_sights1_image2;
                img_three = R.drawable.historical_sights5_image3;
                address = R.string.Historical_sight5_address;
                information = R.string.Historical_sight5_historical_information;
                url = getString( R.string.Historical_sight5_website);

                break;

            case 6:
                name = R.string.Historical_sight6_name;
                img_one = R.drawable.historical_sights6_image1;
                img_two = R.drawable.historical_sights6_image2;
                img_three = R.drawable.historical_sights6_image3;
                address = R.string.Historical_sight6_address;
                information = R.string.Historical_sight6_historical_information;
                url = getString( R.string.Historical_sight6_website);

                break;

            case 7:
                name = R.string.Historical_sight7_name;
                img_one = R.drawable.historical_sights7_image1;
                img_two = R.drawable.historical_sights7_image2;
                img_three = R.drawable.historical_sights7_image3;
                address = R.string.Historical_sight7_address;
                information = R.string.Historical_sight7_historical_information;
                url = getString( R.string.Historical_sight7_website);

                break;

            case 8:
                name = R.string.Historical_sight8_name;
                img_one = R.drawable.historical_sights8_image1;
                img_two = R.drawable.historical_sights8_image2;
                img_three = R.drawable.historical_sights8_image3;
                address = R.string.Historical_sight8_address;
                information = R.string.Historical_sight8_historical_information;
                url = getString( R.string.Historical_sight8_website);

                break;

            case 9:
                name = R.string.Historical_sight9_name;
                img_one = R.drawable.historical_sights9_image1;
                img_two = R.drawable.historical_sights9_image2;
                img_three = R.drawable.historical_sights9_image3;
                address = R.string.Historical_sight9_address;
                information = R.string.Historical_sight9_historical_information;
                url = getString( R.string.Historical_sight9_website);

                break;



        }
    }

    // === ON CREATE ===

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.historical_sights_layout);


        // === Main Menu Link ===

        app_logo = (ImageView) findViewById( R.id.appIcon);
        app_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        // === LIST PARAMETER CREATION ===

        Integer[] imageArray = {
                R.drawable.historical_sights1_image1,
                R.drawable.historical_sights2_image1,
                R.drawable.historical_sights3_image1,
                R.drawable.historical_sights4_image1,
                R.drawable.historical_sights5_image1,
                R.drawable.historical_sights6_image1,
                R.drawable.historical_sights7_image1,
                R.drawable.historical_sights8_image1,

        };

        String[] names = getResources().getStringArray( R.array.historical_sights_names);
        final String[] information = getResources().getStringArray( R.array.historical_sight_description_preview);


        // === LIST CREATION ===

        CustomListAdapter whatever = new CustomListAdapter(this, names, information, imageArray);
        listView = (ListView) findViewById( R.id.listViewID);
        listView.setAdapter(whatever);


        // === ADD EVENT LISTENER TO EVERY VIEW ===

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                createHotelData(position+1);
                setContentView( R.layout.specific_history_content);

                // === MAIN MENU LINK ===

                app_logo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HistoryActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });


                // === ASSIGN INFO TO SPECIFIC PAGE WIDGETS ===

                app_logo = (ImageView) findViewById( R.id.appIcon);
                img_switcher = (ImageSwitcher) findViewById( R.id.img_switcher);

                // === NAME AND DESCRIPTION
                spec_name = (TextView) findViewById( R.id.spec_history_name);
                spec_description = (TextView) findViewById( R.id.spec_history_description);


                // === MAP / WEB / PHONE ICONS AND TOAST ===
                map_btn = (Button) findViewById( R.id.food_map_icon);
                web_btn = (Button) findViewById( R.id.food_web_icon);

                final Toast phone_toast = Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT);

                map_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });

                web_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });



                // === ADD A VIEW TO THE IMG SWITCHER ===

                img_switcher.setFactory(new ViewSwitcher.ViewFactory() {
                    @Override
                    public View makeView() {
                        ImageView imageView = new ImageView(getApplicationContext());
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                        return imageView;
                    }
                });

                // === ASSIGN PAGE VARIABLES TO WIDGETS ===

                spec_name.setText(name);
                spec_description.setText(" ");
                img_switcher.setImageDrawable(getResources().getDrawable(img_one));

                // === IMG WHEEL ITERATION VARIABLE ===
                img_num = 1;

                // === IMAGE SCROLL DOTS ===

                navdot1 = (ImageView) findViewById( R.id.navDot1);
                navdot2 = (ImageView) findViewById( R.id.navDot2);
                navdot3 = (ImageView) findViewById( R.id.navDot3);

                // === ON SWIPE LISTENER ===

                img_switcher.setOnTouchListener(new OnSwipeTouchListener(HistoryActivity.this){

                    public void onSwipeLeft(){
                        if (img_num == 1){
                            img_switcher.setImageDrawable(getResources().getDrawable(img_two));
                            img_num = 2;


                            navdot2.setImageDrawable(getResources().getDrawable( R.drawable.active_circle));
                            navdot1.setImageDrawable(getResources().getDrawable( R.drawable.non_active_circle));

                        }
                        else if (img_num == 2){
                            img_switcher.setImageDrawable(getResources().getDrawable(img_three));
                            img_num = 3;

                            navdot3.setImageDrawable(getResources().getDrawable( R.drawable.active_circle));
                            navdot2.setImageDrawable(getResources().getDrawable( R.drawable.non_active_circle));
                        }
                    }

                    // === ON SWIPE LISTENER ===

                    public void onSwipeRight(){
                        if (img_num == 3){
                            img_switcher.setImageDrawable(getResources().getDrawable(img_two));
                            img_num = 2;

                            navdot2.setImageDrawable(getResources().getDrawable( R.drawable.active_circle));
                            navdot3.setImageDrawable(getResources().getDrawable( R.drawable.non_active_circle));

                        }
                        else if (img_num == 2){
                            img_switcher.setImageDrawable(getResources().getDrawable(img_one));
                            img_num = 1;

                            navdot1.setImageDrawable(getResources().getDrawable( R.drawable.active_circle));
                            navdot2.setImageDrawable(getResources().getDrawable( R.drawable.non_active_circle));

                        }
                    }

                });
            }
        });

        // === SETTINGS ICON LINK ===

        settings_btn = (ImageButton) findViewById( R.id.setting_image_button);
        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}


