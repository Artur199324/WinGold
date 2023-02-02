package com.poomgames.catfore.load.buuu;

import java.util.HashMap;

public class Splii {

    private final String lll;
    private final String [] kk = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
    private final String [] kk2 = {"1","2","3","4","5","6","7","8","9"};
    private HashMap<String,String> data;
    private HashMap<String,String> dataApp;
    private String org = "organic";

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public HashMap<String, String> getDataApp() {
        return dataApp;
    }

    public Splii(String lll) {
        this.lll = lll;
    }

    public void spliit(){
        data = new HashMap<>();
        dataApp = new HashMap<>();
        String[] ll = lll.split("=");
        for (int i = 0; i< kk.length;i++){
            data.put(kk[i], ll[i] + "=");
        }
        String[] llll = ll[0].split("&");

        for (int i = 0;i<kk2.length;i++){
            if (i==0){
                dataApp.put(kk2[i], llll[1]);
            }else {
                dataApp.put(kk2[i], ll[i].replace("&",""));
            }
        }
    }
}
