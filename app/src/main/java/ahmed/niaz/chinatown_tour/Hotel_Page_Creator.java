package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;



/**
 * Created by Niaz on 4/9/18.
 */

public class Hotel_Page_Creator extends AppCompatActivity {


    // === CREATE VARIABLES ===

    private ImageSwitcher img_switcher;
    private ImageView app_logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specific_hotel_content);


        // === INSTANTIATE VARIABLES ===

        img_switcher = (ImageSwitcher) findViewById(R.id.img_switcher);
        app_logo = (ImageView) findViewById(R.id.appIcon);


        // === LINK APP ICON TO MAIN MENU ====

        app_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hotel_Page_Creator.this,MainActivity.class);
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

        // === ADD ANIMATIONS ===

        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        img_switcher.setInAnimation(in);
        img_switcher.setOutAnimation(out);
        img_switcher.setImageDrawable(getResources().getDrawable(R.drawable.hotel1_image1));

        // === ON SWIPE LISTENER ===

        img_switcher.setOnTouchListener(new OnSwipeTouchListener(Hotel_Page_Creator.this){
         public void onSwipeLeft(){

            }

            public void onSwipeRight(){

            }


        });
    }

}

