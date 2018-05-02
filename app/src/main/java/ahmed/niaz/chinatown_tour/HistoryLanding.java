package ahmed.niaz.chinatown_tour;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by anishamiah on 4/28/18.
 */

public class HistoryLanding extends AppCompatActivity {

    private ViewPager msliderViewpager;
    private LinearLayout mdot_layout;


    private TextView[] mDots;
    private SliderAdapter sliderAdapter;


    protected void onCreate(Bundle savedInstanceState){

        super.onCreate( savedInstanceState);
        setContentView( R.layout.history_landing);


        msliderViewpager = (ViewPager) findViewById( R.id.sliderViewpager );
        mdot_layout= (LinearLayout) findViewById( R.id.dot_layout );

sliderAdapter = new SliderAdapter(this);
msliderViewpager.setAdapter( sliderAdapter );



addDotsIndicator();

    }
public void addDotsIndicator(){


        mDots = new TextView[3];

        for (int i=0; i< mDots.length; i++){

            mDots[i] = new TextView(this );
            mDots[i].setText( Html.fromHtml( "&#8226;") );
            mDots[i].setTextColor(35);
            mDots[i].setTextColor(getResources().getColor( R.color.colorTransparentWhite) );

            mdot_layout.addView(mDots[i]);


        }



 }



}
