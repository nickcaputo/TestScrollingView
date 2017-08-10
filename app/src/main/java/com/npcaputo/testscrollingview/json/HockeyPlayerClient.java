package com.npcaputo.testscrollingview.json;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HockeyPlayerClient {

    private static final String HOCKEY_PLAYER_URL = "https://jc-xerxes.gpshopper.com";

    private static Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl(HOCKEY_PLAYER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static HockeyPlayerService getService() {
        return getInstance().create(HockeyPlayerService.class);
    }

}
