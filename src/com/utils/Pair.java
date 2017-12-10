/*
    Made By ZizoNaser
    @ Sat Dec 9, 5:20pm
    Twitter: @ZizoNaser
 */
package com.utils;

public class Pair<T,E> {
    private T first;
    private E second;

    public Pair(){}
    public Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public E getSecond() {
        return second;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
