package com.example.rvlistadapter.ui

import androidx.lifecycle.*
import com.example.rvlistadapter.Jobs.Job
import com.example.rvlistadapter.Jobs.JobsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi

class ListViewModel : ViewModel() {

    private val jobsRepository: JobsRepository

    init {
        jobsRepository = JobsRepository.create()
    }

    @ExperimentalCoroutinesApi
    val _jobs: LiveData<List<Job>> = jobsRepository.getJobs(milliSeconds = 5000).asLiveData()

    override fun onCleared() {
        jobsRepository.close()
    }

}