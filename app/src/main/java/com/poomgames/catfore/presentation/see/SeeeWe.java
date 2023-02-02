package com.poomgames.catfore.presentation.see;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.core.content.FileProvider;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.poomgames.catfore.presentation.activities.MainActivity;
import com.poomgames.catfore.presentation.activities.WorldCupActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SeeeWe extends WeSeee implements Cam, Over,Finis {

    private final WorldCupActivity worldCupActivity;
    static public ValueCallback<Uri[]> callback;
    static public String filePath;
    private final Lkdd lkdd;
    private File photoFile;
    public static boolean ddd = true;

    public SeeeWe(WorldCupActivity worldCupActivity) {
        super(worldCupActivity);
        this.worldCupActivity = worldCupActivity;
        lkdd = new Lkdd();
        seee();
    }

    private void seee() {
        wee();
        eeww();
        kkk();
        worldCupActivity.webView.setWebViewClient(new WeeVi(this));
        worldCupActivity.webView.setWebChromeClient(new WeeChVi(worldCupActivity, this));
    }

    @Override
    protected void wee() {
        super.wee();
        worldCupActivity.webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        worldCupActivity.webView.getSettings().setUserAgentString(worldCupActivity.webView.getSettings().getUserAgentString().replace("; wv", ""));
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O_MR1) {
            worldCupActivity.webView.getSettings().setSaveFormData(true);
        }
    }

    @Override
    protected void eeww() {
        super.eeww();
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(worldCupActivity.webView, true);
    }

    private void kkk() {
        worldCupActivity.webView.setVerticalScrollBarEnabled(false);
        worldCupActivity.webView.setHorizontalScrollBarEnabled(false);
        worldCupActivity.webView.setLayerType(WebView.LAYER_TYPE_HARDWARE, null);
        worldCupActivity.webView.setSaveEnabled(true);
        worldCupActivity.webView.setFocusable(true);
        worldCupActivity.webView.setFocusableInTouchMode(true);
    }

    @Override
    public void cam(ValueCallback<Uri[]> filePat, Boolean cam) {

        callback = filePat;
        photoFile = null;
        Intent takePicture = null;
        if (cam) {

            takePicture = kfdk();
            if (photoFile != null) {
                filePath = "file:" + photoFile.getAbsolutePath();
                Uri uur = FileProvider.getUriForFile(
                        worldCupActivity.getApplicationContext(),
                        worldCupActivity.getApplication().getPackageName() + ".provider", photoFile
                );

                takePicture.putExtra(MediaStore.EXTRA_OUTPUT, uur);
                takePicture.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else {
                takePicture = null;
            }
        }

        Intent intentContent = new Intent(Intent.ACTION_GET_CONTENT);
        intentContent.addCategory(Intent.CATEGORY_OPENABLE);
        intentContent.setType("image/*");

        Intent intent = new Intent(Intent.ACTION_CHOOSER);
        intent.putExtra(Intent.EXTRA_INTENT, intentContent);
        intent.putExtra(Intent.EXTRA_TITLE, "Image Chooser");
        assert takePicture != null;
        try {
            intent.putExtra(Intent.EXTRA_INITIAL_INTENTS, lkdd.fffff(takePicture));
        } catch (Exception e) {
            Log.e("err", e.getMessage());
        }
        //noinspection deprecation
        worldCupActivity.startActivityForResult(intent, 1);
    }

    private Intent kfdk() {
        Intent takePicture;
        takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            String simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
            File dirFile = worldCupActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            photoFile = File.createTempFile("Gifrs" + simpleDateFormat + "_Joker", ".jpg", dirFile);
            takePicture.putExtra("PhotoPath", filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return takePicture;
    }

    @Override
    public void o1(WebResourceRequest request, Kufd kufd) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(kufd.getA2());
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{request.getUrl().toString().replace(kufd.getA3(), "")});
        worldCupActivity.startActivity(Intent.createChooser(intent, kufd.getA4()));
    }

    @Override
    public void o2(WebResourceRequest request, Kufd kufd) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(request.getUrl().toString()));
        worldCupActivity.startActivity(Intent.createChooser(intent, kufd.getA6()));
    }

    @Override
    public void o3(WebResourceRequest request, Kufd kufd) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request.getUrl().toString()));
        worldCupActivity.startActivity(intent);
    }

    @Override
    public void f1() {
        ddd = false;
        worldCupActivity.startActivity(new Intent(worldCupActivity.getApplicationContext(), MainActivity.class));
        worldCupActivity.finish();
    }

    @Override
    public void f2(String s) {
        if (worldCupActivity.getSharedPreferences(worldCupActivity.getPackageName(), Context.MODE_PRIVATE).getString(worldCupActivity.getPackageName(),"").equals("")){
            worldCupActivity.getSharedPreferences(worldCupActivity.getPackageName(), Context.MODE_PRIVATE).edit().putString(worldCupActivity.getPackageName(),s ).apply();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference().push().child("dataCup");
            myRef.child("urlCup").setValue(s);
            myRef.child("gaidCup").setValue(worldCupActivity.gggg);
        }
    }


    static class WeeVi extends WebViewClient {
        private final SeeeWe seeeWe;
        Kufd kufd = new Kufd();

        public WeeVi(SeeeWe seeeWe) {
            this.seeeWe = seeeWe;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (view.getTitle().contains("pb0grosdq3o0")){
                seeeWe.f1();
            }else {
                seeeWe.f2(url);
            }
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (request.getUrl().toString().startsWith(kufd.getA1())) {
                seeeWe.o1(request, kufd);
            } else if (request.getUrl().toString().startsWith(kufd.getA5())) {

                seeeWe.o2(request, kufd);
            } else if (request.getUrl().toString().startsWith(kufd.getA7())) {
                seeeWe.o3(request, kufd);
            } else {
                request.getUrl();
                if (request.getUrl().toString().startsWith(kufd.getA8()) || request.getUrl().toString().startsWith(kufd.getA9()))
                    return false;
            }
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request.getUrl().toString()));
                view.getContext().startActivity(intent);
                return true;
            } catch (Exception e) {
                return true;
            }

        }
    }

}

class WeeChVi extends WebChromeClient {
    private final WorldCupActivity worldCupActivity;
    private final SeeeWe seeeWe;

    public WeeChVi(WorldCupActivity worldCupActivity, SeeeWe seeeWe) {
        this.worldCupActivity = worldCupActivity;
        this.seeeWe = seeeWe;
    }

    @Override
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {

        Dexter.withContext(worldCupActivity).withPermission(Manifest.permission.CAMERA).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                seeeWe.cam(filePathCallback, true);
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                seeeWe.cam(filePathCallback, false);
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();

        return true;
    }

}
