package com.felipe.placapp.awayteam


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import com.felipe.placapp.R
import com.felipe.placapp.score.ScoreActivity
import kotlinx.android.synthetic.main.fragment_away_team.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AwayTeamFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btNextStep.setOnClickListener {
            sendHomeTeamName()
        }
    }
    private fun sendHomeTeamName() {
        val intent = Intent("FILTER_AWAY_TEAM")
        intent.putExtra("away_team", inputAwayTeam.text.toString())
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }

    private fun nextScreen() {
        sendAwayTeamName()
    }

    private fun sendAwayTeamName() {
        val intent = Intent("FILTER_AWAY_TEAM")
        intent.putExtra("away_team", inputAwayTeam.text.toString())
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }

}
