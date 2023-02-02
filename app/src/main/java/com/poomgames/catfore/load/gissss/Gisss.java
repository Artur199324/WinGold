package com.poomgames.catfore.load.gissss;

import android.util.Base64;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Gisss {
    public boolean a;
    private String dd;


    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public interface Callback {
        void call(Gisss gisss);
    }
    public interface CallGame{
        void callGame();
    }

    private final Callback callback;
    private final CallGame callGame;


    public Gisss(Callback callback, CallGame callGame) {
        this.callback = callback;
        this.callGame = callGame;
    }

    public void gggi(String s) {

        new Thread(() -> {
          try {
              OkHttpClient okHttpClient = new OkHttpClient.Builder()
                      .connectTimeout(20, TimeUnit.SECONDS)
                      .readTimeout(20, TimeUnit.SECONDS)
                      .writeTimeout(20, TimeUnit.SECONDS)
                      .build();
              Request request = new Request.Builder()
                      .url(s)
                      .build();
              Response response = okHttpClient.newCall(request).execute();

              if (response.isSuccessful()) {

                  String d  = Objects.requireNonNull(response.body()).string();

                  if (!d.equals("WorldCupPlayingthebest")){
                      setDd(de(d));

                      a = true;
                      callback.call(Gisss.this);
                  }else {

                      callGame.callGame();
                  }


              }else {
                  a = false;
              }
          }catch (Exception e){
              a = false;
          }
        }).start();


    }


    private String de(String s){
        byte[] sss = android.util.Base64.decode(s, Base64.DEFAULT);
        return new String(sss);
    }
}
