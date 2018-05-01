package ahmed.niaz.chinatown_tour;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TimelineSliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public TimelineSliderAdapter(Context context) {

        this.context = context;
    }

    //Arrays
    public int[] slide_images = new int[]  {
            R.drawable.timeline1870s,
            R.drawable.timeline1880s,
            R.drawable.timeline1890s,
            R.drawable.timeline1900s,
            R.drawable.timeline1910s,
            R.drawable.timeline1920s,
            R.drawable.timeline1930s,
            R.drawable.timeline1940s,
            R.drawable.timeline1950s,
            R.drawable.timeline1960s,
            R.drawable.timeline1970s,
            R.drawable.timeline1980s,
            R.drawable.timeline1990s
    };

    public int[] slide_headings = {
            R.string.timeline1,
            R.string.timeline2,
            R.string.timeline3,
            R.string.timeline4,
            R.string.timeline5,
            R.string.timeline6,
            R.string.timeline7,
            R.string.timeline8,
            R.string.timeline9,
            R.string.timeline10,
            R.string.timeline11,
            R.string.timeline12,
            R.string.timeline13,
    };

    int[] slide_descriptions = new int[] {
            //change to descriptions and delete strings to get Rl to work
            R.string.timeline1870sdes,
            R.string.timeline1880sdes,
            R.string.timeline1890sdes,
            R.string.timeline1900sdes,
            R.string.timeline1910sdes,
            R.string.timeline1920sdes,
            R.string.timeline1930sdes,
            R.string.timeline1940sdes,
            R.string.timeline1950sdes,
            R.string.timeline1960sdes,
            R.string.timeline1970sdes,
            R.string.timeline1980sdes,
            R.string.timeline1990sdes,
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate( R.layout.timeline, container, false);

        ImageView slideImageView = (ImageView) view.findViewById( R.id.slideImages);
        TextView slideHeading = view.findViewById( R.id.slideHeadings);
        TextView slideDescription = view.findViewById( R.id.slideDescriptions);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override //stops
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((ConstraintLayout)object);
    }
}