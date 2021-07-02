package com.torlov.cseeleven;

public class ExampleTweets {
    public static void main(String[] args) {

    }

    public class user {
        String userName;
        String fullName;
        int followers;
        public user(String userName, String fullName, int followers) {
            this.userName = userName;
            this.fullName = fullName;
            this.followers = followers;
        }

        // converts the user's names into one string
        public String toText() {
            return fullName + " @" + userName;
        }
    }

    public class tweet {
        String content;
        user user;
        int likes;
        String tweetID;
        public tweet(String content, user user, int likes, String tweetID) {
            this.content = content;
            this.tweetID = tweetID;
            this.user = user;
            this.likes = likes;
        }

        // compare which tweet has more characters
        boolean longerThan(tweet otherTweet) {
            if (otherTweet.content.length() < content.length()) {
            return true;
        }

        return false;
        }

        // compare which tweet has more likes
        boolean moreLikes(tweet otherTweet) {
            if (otherTweet.likes < likes) {
                return true;
            }

            return false;
        }

        // a different user effectively copies the tweet
        tweet retweet(user otherUser) {
            tweet newTweet = new tweet(content, otherUser, 0, tweetID + "-rt");

            return newTweet;
        }

        // appends the tweet to the username
        String toText() {
            return user.toText() + ": " + content + ": " + likes + " Likes";
        }

        // converts the tweet into a usable link
        String toLink() {
            return "https://twitter.com/" + user.userName + "/" + tweetID;
        }
    }

    public class testTweet {
        // game dev I follow
        user projectMoon = new user("ProjMoonStudio", "ProjectMoon", 37500);
        // another game dev I follow
        user regalis = new user("UnderTowGames", "Regalis", 5786);
        //
        user league = new user("LeagueOfLegends","League of Legends", 4900000);
    }
}

