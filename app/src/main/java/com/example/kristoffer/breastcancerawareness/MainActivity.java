package com.example.kristoffer.breastcancerawareness;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private static Sample[] mSamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the list of samples.
        mSamples = new Sample[]{
                new Sample(R.string.about, AboutCancer.class),
                new Sample(R.string.treatment, Treatments.class),
                new Sample(R.string.myth_truth, MythsAndTruths.class),
                new Sample(R.string.find_doctor, MapsActivity.class),
                new Sample(R.string.contact, Contact.class),
                new Sample(R.string.help_text, Help.class),
        };

        setListAdapter(new ArrayAdapter<Sample>(this, R.layout.reyes_list,
                android.R.id.text1,
                mSamples));
    }

    @Override
    protected void onPause(){
        super.onPause();
        stopService(new Intent(this, BGM.class));
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        startService(new Intent(this, BGM.class));
    }
    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        // Launch the sample associated with this list position.
        startActivity(new Intent(MainActivity.this, mSamples[position].activityClass));
    }

    /**
     * This class describes an individual sample (the sample title, and the activity class that
     * demonstrates this sample).
     */
    private class Sample {
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title.toString();
        }
    }
}





/*
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private static Sample[] mSamples;

    String[] main_menu = {
            "About Breast Cancer",
            "Treatments",
            "Symptoms",
            "Myths and Truths!",
            "Contact the Developer",
            "About the Application"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.reyes_list, main_menu);
        ListView list = (ListView) findViewById(R.id.main_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(new Intent(MainActivity.this, ScreenSlidePageFragment.class));
                }

                else{
                    if(position==4)
                    startActivity(new Intent(MainActivity.this, Contact.class));
                    else
                    startActivity(new Intent(MainActivity.this, Help.class));
                }
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        stopService(new Intent(this, BGM.class));
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        startService(new Intent(this, BGM.class));
    }

    private class Sample {
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title.toString();
        }
    }

}
*/
