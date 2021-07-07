package com.torlov.cseeleven;


class TextTweet {
    String contents;
    int likes;

    TextTweet(String contents, int likes) {
        this.contents = contents;
        this.likes = likes;
    }

    boolean hasMention(String username) {
        String[] words = contents.split(" ");
        username = "@" + username;

        for (String word : words) {
            if (word.equals(username)) {
                return true;
            }
        }

        return false;
    }

    boolean hasLike() {
        return likes > 0;
    }

    String firstMention() {
        String[] words = contents.split(" ");

        for (String word : words) {
            if (word.length() > 1 && word.charAt(0) == '@') {
                return word.substring(1);
            }
        }

        return "";
    }
}

class ReplyTweet {
    TextTweet replyTo;
    String contents;
    int likes;

    ReplyTweet(TextTweet replyTo, String contents, int likes) {
        this.replyTo = replyTo;
        this.contents = contents;
        this.likes = likes;
    }

    boolean morePopularReply() {
        return likes > replyTo.likes;
    }

    int allLikes() {
        return likes + replyTo.likes;
    }

    boolean hasMention(String username) {
        String[] words = contents.split(" ");
        username = "@" + username;

        for (String word : words) {
            if (word.equals(username)) {
                return true;
            }
        }

        return replyTo.hasMention(username);
    }
}
public class Drill3 {

}
