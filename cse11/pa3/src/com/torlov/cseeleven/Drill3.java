public class Drill3 {



}

class TextTweet {
    String contents;
    int likes;

    public TextTweet(String contents, int likes) {
        this.contents = contents;
        this.likes = likes;
    }

    public boolean hasMention(String username) {
        String[] words = contents.split(" ");
        username = "@" + username;

        for (String word : words) {
            if (word.equals(username)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasLike() {
        return likes > 0;
    }

    public String firstMention() {
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

    public ReplyTweet(TextTweet replyTo, String contents, int likes) {
        this.replyTo = replyTo;
        this.contents = contents;
        this.likes = likes;
    }

    public boolean morePopularReply() {
        return likes > replyTo.likes;
    }

    public int allLikes() {
        return likes + replyTo.likes;
    }

    public boolean hasMention(String username) {
        String[] words = contents.split(" ");
        username = "@" + username;

        for (String word : words) {
            if (word.equals(username)) {
                return true;
            }
        }

        return replyTo.hasMention(username.substring(1));
    }
}