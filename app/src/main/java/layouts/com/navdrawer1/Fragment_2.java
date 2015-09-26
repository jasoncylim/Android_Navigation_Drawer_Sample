package layouts.com.navdrawer1;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.String.*;


/**
 * This fragment implements the
 */
public class Fragment_2 extends Fragment implements SensorEventListener {


    private SensorManager mSensorManager;
    private double gyro_x = 0;
    private double gyro_y = 0;
    private double gyro_z = 0;
    private double lastTime;
    private TextView gyroString;

    public Fragment_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_2, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mSensorManager = (SensorManager) getActivity().getSystemService(getActivity().SENSOR_SERVICE);

        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
                SensorManager.SENSOR_DELAY_NORMAL);

        lastTime = -1;

        gyroString = (TextView) getActivity().findViewById(R.id.textViewGyroData);
        gyroString.setText("No Gyro");

        Button reset = (Button) getActivity().findViewById(R.id.buttonGyroReset);

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Reset Gyro to zero;
                gyro_x = 0;
                gyro_y = 0;
                gyro_z = 0;
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            double x = event.values[0];
            double y = event.values[1];
            double z = event.values[2];

            //String s = "x: " + Double.toString(x) + "\n" + "y: " + Double.toString(y) + "\n" + "z: " + Double.toString(z);

            //gyroString.setText(s);

            double currentTime = event.timestamp / 1000000000; //convert from nanosec to sec

            if (lastTime != -1) {
                double pi = 3.14;

                double dt = currentTime - lastTime;

                gyro_x = gyro_x + dt*x*180/pi;
                gyro_y = gyro_y + dt*y*180/pi;
                gyro_z = gyro_z + dt*z*180/pi;

                String s = format("x: %.2f\ny: %.2f\nz: %.2f", gyro_x, gyro_y, gyro_z);
                //String s = "x: " + Double.toString(gyro_x) + "\n" + "y: " + Double.toString(gyro_y) + "\n" + "z: " + Double.toString(gyro_z);

                gyroString.setText(s);
            }

            lastTime = currentTime;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
