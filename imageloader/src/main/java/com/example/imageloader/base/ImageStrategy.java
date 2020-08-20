package com.example.imageloader.base;

import android.content.Context;
import com.example.imageloader.base.BaseImageSetting;

/**
 * 实现图片加载的接口
 * @param <T> 派生自BaseImageSetting的任意
 */
public interface ImageStrategy<T extends BaseImageSetting> {

    //加载图片
    public void loadImage(Context context, T setting);
}
