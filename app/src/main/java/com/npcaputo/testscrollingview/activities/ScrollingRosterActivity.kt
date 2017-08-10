package com.npcaputo.testscrollingview.activities

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.npcaputo.testscrollingview.R
import com.npcaputo.testscrollingview.Roster
import com.npcaputo.testscrollingview.adapters.HockeyPlayerRecyclerViewAdapter
import com.npcaputo.testscrollingview.json.HockeyPlayerClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScrollingRosterActivity : AppCompatActivity() {

    private val CLASS_SIG = ScrollingRosterActivity::class.java.simpleName
    var hockeyPlayersView: RecyclerView? = null
    var refresh: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling_roster)
        hockeyPlayersView = findViewById<RecyclerView>(R.id.showing_hockey_players)
        refresh = findViewById<SwipeRefreshLayout>(R.id.swipe_refresh)
        refresh!!.setOnRefreshListener {
            fetchHockeyMembers()
        }

        refresh!!.isRefreshing = true
        fetchHockeyMembers()
    }

    private fun fetchHockeyMembers() {
        HockeyPlayerClient.getService().hockeyPlayersJson.enqueue(object : Callback<Roster> {
            override fun onResponse(call: Call<Roster>, response: Response<Roster>) {
                refresh!!.isRefreshing = false
                val context = this@ScrollingRosterActivity

                val hockeyPlayersAdapter = HockeyPlayerRecyclerViewAdapter(response.body()!!.roster, context)
                hockeyPlayersView!!.layoutManager = LinearLayoutManager(context)
                hockeyPlayersView!!.adapter = hockeyPlayersAdapter
            }

            override fun onFailure(call: Call<Roster>, t: Throwable) {
                refresh!!.isRefreshing = false
                Log.e(CLASS_SIG, t.message)
            }
        })
    }
}
