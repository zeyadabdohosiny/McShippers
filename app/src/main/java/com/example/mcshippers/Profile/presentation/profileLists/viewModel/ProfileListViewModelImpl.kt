package com.example.mcshippers.Profile.presentation.profileLists.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mcshippers.Profile.data.ProfleRepository
import com.example.mcshippers.Profile.model.Profile
import kotlinx.coroutines.launch

class ProfileListViewModelImpl(var repository: ProfleRepository) : ViewModel() {

    private var _profilesList = MutableLiveData<Profile>()
    val profileList: MutableLiveData<Profile> = _profilesList

    fun getALlProfilesRemote() {
        viewModelScope.launch {
            var list = repository.getAllProfilesFromRemote()
            profileList.value = list
            repository.insertProfiles(list)
        }
    }

    fun getAllProfilesLocal() {
        viewModelScope.launch {
         profileList.value=repository.getAllProfilesFromLocal()
        }
    }

}