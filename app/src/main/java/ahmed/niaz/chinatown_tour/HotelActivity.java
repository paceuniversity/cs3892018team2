package ahmed.niaz.chinatown_tour;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import java.util.ArrayList;


/**
 * Created by Niaz on 4/9/18.
 */

public class HotelActivity extends AppCompatActivity {


    // HOTEL 18 x 3
    // ACTIVITY 15 x 1
    // FOOD 15 x 1


    // === CREATE VARIABLES ===

    private ImageSwitcher img_switcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotels);


        // === INSTANTIATE VARIABLES ===

        img_switcher = (ImageSwitcher) findViewById(R.id.img_switcher);



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

        img_switcher.setOnTouchListener(new OnSwipeTouchListener(HotelActivity.this){
            public void onSwipeTop(){

            }

            public void onSwipeBot(){

            }

            public void onSwipeLeft(){

            }

            public void onSwipeRight(){

            }


        });
    }

}

