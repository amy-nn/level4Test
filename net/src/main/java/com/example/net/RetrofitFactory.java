package com.example.net;

import com.example.net.common.Config_url;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 单例Retrofit工厂：返回Retrofit对象
 */
public class RetrofitFactory {

    //volatile关键字：避免重新排列
    private static volatile RetrofitFactory factory;
    private Retrofit retrofit;

    private RetrofitFactory(){
        init();
    }

    /**
     * double check的方式创建retrofitFactory
     * @return
     */
    public static RetrofitFactory getRetrofitFactoryInstance(){

        if(factory == null){
            synchronized (RetrofitFactory.class){
                if(factory == null){
                    factory = new RetrofitFactory();
                }
            }
        }
        return factory;
    }

    /**
     * 初始化retrofit对象
     */
    public void init(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Config_url.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();
    }

    /**
     * 创建OkHttpClient对象
     * @return
     */
    public OkHttpClient getOkHttpClient(){

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
//                .addNetworkInterceptor(new HttpLoggingInterceptor())
                .addNetworkInterceptor(getInterceptor())
                .addInterceptor(createInterceptor())
                .build();

        return client;
    }

    /**
     * 自定义拦截器
     */
    public Interceptor createInterceptor(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Response response = chain.proceed(request);

                /**
                 * 状态是401需要加token
                 */
                if(response != null &&  response.code() == 401){

                    String token = "eaacae51-1c55-4ead-a31d-8070e336bc51AND1558449232809";

                    //方式一
//                    Request.Builder builder = new Request.Builder();
//                    builder.addHeader("Authorization","bearer"+token);
//                    Request newRequest = builder.build();

                    //方式二
                    Request newRequest = request.newBuilder().addHeader("token",token).build();
                    return  chain.proceed(newRequest);
                }
                return response;
            }
        };
        return interceptor;
    }

    /**
     * 请求token的值
     * @return
     */
    public String requestToken(){



        return null;
    }

    /**
     * 日志拦截器
     * @return
     */
    public Interceptor getInterceptor(){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    /**
     * 返回API接口
     * 例：RetrofitAPI api = retrofit.create(RetrofitAPI.class);
     * @param service
     * @param <T>
     * @return
     */
    public <T> T getApiInterface(Class<T> service){
        return retrofit.create(service);
    }
}
