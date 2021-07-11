public class ExampleTweets {
    public static void main(String[] args) {
        TestTweet testTweets = new TestTweet();
        testTweets.testUserToText();
        testTweets.compareLengths();
        testTweets.compareLikes();
        testTweets.tweetToText();
        testTweets.tweetToLink();
        testTweets.testRetweet();
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
            return user.toText() + " : " + content + " : " + likes + " Likes";
        }

        // converts the tweet into a usable link
        String toLink() {
            return "https://twitter.com/" + user.userName + "/status/" + tweetID;
        }
    }

    public static class TestTweet {
        // game dev I follow
        User projectMoon = new User("ProjMoonStudio", "ProjectMoon", 37500);
        // another game dev I follow
        User regalis = new User("UnderTowGames", "Regalis", 5786);
        // game dev from a game I don't play
        User league = new User("LeagueOfLegends","League of Legends", 4900000);

        Tweet projMoonNews = new Tweet("We are waiting for Steam's release permission.", projectMoon, 337, "1402136378318626836");
        Tweet projMoonPatch = new Tweet("Patch Note ver 1.1.0.3 - Add battle symbols, Achievement, tutorial, small stories", projectMoon, 664, "1398240241249521667");
        Tweet regalisUpdate = new Tweet("We're working on upgradable/swappable submarine weapons - here's a sneak peek of a new WIP weapon... #gamedev #indiegame #barotrauma #IndieGameDev", regalis, 147, "1387379385032904710");
        Tweet leagueInfo = new Tweet("Ruin’s reign will be eternal. Sentinels of Light coming July 8.", league, 12400, "1408802239636967424");

        // outputs user.toText with projectMoon and regalis
        void testUserToText() {
            System.out.println(projectMoon.toText());
            System.out.println(regalis.toText());
        }

        // will compare first 2 and last 2 tweets
        void compareLengths() {
            System.out.println("Comparing two Project Moon tweet lengths, output is false");
            System.out.println(projMoonNews.longerThan(projMoonPatch));
            System.out.println("Comparing Regalis and League tweet lengths, output is true");
            System.out.println(regalisUpdate.longerThan(leagueInfo));
        }

        // compare first and third tweets, and second and fourth
        void compareLikes() {
            System.out.println("Comparing first Project Moon tweet to Regalis tweet likes, output is true");
            System.out.println(projMoonNews.moreLikes(regalisUpdate));
            System.out.println("Comparing second Project Moon tweet and League tweet likes, output is false");
            System.out.println(projMoonPatch.moreLikes(leagueInfo));
        }

        // converts the first and last tweet into string
        void tweetToText() {
            System.out.println(projMoonNews.toText());
            System.out.println(leagueInfo.toText());
        }

        // converts the second and third tweet into a link
        void tweetToLink() {
            System.out.println(projMoonPatch.toLink());
            System.out.println(regalisUpdate.toLink());
        }

        // Project Moon will retweet the Regalis and League tweet, and then Regalis will retweet the second one
        // these tweets will then be output as a string and link
        void testRetweet() {
            System.out.println("Creating three retweets, two will be project moon retweeting the other developer's tweets, the third a retweet of a retweet." +
                    "\nThe links won't work since it will probably never happen.");
            Tweet projMoonRetweetRegalis = regalisUpdate.retweet(projectMoon);
            Tweet projMoonRetweetLeague = leagueInfo.retweet(projectMoon);
            Tweet regalisRetweet = projMoonRetweetLeague.retweet(regalis);

            System.out.println(projMoonRetweetRegalis.toText());
            System.out.println(projMoonRetweetLeague.toText());
            System.out.println(regalisRetweet.toText());
            System.out.println(projMoonRetweetRegalis.toLink());
            System.out.println(projMoonRetweetLeague.toLink());
            System.out.println(regalisRetweet.toLink());
        }
    }
}