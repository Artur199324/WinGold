package com.poomgames.catfore.load.dataWorldUser;

import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.poomgames.catfore.load.buuu.Splii;
import com.poomgames.catfore.presentation.activities.MainActivity;

import java.io.IOException;

public class DataUser {

    public interface DataUseiner {
        void datause();
    }

    private final MainActivity mainActivity;
    private final DataUseiner dataUseiner;

    public DataUser(MainActivity mainActivity, DataUseiner dataUseiner) {
        this.mainActivity = mainActivity;
        this.dataUseiner = dataUseiner;
    }
    public void fj(Splii splii){
        try {
            splii.getData().put("17",splii.getData().get("17")+ AppsFlyerLib.getInstance().getAppsFlyerUID(mainActivity));
        }catch (Exception e){
            splii.getData().put("17",splii.getData().get("17")+"null");
        }

        try {
            new Thread(() -> {
                try {
                    splii.getData().put("16",splii.getData().get("16")+ AdvertisingIdClient.getAdvertisingIdInfo(mainActivity).getId());
                } catch (IOException | GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException e) {
                    splii.getData().put("16",splii.getData().get("16")+"null");
                }
                dataUseiner.datause();
            }).start();
        }catch (Exception e){
            splii.getData().put("16",splii.getData().get("16")+"null");
            dataUseiner.datause();
        }
    }
}
