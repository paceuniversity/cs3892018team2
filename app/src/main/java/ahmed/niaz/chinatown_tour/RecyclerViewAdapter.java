package ahmed.niaz.chinatown_tour;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private ArrayList<Integer> restaurantImages = new ArrayList<>();
    private ArrayList<Integer> restaurantDescriptions = new ArrayList<>();
    private ArrayList<String> restaurantMenu = new ArrayList<>();
    private ArrayList<String> restaurantWebsite = new ArrayList<>();
    private ArrayList<String> restaurantMap = new ArrayList<>();
    private Context rContext;



    public RecyclerViewAdapter(Context context, ArrayList<Integer> names, ArrayList<Integer> images, ArrayList<Integer> descriptions, ArrayList<String> menus, ArrayList<String> website, ArrayList<String> map){
        restaurantNames = names;
        restaurantImages = images;
        restaurantDescriptions = descriptions;
        restaurantMenu = menus;
        restaurantWebsite = website;
        restaurantMap = map;
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

        Glide.with(rContext)
                .asBitmap()
                .load(restaurantImages.get(position))
                .into(holder.image);
        holder.name.setText(restaurantNames.get(position));


        //== SETS TOAST NAME FOR IMAGE AND INTENT TO GO TO THEIR RESPECTIVE DETAILED PAGE ==
        holder.image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
               Toast.makeText(rContext, restaurantNames.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(rContext, SpecificFoodActivity.class);
                intent.putExtra("food_Image", restaurantImages.get(position));
                intent.putExtra("food_Name", restaurantNames.get(position));
                intent.putExtra("food_Description", restaurantDescriptions.get(position));
                intent.putExtra("food_Menu", restaurantMenu.get(position));
                intent.putExtra("food_Website", restaurantWebsite.get(position));
                intent.putExtra("food_Map", restaurantMap.get(position));
                rContext.startActivity(intent);


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
