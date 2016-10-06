package com.xuan.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by xzhou2 on 9/13/16.
 */
public class Twitter {
    private Map<Integer, User> map;
    private int counter = 0;
    private static final int cap = 10;
    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user;
        if (!map.containsKey(userId)) {
            user = new User(userId);
            map.put(userId, user);
        } else {
            user = map.get(userId);
        }
        user.post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!map.containsKey(userId)) {
            return result;
        }
        User user = map.get(userId);
        PriorityQueue<Tweet> queue = new PriorityQueue<>((p,q) -> q.seq - p.seq);
        if (user.getTweet() != null) {
            queue.offer(user.getTweet());
        }
        for(int friend : user.friends) {
            User curr = map.get(friend);
            if (curr.getTweet() != null) {
                queue.offer(curr.getTweet());
            }
        }
        while(result.size() < cap && !queue.isEmpty()) {
            Tweet tweet = queue.poll();
            result.add(tweet.tweetId);
            if (tweet.next != null) {
                queue.offer(tweet.next);
            }
        }
        return result;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        User from = map.get(followerId), to = map.get(followeeId);
        if (from == null) {
            from = new User(followerId);
            map.put(followerId, from);
        }
        if (to == null) {
            to = new User(followeeId);
            map.put(followeeId, to);
        }
        from.follow(to);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        User from = map.get(followerId), to = map.get(followeeId);
        if (from == null) {
            from = new User(followerId);
            map.put(followerId, from);
        }
        if (to == null) {
            to = new User(followeeId);
            map.put(followeeId, to);
        }
        from.unfollow(to);
    }

    private class User {
        int userId;
        Set<Integer> friends;
        Tweet head;

        User(int u) {
            userId = u;
            friends = new HashSet<>();
            head = null;
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, counter++);
            if (head == null) {
                head = tweet;
            } else {
                tweet.next = head;
                head = tweet;
            }
        }

        public Tweet getTweet() {
            return head;
        }

        public void follow(User to) {
            friends.add(to.userId);
        }

        public void unfollow(User to) {
            friends.remove(to.userId);
        }
    }

    private class Tweet{
        int tweetId;
        int seq;
        Tweet next;

        Tweet(int t, int s) {
            tweetId = t;
            seq = s;
        }
    }
}