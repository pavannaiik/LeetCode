class Twitter {
public:
    unordered_map<int,set<int>>followers;
    unordered_map<int,vector<pair<int,int>>>tweets;
    long long time;
    Twitter() {
        time=0;
    }
    
    void postTweet(int userId, int tweetId) {
        tweets[userId].push_back({time++,tweetId});
    }
    
    vector<int> getNewsFeed(int userId) {
        priority_queue<pair<int,int>>maxHeap;
        for(auto tweet:tweets[userId]){
            maxHeap.push(tweet); //tweets and timestamps
        }
        for(auto f:followers[userId]){
            for(auto p2:tweets[f])
              maxHeap.push(p2);
        }
        vector<int>res;
        while(res.size() < 10 && maxHeap.size() >0){
            res.push_back(maxHeap.top().second);
            maxHeap.pop();
        }
        return res;

    }
    
    void follow(int followerId, int followeeId) {
        followers[followerId].insert(followeeId);
    }
    
    void unfollow(int followerId, int followeeId) {
        followers[followerId].erase(followeeId);
    }
};

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter* obj = new Twitter();
 * obj->postTweet(userId,tweetId);
 * vector<int> param_2 = obj->getNewsFeed(userId);
 * obj->follow(followerId,followeeId);
 * obj->unfollow(followerId,followeeId);
 */