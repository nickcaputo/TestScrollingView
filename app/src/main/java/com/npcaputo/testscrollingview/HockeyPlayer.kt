package com.npcaputo.testscrollingview

import com.google.gson.annotations.SerializedName

class HockeyPlayer {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("position")
    var position: String? = null

    @SerializedName("image_url")
    var imageUrl: String? = null

}
