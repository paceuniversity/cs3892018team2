package ahmed.niaz.chinatown_tour;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FactsSliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public FactsSliderAdapter(Context context) {

        this.context = context;
    }

    //Arrays
    public int[] slide_images = new int[]  {
            R.drawable.funfactim1,
            R.drawable.funfactim2,
            R.drawable.funfactim3,
            R.drawable.funfactim3,
            R.drawable.funfactim4,
            R.drawable.funfactim5,
            R.drawable.funfactim6,
            R.drawable.funfactim7,
            R.drawable.funfactim8,
            R.drawable.funfactim9,
            R.drawable.funfactim9
    };

    int[] slide_descriptions = new int[] {
            //change to descriptions and delete strings to get Rl to work
            R.string.funfact1,
            R.string.funfact2,
            R.string.funfact3,
            R.string.funfact4,
            R.string.funfact5,
            R.string.funfact6,
            R.string.funfact7,
            R.string.funfact8,
            R.string.funfact9,
            R.string.funfact10,
    };

    public int getCount() {
        return slide_descriptions.length;
    }

    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate( R.layout.timeline, container, false);

        ImageView slideImageView = (ImageView) view.findViewById( R.id.slideImages);
        TextView slideDescription = view.findViewById( R.id.slideDescriptions);

        slideImageView.setImageResource(slide_images[position]);
        slideDescription.setText(slide_descriptions[position]);

        container.addView(view);

        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((ConstraintLayout)object);
    }
}
