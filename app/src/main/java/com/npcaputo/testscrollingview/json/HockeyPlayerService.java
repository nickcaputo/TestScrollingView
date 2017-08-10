package com.npcaputo.testscrollingview.json;

import com.npcaputo.testscrollingview.Roster;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HockeyPlayerService {

    @GET("android_eval.json")
    Call<Roster> getHockeyPlayersJson();

}
