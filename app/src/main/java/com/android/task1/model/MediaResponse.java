package com.android.task1.model;

public class MediaResponse {
  private String mediaVideoUrl;
  private String mediImgUrl;

  public MediaResponse(String mediaVideoUrl, String mediImgUrl) {
    this.mediaVideoUrl = mediaVideoUrl;
    this.mediImgUrl = mediImgUrl;
  }

  public String getVideoUrl() {
    return mediaVideoUrl;
  }

  public void setVideoUrl(String mUrl) {
    this.mediaVideoUrl = mUrl;
  }

  public String getImgUrl() {
    return mediImgUrl;
  }

  public void setImgUrl(String mCoverUrl) {
    this.mediImgUrl = mCoverUrl;
  }
}
