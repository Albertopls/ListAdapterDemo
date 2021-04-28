package com.example.rvlistadapter.Jobs

import com.example.rvlistadapter.R
import kotlin.random.Random

class JobsGenerator {

    val athlete = Job(
            image = R.drawable.athlete,
            title = "Athlete",
            description = "A crazy rabbit being athlete, he is really happy to start running.",
            salary = 20_200.00
    )
    val dancer = Job(
            image = R.drawable.dancer,
            title = "Dancer",
            description = "He is dancing because in an early future he will become a coach.",
            salary = 16_530.23
    )
    val painter = Job(
            image = R.drawable.painter,
            title = "Painter",
            description = "This is her last drawing, she is an awesome graphic artist, she teach on a website called domestika.",
            salary = 12_456.00
    )
    val secretary = Job(
            image = R.drawable.secretary,
            title = "Secretary",
            description = "She works as a secretary in development Company, this is her first day and she really nervous.",
            salary = 18_300.00
    )
    val skater = Job(
            image = R.drawable.skater,
            title = "Skater",
            description = "He is training really hard because he will have a skater challenge",
            salary = 9_540.00
    )
    val coach = Job(
            image = R.drawable.trainner,
            title = "Trainner",
            description = "Now he is working out, because in 9:00 am he going to do excercise with his students ",
            salary = 21_000.00
    )

    val longJobs = listOf(skater, painter, secretary, coach)
    val shortJobs = listOf(dancer, athlete)

    fun jobsGenerator(): List<Job> {
        return shortJobs.take(Random.nextInt(from = 0, until = shortJobs.size + 1)).plus(longJobs)
                .shuffled().mutate()
    }

    private fun List<Job>.mutate(): List<Job> = this.map {
        it.copy(
                salary = it.salary.mutate()
        )
    }

    private fun Double.mutate(): Double {
        if (this > 20_000) {
            val increase = this * 0.15
            return this + increase
        }
        return this
    }
}