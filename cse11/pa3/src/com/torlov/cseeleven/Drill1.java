package com.torlov.cseeleven;

public class Drill1 {
    class A {
        int f1;
        String f2;
    }

    class B {
        A field1;
        String field2;
    }

    class C {
        B fieldB;
        A fieldA;
        int field3;
    }
}

