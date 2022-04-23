package com.study.coroutinereactivestudy.spring_reactive_programming.chapter_2.exam_1;

public class ConcreteObserverA implements Observer<String> {
    @Override
    public void observe(String event) {
        System.out.println("Observer A: " + event);
    }
}
