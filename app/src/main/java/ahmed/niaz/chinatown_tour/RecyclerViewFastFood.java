package ahmed.niaz.chinatown_tour;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;

/**
 * Created by jason on 4/24/2018.
 */
//This class creates the RecyclerViewer for Fast Food

public class RecyclerViewFastFood extends RecyclerView.Adapter<RecyclerViewFastFood.ViewHolder>{

    private ArrayList<Integer> fastFoodNames = new ArrayList<>();
    private ArrayList<Integer> fastFoodImages = new ArrayList<>();
    private Context fContext;

    public RecyclerViewFastFood(ArrayList<Integer> fNames, ArrayList<Integer> fImages,Context context){
        fastFoodNames = fNames;
        fastFoodImages = fImages;
        fContext = context;
    }

    //Binds the fast food layout file
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fast_food_layout_listitems, parent, false);

        return new ViewHolder(view);

    }

    //Binds the data to each individual item list
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(fContext)
                .asBitmap()
                .load(fastFoodImages.get(position))
                .into(holder.image);

        holder.name.setText(fastFoodNames.get(position));

        holder.image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Log.d(TAG, "onClick: clicked on an image: " + fastFoodNames.get(position));
                Toast.makeText(fContext, fastFoodNames.get(position), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return fastFoodNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image2);
            name = itemView.findViewById(R.id.name2);
        }
    }



}
