package com.example.imageloader.strategy;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.imageloader.base.ImageStrategy;
import com.example.imageloader.settings.NormalImageSetting;

/**
 * 具体的Glide策略
 * 功能：主要实现Glide框架加载图片功能
 */
public class GlideStrategy implements ImageStrategy<NormalImageSetting> {

    /**
     * Glide图片框架的设置对象
     */
    RequestOptions requestOptions;


    @Override
    public void loadImage(Context context, NormalImageSetting setting) {

        //角度不为0，则设置图片角度
        if(setting.getImageRadius() != 0){
            requestOptions = RequestOptions.bitmapTransform(new RoundedCorners(setting.getImageRadius()));
        }
        else {
            requestOptions = new RequestOptions();
        }

        //如果有默认图片，则添加到设置中
        if(setting.getDefaultImageId() > 0){
            //设置占位图片id
            requestOptions.placeholder(setting.getDefaultImageId());
            //设置错误图片id
            requestOptions.error(setting.getDefaultImageId());
        }

        Glide.with(context).load(setting.getUrl()).apply(requestOptions).into(setting.getImageView());
    }
}
