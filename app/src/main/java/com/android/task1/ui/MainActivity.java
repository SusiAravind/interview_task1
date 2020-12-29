package com.android.task1.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.android.task1.R;
import com.android.task1.adapter.MediaRecyclerAdapter;
import com.android.task1.model.MediaResponse;
import com.android.task1.ui.MediaRecyclerView;
import com.android.task1.utils.DividerItemDecoration;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {

    MediaRecyclerView mRecyclerView;

    private ArrayList<MediaResponse> mediaResponseList = new ArrayList<>();
    private MediaRecyclerAdapter mAdapter;
    private boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        // Prepare demo content
        prepareVideoList();

        //set data object
        mRecyclerView.setMediaResponses(mediaResponseList);
        mAdapter = new MediaRecyclerAdapter(mediaResponseList, initGlide(),this);

        //Set Adapter
        mRecyclerView.setAdapter(mAdapter);

        if (firstTime) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    mRecyclerView.playVideo(false);
                }
            });
            firstTime = false;
        }
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.exoPlayerRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());



    }

    private RequestManager initGlide() {
        RequestOptions options = new RequestOptions();

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }

    @Override
    protected void onDestroy() {
        if (mRecyclerView != null) {
            mRecyclerView.releasePlayer();
        }
        super.onDestroy();
    }

    private void prepareVideoList() {

        mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/0d/29/18/0d2918323789eabdd7a12cdd658eda04.mp4",
                null));
         mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/77/4f/21/774f219598dde62c33389469f5c1b5d1.mp4",
                null));
         mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/c2/6d/2b/c26d2bacb4a9f6402d2aa0721193e06e.mp4",
                null));
         mediaResponseList.add(new MediaResponse(null,
                "https://i.pinimg.com/564x/6f/5f/fb/6f5ffb82a1f9a9f7e478b8a2486831f5.jpg"));
         mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/75/40/9a/75409a62e9fb61a10b706d8f0c94de9a.mp4",
                null));
         mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/0d/29/18/0d2918323789eabdd7a12cdd658eda04.mp4",
                null));
         mediaResponseList.add(new MediaResponse(null,
                "https://i.pinimg.com/564x/97/a5/51/97a5513d3c512eb382e564ba542d917b.jpg"));
         mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/dd/24/bb/dd24bb9cd68e9e25d1def88cad0a9ea7.mp4",
                null));
         mediaResponseList.add(new MediaResponse(null,
                "https://i.pinimg.com/564x/72/c1/a8/72c1a8aabbfe782643c4a5e739ec0ed2.jpg"));
         mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/d5/15/78/d51578c69d36c93c6e20144e9f887c73.mp4",
                null));
         mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/c2/6d/2b/c26d2bacb4a9f6402d2aa0721193e06e.mp4",
                null));
         mediaResponseList.add(new MediaResponse(null,
                "https://i.pinimg.com/564x/e2/fc/bc/e2fcbc98ceeb7d9316f8b4c889440bf7.jpg"));
         mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/62/81/60/628160e025f9d61b826ecc921b9132cd.mp4",
                null));
         mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/5f/aa/3d/5faa3d057eb31dd05876f622ea2e7502.mp4",
                null));
         mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/65/b0/54/65b05496c385c89f79635738adc3b15d.mp4",
                null));
         mediaResponseList.add(new MediaResponse(null,
                "https://i.pinimg.com/564x/3c/52/d3/3c52d31a1b388ea584175f7859fb23e7.jpg"));
         mediaResponseList.add(new MediaResponse(null,
                "https://i.pinimg.com/564x/4c/32/ee/4c32ee62af42bacec8c50ddfd10ade63.jpg"));
         mediaResponseList.add(new MediaResponse(null,
                "https://i.pinimg.com/564x/94/cb/29/94cb29d0279e376c6d89fe9a31191f94.jpg"));
         mediaResponseList.add(new MediaResponse("https://v.pinimg.com/videos/720p/86/a1/c6/86a1c63fc58b2e1ef18878b7428912dc.mp4",
                null));

    }

    @Override
    protected void onPause() {
        mRecyclerView.onPausePlayer();
        super.onPause();

    }

    @Override
    protected void onResume() {
    //    mRecyclerView.playVideo(true);
        super.onResume();
    }
}
