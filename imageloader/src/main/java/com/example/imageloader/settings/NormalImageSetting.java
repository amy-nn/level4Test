package com.example.imageloader.settings;

import android.os.Build;
import android.widget.ImageView;
import com.example.imageloader.base.BaseImageSetting;

/**
 * 通用图片设置类
 * ImageSetting类的其中一种实现
 */
public class NormalImageSetting extends BaseImageSetting {

    private static NormalImageSetting setting;

    //私有构造
    private NormalImageSetting(){

    }

    /**
     * 设置类的构造方法，为属性赋值（值从builder中得到）
     * @param builder
     */
    private NormalImageSetting(Builder builder){
        this.defaultImageId = builder.defaultImageId;
        this.url = builder.url;
        this.imageRadius = builder.imageRadius;
        this.imageView = builder.imageView;
    }

    /**
     * NormalSetting的构建类
     * 特点：内部、静态
     */
    public static class Builder{

        /**
         * 占位图片id(加载失败时显示该图片）
         */
        private int defaultImageId;
        /**
         * 显示图片的控件
         */
        private ImageView imageView;
        /**
         * 图片网址
         */
        private String url;
        /**
         * 图片半径（圆角）
         */
        private int imageRadius;

        //不希望通过构造创建对象
        public Builder(){

        }

        public Builder url(String url){
            this.url = url;
            return this;
        }

        public Builder defaultImageId(int id){
            this.defaultImageId = id;
            return this;
        }

        public Builder into(ImageView imageView){
            this.imageView = imageView;
            return this;
        }

        public Builder radius(int imageRadius){
            this.imageRadius = imageRadius;
            return this;
        }

        public NormalImageSetting build(){
            setting = new NormalImageSetting(this);
            return setting;
        }
    }
}
