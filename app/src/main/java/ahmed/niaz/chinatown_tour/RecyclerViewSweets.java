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
 * Created by jason on 4/25/2018.
 */

public class RecyclerViewSweets extends RecyclerView.Adapter<RecyclerViewSweets.ViewHolder>{

    //vars
    private ArrayList<Integer> sweetsName = new ArrayList<>();
    private ArrayList<Integer> sweetsImage = new ArrayList<>();
    private Context sContext;

    public RecyclerViewSweets(ArrayList<Integer> sName, ArrayList<Integer> sImage, Context context){
        sweetsImage = sImage;
        sweetsName = sName;
        sContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sweets_layout_listitems,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(sContext)
                .asBitmap()
                .load(sweetsImage.get(position))
                .into(holder.image);
        holder.name.setText(sweetsName.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onCLick: clicked on an image: " + sweetsName.get(position));
                Toast.makeText(sContext, sweetsName.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return sweetsName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image3);
            name = itemView.findViewById(R.id.name3);
        }
    }




}
