package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.reactive.asFlow
import reactor.core.publisher.Flux

suspend fun main() = coroutineScope {
    Flux.range(1, 5).asFlow()
        .collect { println(it) }

    println()

    /*
    flowOf(1, 2, 3, 4, 5).asFlux()
        .doOnNext { println(it) }
        .subscribe()
    */
}
