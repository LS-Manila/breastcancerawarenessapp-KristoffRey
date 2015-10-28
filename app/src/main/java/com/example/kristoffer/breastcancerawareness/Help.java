package com.example.kristoffer.breastcancerawareness;

import android.view.MenuItem;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.widget.TextView;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;

public class Help extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        InputStream input_File = getResources().openRawResource(R.raw.abtapp);
        TextView helpme = (TextView)findViewById(R.id.content);
        try{
            helpme.setText(convertToString(input_File));
        }
        catch (Exception e){
            helpme.setText("Invalid File!");
        }
    }

    public String convertToString(InputStream filename) {
        StringBuffer strBuffer = new StringBuffer();
        BufferedReader txt_file = new BufferedReader(new InputStreamReader(filename));
        String init;
        try {
            while((init = txt_file.readLine()) != null){
                strBuffer.append(init + "\n" );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strBuffer.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }
}
