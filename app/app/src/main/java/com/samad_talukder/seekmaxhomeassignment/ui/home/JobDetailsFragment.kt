package com.samad_talukder.seekmaxhomeassignment.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.samad_talukder.seekmaxhomeassignment.api.ApiResult
import com.samad_talukder.seekmaxhomeassignment.databinding.FragmentJobDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import java.util.Objects.isNull

@AndroidEntryPoint
class JobDetailsFragment : Fragment() {
    private lateinit var binding: FragmentJobDetailsBinding
    private val jobDetailsViewModel: JobDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJobDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jobId = arguments?.getString("job_id") ?: ""

        observeJobDetails()
        callJobDetailsAPI(jobId)
    }

    private fun observeJobDetails() {
        jobDetailsViewModel.allJobListResponse.observe(this) { response ->
            when (response) {
                is ApiResult.Loading -> {}

                is ApiResult.Success -> {

                    if (!isNull(response.data)) {

                        response.data.let {
                            binding.apply {
                                tvJobTitle.text = it.positionTitle
                                tvCompanyName.text = it.company.name
                                tvJobDescription.text = it.description

                                if (it.haveIApplied) {
                                    tvHasApplied.visibility = View.VISIBLE
                                } else {
                                    tvHasApplied.visibility = View.GONE
                                }
                            }
                        }
                    }

                }
                is ApiResult.Error -> {
                    Toast.makeText(context, response.errorMessage, Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    private fun callJobDetailsAPI(jobId: String) {
        jobDetailsViewModel.getJobDetailsByID(jobId)
    }

}