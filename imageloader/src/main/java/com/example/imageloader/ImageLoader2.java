package com.example.imageloader;

import android.content.Context;

import com.example.imageloader.base.ImageStrategy;
import com.example.imageloader.settings.NormalImageSetting;
import com.example.imageloader.strategy.GlideStrategy;

/**
 * 图片加载框架的使用类
 * 要素：1.具体的策略对象   2.实现方法
 * 特点：单例
 */
public class ImageLoader2 {

    private ImageStrategy strategy;
    private static volatile ImageLoader2 imageLoder;

    private ImageLoader2(){
        /**
         * 默认使用glide框架策略
         */
        strategy = new GlideStrategy();
    }

    /**
     * 使用create方法创建该类对象
     * @return
     */
    public static ImageLoader2 create(){
        if(imageLoder == null){
            synchronized (ImageLoader2.class){
                imageLoder = new ImageLoader2();
            }
        }
        return imageLoder;
    }

    /**
     * 加载图片方法
     * @param context
     * @param setting
     */
    public void loadImage(Context context, NormalImageSetting setting){

        //具体策略的加载图片方法
        strategy.loadImage(context,setting);
    }

    /**
     * 设置策略方法
     * @param strategy
     */
    public void setStrategy(ImageStrategy strategy){

        this.strategy = strategy;
    }
}
