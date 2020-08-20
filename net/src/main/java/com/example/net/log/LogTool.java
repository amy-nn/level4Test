package com.example.net.log;

import android.os.Build;
import android.util.Log;

import com.example.command.BuildConfig;

/**
 * log的执行类 策略设计模式
 * isDebug:用来指定是否显示log,若该值为true则显示log,否则隐藏log
 * iLog: 如果有多个ILog接口的实现类，则指定具体的一个实现类给iLog对象
 *
 * 注意：策略模式核心（1.和接口相同的方法   2.setImplType方法）
 */
public class LogTool {

    private static volatile LogTool logTool;
    private ILog iLog;
    private boolean isDebug = BuildConfig.isDebug;

    private LogTool(){
        iLog = new ILogImpl();
    }

    public static LogTool getInstance(){
        if(logTool == null){
            synchronized (LogTool.class){
                logTool = new LogTool();
            }
            return logTool;
        }
        return logTool;
    }

    public void setImplType(ILog iLog){
        this.iLog = iLog;
    }

    public void setDebug(boolean isDebug){
        this.isDebug = isDebug;
    }

    /**
     * debug log
     * @param Tag
     * @param messag
     */
    public void d(String Tag,String messag){
        if(isDebug)
            iLog.d(Tag,messag);
    }
    public void d(String messag){
        if(isDebug)
            iLog.d(messag);
    }

    /**
     * info log
     * @param Tag
     * @param messag
     */
    public void i(String Tag,String messag){
        if(isDebug)
            iLog.i(Tag,messag);
    }
    public void i(String messag){
        if(isDebug)
            iLog.i(messag);
    }

    /**
     * error log
     * @param Tag
     * @param messag
     */
    public void e(String Tag,String messag){
        if(isDebug)
            iLog.e(Tag,messag);
    }
    public void e(String messag){
        if(isDebug)
            iLog.e(messag);
    }
}
