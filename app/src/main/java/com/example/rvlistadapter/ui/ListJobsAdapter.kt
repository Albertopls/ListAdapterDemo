package com.example.rvlistadapter.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rvlistadapter.Jobs.Job
import com.example.rvlistadapter.R
import com.example.rvlistadapter.util.formatNumber
import kotlin.properties.Delegates

class ListJobsAdapter : ListAdapter<Job, ListJobsAdapter.ListJobsViewHolder>(Diff()) {

    class ListJobsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.item_img)
        var title: TextView = itemView.findViewById(R.id.item_txt_title)
        var salary: TextView = itemView.findViewById(R.id.item_txt_salary)
        var description: TextView = itemView.findViewById(R.id.item_txt_desc)

        fun bind(job: Job) {
            image.setImageResource(job.image)
            title.text = job.title
            salary.text = job.salary.formatNumber()
            description.text = job.description
        }

    }

    private class Diff : DiffUtil.ItemCallback<Job>() {

        override fun areItemsTheSame(oldItem: Job, newItem: Job) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Job, newItem: Job) = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListJobsViewHolder =
            ListJobsViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_job, parent, false)
            )


    override fun onBindViewHolder(holder: ListJobsViewHolder, position: Int) =
            holder.bind(getItem((position)))

}