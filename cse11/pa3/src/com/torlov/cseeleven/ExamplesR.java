package com.torlov.cseeleven;

public class ExamplesR {
    // using a null object, we can create an R object, even though it needs an R as a parameter
    // therefore, we can construct this object
    R firstObject = new R("Words", null);
    R secondObject = new R("More words", firstObject);
}

class R {
    String words;
    R objectR;

    R(String words, R objectR) {
        this.words = words;
        this.objectR = objectR;
    }
}
