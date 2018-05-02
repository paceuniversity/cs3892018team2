package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by WilliamZhong on 4/18/18.
 */

public class BussesFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_busses,container,false);

        ListView busListView = (ListView) view.findViewById(R.id.listView_busses);

        // === CREATE BUS OBJECTS ===
        BusObject m21 = new BusObject(getString(R.string.m21_bus),getString(R.string.m21_bus_description),
                getResources().getDrawable(R.drawable.m21_bus_route));

        BusObject m14a = new BusObject(getString(R.string.m14a_bus),getString(R.string.m14a_bus_description),
                getResources().getDrawable(R.drawable.m14a_bus_route));

        BusObject m15 = new BusObject(getString(R.string.m15_bus),getString(R.string.m15_bus_description),
                getResources().getDrawable(R.drawable.m15_bus_route));


        // == CREATE ARRAY LIST OF BUSOBJECTS AND ADD OBJECTS ===
        ArrayList<BusObject> busList = new ArrayList<>();
        busList.add(m21);
        busList.add(m14a);
        busList.add(m15);


        // === SET ADAPTER ===
        BusListAdapter adapter = new BusListAdapter(getActivity(),R.layout.buss_adapter_view,busList);
        busListView.setAdapter(adapter);


        //=== CLICK LISTENER TO GO TO MAPS VIA URL ===
        busListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] url = getActivity().getResources().getStringArray(R.array.bus_urls);
                String urls = url[position];
                Uri uri = Uri.parse(urls); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return view;
    };

}
