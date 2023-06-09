package com.samad_talukder.seekmaxhomeassignment.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.samad_talukder.seekmaxhomeassignment.api.ApiResult
import com.samad_talukder.seekmaxhomeassignment.domain.AllJobListUseCase
import com.samad_talukder.seekmaxhomeassignment.domain.model.AllJobListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class that handles business logic for fetching all job list data from the repository
 * @param application Application object used to create the ViewModel
 * @param allJobListUseCase Use case object for fetching all job list data
 */

@HiltViewModel
class AllJobListViewModel @Inject constructor(
    application: Application,
    private val allJobListUseCase: AllJobListUseCase,
) : AndroidViewModel(application) {

    private val _allJobListResponse: MutableLiveData<ApiResult<AllJobListResponse>> =
        MutableLiveData()
    val allJobListResponse: LiveData<ApiResult<AllJobListResponse>> =
        _allJobListResponse


    fun getAllJobList(page:Int) = viewModelScope.launch {
        _allJobListResponse.value = ApiResult.Loading

        allJobListUseCase.execute(page).collect { values ->
            _allJobListResponse.value = values
        }
    }

}

