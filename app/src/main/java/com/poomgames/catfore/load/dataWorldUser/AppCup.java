package com.poomgames.catfore.load.dataWorldUser;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.poomgames.catfore.load.buuu.Splii;
import com.poomgames.catfore.presentation.activities.MainActivity;

import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

public class AppCup {

    private final MainActivity mainActivity;
    private final boolean a;
    private boolean b = true;
    private final String[] kk2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[] sa;
    private final ApppIn apppIn;

    public AppCup(MainActivity mainActivity, boolean a, ApppIn apppIn) {
        this.mainActivity = mainActivity;
        this.a = a;
        this.apppIn = apppIn;
    }

    public interface ApppIn {
        void aaaa();
    }

    public void aaapp(Splii splii) {
        AppsFlyerLib.getInstance().setHost("", "appsflyersdk.com");
        AppsFlyerLib.getInstance().init("sXqSbTB8zCtEdhbDZ4SCdh", new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {

                if (b) {
                    b = false;
                    for (int i = 0; i < splii.getDataApp().size(); i++) {
                        try {
                            if (i < 3) {
                                splii.getDataApp().put(kk2[i], map.get(splii.getDataApp().get(kk2[i])).toString());
                            } else {
                                splii.getDataApp().put(kk2[i], URLEncoder.encode(map.get(splii.getDataApp().get(kk2[i])).toString(), "utf-8"));
                            }
                        } catch (Exception e) {
                            splii.getDataApp().put(kk2[i], "null");
                        }
                    }
                    jjjj(splii);
                }
            }

            @Override
            public void onConversionDataFail(String s) {
                if (b) {
                    b = false;
                    for (int i = 0; i < splii.getDataApp().size(); i++) {
                        splii.getDataApp().put(kk2[i], "null");
                    }
                    jjjj(splii);
                }
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {
                if (b) {
                    b = false;
                    for (int i = 0; i < splii.getDataApp().size(); i++) {
                        splii.getDataApp().put(kk2[i], "null");
                    }
                    jjjj(splii);
                }
            }

            @Override
            public void onAttributionFailure(String s) {
                if (b) {
                    b = false;
                    for (int i = 0; i < splii.getDataApp().size(); i++) {
                        splii.getDataApp().put(kk2[i], "null");
                    }
                    jjjj(splii);
                }
            }
        }, mainActivity);
        AppsFlyerLib.getInstance().start(mainActivity);
    }


    private void jjjj(Splii splii) {

        if (!a && !Objects.requireNonNull(splii.getDataApp().get("4")).equals("null")) {
            try {

                sa = Objects.requireNonNull(splii.getDataApp().get("4")).split("_");
                splii.getData().put("24", splii.getData().get("24") + sa[1]);
                splii.setOrg(sa[1]);
            } catch (Exception e) {
                e.printStackTrace();
                splii.getData().put("10", splii.getData().get("10") + splii.getDataApp().get("4"));
            }

            try {
                splii.getData().put("10", splii.getData().get("10") + sa[0]);
            } catch (Exception e) {
                splii.getData().put("10", splii.getData().get("10") + "null");
            }

            try {
                splii.getData().put("11", splii.getData().get("11") + sa[2]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                splii.getData().put("12", splii.getData().get("12") + sa[3]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                splii.getData().put("13", splii.getData().get("13") + sa[4]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                splii.getData().put("14", splii.getData().get("14") + sa[5]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                splii.getData().put("15", splii.getData().get("15") + sa[6]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            splii.getData().put("1", splii.getData().get("1") + splii.getDataApp().get("1"));
            splii.getData().put("2", splii.getData().get("2") + splii.getDataApp().get("2"));
            splii.getData().put("3", splii.getData().get("3") + splii.getDataApp().get("3"));
            splii.getData().put("5", splii.getData().get("5") + splii.getDataApp().get("5"));
            splii.getData().put("6", splii.getData().get("6") + splii.getDataApp().get("6"));
            splii.getData().put("7", splii.getData().get("7") + splii.getDataApp().get("7"));
            splii.getData().put("8", splii.getData().get("8") + splii.getDataApp().get("8"));
            splii.getData().put("9", splii.getData().get("9") + splii.getDataApp().get("9"));
            splii.getData().put("4", splii.getData().get("4") + splii.getDataApp().get("4"));
            apppIn.aaaa();
        } else if (a) {
            splii.getData().put("1", splii.getData().get("1") + splii.getDataApp().get("1"));
            splii.getData().put("2", splii.getData().get("2") + splii.getDataApp().get("2"));
            splii.getData().put("3", splii.getData().get("3") + splii.getDataApp().get("3"));
            splii.getData().put("5", splii.getData().get("5") + splii.getDataApp().get("5"));
            splii.getData().put("6", splii.getData().get("6") + splii.getDataApp().get("6"));
            splii.getData().put("7", splii.getData().get("7") + splii.getDataApp().get("7"));
            splii.getData().put("8", splii.getData().get("8") + splii.getDataApp().get("8"));
            splii.getData().put("9", splii.getData().get("9") + splii.getDataApp().get("9"));
            splii.getData().put("4", splii.getData().get("4") + splii.getDataApp().get("4"));
            apppIn.aaaa();
        } else {
            splii.getData().put("10", splii.getData().get("10") + "null");
            splii.getData().put("11", splii.getData().get("11") + "");
            splii.getData().put("12", splii.getData().get("12") + "");
            splii.getData().put("13", splii.getData().get("13") + "");
            splii.getData().put("14", splii.getData().get("14") + "");
            splii.getData().put("15", splii.getData().get("15") + "");
            splii.getData().put("16", splii.getData().get("16") + "");
            splii.getData().put("1", splii.getData().get("1") + splii.getDataApp().get("1"));
            splii.getData().put("2", splii.getData().get("2") + splii.getDataApp().get("2"));
            splii.getData().put("3", splii.getData().get("3") + splii.getDataApp().get("3"));
            splii.getData().put("5", splii.getData().get("5") + splii.getDataApp().get("5"));
            splii.getData().put("6", splii.getData().get("6") + splii.getDataApp().get("6"));
            splii.getData().put("7", splii.getData().get("7") + splii.getDataApp().get("7"));
            splii.getData().put("8", splii.getData().get("8") + splii.getDataApp().get("8"));
            splii.getData().put("9", splii.getData().get("9") + splii.getDataApp().get("9"));
            splii.getData().put("4", splii.getData().get("4") + splii.getDataApp().get("4"));
            splii.getData().put("24", splii.getData().get("24") + "null");
            apppIn.aaaa();
        }
    }
}
