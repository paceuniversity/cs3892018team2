package ahmed.niaz.chinatown_tour;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;

/**
 * Created by jason on 4/18/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    //Data Variables
    private ArrayList<Integer> restaurantNames = new ArrayList<>();
    private ArrayList<Integer> matchRestaurant = new ArrayList<Integer>();
    private ArrayList<Integer> matchFastFood = new ArrayList<Integer>();
    private ArrayList<Integer> matchSweets = new ArrayList<Integer>();

    private ArrayList<Integer> restaurantImages = new ArrayList<>();
    private Context rContext;

    //==== SPECIFIC FOOD VARIABLES ===

    public int spec_img;
    public int spec_foodname;
    public int spec_foodmenu_link;
    public int spec_foodmap_link;
    public int spec_foodweb_link;


    public RecyclerViewAdapter(Context context, ArrayList<Integer> names, ArrayList<Integer> images){
        restaurantNames = names;
        restaurantImages = images;
        rContext = context;
    }

    @Override
    //binds the restaurant layout file
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_layout_listitems, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //binds data on each individual list item
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onCreateViewHolder: called"); //for debugging

        // === TO MATCH POSITION AND FOOD OPTION

        // === RESTAURANTS
        matchRestaurant.add(2131624369);
        matchRestaurant.add(2131624375);
        matchRestaurant.add(2131624381);
        matchRestaurant.add(2131624387);
        matchRestaurant.add( 2131624393);
        // === FAST FOOD
       matchFastFood.add(2131624191);
       matchFastFood.add(2131624173 );
       matchFastFood.add(2131624179);
       matchFastFood.add(2131624185);
       matchFastFood.add(2131624167);
        // === SWEETS
        matchSweets.add(2131624403);
        matchSweets.add(2131624409);
        matchSweets.add(2131624415);
        matchSweets.add(2131624421);
        matchSweets.add(2131624427);


        Glide.with(rContext)
                .asBitmap()
                .load(restaurantImages.get(position))
                .into(holder.image);
        holder.name.setText(restaurantNames.get(position));


        //This just prints out a toast when clicking on an image good testing to help setup info page
        holder.image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
               // Log.d(TAG, "onClick: clicked on an image" + restaurantNames.get(position));
               Intent intent = new Intent(view.getContext(), SpecificFoodActivity.class);
                rContext.startActivity(intent);

                Log.i("POSITION", (" " + position + " "));
                Log.i("ARRAY SIZE", (" " + restaurantNames.size() + " "));
                Log.i("INDEX", ( " " + restaurantNames.indexOf(restaurantNames.get(position)) + " "));

               int matching_var = (restaurantNames.get(position)%10000)/100;
                Log.i("POSITION", (" " +  matching_var + " "));

                Log.i("POSITION", (" " + position + " "));
                Log.i("ARRAY SIZE", (" " + restaurantNames.size() + " "));
                Log.i("INDEX", ( " " + restaurantNames.indexOf(restaurantNames.get(position)) + " "));


            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView name;

        public ViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.image); //Refers to id for image in the restaurant layout xml
            name = itemView.findViewById(R.id.name);  //"  " for restaurant name " "
        }

    }

}
