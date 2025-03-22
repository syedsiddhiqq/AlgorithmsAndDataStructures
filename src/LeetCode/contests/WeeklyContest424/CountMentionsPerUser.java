package LeetCode.contests.WeeklyContest424;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountMentionsPerUser {
    public static class User {
        int id;
        int t;

        User(int id, int t) {
            this.id = id;
            this.t = t;
        }
    }

    public static int[] countMentions(int n, List<List<String>> events) {
        events.sort((event1, event2) -> {
            int t1 = Integer.parseInt(event1.get(1));
            int t2 = Integer.parseInt(event2.get(1));
            if (t1 == t2) {
                boolean aOffline = event1.get(0).equals("OFFLINE");
                boolean bOffline = event2.get(0).equals("OFFLINE");
                if (aOffline && !bOffline) {
                    return -1;
                } else if (!aOffline && bOffline) {
                    return 1;
                } else {
                    return 0;
                }
            }
            return t1 - t2;
        });
        Map<Integer, User> userMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            userMap.put(i, new User(i, 0));
        }

        int[] mentions = new int[n];
        for (List<String> event : events) {
            String type = event.get(0);
            int t = Integer.parseInt(event.get(1));
            if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(event.get(2));
                User user = userMap.get(id);
                user.t = t + 60;
            } else {
                String idString = event.get(2);
                if (idString.equals("HERE") || idString.equals("ALL")) {
                    for (int i = 0; i < n; i++) {
                        User user = userMap.get(i);
                        if (idString.equals("HERE") && user.t <= t) {
                            mentions[i]++;
                        } else if (idString.equals("ALL")) {
                            mentions[i]++;
                        }
                    }
                } else {
                    String[] ids = event.get(2).split(" ");
                    for (String userId : ids) {
                        int id = Integer.parseInt(userId.substring(2));
                        mentions[id]++;
                    }
                }
            }
        }
        return mentions;
    }

    public static void main(String[] args) {
        List<List<String>> events = Arrays.asList(
                Arrays.asList("MESSAGE", "1", "id0 id1"),
                Arrays.asList("MESSAGE", "5", "id2"),
                Arrays.asList("MESSAGE", "6", "ALL"),
                Arrays.asList("OFFLINE", "5", "2")
        );
        int[] mentions = countMentions(3, events);
        System.out.println(mentions.toString());
    }
}
