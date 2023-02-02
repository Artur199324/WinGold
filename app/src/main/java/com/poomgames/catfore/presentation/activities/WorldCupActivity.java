package com.poomgames.catfore.presentation.activities;

import static com.poomgames.catfore.presentation.see.SeeeWe.callback;
import static com.poomgames.catfore.presentation.see.SeeeWe.filePath;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.poomgames.catfore.presentation.see.SeeeWe;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;

public class WorldCupActivity extends AppCompatActivity {

    public WebView webView;
    private String llll;
    public String gggg;
    private boolean ff = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);
        llll = getIntent().getStringExtra(getPackageName() + "llll");
        gggg = getIntent().getStringExtra(getPackageName() + "gggg");
        new SeeeWe(this);
        webView.loadUrl(llll);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            if (ff) {
                if (getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).getString(getPackageName(), "").equals("")) {
                    webView.loadUrl(llll);
                } else {
                    webView.loadUrl(getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).getString(getPackageName(), ""));
                }
            }

            ff = true;
            webView.goBack();
            new Handler(Looper.getMainLooper()).postDelayed(() -> ff = false, 2333);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri[] res = null;
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                if (callback == null) {
                    return;
                }
                if (data == null || data.getData() == null) {
                    if (filePath != null) {
                        res = new Uri[]{Uri.parse(filePath)};
                    }
                } else {
                    String dataS = data.getDataString();
                    if (dataS != null) {
                        res = new Uri[]{Uri.parse(dataS)};
                    }
                }
            }
        }
        try {
            callback.onReceiveValue(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        callback = null;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        try {
            webView.saveState(outState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        try {
            webView.restoreState(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            try {
                kkkk();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    private void kkkk(){
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
        WindowInsetsControllerCompat windowInsetsControllerCompat = WindowCompat.getInsetsController(getWindow(), webView);
        windowInsetsControllerCompat.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        KeyboardVisibilityEvent.setEventListener(this, b -> {
            if (!b){
                try {
                    kkkk();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}