package com.study.coroutinereactivestudy.spring_reactive_programming.chapter_2.exam_1;

public interface Subject<T> {
    void registerObserver(Observer<T> observer);
    void unregisterObserver(Observer<T> observer);
    void notifyObservers(T event);
}
