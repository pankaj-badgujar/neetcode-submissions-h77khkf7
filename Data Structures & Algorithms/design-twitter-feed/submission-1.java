// store {user: set[followees]} in a map
// what if we store each tweet in a heap that sorts them by time
// each time we get the top tweet, if its 
class Tweet {
    int time;
    int tweetId;
    int userId;

    public Tweet(int time, int tweetId, int userId){
        this.time = time;
        this.tweetId = tweetId;
        this.userId = userId;
    }
}
class Twitter {
    Map<Integer, HashSet<Integer>> map;
    List<Tweet> visitedTweet;
    PriorityQueue<Tweet> maxHeap; // [time, tweetId]
    int time;


    public Twitter() {
        this.map = new HashMap<>();
        this.visitedTweet = new ArrayList<>();
        this.maxHeap = new PriorityQueue<>((a,b) -> b.time - a.time);
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        // we should store the user in map
        map.computeIfAbsent(userId, (k) -> new HashSet<>());

        // creat a tweet obj
        Tweet tweet = new Tweet(time, tweetId, userId);

        // and we should store the tweet in the heap
        maxHeap.add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        // we keep extracting tweets from maxHeap until we reach 10, or
        
        while (!maxHeap.isEmpty() && newsFeed.size() < 10){
            Tweet latestTweet = maxHeap.poll();
            System.out.println("latestTweet: tweetId: " + latestTweet.tweetId);
            System.out.println("latestTweet: userId: " + latestTweet.userId);
            System.out.println("latestTweet: time: " + latestTweet.time);
            System.out.println("");
            visitedTweet.add(latestTweet);

            if (
                latestTweet.userId == userId || 
                (
                    map.containsKey(userId) && 
                    map.get(userId).contains(latestTweet.userId)
                )
            ) {
                newsFeed.add(latestTweet.tweetId);
            System.out.println("newsFeed.size(): " + newsFeed.size());
            System.out.println("------");
            }
        }
        for (Tweet tweet : visitedTweet){
            maxHeap.add(tweet);
        }
        visitedTweet = new ArrayList<>();
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        map.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        if (map.containsKey(followerId)){
            map.get(followerId).remove(followeeId);
        }
    }
}
