package com.example.net.log;

/**
 * Log的基类
 */
public interface ILog {

    /**
     * debug log
     * @param Tag
     * @param messag
     */
    public void d(String Tag,String messag);
    public void d(String messag);

    /**
     * info log
     * @param Tag
     * @param messag
     */
    public void i(String Tag,String messag);
    public void i(String messag);

    /**
     * error log
     * @param Tag
     * @param messag
     */
    public void e(String Tag,String messag);
    public void e(String messag);

}
