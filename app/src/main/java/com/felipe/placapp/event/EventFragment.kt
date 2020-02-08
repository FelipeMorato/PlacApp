package com.felipe.placapp.event

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.felipe.placapp.R
import com.felipe.placapp.hometeam.HomeTeamFragment
import kotlinx.android.synthetic.main.fragment_away_team.*
import kotlinx.android.synthetic.main.fragment_away_team.btNextStep
import kotlinx.android.synthetic.main.fragment_blank.*

class EventFragment : Fragment(){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btNextStep.setOnClickListener {
            nextScreen()
        }
    }

    private fun nextScreen() {
        val ft = activity?.supportFragmentManager?.beginTransaction()
        ft?.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )
        ft?.replace(R.id.containerGame, HomeTeamFragment())
        ft?.addToBackStack(null)
        ft?.commit()
    }

    private fun sendEventName() {
        val intent = Intent("FILTER_EVENT")
        intent.putExtra("event_name", inputEvent.text.toString())
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }

}
