package layouts.com.navdrawer1;


import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_1 extends Fragment implements SensorEventListener {

    private SensorManager mSensorManager;
    TextView txt1;
    double gx = 0;
    double gy = 0;
    double gz = 0;

    public Fragment_1() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mSensorManager = (SensorManager) getActivity().getSystemService(getActivity().SENSOR_SERVICE);
        mSensorManager.registerListener(this,mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);

        txt1 = (TextView) getView().findViewById(R.id.textView);


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            double x = event.values[0];
            double y = event.values[1];
            double z = event.values[2];

            String s = Double.toString(x) + "\n" + Double.toString(y) + "\n" + Double.toString(z);



            double alpha = 0.8;

            gx = gx*alpha + (1-alpha)*x;
            gy = gy*alpha + (1-alpha)*y;
            gz = gz*alpha + (1-alpha)*z;

            double ax = x - gx;
            double ay = y - gy;
            double az = z - gz;

            s = Double.toString(ax) + "\n" + Double.toString(ay) + "\n" + Double.toString(az);

            txt1.setText(s);

        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
