//package com.torlov.cseeleven;

public class ReplyTweet extends Tweet {

    private Tweet replyTo;

    ReplyTweet (String contents, String author, int likes, Tweet replyTo) {
        super(contents, author, likes);
        this.replyTo = replyTo;
    }

    public boolean isStartOfThreadBy(String author) {
        return replyTo.isStartOfThreadBy(author);
    }

    public int totalLikes() {
        return replyTo.totalLikes() + likes;
    }

    public String unrollThread() {
        return replyTo.unrollThread() + super.unrollThread();
    }
}