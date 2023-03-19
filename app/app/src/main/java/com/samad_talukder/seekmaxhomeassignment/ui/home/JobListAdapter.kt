package com.samad_talukder.seekmaxhomeassignment.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.samad_talukder.seekmaxhomeassignment.databinding.ItemJobListBinding
import com.samad_talukder.seekmaxhomeassignment.domain.model.Jobs

class JobListAdapter : RecyclerView.Adapter<JobListAdapter.JobListViewHolder>() {
    var onClick: ((String) -> Unit)? = null

    private val diffCallback = object : DiffUtil.ItemCallback<Jobs>() {
        override fun areItemsTheSame(oldItem: Jobs, newItem: Jobs) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Jobs, newItem: Jobs) = oldItem == newItem
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var jobList: List<Jobs>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobListViewHolder {
        val itemBinding =
            ItemJobListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobListViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    override fun onBindViewHolder(holder: JobListViewHolder, position: Int) {

        holder.bind(jobList[position])
    }

    inner class JobListViewHolder(private val itemBinding: ItemJobListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(jobs: Jobs) {
            itemBinding.apply {
                tvJobTitle.text = jobs.positionTitle
                tvCompanyName.text = jobs.company.name
                tvJobDescription.text = jobs.description
                if (jobs.haveIApplied) {
                    tvHasApplied.visibility = View.VISIBLE
                } else {
                    tvHasApplied.visibility = View.GONE
                }

                cvJob.setOnClickListener {
                    onClick?.invoke(
                        jobs.id
                    )
                }
            }

        }

    }
}