package com.npcaputo.testscrollingview.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.npcaputo.testscrollingview.HockeyPlayer
import com.npcaputo.testscrollingview.R
import com.npcaputo.testscrollingview.activities.HockeyPlayerDetailsActivity
import com.squareup.picasso.Picasso

class HockeyPlayerRecyclerViewAdapter() : RecyclerView.Adapter<HockeyPlayerRecyclerViewAdapter.HockeyPlayerViewHolder>() {

    var mHockeyPlayers: List<HockeyPlayer>? = null
    var mContext: Context? = null

    constructor(hockeyPlayers: List<HockeyPlayer>, context: Context) : this() {
        mHockeyPlayers = hockeyPlayers
        mContext = context
    }

    override fun onBindViewHolder(holder: HockeyPlayerViewHolder?, pos: Int) {
        val name = mHockeyPlayers!![pos].name
        val position = mHockeyPlayers!![pos].position
        val imageUrl = mHockeyPlayers!![pos].imageUrl

        holder!!.name.text = name
        holder.position.text = position
        Picasso.with(mContext).load(imageUrl).into(holder.image)

        holder.view.setOnClickListener({
            val detailsView: Intent = Intent(mContext, HockeyPlayerDetailsActivity::class.java)
            detailsView.putExtra(HockeyPlayerDetailsActivity.NAME_EXTRA, name)
            detailsView.putExtra(HockeyPlayerDetailsActivity.POSITION_EXTRA, position)
            detailsView.putExtra(HockeyPlayerDetailsActivity.IMAGE_URL_EXTRA, imageUrl)

            mContext!!.startActivity(detailsView)
        })
    }

    override fun getItemCount(): Int {
        if (mHockeyPlayers != null) {
            return mHockeyPlayers!!.size
        } else {
            return 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HockeyPlayerViewHolder {
        return HockeyPlayerViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.hockey_player_view, parent, false))
    }


    class HockeyPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var view: View = itemView
        var name: TextView = itemView.findViewById(R.id.hockey_player_view_title)
        var position: TextView = itemView.findViewById(R.id.hockey_player_view_position)
        var image: ImageView = itemView.findViewById(R.id.hockey_player_view_image)
    }
}