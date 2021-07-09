package com.torlov.cseeleven;

public class ReplyTweet implements Tweets {
    private String contents;
    private String author;
    private int likes;
    private Tweets replyTo;

    ReplyTweet (String contents, String author, int likes, Tweets replyTo) {
        this.contents = contents;
        this.author = author;
        this.likes = likes;
        this.replyTo = replyTo;
    }

    public boolean isStartOfThreadBy(String author) {
        return this.author.equals(author);
    }

    public int totalLikes() {
        return likes;
    }

    public String unrollThread() {
        return replyTo.unrollThread() + author + "\n" + likes + " likes\n" + contents;
    }
}
