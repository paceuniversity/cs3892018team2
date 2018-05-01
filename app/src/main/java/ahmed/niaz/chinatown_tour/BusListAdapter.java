package ahmed.niaz.chinatown_tour;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
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

public class BusListAdapter extends ArrayAdapter<BusObject> {
    private Context mContext;
    int mResource;

    public BusListAdapter(Context context, int resource, ArrayList<BusObject> objects){
        super(context,resource,objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String bus = getItem(position).getBus();
        String description = getItem(position).getDescription();
        Drawable image = getItem(position).getImage();

        BusObject busObject = new BusObject(bus,description,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvBus = (TextView)convertView.findViewById(R.id.textView_bus);
        TextView tvDescription = (TextView)convertView.findViewById(R.id.textView_description);
        ImageView tvday = (ImageView) convertView.findViewById(R.id.imageView_routes);

        tvBus.setText(bus);
        tvDescription.setText(description);
        tvday.setImageDrawable(image);

        return convertView;
    }
}
