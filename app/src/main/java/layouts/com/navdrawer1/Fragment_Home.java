package layouts.com.navdrawer1;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Home extends Fragment {

    private SensorManager mSensorManager;
    ListView sensorList;

    public Fragment_Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sensorList = (ListView) getActivity().findViewById(R.id.listViewHome);


        mSensorManager = (SensorManager) getActivity().getSystemService(getActivity().SENSOR_SERVICE);
        List< Sensor> tempSensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        List<String> sensorNames = new ArrayList<String>();

        int i;
        String s;

        for (i = 0; i < tempSensorList.size(); i++){
            s = tempSensorList.get(i).getName() + "\n" + tempSensorList.get(i).getVendor() + "\n" +
                    tempSensorList.get(i).getVersion() + "\n" + tempSensorList.get(i).getMaximumRange() + "\n" +
                    Integer.toString(tempSensorList.get(i).getMinDelay());
            sensorNames.add(s);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,sensorNames){

            //override the getView method of Array adapter and change the color
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                return view;
            }
        };

        sensorList.setAdapter(adapter);
      //  sensorList.setBackgroundColor(Color.BLACK);
    }
}
