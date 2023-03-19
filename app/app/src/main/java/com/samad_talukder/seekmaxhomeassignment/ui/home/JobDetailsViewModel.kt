package com.samad_talukder.seekmaxhomeassignment.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.samad_talukder.seekmaxhomeassignment.api.ApiResult
import com.samad_talukder.seekmaxhomeassignment.domain.JobDetailsByIDUseCase
import com.samad_talukder.seekmaxhomeassignment.domain.model.AllJobListResponse
import com.samad_talukder.seekmaxhomeassignment.domain.model.Jobs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class for displaying job details.
 * @param application The application context.
 * @param allJobListUseCase Use case for retrieving job details by ID.
 */

@HiltViewModel
class JobDetailsViewModel @Inject constructor(
    application: Application,
    private val allJobListUseCase: JobDetailsByIDUseCase,
) : AndroidViewModel(application) {

    private val _allJobListResponse: MutableLiveData<ApiResult<Jobs>> =
        MutableLiveData()
    val allJobListResponse: LiveData<ApiResult<Jobs>> =
        _allJobListResponse


    fun getJobDetailsByID(jobID: String) = viewModelScope.launch {
        _allJobListResponse.value = ApiResult.Loading

        allJobListUseCase.execute(jobID).collect { values ->
            _allJobListResponse.value = values
        }
    }
}

