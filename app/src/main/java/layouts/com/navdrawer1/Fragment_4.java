package layouts.com.navdrawer1;


import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_4 extends Fragment {

    private SensorManager mSensorManager;
    private OrientationEventListener myOrientationEventListener;
    private TextView orientationValue;
    private TextView orientationName;

    public Fragment_4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_4, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        orientationValue = (TextView) getActivity().findViewById(R.id.orientationTextViewValue);
        orientationName = (TextView) getActivity().findViewById(R.id.orientationTextViewName);

        myOrientationEventListener = new OrientationEventListener(getContext(), SensorManager.SENSOR_DELAY_NORMAL){

            @Override
            public void onOrientationChanged(int orientationValue) {
                Fragment_4.this.orientationValue.setText(Integer.toString(orientationValue));

                if(orientationValue < 0){
                    orientationName.setText("ON THE TABLE");
                } else if (orientationValue >= 355 || orientationValue <= 5){
                    orientationName.setText("DEFAULT");
                } else if (orientationValue >= 85 && orientationValue <= 95){
                    orientationName.setText("RIGHT");
                } else if (orientationValue >= 175 && orientationValue <= 185){
                    orientationName.setText("UPSIDE DOWN");
                } else if (orientationValue >= 265 && orientationValue <= 275){
                    orientationName.setText("LEFT");
                }
            }
        };
        myOrientationEventListener.enable();
    }
}
