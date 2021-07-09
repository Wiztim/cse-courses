package com.torlov.cseeleven;

public interface Tweets {
    public boolean isStartOfThreadBy(String author);
    public int totalLikes();
    public String unrollThread();
}
