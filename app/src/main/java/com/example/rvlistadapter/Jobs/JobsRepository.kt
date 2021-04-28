package com.example.rvlistadapter.Jobs

import kotlinx.coroutines.*
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOn


class JobsRepository {

    private val jobsGenerator: JobsGenerator
    private val dispatcher: CoroutineDispatcher

    init {
        jobsGenerator = JobsGenerator()
        dispatcher = Dispatchers.IO
    }

    companion object {
        @JvmStatic
        fun create() = JobsRepository()
    }

    fun getJobs(milliSeconds: Long): Flow<List<Job>> {

        return channelFlow {
            while (!isClosedForSend) {
                val jobs = jobsGenerator.jobsGenerator()
                send(jobs)
                delay(timeMillis = milliSeconds)


            }
        }.flowOn(dispatcher)
    }

    fun close() {
        dispatcher.cancel()
    }
}