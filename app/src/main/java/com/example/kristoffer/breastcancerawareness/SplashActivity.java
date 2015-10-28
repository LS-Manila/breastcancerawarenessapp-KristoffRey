package com.example.kristoffer.breastcancerawareness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startService(new Intent(this, BGM.class));
        startAnim();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        startService(new Intent(this, BGM.class));
    }

    private void startAnim() {
        ImageView banner = (ImageView)findViewById(R.id.banner);
        ImageView ribbon = (ImageView)findViewById(R.id.ribbon);
        TextView title1 = (TextView)findViewById(R.id.title1);
        TextView title2 = (TextView)findViewById(R.id.title2);
        TextView footer1 = (TextView)findViewById(R.id.footer1);
        TextView footer2 = (TextView)findViewById(R.id.footer2);
        TextView phrase = (TextView)findViewById(R.id.phrase);

        Animation decel = AnimationUtils.loadAnimation(this, R.anim.decelerate);
        //Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation fadeDelay = AnimationUtils.loadAnimation(this, R.anim.fade_in_delay);
        Animation overshoot = AnimationUtils.loadAnimation(this, R.anim.overshoot);

        title1.startAnimation(decel);
        ribbon.startAnimation(fadeDelay);
        banner.startAnimation(overshoot);
        title2.startAnimation(overshoot);
        footer1.startAnimation(fadeDelay);
        footer2.startAnimation(fadeDelay);
        phrase.startAnimation(fadeDelay);

        title1.setVisibility(View.INVISIBLE);
        ribbon.setVisibility(View.INVISIBLE);
        banner.setVisibility(View.INVISIBLE);
        title2.setVisibility(View.INVISIBLE);
        footer1.setVisibility(View.INVISIBLE);
        footer2.setVisibility(View.INVISIBLE);
        phrase.setVisibility(View.INVISIBLE);

        fadeDelay.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                // The animation has ended, transition to the Main Menu screen
                startActivity(new Intent(SplashActivity.this,
                        MainActivity.class));
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        });
    }

}
