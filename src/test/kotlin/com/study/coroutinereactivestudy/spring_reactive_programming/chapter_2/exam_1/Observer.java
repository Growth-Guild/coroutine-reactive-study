package com.study.coroutinereactivestudy.spring_reactive_programming.chapter_2.exam_1;

public interface Observer<T> {
    void observe(T event);
}
