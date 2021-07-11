//package com.torlov.cseeleven;
import tester.*;

public class Tweets {
        Tweet textTweet1 = new TextTweet("Hello", "Tim", 11);
        Tweet textTweet2 = new TextTweet("This is a test", "notABot", 9999);
        Tweet textTweet3 = textTweet1;
        Tweet replyTweet1 = new ReplyTweet("Hello to you", "Phil", 3, textTweet1);
        Tweet replyTweet2 = new ReplyTweet("Test response", "notABot", 0, textTweet2);
        Tweet replyTweet3 = new ReplyTweet("A third response", "notABot", 333, textTweet3);

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
                        t.checkExpect(replyTweet3.isStartOfThreadBy("notABot"), false);
        }

        boolean testTextTweetTotalLikes(Tester t) {
                return t.checkExpect(textTweet1.totalLikes(), 11) &&
                        t.checkExpect(textTweet2.totalLikes(), 9999) &&
                        t.checkExpect(textTweet3.totalLikes(), 11);
        }

        boolean testReplyTweetTotalLikes(Tester t) {
                return t.checkExpect(replyTweet1.totalLikes(), 14) &&
                        t.checkExpect(replyTweet2.totalLikes(), 9999) &&
                        t.checkExpect(replyTweet3.totalLikes(), 344);
        }

        boolean testTextTweetUnrollThread(Tester t) {
                return t.checkExpect(textTweet1.unrollThread(),"Tim\n11 likes\nHello\n") &&
                        t.checkExpect(textTweet2.unrollThread(),"notABot\n9999 likes\nThis is a test\n") &&
                        t.checkExpect(textTweet3.unrollThread(),"Tim\n11 likes\nHello\n");
        }

        boolean testReplyTweetUnrollThread(Tester t) {
                return t.checkExpect(replyTweet1.unrollThread(), "Tim\n11 likes\nHello\nPhil\n3 likes\nHello to you\n") &&
                        t.checkExpect(replyTweet2.unrollThread(), "notABot\n9999 likes\nThis is a test\nnotABot\n0 likes\nTest response\n") &&
                        t.checkExpect(replyTweet3.unrollThread(), "Tim\n11 likes\nHello\nnotABot\n333 likes\nA third response\n");
        }


}