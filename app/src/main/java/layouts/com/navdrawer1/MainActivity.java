package layouts.com.navdrawer1;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerlayout;
    private ListView navList;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    //private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerlayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        navList = (ListView)findViewById(R.id.navlist);
        ArrayList<String> navArray = new ArrayList<>();
        navArray.add("Home");
        navArray.add("Accelerometer");
        navArray.add("Fragment 2");
        navArray.add("Fragment 3");
        navArray.add("Fragment 4");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,navArray);
        navList.setAdapter(adapter);
        navList.setOnItemClickListener(this);   // attach it to the on click listener
        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // highlights the current selection in the navigation drawer

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, R.string.open_drawer, R.string.close_drawer); // for accessibility mode
        drawerlayout.setDrawerListener(actionBarDrawerToggle);  //listen to when the action bar is pressed

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);  // set the home button to the burger icon (3 horizontal line) instead of the back button
        actionBar.setDisplayHomeAsUpEnabled(true);  //set the back button

        fragmentManager = getSupportFragmentManager();

        loadSelection(0);   //select home at start
    }

    private void loadSelection(int i){
        navList.setItemChecked(i, true);

        switch (i){
            case 0:
                Fragment_Home fragment_home = new Fragment_Home();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, fragment_home);
                fragmentTransaction.commit();
                break;
            case 1:
                Fragment_1 fragment1 = new Fragment_1();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, fragment1);
                fragmentTransaction.commit();
                break;
            case 2:
                Fragment_2 fragment2 = new Fragment_2();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, fragment2);
                fragmentTransaction.commit();
                break;
            case 3:
                Fragment_3 fragment3 = new Fragment_3();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, fragment3);
                fragmentTransaction.commit();
                break;
            case 4:
                Fragment_4 fragment4 = new Fragment_4();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, fragment4);
                fragmentTransaction.commit();
                break;
        }

    }


    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();  // to get the hamburger menu icon
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        } else if (id == android.R.id.home){
            // open the navigation drawer determined by the home button
            if(drawerlayout.isDrawerOpen(navList)){
                drawerlayout.closeDrawer(navList);
            } else {
                drawerlayout.openDrawer(navList);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        loadSelection(position);
        drawerlayout.closeDrawer(navList);

    }
}
