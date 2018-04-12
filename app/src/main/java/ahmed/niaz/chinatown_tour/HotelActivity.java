package ahmed.niaz.chinatown_tour;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.EventListener;


/**
 * Created by Niaz on 4/9/18.
 */

public class HotelActivity extends AppCompatActivity {

    // === CREATE CLASS VARIABLES ===

    ImageSwitcher img_switcher;
    Button btn_1;
    Button btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotels);

        // === INSTANTIATE VARIABLES ===

        img_switcher = (ImageSwitcher) findViewById(R.id.img_switcher);
        btn_1 = (Button) findViewById(R.id.button3);
        btn_2 = (Button) findViewById(R.id.button4);

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

        // === BUTTON EVENT LISTENERS ==

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_switcher.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_switcher.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_foreground));
            }
        });
    }
}

