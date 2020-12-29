package com.android.task1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.android.task1.R;
import com.android.task1.model.MediaResponse;
import com.bumptech.glide.RequestManager;
import java.util.ArrayList;

public class MediaRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private ArrayList<MediaResponse> mediaResponses;
  private RequestManager requestManager;
Context mContext;
  public MediaRecyclerAdapter(ArrayList<MediaResponse> mediaResponses,
                              RequestManager requestManager, Context context) {
    this.mediaResponses = mediaResponses;
    this.requestManager = requestManager;
    this.mContext=context;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    return new MediaViewHolder(
        LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.layout_media_list_item, viewGroup, false));
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    ((MediaViewHolder) viewHolder).onBind(mediaResponses.get(i), requestManager,mContext);
  }

  @Override
  public int getItemCount() {
    return mediaResponses.size();
  }
}
