package cl.rodrigoayala.clasefinal.ejemplos;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import cl.rodrigoayala.clasefinal.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView vidView = (VideoView)findViewById(R.id.miVideo);
        String vidAddress = "http://www.sample-videos.com/video/3gp/240/big_buck_bunny_240p_1mb.3gp";
        Uri vidUri = Uri.parse(vidAddress);
        vidView.setVideoURI(vidUri);
        vidView.start();
    }
}
