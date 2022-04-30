package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    val job = Job()
    println(job)    // JobImpl{Active}@ABC
    job.complete()
    println(job)    // JobImpl{Completed}@ABC

    val activeJob = launch { }
    println(activeJob)  // StandaloneCoroutine{Active}@DEF
    activeJob.join()
    println(activeJob)  // StandaloneCoroutine{Completed}@DEF

    val lazyJob = launch(start = CoroutineStart.LAZY) { }
    println(lazyJob)    // LazyStandaloneCoroutine{New}@GHI
    lazyJob.start()
    println(lazyJob)    // LazyStandaloneCoroutine{Active}@GHI
    lazyJob.join()
    println(lazyJob)    // LazyStandaloneCoroutine{Completed}@GHI
}
