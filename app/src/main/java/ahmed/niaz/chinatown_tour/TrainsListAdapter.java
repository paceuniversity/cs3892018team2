package ahmed.niaz.chinatown_tour;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WilliamZhong on 5/1/18.
 */

public class TrainsListAdapter extends ArrayAdapter<TrainsObject>{

    private Context mContext;

    int mResource;

    public TrainsListAdapter(Context context, int resource, ArrayList<TrainsObject> objects){
        super(context,resource,objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String station = getItem(position).getStation();
        String trains = getItem(position).getTrains();
        String description = getItem(position).getDecription();
        Drawable image = getItem(position).getImage();

        TrainsObject trainObject = new TrainsObject(station,trains,description,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvStation = (TextView)convertView.findViewById(R.id.train_station);
        TextView tvTrain = (TextView)convertView.findViewById(R.id.trains);
        TextView tvDescription = (TextView)convertView.findViewById(R.id.train_description);
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.train_image);

        tvStation.setText(station);
        tvTrain.setText(trains);
        tvDescription.setText(description);
        ivImage.setImageDrawable(image);

        return convertView;
    }
}
