package com.torlov.cseeleven;

class TextTweet {
    String contents;
    int likes;

    TextTweet(String contents, int likes) {
        this.contents = contents;
        this.likes = likes;
    }

    boolean hasMention() {
        return false;
    }

    boolean hasLike() {
        return false;
    }

    String firstMention() {
        return "";
    }
}

class ReplyTweet {
    TextTweet replyTo;
    String contents;
    int likes;

    boolean morePopularReply() {
        return false;
    }

    int allLikes() {
        return 0;
    }

    boolean hasMention(String username) {
        return false;
    }
}
public class Drill3 {

}
