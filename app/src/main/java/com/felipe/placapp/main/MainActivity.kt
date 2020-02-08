package com.felipe.placapp.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.felipe.placapp.R
import com.felipe.placapp.game.GameActivity
import com.felipe.placapp.score.ScoreActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var eventName = ""
    private var homeTeam = ""
    private var awayTeam = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerBroadcastReceiver()

        btNewGame.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }

        btExit.setOnClickListener {
            finish()
        }
    }

    private fun registerBroadcastReceiver() {
        val intentFilter = IntentFilter("FILTER_EVENT")
        intentFilter.addAction("FILTER_HOME_TEAM")
        intentFilter.addAction("FILTER_AWAY_TEAM")
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, intentFilter)
    }

    public override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver)
    }

    private val mMessageReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.hasExtra("event_name")) {
                eventName = intent.getStringExtra("event_name")
            }
            if (intent.hasExtra("home_team")) {
                homeTeam = intent.getStringExtra("home_team")
            }
            if (intent.hasExtra("away_team")) {
                awayTeam = intent.getStringExtra("away_team")
                val nextScreen = Intent(this@MainActivity, ScoreActivity::class.java)
                nextScreen.putExtra("eventName", eventName)
                nextScreen.putExtra("homeTeam", homeTeam)
                nextScreen.putExtra("awayTeam", awayTeam)
                startActivity(nextScreen)
                finish()
            }
        }
    }
}
