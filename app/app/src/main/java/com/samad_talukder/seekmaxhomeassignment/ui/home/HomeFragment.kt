package com.samad_talukder.seekmaxhomeassignment.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samad_talukder.seekmaxhomeassignment.R
import com.samad_talukder.seekmaxhomeassignment.api.ApiResult
import com.samad_talukder.seekmaxhomeassignment.databinding.FragmentHomeBinding
import com.samad_talukder.seekmaxhomeassignment.domain.model.Jobs
import dagger.hilt.android.AndroidEntryPoint
import java.util.Objects.isNull

/**
 * A simple [Fragment] subclass.
 * This fragment is responsible for showing the list of jobs.
 */

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val allJobListViewModel: AllJobListViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var jobListAdapter: JobListAdapter
    private var currentPage = 1
    private var hasNext = true
    private var isLoading = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeJobList()

        if (currentPage == 1) {
            callJobListAPI(currentPage)
        }
        binding.apply {
            tvError.visibility = View.GONE
            rvJobList.visibility = View.VISIBLE

            val layoutManager = LinearLayoutManager(context)
            rvJobList.layoutManager = layoutManager
            rvJobList.setHasFixedSize(true)

            jobListAdapter = JobListAdapter()
            rvJobList.adapter = jobListAdapter

            binding.rvJobList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    if (!isLoading && hasNext && dy > 0) {
                        val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                        val totalCount = layoutManager.itemCount

                        if (lastVisibleItem == totalCount - 1) {
                            callJobListAPI(currentPage)
                        }
                    }
                }
            })

        }

    }

    private fun observeJobList() {
        allJobListViewModel.allJobListResponse.observe(this) { response ->

            when (response) {
                is ApiResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    isLoading = false
                }
                is ApiResult.Success -> {

                    if (!isNull(response.data)) {

                        response.data.let {
                            hasNext = it.hasNext

                            if (hasNext) {
                                currentPage++
                            }

                            if (it.jobs.isNotEmpty()) {
                                showList(it.jobs)
                            } else {
                                binding.tvError.visibility = View.VISIBLE
                                binding.rvJobList.visibility = View.GONE
                            }
                        }
                    }

                }
                is ApiResult.Error -> {
                    binding.tvError.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    binding.rvJobList.visibility = View.GONE
                    binding.tvError.text = response.errorMessage

                }

            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showList(jobs: List<Jobs>) {
        binding.apply {
            tvError.visibility = View.GONE
            rvJobList.visibility = View.VISIBLE

            jobListAdapter.jobList += jobs
            jobListAdapter.notifyDataSetChanged()

            jobListAdapter.onClick = { jobId ->
                val bundle = bundleOf("job_id" to jobId)
                findNavController().navigate(R.id.action_menu_home_to_jobDetailsFragment, bundle)
            }

        }

    }

    private fun callJobListAPI(page: Int) {
        allJobListViewModel.getAllJobList(page)
    }

}