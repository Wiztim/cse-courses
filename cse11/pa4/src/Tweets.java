import tester.*;

interface Tweet {
        public boolean isStartOfThreadBy(String author);
        public int totalLikes();
        public String unrollThread();
}

abstract class BaseTweet implements Tweet {
        public String contents;
        public String author;
        public int likes;

        BaseTweet(String contents, int likes, String author) {
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

class TextTweet extends BaseTweet {
        TextTweet (String contents, int likes, String author) {
                super(contents, likes, author);
        }
}

class ReplyTweet extends BaseTweet {
        public Tweet replyTo;

        ReplyTweet (String contents, int likes, String author, BaseTweet replyTo) {
                super(contents, likes, author);
                this.replyTo = replyTo;
        }

        public boolean isStartOfThreadBy(String author) {
                return this.author.equals(author) && replyTo.isStartOfThreadBy(author);
        }

        public int totalLikes() {
                return replyTo.totalLikes() + likes;
        }

        public String unrollThread() {
                return replyTo.unrollThread() + super.unrollThread();
        }
}

public class Tweets {
        BaseTweet textTweet1 = new TextTweet("Hello", 11, "Tim");
        BaseTweet textTweet2 = new TextTweet("This is a test", 9999,"notABot");
        BaseTweet textTweet3 = textTweet1;
        BaseTweet replyTweet1 = new ReplyTweet("Hello to you", 3,"Phil", textTweet1);
        BaseTweet replyTweet2 = new ReplyTweet("Test response", 0,"notABot", textTweet2);
        BaseTweet replyTweet3 = new ReplyTweet("A third response", 333,"notABot", replyTweet2);
        BaseTweet replyTweet4 = new ReplyTweet("Tertiary response", 15,"The Second Bot", replyTweet3);

        boolean testTextTweetIsStartOfThreadBy(Tester t) {
                return t.checkExpect(textTweet1.isStartOfThreadBy("Tim"), true) &&
                        t.checkExpect(textTweet1.isStartOfThreadBy("notABot"), false) &&
                        t.checkExpect(textTweet2.isStartOfThreadBy("notABOT"), false) &&
                        t.checkExpect(textTweet3.isStartOfThreadBy("Tim"), true);
        }

        boolean testReplyTweetIsStartOfThreadBy(Tester t) {
                return t.checkExpect(replyTweet1.isStartOfThreadBy("Phil"), false) &&
                        t.checkExpect(replyTweet1.isStartOfThreadBy("Tim"), true) &&
                        t.checkExpect(replyTweet2.isStartOfThreadBy("notABot"), true) &&
                        t.checkExpect(replyTweet3.isStartOfThreadBy("notABot"), true) &&
                        t.checkExpect(replyTweet4.isStartOfThreadBy("notABot"), true) &&
                        t.checkExpect(replyTweet4.isStartOfThreadBy("The Second Bot"), false);
        }

        boolean testTextTweetTotalLikes(Tester t) {
                return t.checkExpect(textTweet1.totalLikes(), 11) &&
                        t.checkExpect(textTweet2.totalLikes(), 9999) &&
                        t.checkExpect(textTweet3.totalLikes(), 11);
        }

        boolean testReplyTweetTotalLikes(Tester t) {
                return t.checkExpect(replyTweet1.totalLikes(), 14) &&
                        t.checkExpect(replyTweet2.totalLikes(), 9999) &&
                        t.checkExpect(replyTweet3.totalLikes(), 10332);
        }

        boolean testTextTweetUnrollThread(Tester t) {
                return t.checkExpect(textTweet1.unrollThread(),"Tim\n11 likes\nHello\n") &&
                        t.checkExpect(textTweet2.unrollThread(),"notABot\n9999 likes\nThis is a test\n") &&
                        t.checkExpect(textTweet3.unrollThread(),"Tim\n11 likes\nHello\n");
        }

        boolean testReplyTweetUnrollThread(Tester t) {
                return t.checkExpect(replyTweet1.unrollThread(), "Tim\n11 likes\nHello\nPhil\n3 likes\nHello to you\n") &&
                        t.checkExpect(replyTweet2.unrollThread(), "notABot\n9999 likes\nThis is a test\nnotABot\n0 likes\nTest response\n") &&
                        t.checkExpect(replyTweet3.unrollThread(), "notABot\n9999 likes\nThis is a test\nnotABot\n0 likes\nTest response\nnotABot\n333 likes\nA third response\n");
        }


}