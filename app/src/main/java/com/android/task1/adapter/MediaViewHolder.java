package com.android.task1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.task1.R;
import com.android.task1.model.MediaResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import static android.view.View.VISIBLE;

public class MediaViewHolder extends RecyclerView.ViewHolder {

    public FrameLayout mediaContainer;
    public FrameLayout thumb;
    public ImageView imageView/*, volumeControl*/;
    public ProgressBar progressBar;
    public RequestManager requestManager;
    private View parent;

    public MediaViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        mediaContainer = itemView.findViewById(R.id.mediaContainer);
      thumb = itemView.findViewById(R.id.thumb);
        imageView = itemView.findViewById(R.id.ivMediaCoverImage);
        progressBar = itemView.findViewById(R.id.progressBar);
        // volumeControl = itemView.findViewById(R.id.ivVolumeControl);
    }

    void onBind(MediaResponse mediaResponse, RequestManager requestManager, Context context) {
        this.requestManager = requestManager;
        parent.setTag(this);

        if (mediaResponse.getImgUrl() != null) {
            imageView.setVisibility(VISIBLE);
            Glide.with(context).load(mediaResponse.getImgUrl()).into(imageView);
        } else {
           // imageView.setVisibility(View.GONE);

         /* Glide.with(context)
                  .load(mediaResponse.getVideoUrl())
                  .into(imageView);*/



          long interval = 1000;
          RequestOptions options = new RequestOptions().frame(interval);
          Glide.with(context).asBitmap()
                  .load(mediaResponse.getVideoUrl())
                  .apply(options)
                  .into(imageView);


        }



        /*if (mediaResponse.getVideoUrl()!=null) {



          PlayerView videoSurfaceView;
          SimpleExoPlayer videoPlayer;




          videoSurfaceView = new PlayerView(context);
          videoSurfaceView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM);

          thumb.addView(videoSurfaceView);
          videoSurfaceView.requestFocus();
          videoSurfaceView.setVisibility(VISIBLE);
          videoSurfaceView.setAlpha(1);


          BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
          TrackSelection.Factory videoTrackSelectionFactory =
                  new AdaptiveTrackSelection.Factory(bandwidthMeter);
          TrackSelector trackSelector =
                  new DefaultTrackSelector(videoTrackSelectionFactory);

          //Create the player using ExoPlayerFactory
          videoPlayer = ExoPlayerFactory.newSimpleInstance(context, trackSelector);
          // Disable Player Control
          videoSurfaceView.setUseController(false);
          // Bind the player to the view.
          videoSurfaceView.setPlayer(videoPlayer);


          videoSurfaceView.setPlayer(videoPlayer);


          DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(
                  context, Util.getUserAgent(context, "TASK1"));
          String mediaUrl = mediaResponse.getVideoUrl();
          if (mediaUrl != null) {
            MediaSource videoSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(Uri.parse(mediaUrl));
            videoPlayer.prepare(videoSource);
            videoPlayer.setPlayWhenReady(false);

          }
        }*/

    }
}

