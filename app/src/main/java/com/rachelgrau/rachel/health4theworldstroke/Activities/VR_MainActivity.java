package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.vr.sdk.widgets.video.VrVideoEventListener;
import com.google.vr.sdk.widgets.video.VrVideoView;
import com.rachelgrau.rachel.health4theworldstroke.R;

import java.io.IOException;


public class VR_MainActivity extends AppCompatActivity {

    /**
     * Preserve the video's state when rotating the phone.
     */
    private static final String STATE_IS_PAUSED = "isPaused";
    private static final String STATE_PROGRESS_TIME = "progressTime";
    /**
     * The video duration doesn't need to be preserved, but it is saved in this example. This allows
     * the seekBar to be configured during {@link #onRestoreInstanceState(Bundle)} rather than waiting
     * for the video to be reloaded and analyzed. This avoid UI jank.
     */
    private static final String STATE_VIDEO_DURATION = "videoDuration";


    private VideoLoaderTask backgroundVideoLoaderTask;

    /**
     * The video view and its custom UI elements.
     */
    protected VrVideoView videoWidgetView;

    /**
     * Seeking UI & progress indicator. The seekBar's progress value represents milliseconds in the
     * video.
     */
    private SeekBar seekBar;

    private ImageButton volumeToggle;
    private ImageButton playToggle;
    protected ImageView playIcon;
    private boolean isMuted;
    public static String Vname="";
    /**
     * By default, the video will start playing as soon as it is loaded. This can be changed by using
     * {@link VrVideoView#pauseVideo()} after loading the video.
     */
    private boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vr__main);

        Vname=this.getIntent().getStringExtra(Vname);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBarListener());

        videoWidgetView = (VrVideoView) findViewById(R.id.video_view);
        videoWidgetView.setEventListener(new ActivityEventListener());

        volumeToggle = (ImageButton) findViewById(R.id.volume_toggle);
        volumeToggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setIsMuted(!isMuted);
            }
        });

        playToggle = (ImageButton) findViewById((R.id.play_toggle));
        playToggle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                handlePause();
            }
        });

        playIcon = (ImageView) findViewById(R.id.playButton);
        playIcon.setVisibility(View.INVISIBLE);
        playIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                handlePause();
            }
        });


        // Load the bitmap in a background thread to avoid blocking the UI thread. This operation can
        // take 100s of milliseconds.
        if (backgroundVideoLoaderTask != null) {
            // Cancel any task from a previous intent sent to this activity.
            backgroundVideoLoaderTask.cancel(true);
        }
        backgroundVideoLoaderTask = new VideoLoaderTask();
        backgroundVideoLoaderTask.execute("bells.mp4");
    }


    private void setIsMuted(boolean isMuted) {
        this.isMuted = isMuted;
        volumeToggle.setImageResource(isMuted ? R.drawable.volume_off : R.drawable.volume_on);
        videoWidgetView.setVolume(isMuted ? 0.0f : 1.0f);
    }


    private void handlePause() {
        togglePause();
        updatePauseButtons();
    }

    private void updatePauseButtons(){
        playToggle.setImageResource(isPaused ? R.drawable.play_off : R.drawable.play_on);
        playIcon.setVisibility(isPaused ? View.VISIBLE: View.INVISIBLE);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong(STATE_PROGRESS_TIME, videoWidgetView.getCurrentPosition());
        savedInstanceState.putLong(STATE_VIDEO_DURATION, videoWidgetView.getDuration());
        savedInstanceState.putBoolean(STATE_IS_PAUSED, isPaused);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        long progressTime = savedInstanceState.getLong(STATE_PROGRESS_TIME);
        videoWidgetView.seekTo(progressTime);
        seekBar.setMax((int) savedInstanceState.getLong(STATE_VIDEO_DURATION));
        seekBar.setProgress((int) progressTime);

        isPaused = savedInstanceState.getBoolean(STATE_IS_PAUSED);
        if (isPaused) {
            videoWidgetView.pauseVideo();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Prevent the view from rendering continuously when in the background.
        videoWidgetView.pauseRendering();
        // If the video is playing when onPause() is called, the default behavior will be to pause
        // the video and keep it paused when onResume() is called.
        isPaused = true;
        updatePauseButtons();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Resume the 3D rendering.
        videoWidgetView.resumeRendering();
    }

    @Override
    protected void onDestroy() {
        // Destroy the widget and free memory.
        videoWidgetView.shutdown();
        super.onDestroy();
    }

    private void togglePause() {
        if (isPaused) {
            videoWidgetView.playVideo();
        } else {
            videoWidgetView.pauseVideo();
        }
        isPaused = !isPaused;
    }

    /**
     * When the user manipulates the seek bar, update the video position.
     */
    private class SeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                videoWidgetView.seekTo(progress);
            } // else this was from the ActivityEventHandler.onNewFrame()'s seekBar.setProgress update.
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) { }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) { }
    }

    /**
     * Listen to the important events from widget.
     */
    private class ActivityEventListener extends VrVideoEventListener {
        /**
         * Called by video widget on the UI thread when it's done loading the video.
         */
        @Override
        public void onLoadSuccess() {
            seekBar.setMax((int) videoWidgetView.getDuration());
        }

        /**
         * Called by video widget on the UI thread on any asynchronous error.
         */
        @Override
        public void onLoadError(String errorMessage) {
            // An error here is normally due to being unable to decode the video format.
            Toast.makeText(
                    VR_MainActivity.this, "Error loading video: " + errorMessage, Toast.LENGTH_LONG)
                    .show();
        }

        @Override
        public void onClick() {

        }

        /**
         * Update the UI every frame.
         */
        @Override
        public void onNewFrame() {
            seekBar.setProgress((int) videoWidgetView.getCurrentPosition());
        }

        /**
         * Make the video play in a loop. This method could also be used to move to the next video in
         * a playlist.
         */
        @Override
        public void onCompletion() {
            videoWidgetView.seekTo(0);
        }
    }

    /**
     * Helper class to manage threading.
     */
    class VideoLoaderTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... fileInformation) {
            try {
                String videoUrl="";
                if(Vname.equals("Bells")){
                    videoUrl="https://player.vimeo.com/external/220082127.hd.mp4?s=609a47c79fc41735c5e10c735bc171b3ff02a7a9&profile_id=119";
                }if(Vname.equals("Buddha")){
                    videoUrl="https://player.vimeo.com/external/220082376.hd.mp4?s=7ff60014fc882dd6f0f732f4aaa46c172c9dcb37&profile_id=119";
                }if(Vname.equals("Flags")){
                    videoUrl="https://player.vimeo.com/external/220082275.hd.mp4?s=0d555e0984b540a45c80d02a07ea68c62c34ac39&profile_id=119";
                }if(Vname.equals("Market place 1")){
                    videoUrl="https://player.vimeo.com/external/220082608.hd.mp4?s=88b7c3083855d20ee414ebeb6e36a7562fda631d&profile_id=119";
                }if(Vname.equals("Market place 2")){
                    videoUrl="https://player.vimeo.com/external/220082795.hd.mp4?s=adb6102bc008cd95c8d20df8ad4d475d8dd06e53&profile_id=119";
                }if(Vname.equals("Rocky Beach")){
                    videoUrl="https://player.vimeo.com/external/220082847.hd.mp4?s=39da6e3c156c0f9a5a38fa5e0bd39faddac19aab&profile_id=119";
                }if(Vname.equals("Sandy Beach")){
                    videoUrl="https://player.vimeo.com/external/220083158.hd.mp4?s=179b1c6c548acfca54381abc1b16a6797293c015&profile_id=119";
                }
                Uri uri= Uri.parse(videoUrl);
                VrVideoView.Options options = new VrVideoView.Options();
                options.inputType = VrVideoView.Options.TYPE_MONO;
                //videoWidgetView.loadVideoFromAsset(fileInformation[0], options);
                videoWidgetView.loadVideo(uri, options);
            }
            catch (IOException e) {
                // An error here is normally due to being unable to locate the file.
                // Since this is a background thread, we need to switch to the main thread to show a toast.
                videoWidgetView.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast
                                .makeText(VR_MainActivity.this, "Error opening file. ", Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

            return true;
        }
    }
}
