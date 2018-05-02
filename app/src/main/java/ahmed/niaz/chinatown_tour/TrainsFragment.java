package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by WilliamZhong on 4/18/18.
 */

public class TrainsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trains,container,false);

        ListView trainListView = (ListView)view.findViewById(R.id.listView_trains);

        // === CREATE TRAIN OBJECTS ===
        TrainsObject canal = new TrainsObject(getString(R.string.canal_street_station),getString(R.string.canal_street_trains),
                getString(R.string.canal_street_description),getResources().getDrawable(R.drawable.canal_street_station));

        TrainsObject grand = new TrainsObject(getString(R.string.grand_street_station),getString(R.string.grand_street_trains),
                getString(R.string.grand_street_description),getResources().getDrawable(R.drawable.grand_street_station));

        TrainsObject eastBWay = new TrainsObject(getString(R.string.east_broadway_description),getString(R.string.east_broadway_trains),
                getString(R.string.east_broadway_description),getResources().getDrawable(R.drawable.east_broadway_station));


        // === CREATE ARRAYLIST OF TRAIN OBJECTS AND ADD OBJECTS ===
        ArrayList<TrainsObject> trainList = new ArrayList<>();
        trainList.add(canal);
        trainList.add(grand);
        trainList.add(eastBWay);


        // === SET ADAPTER ===
        TrainsListAdapter adapter = new TrainsListAdapter(getActivity(),R.layout.train_adapter_view,trainList);
        trainListView.setAdapter(adapter);

        //=== CLICK LISTENER TO GO TO MAPS VIA URL ===
        trainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] url = getActivity().getResources().getStringArray(R.array.train_urls);
                String urls = url[position];
                Uri uri = Uri.parse(urls); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return view;
    }
}
