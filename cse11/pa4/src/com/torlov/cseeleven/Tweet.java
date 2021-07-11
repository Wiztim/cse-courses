//package com.torlov.cseeleven;

public abstract class Tweet {
    protected String contents;
    protected String author;
    protected int likes;

    Tweet(String contents, String author, int likes) {
        this.contents = contents;
        this.author = author;
        this.likes = likes;
    }

    public boolean isStartOfThreadBy(String author) {
        return this.author.equals(author);
    }

    public int totalLikes() {
        return likes;
    }

    public String unrollThread() {
        return this.author + "\n" + this.likes + " likes\n" + this.contents + "\n";
    }
}