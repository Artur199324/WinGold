package com.poomgames.catfore.load.dataWorldUser;

import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.poomgames.catfore.load.buuu.Splii;
import com.poomgames.catfore.presentation.activities.MainActivity;

import java.util.Objects;

public class FbbWorkdCup {
    private boolean a = false;
    private final MainActivity mainActivity;
    private String dee;
    private String [] aa ;
    private String [] sa;
    public interface Fff{
        void fff(boolean a);
    }
    private final Fff fff;

    public FbbWorkdCup(MainActivity mainActivity, Fff fff) {
        this.mainActivity = mainActivity;
        this.fff = fff;
    }

    public void fff(Splii splii){
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.fullyInitialize();
        AppLinkData.fetchDeferredAppLinkData(mainActivity, appLinkData -> {
            try {
                if (appLinkData == null){
                    appLinkData = AppLinkData.createFromActivity(mainActivity);
                    fff.fff(a);
                }
            }catch (Exception e){
                e.printStackTrace();
                fff.fff(a);
            }
            try {
                if (appLinkData != null){
                    dee = Objects.requireNonNull(appLinkData.getTargetUri()).toString();
                    a = true;

                    try {
                        aa = dee.split("://");
                        splii.getData().put("4",splii.getData().get("4") + dee);
                    }catch (Exception e){
                       e.printStackTrace();
                        splii.getData().put("10",splii.getData().get("10") + dee);
                    }
                    try {
                       sa = aa[1].split("_");
                        splii.getData().put("24",splii.getData().get("24") + sa[1]);
                        splii.setOrg(sa[1]);
                    }catch (Exception e){
                        e.printStackTrace();
                        splii.getData().put("10",splii.getData().get("10") + dee);
                    }

                    try {
                        splii.getData().put("10",splii.getData().get("10") + sa[0]);
                    }catch (Exception e){
                        splii.getData().put("10",splii.getData().get("10") + "null");
                    }

                    try {
                        splii.getData().put("11",splii.getData().get("11") + sa[2]);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try {
                        splii.getData().put("12",splii.getData().get("12") + sa[3]);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try {
                        splii.getData().put("13",splii.getData().get("13") + sa[4]);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try {
                        splii.getData().put("14",splii.getData().get("14") + sa[5]);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    try {
                        splii.getData().put("15",splii.getData().get("15") + sa[6]);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    fff.fff(a);
                }
            }catch (Exception e){
                fff.fff(a);
                e.printStackTrace();
            }
        });
    }
}
