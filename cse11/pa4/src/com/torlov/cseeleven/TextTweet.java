package com.torlov.cseeleven;

public class TextTweet implements Tweets {
    private String contents;
    private String author;
    private int likes;

    TextTweet (String contents, String author, int likes) {
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
        return author + "\n" + likes + " likes\n" + contents;
    }
}
