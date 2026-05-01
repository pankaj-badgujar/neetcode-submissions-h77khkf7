// store {user: set[followees]} in a followMap
// what if we store each tweet in a heap that sorts them by time
// each time we get the top tweet, if its 
class Twitter {
    int time;
    Map<Integer, List<int[]>> tweetMap;
    Map<Integer, HashSet<Integer>> followMap;
    
    public Twitter() {
        this.time = 0;
        this.tweetMap = new HashMap<>(); // userId -> list of [time, tweetId]
        this.followMap = new HashMap<>(); // userId -> set of followeeId
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        // add self
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followeeId : followMap.get(userId)){
            if (tweetMap.containsKey(followeeId)){
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                maxHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }
        
        // now maxHeap only has relevant tweets
        // we keep extracting tweets from maxHeap until we reach 10, or
        while (!maxHeap.isEmpty() && newsFeed.size() < 10){    
            int[] curr = maxHeap.poll();
            newsFeed.add(curr[1]);
            int index = curr[3];
            if (index > 0){
                int[] tweet = tweetMap.get(curr[2]).get(index - 1);
                maxHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }
        }
        
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
