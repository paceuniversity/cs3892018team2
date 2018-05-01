package ahmed.niaz.chinatown_tour;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HistoryTimeline extends AppCompatActivity {

    Context context;
    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;

    TextView[] mDots;

    TimelineSliderAdapter sliderAdapter;

    Button mPastBtn;  //back
    Button mFutureBtn;  //next

    int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.timeline);

        mSlideViewPager = (ViewPager) findViewById( R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById( R.id.dotLayout);

        mPastBtn = (Button) findViewById( R.id.pastBtn);
        mFutureBtn = (Button) findViewById( R.id.futureBtn);

        sliderAdapter = new TimelineSliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        //https://www.youtube.com/watch?v=byLKoPgB7yA
        mFutureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSlideViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        mPastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position){

        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for(int i=0; i<mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor( R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor( R.color.colorPrimaryDark));

        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);

            mCurrentPage = i;

            if(i == 0){
                mFutureBtn.setEnabled(true);
                mPastBtn.setEnabled(false);
                mPastBtn.setVisibility(View.INVISIBLE);

                mFutureBtn.setText(context.getResources().getString( R.string.timeline_button2));
                mPastBtn.setTag("");
            }

            else if (i == mDots.length -1){
                mFutureBtn.setEnabled(true);
                mPastBtn.setEnabled(true);
                mPastBtn.setVisibility(View.VISIBLE);

                mFutureBtn.setText(context.getResources().getString( R.string.timeline_button3));
                mPastBtn.setTag(context.getResources().getString( R.string.timeline_button1));
            }

            else {
                mFutureBtn.setEnabled(true);
                mPastBtn.setEnabled(true);
                mPastBtn.setVisibility(View.VISIBLE);

                mFutureBtn.setText(context.getResources().getString( R.string.timeline_button3));
                mPastBtn.setTag(context.getResources().getString( R.string.timeline_button1));
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}