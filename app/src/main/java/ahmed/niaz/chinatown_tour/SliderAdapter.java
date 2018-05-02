package ahmed.niaz.chinatown_tour;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;


    }


    //Arrays
    // list of images
    public int[] slide_images = {

            R.drawable.timeline_icon,
            R.drawable.historical_sights_icon,
            R.drawable.fun_facts_icon


    };
    // list of titles
    public String[] slide_headings = {

            "TIMELINE OF CHINATOWN",
            "HISTORICAL SIGHTS",
            "FUN FACTS"


    };
    // list of descriptions
    public String[] slide_descs = {

            "Emerge yourself in Chinatown's rich historical timeline!",
            "List of Historical sights that you can explore!",
            "Learn some fun facts about Chinatown!"


    };


    // list of background colors
    public int[] lst_backgroundcolor = {


            Color.rgb( 239, 85, 85 ),
            Color.rgb( 255, 255, 255 ),
            Color.rgb( 110, 49, 89 )

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
    public Object instantiateItem(ViewGroup container, final int position) {


        layoutInflater = (LayoutInflater) context.getSystemService( context.LAYOUT_INFLATER_SERVICE );
        View view = layoutInflater.inflate( R.layout.slide_layout, container, false );

        RelativeLayout layoutslide = (RelativeLayout) view.findViewById( R.id.sliderelativelayout );


        // ImageView slideButtonsView = (ImageView) view.findViewById( R.id.slide_image );
        ImageView slideImageView = (ImageView) view.findViewById( R.id.slide_image );
        final TextView slideHeading = (TextView) view.findViewById( R.id.slide_heading );
        TextView slideDescription = (TextView) view.findViewById( R.id.slide_desc );

        // slideButtonsView.setOnClickListener( (View.OnClickListener) slide_links[position] );
        slideImageView.setImageResource( slide_images[position] );
        slideHeading.setText( slide_headings[position] );
        slideDescription.setText( slide_descs[position] );
        layoutslide.setBackgroundColor( lst_backgroundcolor[position] );

        layoutslide.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if (slide_headings[position].equalsIgnoreCase( slide_headings[0])) {
                        intent = new Intent( context,HistoryTimeline.class );
                }else if (slide_headings[position].equalsIgnoreCase( slide_headings[1])) {
                    intent = new Intent( context,HistoryActivity.class );
                }else if (slide_headings[position].equalsIgnoreCase( slide_headings[2])) {
                    intent = new Intent( context,HistoryFacts.class );
                }


                context.startActivity( intent );
            }
        } );


        container.addView( view );

        return view;


    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView( (ConstraintLayout) object );
    }
}







