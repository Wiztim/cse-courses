package com.torlov.cseeleven;

class C1 {
    C2 other;
    C1(C2 other) {
        this.other = other;
    }
}

class C2 {
    int x;
    C2(int x) {
        this.x = x;
    }
}

public class Drill2 {
    C2 first;
    C1 second;
    C1 third;


}
