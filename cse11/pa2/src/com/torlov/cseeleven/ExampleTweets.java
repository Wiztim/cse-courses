package com.torlov.cseeleven;

public class ExampleTweets {
    public static void main(String[] args) {
        TestTweet asdf = new TestTweet();
    }

    public static class User {
        String userName;
        String fullName;
        int followers;
        public User(String userName, String fullName, int followers) {
            this.userName = userName;
            this.fullName = fullName;
            this.followers = followers;
        }

        // converts the user's names into one string
        public String toText() {
            return fullName + " @" + userName;
        }
    }

    public static class Tweet {
        String content;
        User user;
        int likes;
        String tweetID;
        public Tweet(String content, User user, int likes, String tweetID) {
            this.content = content;
            this.tweetID = tweetID;
            this.user = user;
            this.likes = likes;
        }

        // compare which tweet has more characters
        boolean longerThan(Tweet otherTweet) {
            if (otherTweet.content.length() < content.length()) {
                return true;
            }

            return false;
        }

        // compare which tweet has more likes
        boolean moreLikes(Tweet otherTweet) {
            if (otherTweet.likes < likes) {
                return true;
            }

            return false;
        }

        // a different user effectively copies the tweet
        Tweet retweet(User otherUser) {
            Tweet newTweet = new Tweet(content, otherUser, 0, tweetID + "-rt");

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

    public static class TestTweet {
        // game dev I follow
        User projectMoon = new User("ProjMoonStudio", "ProjectMoon", 37500);
        // another game dev I follow
        User regalis = new User("UnderTowGames", "Regalis", 5786);
        // game dev
        User league = new User("LeagueOfLegends","League of Legends", 4900000);

        Tweet projMoonNews = new Tweet("We are waiting for Steam's release permission.", projectMoon, 337, "1402136378318626836");
        Tweet projMoonPatch = new Tweet("Patch Note ver 1.1.0.3 - Add battle symbols, Achievement, tutorial, small stories", projectMoon, 664, "1398240241249521667");
        Tweet regalisUpdate = new Tweet("We're working on upgradable/swappable submarine weapons - here's a sneak peek of a new WIP weapon... #gamedev #indiegame #barotrauma #IndieGameDev", regalis, 147, "1387379385032904710");


    }
}