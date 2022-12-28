package com.example.mcshippers.Profile.presentation.profileDetails.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.mcshippers.Profile.presentation.profileDetails.viewModel.ProfileListViewModelImpl

import com.example.mcshippers.R
import com.example.mcshippers.base.reciever.ConnectionLiveData
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileListActivity : AppCompatActivity(), ProfileListActivityView {
    val viewModel: ProfileListViewModelImpl by viewModel()
    private var isInternetConnected: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_details)
        viewModel.getALlProfilesRemote()
        CheackInterNetConnectivity()

    }

    private fun appState() {
        if (isInternetConnected == false) {
            viewModel.getAllProfilesLocal()
            return
        }
        viewModel.getALlProfilesRemote()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    fun CheackInterNetConnectivity() {
        val connectionLiveData = ConnectionLiveData(this)
        connectionLiveData.observe(this, Observer { isConnected ->
            if (!isConnected) {
                //   mSnackBar?.duration = 5
                //   mSnackBar?.show()
            } else {
            }
            Log.d("Zeyad", isConnected.toString())
            isInternetConnected = isConnected
        })
    }
}