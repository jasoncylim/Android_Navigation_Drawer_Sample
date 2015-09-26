package layouts.com.navdrawer1;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_3 extends Fragment {

    private SensorManager mSensorManager;
    private TextView txt1;
    private TextView txt3;
    private TextView txt5;
    private GPSReader GP;

    public Fragment_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_3, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setContentView(R.layout.activity_main);
        //GP = new GPSReader(getContext());

        mSensorManager = (SensorManager) getActivity().getSystemService(getActivity().SENSOR_SERVICE);

        mSensorManager.registerListener((SensorEventListener) getContext(), mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_NORMAL);

        txt1 = (TextView) getActivity().findViewById(R.id.textViewTitle);
        txt3 = (TextView) getActivity().findViewById(R.id.textViewHeadingValue);
    }


    public class GPSReader extends Service implements LocationListener {
/**/
        // Constants
        final int MIN_TIME_BW_UPDATES = 1; // milliseconds
        final double MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; //meters

        // Variables
        LocationManager locationManager;
        Context mContext;

        public GPSReader(Context mContext) {
            //this.mContext = mContext;
            //locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
        }

        @Override
        public void onLocationChanged(Location location) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub

        }

        @Override
        public IBinder onBind(Intent intent) {
            // TODO Auto-generated method stub
            return null;
        }
/*
        public Location getGPSLocation() {


            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                //return 0;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    MIN_TIME_BW_UPDATES, (float) MIN_DISTANCE_CHANGE_FOR_UPDATES,
                    this);

            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            return location;
        }

        public Location getNetworkLocation() {


            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
               // return TODO;
            }
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                    MIN_TIME_BW_UPDATES, (float) MIN_DISTANCE_CHANGE_FOR_UPDATES,
                    this);

            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            return location;
        }

        public boolean Status(){
            boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            return isGPSEnabled;
        }*/
    }

}
