package com.group20.resortproject.utility;

/**
 * A Tuple
 */
public class Tuple<A, B> {
    public A first;
    public B second;

    public Tuple(A first, B second) {
        this.first = first;
        this.second = second;
    }
}