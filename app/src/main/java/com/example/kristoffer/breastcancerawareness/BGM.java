package com.example.kristoffer.breastcancerawareness;

/**
 * Created by Kristoffer on 10/12/2015.
 */
import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.IBinder;
import java.io.IOException;

public class BGM extends Service {
    final MediaPlayer mp = new MediaPlayer();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        if (mp.isPlaying()) {
            mp.stop();
            mp.reset();
        }
        try {

            AssetFileDescriptor afd;
            afd = getAssets().openFd("bgm_piano.mp3");
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mp.prepare();
            mp.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mp.setLooping(true); // Set looping
    }

    @Override
    public void onDestroy() {
        mp.stop();
    }

    @Override
    public void onStart(Intent intent, int startid) {
        mp.start();
    }
}