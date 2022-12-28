package com.example.mcshippers.Profile.presentation.profileDetails.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mcshippers.Profile.model.Profile
import com.example.mcshippers.Profile.presentation.profileDetails.viewModel.ProfileListViewModelImpl

import com.example.mcshippers.R
import com.example.mcshippers.base.reciever.ConnectionLiveData
import com.example.mcshippers.databinding.ActivityProfileListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileListActivity : AppCompatActivity(), ProfileListActivityView,
    ProfleListAdapter.ProfileListAdapterInterface {
    val viewModel: ProfileListViewModelImpl by viewModel()
    private var isInternetConnected: Boolean = false
    var binding: ActivityProfileListBinding? = null
    var adapter: ProfleListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileListBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        viewModel.getALlProfilesRemote()
        CheackInterNetConnectivity()
        initRecylcerView()
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

    override fun onSendOrderClickListner(position: Int) {

    }

     fun initRecylcerView() {
        binding?.rvAthleteList?.layoutManager =
            LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        viewModel.profileList?.observe(this, object : Observer<Profile> {
            override fun onChanged(profile: Profile?) {
                if (profile?.athletes?.isEmpty() == true || profile == null) {
                    Toast.makeText(baseContext, "", Toast.LENGTH_LONG).show()
                } else {
                    adapter = ProfleListAdapter(this@ProfileListActivity)
                    binding?.rvAthleteList?.adapter = adapter
                    adapter?.differ?.submitList(profile.athletes)
                }

            }
        })

    }

}