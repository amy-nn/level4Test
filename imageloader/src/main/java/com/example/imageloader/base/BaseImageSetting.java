package com.example.imageloader.base;

import android.widget.ImageView;

/**
 * 加载图片策略类
 */
public abstract class BaseImageSetting {

    /**
     * 占位图片id(加载失败时显示该图片）
     */
    protected int defaultImageId;
    /**
     * 显示图片的控件
     */
    protected ImageView imageView;
    /**
     * 图片网址
     */
    protected String url;
    /**
     * 图片半径（圆角）
     */
    protected int imageRadius;

    public int getDefaultImageId() {
        return defaultImageId;
    }

    public void setDefaultImageId(int defaultImageId) {
        this.defaultImageId = defaultImageId;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public int getImageRadius() {
        return imageRadius;
    }

    public void setImageRadius(int imageRadius) {
        this.imageRadius = imageRadius;
    }
}
